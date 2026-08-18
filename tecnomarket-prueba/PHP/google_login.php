<?php
require_once __DIR__ . '/conexion.php';
require_once __DIR__ . '/seguridad.php';
require_once __DIR__ . '/autenticacion.php';
require_once __DIR__ . '/google_config.php';

if (usuarioActual()) {
    redirigir('../index.php');
}

if (!googleConfigurado()) {
    establecerMensaje('El acceso con Google aún no está configurado en el servidor.', 'error');
    redirigir('../login.php');
}

$configuracion = configuracionGoogle();
$_SESSION['google_oauth_state'] = bin2hex(random_bytes(32));

$parametros = http_build_query([
    'client_id' => $configuracion['client_id'],
    'redirect_uri' => $configuracion['redirect_uri'],
    'response_type' => 'code',
    'scope' => 'openid email profile',
    'state' => $_SESSION['google_oauth_state'],
    'prompt' => 'select_account',
], '', '&', PHP_QUERY_RFC3986);

header('Location: https://accounts.google.com/o/oauth2/v2/auth?' . $parametros);
exit;
