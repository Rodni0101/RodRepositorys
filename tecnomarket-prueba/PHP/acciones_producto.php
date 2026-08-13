<?php
require_once __DIR__ . '/conexion.php';
require_once __DIR__ . '/seguridad.php';
require_once __DIR__ . '/autenticacion.php';
require_once __DIR__ . '/productos.php';
require_once __DIR__ . '/imagenes.php';
if (usuarioActual() === null) redirigir('../login.php');
if ($_SERVER['REQUEST_METHOD'] !== 'POST' || !csrfValido()) {
    establecerMensaje('Solicitud no válida.', 'error');
    redirigir('../index.php');
}
$accion = $_POST['accion'] ?? '';
if ($accion === 'nuevo') {
    unset($_SESSION['form_producto']);
    establecerMensaje('Formulario limpiado correctamente.');
    redirigir('../index.php#formulario');
}
$d = ['codigo' => trim($_POST['codigo'] ?? ''), 'nombre' => trim($_POST['nombre'] ?? ''), 'categoria' => trim($_POST['categoria'] ?? ''), 'precio' => trim($_POST['precio'] ?? ''), 'cantidad' => trim($_POST['cantidad'] ?? ''), 'imagen' => trim($_POST['imagen_actual'] ?? '')];
if (isset($_FILES['imagen']) && $_FILES['imagen']['error'] !== UPLOAD_ERR_NO_FILE) {
    [$okImagen, $ruta, $error] = subirImagenProducto($_FILES['imagen'], dirname(__DIR__) . '/uploads');
    if (!$okImagen) {
        $_SESSION['form_producto'] = $d;
        establecerMensaje($error, 'error');
        redirigir('../index.php#formulario');
    }
    $d['imagen'] = $ruta;
}
$_SESSION['form_producto'] = $d;
[$ok, $mensaje] = match ($accion) { 'guardar' => guardarProducto($conexion, $d), 'actualizar' => actualizarProducto($conexion, $d), default => [false, 'Acción no reconocida.']};
establecerMensaje($mensaje, $ok ? 'exito' : 'error');
redirigir('../index.php#formulario');
