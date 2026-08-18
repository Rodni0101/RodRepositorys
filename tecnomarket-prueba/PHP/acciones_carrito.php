<?php
require_once __DIR__ . '/conexion.php';
require_once __DIR__ . '/seguridad.php';
require_once __DIR__ . '/autenticacion.php';
require_once __DIR__ . '/carrito.php';

requiereAutenticacion();

if ($_SERVER['REQUEST_METHOD'] !== 'POST' || !csrfValido()) {
    establecerMensaje('Solicitud de carrito no válida.', 'error');
    redirigir('../dashboard.php');
}

$accion = $_POST['accion'] ?? '';
$codigo = trim($_POST['codigo'] ?? '');
$carrito = carritoActual();

if ($accion === 'vaciar_carrito') {
    guardarCarrito([]);
    establecerMensaje('Carrito vaciado.');
    redirigir('../dashboard.php');
}

if ($accion === 'finalizar_compra') {
    if (!$carrito) {
        establecerMensaje('El carrito está vacío.', 'error');
        redirigir('../dashboard.php');
    }

    try {
        $conexion->begin_transaction();
        $total = 0.0;
        foreach ($carrito as $codigoProducto => $cantidadSolicitada) {
            $cantidadSolicitada = (int) $cantidadSolicitada;
            $consulta = $conexion->prepare('SELECT nombre, precio, cantidad FROM productos WHERE codigo = ? FOR UPDATE');
            $consulta->bind_param('s', $codigoProducto);
            $consulta->execute();
            $producto = $consulta->get_result()->fetch_assoc();
            $consulta->close();

            if (!$producto || $cantidadSolicitada < 1 || (int) $producto['cantidad'] < $cantidadSolicitada) {
                throw new RuntimeException('Las existencias de uno de los productos cambiaron. Revisa el carrito.');
            }

            $actualizar = $conexion->prepare('UPDATE productos SET cantidad = cantidad - ? WHERE codigo = ?');
            $actualizar->bind_param('is', $cantidadSolicitada, $codigoProducto);
            $actualizar->execute();
            $actualizar->close();
            $total += (float) $producto['precio'] * $cantidadSolicitada;
        }
        $conexion->commit();
        guardarCarrito([]);
        establecerMensaje('Compra registrada. Total pagado: $ ' . number_format($total, 0, ',', '.') . '.');
    } catch (Throwable $error) {
        $conexion->rollback();
        establecerMensaje($error->getMessage(), 'error');
    }
    redirigir('../dashboard.php');
}

if ($codigo === '') {
    establecerMensaje('No se identificó el producto.', 'error');
    redirigir('../dashboard.php');
}

if ($accion === 'eliminar_del_carrito') {
    unset($carrito[$codigo]);
    guardarCarrito($carrito);
    establecerMensaje('Producto eliminado del carrito.');
    redirigir('../dashboard.php');
}

$consulta = $conexion->prepare('SELECT nombre, cantidad FROM productos WHERE codigo = ?');
$consulta->bind_param('s', $codigo);
$consulta->execute();
$producto = $consulta->get_result()->fetch_assoc();
$consulta->close();

if (!$producto || (int) $producto['cantidad'] < 1) {
    establecerMensaje('Este producto ya no tiene existencias.', 'error');
    redirigir('../dashboard.php');
}

$cantidad = filter_var($_POST['cantidad'] ?? 1, FILTER_VALIDATE_INT);
if ($accion === 'agregar_carrito') {
    $cantidad = ($carrito[$codigo] ?? 0) + 1;
} elseif ($accion !== 'actualizar_carrito' || $cantidad === false) {
    establecerMensaje('Cantidad no válida.', 'error');
    redirigir('../dashboard.php');
}

if ($cantidad < 1) {
    unset($carrito[$codigo]);
    guardarCarrito($carrito);
    establecerMensaje('Producto eliminado del carrito.');
} elseif ($cantidad > (int) $producto['cantidad']) {
    establecerMensaje('Solo hay ' . (int) $producto['cantidad'] . ' unidad(es) disponible(s) de ' . $producto['nombre'] . '.', 'error');
} else {
    $carrito[$codigo] = $cantidad;
    guardarCarrito($carrito);
    establecerMensaje($accion === 'agregar_carrito' ? 'Producto agregado al carrito.' : 'Cantidad actualizada.');
}

redirigir('../dashboard.php');
