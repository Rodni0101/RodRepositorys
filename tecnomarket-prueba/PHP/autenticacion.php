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
    $q = $conexion->prepare('SELECT id FROM usuarios WHERE correo = ?');
    $q->bind_param('s', $correo);
    $q->execute();
    $existe = $q->get_result()->num_rows > 0;
    $q->close();
    if ($existe)
        return [false, 'Ese correo ya está registrado.'];
    $hash = password_hash($contrasena, PASSWORD_DEFAULT);
    $q = $conexion->prepare('INSERT INTO usuarios (nombre, correo, password_hash) VALUES (?, ?, ?)');
    $q->bind_param('sss', $nombre, $correo, $hash);
    $ok = $q->execute();
    $q->close();
    return $ok ? [true, 'Registro creado. Ya puedes iniciar sesión.'] : [false, 'No fue posible crear la cuenta.'];
}
function iniciarSesion(mysqli $conexion, string $correo, string $contrasena): array
{
    $q = $conexion->prepare('SELECT id, nombre, correo, password_hash FROM usuarios WHERE correo = ? LIMIT 1');
    $q->bind_param('s', $correo);
    $q->execute();
    $usuario = $q->get_result()->fetch_assoc();
    $q->close();
    if (!$usuario || !password_verify($contrasena, $usuario['password_hash']))
        return [false, 'Correo o contraseña incorrectos.'];
    session_regenerate_id(true);
    $_SESSION['usuario'] = ['id' => (int) $usuario['id'], 'nombre' => $usuario['nombre'], 'correo' => $usuario['correo']];
    return [true, ''];
}
function cerrarSesion(): void
{
    unset($_SESSION['usuario']);
    session_regenerate_id(true);
}
