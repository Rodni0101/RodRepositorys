<?php
$buscar = trim($_POST['Buscar'] ?? '');

if ($_SERVER['REQUEST_METHOD'] !== 'POST' || $buscar === '') {
    header('Location: ../Formulario.php');
    exit;
}

$conexion = new mysqli('localhost', 'root', '1048442903', 'Practica_Parcial');

if ($conexion->connect_error) {
    die('No se pudo conectar a la base de datos.');
}

$consulta = 'SELECT Nombre, Apellido, Edad FROM Persona WHERE Nombre LIKE CONCAT("%", ?, "%")';
$preparacion = $conexion->prepare($consulta);

if ($preparacion === false) {
    die('No se pudo realizar la búsqueda.');
}

$preparacion->bind_param('s', $buscar);
$preparacion->execute();
$resultado = $preparacion->get_result();
//estudiar esto
$personas = $resultado->fetch_all(MYSQLI_ASSOC);

$preparacion->close();
$conexion->close();
?>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Resultados de búsqueda</title>
        <link rel="stylesheet" href="../styles.css" />
    </head>
    <body class="pagina-resultados">
        <header>Resultados de búsqueda</header>

        <main class="contenedor-resultados">
            <section class="resultados">
                <p class="busqueda-realizada">
                    Resultados para: <strong><?= htmlspecialchars($buscar) ?></strong>
                </p>

                <?php if (count($personas) > 0): ?>
                    <div class="tabla-contenedor">
                        <table>
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Edad</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php foreach ($personas as $persona): ?>
                                    <tr>
                                        <td><?= htmlspecialchars($persona['Nombre']) ?></td>
                                        <td><?= htmlspecialchars($persona['Apellido']) ?></td>
                                        <td><?= htmlspecialchars((string) $persona['Edad']) ?></td>
                                    </tr>
                                <?php endforeach; ?>
                            </tbody>
                        </table>
                    </div>
                <?php else: ?>
                    <p class="sin-resultados">No se encontraron usuarios con ese nombre.</p>
                <?php endif; ?>

                <a class="boton-volver" href="../Formulario.php">Volver al formulario</a>
            </section>
        </main>
    </body>
</html>
