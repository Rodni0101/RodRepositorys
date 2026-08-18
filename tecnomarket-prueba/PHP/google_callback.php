<?php
require_once __DIR__ . '/conexion.php';
require_once __DIR__ . '/seguridad.php';
require_once __DIR__ . '/autenticacion.php';
require_once __DIR__ . '/google_config.php';

function solicitarGoogle(string $url, array $opciones = []): array
{
    $curl = curl_init($url);
    curl_setopt_array($curl, $opciones + [
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_TIMEOUT => 15,
        CURLOPT_CONNECTTIMEOUT => 8,
    ]);
    $respuesta = curl_exec($curl);
    $codigoHttp = (int) curl_getinfo($curl, CURLINFO_HTTP_CODE);
    $error = curl_error($curl);
    curl_close($curl);

    if ($respuesta === false || $codigoHttp < 200 || $codigoHttp >= 300) {
        throw new RuntimeException('No fue posible validar el acceso con Google' . ($error ? ': ' . $error : '.') );
    }

    $datos = json_decode($respuesta, true);
    if (!is_array($datos)) {
        throw new RuntimeException('Google devolvió una respuesta no válida.');
    }
    return $datos;
}

if (!googleConfigurado()) {
    establecerMensaje('El acceso con Google aún no está configurado en el servidor.', 'error');
    redirigir('../login.php');
}

$stateEsperado = $_SESSION['google_oauth_state'] ?? '';
$stateRecibido = (string) ($_GET['state'] ?? '');
unset($_SESSION['google_oauth_state']);

if (!$stateEsperado || !$stateRecibido || !hash_equals($stateEsperado, $stateRecibido)) {
    establecerMensaje('No se pudo validar la solicitud de Google. Intenta de nuevo.', 'error');
    redirigir('../login.php');
}

if (isset($_GET['error'])) {
    establecerMensaje('El inicio de sesión con Google fue cancelado o no autorizado.', 'error');
    redirigir('../login.php');
}

$codigo = (string) ($_GET['code'] ?? '');
if ($codigo === '') {
    establecerMensaje('Google no devolvió un código de autorización.', 'error');
    redirigir('../login.php');
}

try {
    $configuracion = configuracionGoogle();
    $tokens = solicitarGoogle('https://oauth2.googleapis.com/token', [
        CURLOPT_POST => true,
        CURLOPT_POSTFIELDS => http_build_query([
            'code' => $codigo,
            'client_id' => $configuracion['client_id'],
            'client_secret' => $configuracion['client_secret'],
            'redirect_uri' => $configuracion['redirect_uri'],
            'grant_type' => 'authorization_code',
        ], '', '&', PHP_QUERY_RFC3986),
        CURLOPT_HTTPHEADER => ['Content-Type: application/x-www-form-urlencoded'],
    ]);

    if (empty($tokens['access_token'])) {
        throw new RuntimeException('Google no entregó un token de acceso.');
    }

    $perfil = solicitarGoogle('https://openidconnect.googleapis.com/v1/userinfo', [
        CURLOPT_HTTPHEADER => ['Authorization: Bearer ' . $tokens['access_token']],
    ]);

    $correo = strtolower(trim((string) ($perfil['email'] ?? '')));
    $nombre = trim((string) ($perfil['name'] ?? 'Usuario de Google'));
    $subGoogle = trim((string) ($perfil['sub'] ?? ''));
    if (!$subGoogle || !filter_var($correo, FILTER_VALIDATE_EMAIL) || empty($perfil['email_verified'])) {
        throw new RuntimeException('Google no confirmó una cuenta de correo válida.');
    }

    [$ok, $mensaje] = iniciarSesionGoogle($conexion, $subGoogle, $nombre, $correo);
    if (!$ok) {
        throw new RuntimeException($mensaje);
    }
    redirigir('../index.php');
} catch (Throwable $error) {
    establecerMensaje($error->getMessage(), 'error');
    redirigir('../login.php');
}
