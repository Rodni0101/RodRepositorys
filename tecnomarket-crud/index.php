<?php
include "PHP/conexion.php";

$mensaje = "";
$tipo = "";

if (isset($_SESSION["mensaje"])) {
    $mensaje = $_SESSION["mensaje"];
    $tipo = $_SESSION["tipo"] ?? "exito";
    unset($_SESSION["mensaje"], $_SESSION["tipo"]);
}

$codigo = "";
$nombre = "";
$categoria = "";
$precio = "";
$cantidad = "";

// Recuperar datos del formulario guardados en sesión (después de buscar o error)
if (isset($_SESSION["form_producto"])) {
    $codigo = $_SESSION["form_producto"]["codigo"] ?? "";
    $nombre = $_SESSION["form_producto"]["nombre"] ?? "";
    $categoria = $_SESSION["form_producto"]["categoria"] ?? "";
    $precio = $_SESSION["form_producto"]["precio"] ?? "";
    $cantidad = $_SESSION["form_producto"]["cantidad"] ?? "";
}

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $accion = $_POST["accion"] ?? "";

    if ($accion === "nuevo") {
        unset($_SESSION["form_producto"]);
        $_SESSION["mensaje"] = "Formulario limpiado correctamente.";
        $_SESSION["tipo"] = "exito";
        header("Location: index.php");
        exit;
    }

    $codigo = trim($_POST["codigo"] ?? "");
    $nombre = trim($_POST["nombre"] ?? "");
    $categoria = trim($_POST["categoria"] ?? "");
    $precio = trim($_POST["precio"] ?? "");
    $cantidad = trim($_POST["cantidad"] ?? "");

    $_SESSION["form_producto"] = [
        "codigo" => $codigo,
        "nombre" => $nombre,
        "categoria" => $categoria,
        "precio" => $precio,
        "cantidad" => $cantidad,
    ];

    // BUSCAR

    if ($accion === "buscar") {
        if ($codigo === "") {
            $mensaje = "Ingrese el código del producto a buscar.";
            $tipo = "error";
        } else {
            $stmt = $conexion->prepare("SELECT codigo, nombre, categoria, precio, cantidad FROM productos WHERE codigo = ?");
            $stmt->bind_param("s", $codigo);
            $stmt->execute();
            $resultado = $stmt->get_result();

            if ($resultado->num_rows > 0) {
                $fila = $resultado->fetch_assoc();
                $codigo = $fila["codigo"];
                $nombre = $fila["nombre"];
                $categoria = $fila["categoria"];
                $precio = $fila["precio"];
                $cantidad = $fila["cantidad"];
                $_SESSION["form_producto"] = [
                    "codigo" => $codigo,
                    "nombre" => $nombre,
                    "categoria" => $categoria,
                    "precio" => $precio,
                    "cantidad" => $cantidad,
                ];
                $mensaje = "Producto encontrado. Puede actualizar o eliminar.";
                $tipo = "exito";
            } else {
                $mensaje = "No existe un producto con ese código.";
                $tipo = "error";
            }
            $stmt->close();
        }
    }

    // GUARDAR 

    if ($accion === "guardar") {
        if ($codigo === "" || $nombre === "" || $categoria === "" || $precio === "" || $cantidad === "") {
            $mensaje = "Complete todos los campos antes de guardar.";
            $tipo = "error";
        } else {
            $verificar = $conexion->prepare("SELECT codigo FROM productos WHERE codigo = ?");
            $verificar->bind_param("s", $codigo);
            $verificar->execute();
            $existe = $verificar->get_result();

            if ($existe->num_rows > 0) {
                $mensaje = "El código ya está registrado. Use otro código o busque el producto para actualizar.";
                $tipo = "error";
            } else {
                $insertar = $conexion->prepare(
                    "INSERT INTO productos (codigo, nombre, categoria, precio, cantidad) VALUES (?, ?, ?, ?, ?)"
                );
                $precio_num = (float) $precio;
                $cantidad_num = (int) $cantidad;
                $insertar->bind_param("sssdi", $codigo, $nombre, $categoria, $precio_num, $cantidad_num);

                if ($insertar->execute()) {
                    $_SESSION["ultimo_codigo"] = $codigo;
                    $mensaje = "Producto registrado correctamente.";
                    $tipo = "exito";
                } else {
                    $mensaje = "Error al guardar: " . $conexion->error;
                    $tipo = "error";
                }
                $insertar->close();
            }
            $verificar->close();
        }
    }

    //ACTUALIZAR

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

    // ELIMINAR

    if ($accion === "eliminar") {
        if ($codigo === "") {
            $mensaje = "Ingrese el código del producto a eliminar.";
            $tipo = "error";
        } else {
            $eliminar = $conexion->prepare("DELETE FROM productos WHERE codigo = ?");
            $eliminar->bind_param("s", $codigo);

            if ($eliminar->execute() && $eliminar->affected_rows > 0) {
                $codigo = $nombre = $categoria = $precio = $cantidad = "";
                unset($_SESSION["form_producto"]);
                $mensaje = "Producto eliminado correctamente.";
                $tipo = "exito";
            } else {
                $mensaje = "No existe un producto con ese código.";
                $tipo = "error";
            }
            $eliminar->close();
        }
    }
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="CSS/formulario.css" />
    <title>TecnoMarket | Inventario</title>
</head>

<body>
    <form action="index.php" method="post">
        <h1 class="titulo-form">TecnoMarket S.A.S.</h1>
        <p class="subtitulo-form">Administración de productos — Laboratorio CRUD SENA</p>

        <?php if ($mensaje !== "") { ?>
            <div class="mensaje <?= htmlspecialchars($tipo) ?>">
                <?= htmlspecialchars($mensaje) ?>
            </div>
        <?php } ?>

        <fieldset>
            <legend>Datos del producto</legend>

            <label for="codigo">
                Código
                <input id="codigo" name="codigo" type="text" placeholder="Ej: TM-001"
                    value="<?= htmlspecialchars($codigo) ?>" />
            </label>

            <label for="nombre">
                Nombre
                <input id="nombre" name="nombre" type="text" placeholder="Nombre del producto"
                    value="<?= htmlspecialchars($nombre) ?>" />
            </label>

            <label for="categoria">
                Categoría
                <input id="categoria" name="categoria" type="text" placeholder="Ej: Periféricos"
                    value="<?= htmlspecialchars($categoria) ?>" />
            </label>

            <label for="precio">
                Precio
                <input id="precio" name="precio" type="number" min="0" step="0.01" placeholder="0.00"
                    value="<?= htmlspecialchars((string) $precio) ?>" />
            </label>

            <label for="cantidad">
                Cantidad
                <input id="cantidad" name="cantidad" type="number" min="0" step="1" placeholder="0"
                    value="<?= htmlspecialchars((string) $cantidad) ?>" />
            </label>
        </fieldset>

        <div class="acciones">
            <button type="submit" name="accion" value="guardar" class="btn-guardar">Guardar</button>
            <button type="submit" name="accion" value="actualizar" class="btn-actualizar">Actualizar</button>
            <button type="submit" name="accion" value="nuevo" class="btn-nuevo">Nuevo</button>
            <a class="btn-link btn-dashboard" href="dashboard.php">Dashboard</a>
        </div>
    </form>
</body>

</html>
<?php $conexion->close(); ?>