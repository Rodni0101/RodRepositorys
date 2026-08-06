<?php
include "PHP/conexion.php";

if (empty($_SESSION["csrf_token"])) {
    $_SESSION["csrf_token"] = bin2hex(random_bytes(32));
}

$_SESSION["pagina"] = "dashboard";

/* ==========================
   VARIABLES
========================== */

$mensaje = "";
$tipo = "";

$codigo = "";

/* Si una búsqueda encuentra un producto, la tabla se filtra
   para mostrar únicamente ese resultado. */
$productoEncontrado = null;

/* ==========================
   MENSAJES (flash desde sesión)
   Esto sigue vivo porque index.php redirige para acá
   después de actualizar un producto.
========================== */

if (isset($_SESSION["mensaje"])) {
    $mensaje = $_SESSION["mensaje"];
    $tipo = $_SESSION["tipo"] ?? "exito";

    unset($_SESSION["mensaje"]);
    unset($_SESSION["tipo"]);
}

/* ==========================
   ACCIONES
   Buscar y eliminar se resuelven en el mismo request
   (sin redirect) para poder mostrar el aviso al toque
   y, en el caso de buscar, filtrar la tabla.
========================== */

if ($_SERVER["REQUEST_METHOD"] === "POST") {

    /* Validación CSRF: si el token no coincide, se corta acá. */
    $tokenRecibido = (string) ($_POST["csrf_token"] ?? "");
    $tokenEsperado = (string) ($_SESSION["csrf_token"] ?? "");

    if (!hash_equals($tokenEsperado, $tokenRecibido)) {

        $mensaje = "Sesión inválida o expirada. Intente de nuevo.";
        $tipo = "error";

    } else {

        $accion = $_POST["accion"] ?? "";

        $codigo = trim($_POST["codigo"] ?? "");

        /* ======================
           BUSCAR
        ====================== */

        if ($accion === "buscar") {

            if ($codigo === "") {

                $mensaje = "Ingrese un código.";
                $tipo = "error";

            } else {

                $stmt = $conexion->prepare("
                    SELECT
                        codigo,
                        nombre,
                        categoria,
                        precio,
                        cantidad,
                        imagen
                    FROM productos
                    WHERE codigo = ?
                ");

                $stmt->bind_param("s", $codigo);
                $stmt->execute();

                $consulta = $stmt->get_result();

                if ($consulta->num_rows > 0) {

                    $productoEncontrado = $consulta->fetch_assoc();

                    $mensaje = "Producto encontrado.";
                    $tipo = "exito";

                } else {

                    $mensaje = "Producto no encontrado.";
                    $tipo = "error";
                }

                $stmt->close();
            }
        }

        /* ======================
           ACTUALIZAR
        ====================== */

        if ($accion === "actualizar") {

            if ($codigo === "") {

                $mensaje = "Ingrese un código para actualizar.";
                $tipo = "error";

            } else {

                $stmt = $conexion->prepare(
                    "SELECT codigo, nombre, categoria, precio, cantidad, imagen
                     FROM productos
                     WHERE codigo = ?"
                );

                $stmt->bind_param("s", $codigo);
                $stmt->execute();

                $consulta = $stmt->get_result();

                if ($consulta->num_rows > 0) {

                    $producto = $consulta->fetch_assoc();

                    $_SESSION["form_producto"] = [
                        "codigo" => $producto["codigo"],
                        "nombre" => $producto["nombre"],
                        "categoria" => $producto["categoria"],
                        "precio" => $producto["precio"],
                        "cantidad" => $producto["cantidad"],
                        "imagen" => $producto["imagen"] ?? "",
                    ];

                    $_SESSION["mensaje"] = "Producto cargado para actualizar.";
                    $_SESSION["tipo"] = "exito";

                    header("Location: index.php");
                    exit;

                } else {

                    $mensaje = "No existe un producto con ese código.";
                    $tipo = "error";
                }

                $stmt->close();
            }
        }

        /* ======================
           ELIMINAR
        ====================== */

        if ($accion === "eliminar") {

            if ($codigo === "") {

                $mensaje = "Ingrese un código.";
                $tipo = "error";

            } else {

                $stmt = $conexion->prepare("
                    DELETE
                    FROM productos
                    WHERE codigo = ?
                ");

                $stmt->bind_param("s", $codigo);
                $stmt->execute();

                if ($stmt->affected_rows > 0) {

                    $mensaje = "Producto eliminado correctamente.";
                    $tipo = "exito";

                    /* El código ya no existe, se limpia el input. */
                    $codigo = "";

                } else {

                    $mensaje = "No existe ese producto.";
                    $tipo = "error";
                }

                $stmt->close();
            }
        }
    }
}

/* ==========================
   TABLA
   Si hubo una búsqueda exitosa, se muestra solo ese producto.
   Si no, se lista todo el inventario.
========================== */

if ($productoEncontrado !== null) {

    $productos = [$productoEncontrado];

} else {

    $sql = "
    SELECT
        codigo,
        nombre,
        categoria,
        precio,
        cantidad,
        imagen
    FROM productos
    ORDER BY nombre ASC
    ";

    $resultado = $conexion->query($sql);
    $productos = $resultado ? $resultado->fetch_all(MYSQLI_ASSOC) : [];
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard | TecnoMarket</title>

    <link rel="stylesheet" href="CSS/dashboard.css">
</head>

<body>

    <div class="contenedor">

        <header>

            <div class="header-principal">
                <div class="header-titulo">
                    <div class="menu-acciones">
                        <input type="checkbox" id="menu-toggle" class="menu-toggle">

                        <label for="menu-toggle" class="menu-icon" aria-label="Abrir menú de acciones">
                            <span></span>
                            <span></span>
                            <span></span>
                        </label>

                        <form method="POST" class="Burguer" autocomplete="off">

                            <input type="hidden" name="csrf_token"
                                value="<?= htmlspecialchars($_SESSION["csrf_token"]) ?>">

                            <label for="codigo" class="campo-codigo">

                                Código

                                <input type="text" id="codigo" name="codigo" placeholder="Ej: TM-001" maxlength="20"
                                    value="<?= htmlspecialchars($codigo) ?>" required>

                            </label>

                            <div class="botones-acciones">
                                <button type="submit" name="accion" value="buscar" class="btn-buscar">
                                    Buscar
                                </button>

                                <button type="submit" name="accion" value="actualizar" class="btn-actualizar">
                                    Actualizar
                                </button>

                                <button type="submit" name="accion" value="eliminar" class="btn-eliminar"
                                    onclick="return confirm('¿Está seguro de eliminar este producto?')">
                                    Eliminar
                                </button>
                            </div>

                        </form>
                    </div>

                    <h1>Dashboard — Inventario TecnoMarket</h1>
                </div>

                <nav>
                    <a href="index.php">← Volver al formulario</a>
                </nav>
            </div>

        </header>

        <?php if ($mensaje !== ""): ?>

            <div class="mensaje <?= htmlspecialchars($tipo) ?>">

                <?= htmlspecialchars($mensaje) ?>

            </div>

        <?php endif; ?>

        <section class="tabla">

            <div class="tabla-header">

                <h2>
                    <?= $productoEncontrado !== null ? "Resultado de la búsqueda" : "Productos registrados" ?>
                </h2>

                <?php if ($productoEncontrado !== null): ?>

                    <a href="dashboard.php" class="ver-todos">
                        ✕ Ver todos los productos
                    </a>
                <?php endif; ?>
            </div>

            <table>

                <thead>

                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Categoría</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Imagen</th>
                    </tr>

                </thead>

                <tbody>

                    <?php if (count($productos) > 0): ?>

                        <?php foreach ($productos as $fila): ?>

                            <tr>
                                <td data-label="Código"><?= htmlspecialchars($fila["codigo"]) ?></td>
                                <td data-label="Nombre"><?= htmlspecialchars($fila["nombre"]) ?></td>
                                <td data-label="Categoría"><?= htmlspecialchars($fila["categoria"]) ?></td>
                                <td data-label="Precio">$ <?= number_format((float) $fila["precio"], 0, ",", ".") ?></td>
                                <td data-label="Cantidad"><?= (int) $fila["cantidad"] ?></td>
                                <td data-label="Imagen">
                                    <?php if (!empty($fila["imagen"])): ?>
                                        <a href="<?= htmlspecialchars($fila["imagen"]) ?>" target="_blank" rel="noopener"
                                            class="btn-ver-imagen">Ver imagen</a>
                                    <?php else: ?>
                                        <span class="sin-imagen">Sin foto</span>
                                    <?php endif; ?>
                                </td>
                            </tr>

                        <?php endforeach; ?>

                    <?php else: ?>

                        <tr>
                            <td colspan="5" class="vacio">
                                <?= $productoEncontrado === null ? "No hay productos registrados." : "Producto no encontrado." ?>
                            </td>
                        </tr>

                    <?php endif; ?>

                </tbody>

            </table>

        </section>

        <footer>
            <p>
                Sistema:
                <?= htmlspecialchars($_SESSION["sistema"] ?? "TecnoMarket") ?>
            </p>
        </footer>

    </div>

</body>

</html>
<?php
$conexion->close();