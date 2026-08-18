<?php

function usuarioActual(): ?array
{
    if (session_status() === PHP_SESSION_NONE) {
        session_start();
    }

    $usuario = $_SESSION['usuario'] ?? null;
    return is_array($usuario) ? $usuario : null;
}
function requiereAutenticacion(): void
{
    if (usuarioActual() === null) {
        establecerMensaje('Inicia sesión para acceder al inventario.', 'error');
        redirigir('login.php');
    }
}
function registrarUsuario(mysqli $conexion, string $nombre, string $correo, string $contrasena): array
{
    if ($nombre === '' || $correo === '' || $contrasena === '')
        return [false, 'Completa todos los campos.'];
    if (!filter_var($correo, FILTER_VALIDATE_EMAIL))
        return [false, 'Ingresa un correo electrónico válido.'];
    if (strlen($contrasena) < 8)
        return [false, 'La contraseña debe tener al menos 8 caracteres.'];
    $consulta = $conexion->prepare('SELECT id FROM usuarios WHERE correo = ?');
    $consulta->bind_param('s', $correo);
    $consulta->execute();
    $existe = $consulta->get_result()->num_rows > 0;
    $consulta->close();
    if ($existe)
        return [false, 'Ese correo ya está registrado.'];
    $hash = password_hash($contrasena, PASSWORD_DEFAULT);
    $consulta = $conexion->prepare('INSERT INTO usuarios (nombre, correo, password_hash) VALUES (?, ?, ?)');
    $consulta->bind_param('sss', $nombre, $correo, $hash);
    $consulta_true = $consulta->execute();
    $consulta->close();
    return $consulta_true ? [true, 'Registro creado. Ya puedes iniciar sesión.'] : [false, 'No fue posible crear la cuenta.'];
}
function iniciarSesion(mysqli $conexion, string $correo, string $contrasena): array
{
    $consulta = $conexion->prepare('SELECT id, nombre, correo, password_hash FROM usuarios WHERE correo = ? LIMIT 1');
    $consulta->bind_param('s', $correo);
    $consulta->execute();
    $usuario = $consulta->get_result()->fetch_assoc();
    $consulta->close();
    if (!$usuario || !password_verify($contrasena, $usuario['password_hash']))
        return [false, 'Correo o contraseña incorrectos.'];
    session_regenerate_id(true);
    $_SESSION['usuario'] = ['id' => (int) $usuario['id'], 'nombre' => $usuario['nombre'], 'correo' => $usuario['correo']];
    return [true, ''];
}
function iniciarSesionGoogle(mysqli $conexion, string $googleSub, string $nombre, string $correo): array
{
    $consulta = $conexion->prepare('SELECT id, nombre, correo, google_sub FROM usuarios WHERE google_sub = ? LIMIT 1');
    $consulta->bind_param('s', $googleSub);
    $consulta->execute();
    $usuario = $consulta->get_result()->fetch_assoc();
    $consulta->close();

    if (!$usuario) {
        $consulta = $conexion->prepare('SELECT id, nombre, correo, google_sub FROM usuarios WHERE correo = ? LIMIT 1');
        $consulta->bind_param('s', $correo);
        $consulta->execute();
        $usuario = $consulta->get_result()->fetch_assoc();
        $consulta->close();

        if ($usuario && $usuario['google_sub'] !== null && $usuario['google_sub'] !== $googleSub) {
            return [false, 'Ese correo ya está vinculado con otra cuenta de Google.'];
        }
    }

    if (!$usuario) {
        $passwordTemporal = password_hash(bin2hex(random_bytes(32)), PASSWORD_DEFAULT);
        $consulta = $conexion->prepare('INSERT INTO usuarios (nombre, correo, google_sub, password_hash) VALUES (?, ?, ?, ?)');
        $consulta->bind_param('ssss', $nombre, $correo, $googleSub, $passwordTemporal);
        if (!$consulta->execute()) {
            $consulta->close();
            return [false, 'No fue posible crear la cuenta con Google.'];
        }
        $id = $conexion->insert_id;
        $consulta->close();
        $usuario = ['id' => $id, 'nombre' => $nombre, 'correo' => $correo];
    } else {
        if ($usuario['google_sub'] === null) {
            $consulta = $conexion->prepare('UPDATE usuarios SET google_sub = ? WHERE id = ?');
            $consulta->bind_param('si', $googleSub, $usuario['id']);
            $consulta->execute();
            $consulta->close();
        }
    }

    session_regenerate_id(true);
    $_SESSION['usuario'] = ['id' => (int) $usuario['id'], 'nombre' => $usuario['nombre'], 'correo' => $usuario['correo']];
    return [true, ''];
}
function cerrarSesion(): void
{
    unset($_SESSION['usuario']);
    session_regenerate_id(true);
}
