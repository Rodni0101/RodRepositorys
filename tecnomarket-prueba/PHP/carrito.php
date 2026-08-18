<?php

function carritoActual(): array
{
    $carrito = $_SESSION['carrito'] ?? [];
    return is_array($carrito) ? $carrito : [];
}

function guardarCarrito(array $carrito): void
{
    $_SESSION['carrito'] = $carrito;
}

function resumenCarrito(mysqli $conexion): array
{
    $carrito = carritoActual();
    $items = [];
    $cantidadTotal = 0;
    $total = 0.0;

    foreach ($carrito as $codigo => $cantidad) {
        $cantidad = (int) $cantidad;
        if ($cantidad < 1) {
            continue;
        }

        $consulta = $conexion->prepare('SELECT codigo, nombre, precio, cantidad, imagen FROM productos WHERE codigo = ?');
        $consulta->bind_param('s', $codigo);
        $consulta->execute();
        $producto = $consulta->get_result()->fetch_assoc();
        $consulta->close();

        if (!$producto) {
            continue;
        }

        $cantidad = min($cantidad, (int) $producto['cantidad']);
        if ($cantidad < 1) {
            continue;
        }

        $subtotal = (float) $producto['precio'] * $cantidad;
        $items[] = $producto + ['cantidad_carrito' => $cantidad, 'subtotal' => $subtotal];
        $cantidadTotal += $cantidad;
        $total += $subtotal;
    }

    return ['items' => $items, 'cantidad_total' => $cantidadTotal, 'total' => $total];
}
