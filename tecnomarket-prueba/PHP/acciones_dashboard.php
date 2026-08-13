<?php
require_once __DIR__ . '/conexion.php';
require_once __DIR__ . '/seguridad.php';
require_once __DIR__ . '/autenticacion.php';
require_once __DIR__ . '/productos.php';
if (usuarioActual() === null)
    redirigir('../login.php');
if ($_SERVER['REQUEST_METHOD'] !== 'POST' || !csrfValido()) {
    establecerMensaje('Solicitud no válida.', 'error');
    redirigir('../dashboard.php');
}
$accion = $_POST['accion'] ?? '';
$codigo = trim($_POST['codigo'] ?? '');
if ($codigo === '') {
    establecerMensaje('Ingresa un código.', 'error');
    redirigir('../dashboard.php');
}
if ($accion === 'buscar') {
    $producto = obtenerProducto($conexion, $codigo);
    if (!$producto) {
        establecerMensaje('Producto no encontrado.', 'error');
        redirigir('../dashboard.php');
    }
    $_SESSION['producto_encontrado'] = $producto;
    redirigir('../dashboard.php');
}
if ($accion === 'actualizar') {
    $producto = obtenerProducto($conexion, $codigo);
    if (!$producto) {
        establecerMensaje('No existe un producto con ese código.', 'error');
        redirigir('../dashboard.php');
    }
    $_SESSION['form_producto'] = $producto;
    establecerMensaje('Producto cargado para actualizar.');
    redirigir('../index.php#formulario');
}
if ($accion === 'eliminar') {
    [$ok, $mensaje] = eliminarProducto($conexion, $codigo);
    establecerMensaje($mensaje, $ok ? 'exito' : 'error');
    redirigir('../dashboard.php');
}
establecerMensaje('Acción no reconocida.', 'error');
redirigir('../dashboard.php');
