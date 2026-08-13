<?php
require_once __DIR__ . '/conexion.php';
require_once __DIR__ . '/seguridad.php';
require_once __DIR__ . '/autenticacion.php';
if ($_SERVER['REQUEST_METHOD'] !== 'POST' || !csrfValido()) {
    establecerMensaje('La sesión expiró. Inténtalo de nuevo.', 'error');
    redirigir('../login.php');
}
$accion = $_POST['accion'] ?? '';
if ($accion === 'registro') {
    [$ok, $mensaje] = registrarUsuario($conexion, trim($_POST['nombre'] ?? ''), trim($_POST['correo'] ?? ''), $_POST['contrasena'] ?? '');
    establecerMensaje($mensaje, $ok ? 'exito' : 'error');
    redirigir($ok ? '../login.php' : '../registro.php');
}
if ($accion === 'login') {
    [$ok, $mensaje] = iniciarSesion($conexion, trim($_POST['correo'] ?? ''), $_POST['contrasena'] ?? '');
    if ($ok)
        redirigir('../index.php');
    establecerMensaje($mensaje, 'error');
    redirigir('../login.php');
}
if ($accion === 'logout') {
    cerrarSesion();
    establecerMensaje('Sesión cerrada correctamente.');
    redirigir('../login.php');
}
redirigir('../login.php');
