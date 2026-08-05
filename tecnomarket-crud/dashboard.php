<?php
include "PHP/conexion.php";

$_SESSION["pagina"] = "dashboard";

/* ==========================
   CSRF TOKEN
   Se genera una sola vez por sesión y se valida
   en cada acción que modifica datos (POST).
========================== */

if (!isset($_SESSION["csrf_token"])) {
    $_SESSION["csrf_token"] = bin2hex(random_bytes(32));
}

/* ==========================
   VARIABLES
========================== */

$mensaje = "";
$tipo = "";

$codigo = "";
$nombre = "";
$categoria = "";
$precio = "";
$cantidad = "";

/* ==========================
   MENSAJES (flash desde sesión)
========================== */

if (isset($_SESSION["mensaje"])) {
    $mensaje = $_SESSION["mensaje"];
    $tipo = $_SESSION["tipo"] ?? "exito";

    unset($_SESSION["mensaje"]);
    unset($_SESSION["tipo"]);
}

/* ==========================
   DATOS DEL FORMULARIO (persisten tras un búsqueda)
========================== */

if (isset($_SESSION["form_producto"])) {

    $codigo = $_SESSION["form_producto"]["codigo"] ?? "";
    $nombre = $_SESSION["form_producto"]["nombre"] ?? "";
    $categoria = $_SESSION["form_producto"]["categoria"] ?? "";
    $precio = $_SESSION["form_producto"]["precio"] ?? "";
    $cantidad = $_SESSION["form_producto"]["cantidad"] ?? "";
}

/* ==========================
   ACCIONES
========================== */

if ($_SERVER["REQUEST_METHOD"] === "POST") {

    /* Validación CSRF: si el token no coincide, se corta acá. */
    $tokenRecibido = $_POST["csrf_token"] ?? "";

    if (!hash_equals($_SESSION["csrf_token"], $tokenRecibido)) {

        $_SESSION["mensaje"] = "Sesión inválida o expirada. Intente de nuevo.";
        $_SESSION["tipo"] = "error";

        header("Location: dashboard.php");
        exit;
    }

    $accion = $_POST["accion"] ?? "";

    $codigo = trim($_POST["codigo"] ?? "");

    /* ======================
       BUSCAR
    ====================== */

    if ($accion === "buscar") {

        if ($codigo === "") {

            $_SESSION["mensaje"] = "Ingrese un código.";
            $_SESSION["tipo"] = "error";

            header("Location: dashboard.php");
            exit;
        }

        $stmt = $conexion->prepare("
            SELECT
                codigo,
                nombre,
                categoria,
                precio,
                cantidad
            FROM productos
            WHERE codigo = ?
        ");

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
            ];

            $_SESSION["mensaje"] = "Producto encontrado.";
            $_SESSION["tipo"] = "exito";

        } else {

            unset($_SESSION["form_producto"]);

            $_SESSION["mensaje"] = "Producto no encontrado.";
            $_SESSION["tipo"] = "error";
        }

        $stmt->close();

        header("Location: dashboard.php");
        exit;
    }

    /* ======================
       ACTUALIZAR
       Se manda el código explícitamente por GET en vez de
       confiar ciegamente en lo último guardado en sesión,
       así evitamos editar el producto equivocado si el
       usuario cambió el código en el input sin buscar antes.
    ====================== */

    if ($accion === "actualizar") {

        if ($codigo === "") {

            $_SESSION["mensaje"] = "Ingrese un código para actualizar.";
            $_SESSION["tipo"] = "error";

            if ($accion === "actualizar") {
                if ($codigo === "" || $nombre === "" || $categoria === "" || $precio === "" || $cantidad === "") {
                    $mensaje = "Complete todos los campos antes de actualizar.";
                    $tipo = "error";
                } else {
                    $existe = $conexion->prepare("SELECT codigo FROM productos WHERE codigo = ?");
                    $existe->bind_param("s", $codigo);
                    $existe->execute();
                    $resultado = $existe->get_result();

                    if ($resultado->num_rows === 0) {
                        $mensaje = "No se puede actualizar: el código no existe. Busque primero el producto.";
                        $tipo = "error";
                    } else {
                        $actualizar = $conexion->prepare(
                            "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, cantidad = ? WHERE codigo = ?"
                        );
                        $precio_num = (float) $precio;
                        $cantidad_num = (int) $cantidad;
                        $actualizar->bind_param("ssdis", $nombre, $categoria, $precio_num, $cantidad_num, $codigo);

                        if ($actualizar->execute()) {
                            $mensaje = "Producto actualizado correctamente.";
                            $tipo = "exito";
                        } else {
                            $mensaje = "Error al actualizar: " . $conexion->error;
                            $tipo = "error";
                        }
                        $actualizar->close();
                    }
                    $existe->close();
                }
            }
            header("Location: dashboard.php");
            exit;
        }

        header("Location: index.php?codigo=" . urlencode($codigo));
        exit;
    }

    /* ======================
       ELIMINAR
    ====================== */

    if ($accion === "eliminar") {

        if ($codigo === "") {

            $_SESSION["mensaje"] = "Ingrese un código.";
            $_SESSION["tipo"] = "error";

            header("Location: dashboard.php");
            exit;
        }

        $stmt = $conexion->prepare("
            DELETE
            FROM productos
            WHERE codigo = ?
        ");

        $stmt->bind_param("s", $codigo);
        $stmt->execute();

        if ($stmt->affected_rows > 0) {

            unset($_SESSION["form_producto"]);

            $_SESSION["mensaje"] = "Producto eliminado correctamente.";
            $_SESSION["tipo"] = "exito";

        } else {

            $_SESSION["mensaje"] = "No existe ese producto.";
            $_SESSION["tipo"] = "error";
        }

        $stmt->close();

        header("Location: dashboard.php");
        exit;
    }
}

/* ==========================
   TABLA
========================== */

$sql = "
SELECT
    codigo,
    nombre,
    categoria,
    precio,
    cantidad
FROM productos
ORDER BY nombre ASC
";

$resultado = $conexion->query($sql);
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

            <h1>Dashboard — Inventario TecnoMarket</h1>

            <nav>
                <a href="index.php">← Volver al formulario</a>
            </nav>

            <input type="checkbox" id="menu-toggle" class="menu-toggle">

            <label for="menu-toggle" class="menu-icon" aria-label="Abrir menú de acciones">
                ☰
            </label>

            <form method="POST" class="Burguer" autocomplete="off">

                <input type="hidden" name="csrf_token" value="<?= htmlspecialchars($_SESSION["csrf_token"]) ?>">

                <label for="codigo">

                    Código

                    <input type="text" id="codigo" name="codigo" placeholder="Ej: TM-001" maxlength="20"
                        value="<?= htmlspecialchars($codigo) ?>" required>

                </label>

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

            </form>

        </header>

        <?php if ($mensaje !== ""): ?>

            <div class="mensaje <?= htmlspecialchars($tipo) ?>">

                <?= htmlspecialchars($mensaje) ?>

            </div>

        <?php endif; ?>

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

                    <?php if ($resultado && $resultado->num_rows > 0): ?>

                        <?php while ($fila = $resultado->fetch_assoc()): ?>

                            <tr>
                                <td>
                                    <?= htmlspecialchars($fila["codigo"]) ?>
                                </td>
                                <td>
                                    <?= htmlspecialchars($fila["nombre"]) ?>
                                </td>
                                <td>
                                    <?= htmlspecialchars($fila["categoria"]) ?>
                                </td>
                                <td>$
                                    <?= number_format((float) $fila["precio"], 0, ",", ".") ?>
                                </td>
                                <td>
                                    <?= (int) $fila["cantidad"] ?>
                                </td>
                            </tr>

                        <?php endwhile; ?>

                    <?php else: ?>

                        <tr>
                            <td colspan="5" class="vacio">
                                No hay productos registrados.
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