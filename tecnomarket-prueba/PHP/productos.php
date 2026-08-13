<?php
function obtenerProducto(mysqli $conexion, string $codigo): ?array
{
    $q = $conexion->prepare('SELECT codigo, nombre, categoria, precio, cantidad, imagen FROM productos WHERE codigo = ?');
    $q->bind_param('s', $codigo);
    $q->execute();
    $fila = $q->get_result()->fetch_assoc() ?: null;
    $q->close();
    return $fila;
}
function listarProductos(mysqli $conexion, int $limite = 0): array
{
    $sql = $limite > 0 ? 'SELECT codigo, nombre, categoria, precio, cantidad, imagen FROM productos ORDER BY codigo DESC LIMIT ' . (int) $limite : 'SELECT codigo, nombre, categoria, precio, cantidad, imagen FROM productos ORDER BY nombre ASC';
    $r = $conexion->query($sql);
    return $r ? $r->fetch_all(MYSQLI_ASSOC) : [];
}
function estadisticasProductos(mysqli $conexion): array
{
    $r = $conexion->query("SELECT COUNT(*) productos, COALESCE(SUM(cantidad), 0) unidades, COUNT(DISTINCT NULLIF(TRIM(categoria), '')) categorias FROM productos");
    return $r ? $r->fetch_assoc() : ['productos' => 0, 'unidades' => 0, 'categorias' => 0];
}
function validarDatosProducto(array $d): ?string
{
    foreach (['codigo', 'nombre', 'categoria', 'precio', 'cantidad'] as $campo)
        if ($d[$campo] === '')
            return 'Completa todos los campos.';
    if (!is_numeric($d['precio']) || (float) $d['precio'] < 0 || filter_var($d['cantidad'], FILTER_VALIDATE_INT) === false || (int) $d['cantidad'] < 0)
        return 'El precio y la cantidad deben ser valores válidos no negativos.';
    return null;
}
function guardarProducto(mysqli $conexion, array $d): array
{
    if ($error = validarDatosProducto($d))
        return [false, $error];
    if (obtenerProducto($conexion, $d['codigo']))
        return [false, 'El código ya está registrado.'];
    $precio = (float) $d['precio'];
    $cantidad = (int) $d['cantidad'];
    $q = $conexion->prepare('INSERT INTO productos (codigo, nombre, categoria, precio, cantidad, imagen) VALUES (?, ?, ?, ?, ?, ?)');
    $q->bind_param('sssdis', $d['codigo'], $d['nombre'], $d['categoria'], $precio, $cantidad, $d['imagen']);
    $ok = $q->execute();
    $q->close();
    return [$ok, $ok ? 'Producto registrado correctamente.' : 'No fue posible guardar el producto.'];
}
function actualizarProducto(mysqli $conexion, array $d): array
{
    if ($error = validarDatosProducto($d))
        return [false, $error];
    if (!obtenerProducto($conexion, $d['codigo']))
        return [false, 'No existe un producto con ese código.'];
    $precio = (float) $d['precio'];
    $cantidad = (int) $d['cantidad'];
    $q = $conexion->prepare('UPDATE productos SET nombre = ?, categoria = ?, precio = ?, cantidad = ?, imagen = ? WHERE codigo = ?');
    $q->bind_param('ssdiss', $d['nombre'], $d['categoria'], $precio, $cantidad, $d['imagen'], $d['codigo']);
    $ok = $q->execute();
    $q->close();
    return [$ok, $ok ? 'Producto actualizado correctamente.' : 'No fue posible actualizar el producto.'];
}
function eliminarProducto(mysqli $conexion, string $codigo): array
{
    $q = $conexion->prepare('DELETE FROM productos WHERE codigo = ?');
    $q->bind_param('s', $codigo);
    $q->execute();
    $ok = $q->affected_rows > 0;
    $q->close();
    return [$ok, $ok ? 'Producto eliminado correctamente.' : 'No existe un producto con ese código.'];
}
