<?php
include "PHP/conexion.php";

$_SESSION["pagina"] = "dashboard";

$sql = "SELECT codigo, nombre, categoria, precio, cantidad FROM productos ORDER BY nombre ASC";
$resultado = $conexion->query($sql);
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="CSS/dashboard.css" />
    <title>Dashboard | TecnoMarket</title>
</head>
<body>
    <div class="contenedor">
        <header>
            <h1>Dashboard — Inventario TecnoMarket</h1>
            <nav>
                <a href="index.php">← Volver al formulario</a>
            </nav>
        </header>

        <section class="tabla">
            <h2>Productos registrados</h2>

            <table>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Categoría</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                    </tr>
                </thead>
                <tbody>
                    <?php if ($resultado && $resultado->num_rows > 0) { ?>
                        <?php while ($fila = $resultado->fetch_assoc()) { ?>
                            <tr>
                                <td><?= htmlspecialchars($fila["codigo"]) ?></td>
                                <td><?= htmlspecialchars($fila["nombre"]) ?></td>
                                <td><?= htmlspecialchars($fila["categoria"]) ?></td>
                                <td>$<?= number_format((float) $fila["precio"], 0, ",", ".") ?></td>
                                <td><?= (int) $fila["cantidad"] ?></td>
                            </tr>
                        <?php } ?>
                    <?php } else { ?>
                        <tr>
                            <td colspan="5" class="vacio">No hay productos registrados.</td>
                        </tr>
                    <?php } ?>
                </tbody>
            </table>
        </section>

        <footer>
            <p>Sistema: <?= htmlspecialchars($_SESSION["sistema"] ?? "TecnoMarket") ?></p>
        </footer>
    </div>
</body>
</html>
<?php $conexion->close(); ?>
