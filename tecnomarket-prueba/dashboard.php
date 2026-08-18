<?php
include "PHP/conexion.php";
require_once __DIR__ . "/PHP/seguridad.php";
require_once __DIR__ . "/PHP/autenticacion.php";
require_once __DIR__ . "/PHP/carrito.php";
requiereAutenticacion();

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

if (isset($_SESSION["producto_encontrado"])) {
    $productoEncontrado = $_SESSION["producto_encontrado"];
    unset($_SESSION["producto_encontrado"]);
}

/* ==========================
   MENSAJES (flash desde sesión)
========================== */
/*Codigo unico generado por el servidor (Cross-Site Request Forgery)
si no existe token se crea y si existe no hace nada
*/


/*  ISSET (Valida si hay un mensaje existente en la sesion)
    UNSET (ELIMINA EL MENSAJE) 

    Los mensajes son enviados por los botones que generan las consultas ("Eliminar", "Actualizar", "Buscar")
    */
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

                $consulta = $conexion->prepare("
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

                $consulta->bind_param("s", $codigo);
                $consulta->execute();

                $consulta = $consulta->get_result();

                if ($consulta->num_rows > 0) {

                    $productoEncontrado = $consulta->fetch_assoc();

                    $mensaje = "Producto encontrado.";
                    $tipo = "exito";

                } else {

                    $mensaje = "Producto no encontrado.";
                    $tipo = "error";
                }

                $consulta->close();
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

                $consulta = $conexion->prepare(
                    "SELECT codigo, nombre, categoria, precio, cantidad, imagen
                     FROM productos
                     WHERE codigo = ?"
                );

                $consulta->bind_param("s", $codigo);
                $consulta->execute();

                $consulta = $consulta->get_result();

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

                $consulta->close();
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

                $consulta = $conexion->prepare("
                    DELETE
                    FROM productos
                    WHERE codigo = ?
                ");

                $consulta->bind_param("s", $codigo);
                $consulta->execute();

                if ($consulta->affected_rows > 0) {

                    $mensaje = "Producto eliminado correctamente.";
                    $tipo = "exito";

                    /* El código ya no existe, se limpia el input. */
                    $codigo = "";

                } else {

                    $mensaje = "No existe ese producto.";
                    $tipo = "error";
                }

                $consulta->close();
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

$resumenCarrito = resumenCarrito($conexion);

?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard | TecnoMarket</title>

    <link rel="stylesheet" href="CSS/dashboard.css">
    <link rel="shortcut icon" href="./Favicon/favicon_128x128.png" type="image/x-icon">
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

                        <form method="POST" action="PHP/acciones_dashboard.php" class="Burguer" autocomplete="off">

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
                    <details class="carrito-desplegable">
                        <summary class="btn-carrito" aria-label="Abrir carrito de compra">
                            <span aria-hidden="true">🛒</span> Carrito
                            <span class="contador-carrito"><?= $resumenCarrito['cantidad_total'] ?></span>
                        </summary>
                        <div class="panel-carrito">
                            <div class="panel-carrito-cabecera">
                                <div>
                                    <span class="etiqueta-carrito">Resumen de compra</span>
                                    <h2>Tu carrito</h2>
                                </div>
                                <span><?= $resumenCarrito['cantidad_total'] ?> producto(s)</span>
                            </div>

                            <?php if ($resumenCarrito['items']): ?>
                                <div class="items-carrito">
                                    <?php foreach ($resumenCarrito['items'] as $item): ?>
                                        <article class="item-carrito">
                                            <div class="item-carrito-info">
                                                <strong><?= htmlspecialchars($item['nombre']) ?></strong>
                                                <span>$ <?= number_format((float) $item['precio'], 0, ',', '.') ?> c/u</span>
                                            </div>
                                            <form method="post" action="PHP/acciones_carrito.php" class="cantidad-carrito">
                                                <input type="hidden" name="csrf_token" value="<?= htmlspecialchars(tokenCsrf()) ?>">
                                                <input type="hidden" name="codigo" value="<?= htmlspecialchars($item['codigo']) ?>">
                                                <input type="number" name="cantidad" value="<?= $item['cantidad_carrito'] ?>" min="1" max="<?= (int) $item['cantidad'] ?>" aria-label="Cantidad de <?= htmlspecialchars($item['nombre']) ?>">
                                                <button type="submit" name="accion" value="actualizar_carrito">Actualizar</button>
                                            </form>
                                            <div class="item-carrito-pie">
                                                <strong>$ <?= number_format((float) $item['subtotal'], 0, ',', '.') ?></strong>
                                                <form method="post" action="PHP/acciones_carrito.php">
                                                    <input type="hidden" name="csrf_token" value="<?= htmlspecialchars(tokenCsrf()) ?>">
                                                    <input type="hidden" name="codigo" value="<?= htmlspecialchars($item['codigo']) ?>">
                                                    <button class="btn-quitar" type="submit" name="accion" value="eliminar_del_carrito">Quitar</button>
                                                </form>
                                            </div>
                                        </article>
                                    <?php endforeach; ?>
                                </div>
                                <div class="total-carrito"><span>Total a pagar</span><strong>$ <?= number_format((float) $resumenCarrito['total'], 0, ',', '.') ?></strong></div>
                                <div class="acciones-carrito">
                                    <form method="post" action="PHP/acciones_carrito.php">
                                        <input type="hidden" name="csrf_token" value="<?= htmlspecialchars(tokenCsrf()) ?>">
                                        <button class="btn-vaciar" type="submit" name="accion" value="vaciar_carrito">Vaciar</button>
                                    </form>
                                    <form method="post" action="PHP/acciones_carrito.php">
                                        <input type="hidden" name="csrf_token" value="<?= htmlspecialchars(tokenCsrf()) ?>">
                                        <button class="btn-pagar" type="submit" name="accion" value="finalizar_compra" onclick="return confirm('¿Confirmas la compra? Se descontará el inventario.')">Finalizar compra</button>
                                    </form>
                                </div>
                            <?php else: ?>
                                <p class="carrito-vacio">Aún no agregaste productos. Usa el botón de la tabla para comenzar.</p>
                            <?php endif; ?>
                        </div>
                    </details>
                    <a href="index.php">← Volver al formulario</a>
                    <span class="separador-nav" aria-hidden="true"></span>
                    <form class="form-salir" action="PHP/acciones_auth.php" method="post">
                        <input type="hidden" name="csrf_token" value="<?= htmlspecialchars(tokenCsrf()) ?>">
                        <button class="btn-salir" type="submit" name="accion" value="logout">Cerrar sesión</button>
                    </form>
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
                        <th>Compra</th>
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
                                <td data-label="Compra">
                                    <?php if ((int) $fila['cantidad'] > 0): ?>
                                        <form method="post" action="PHP/acciones_carrito.php" class="form-agregar-carrito">
                                            <input type="hidden" name="csrf_token" value="<?= htmlspecialchars(tokenCsrf()) ?>">
                                            <input type="hidden" name="codigo" value="<?= htmlspecialchars($fila['codigo']) ?>">
                                            <button type="submit" name="accion" value="agregar_carrito">+ Agregar</button>
                                        </form>
                                    <?php else: ?>
                                        <span class="agotado">Agotado</span>
                                    <?php endif; ?>
                                </td>
                            </tr>

                        <?php endforeach; ?>

                    <?php else: ?>

                        <tr>
                            <td colspan="7" class="vacio">
                                <?= $productoEncontrado === null ? "No hay productos registrados." : "Producto no encontrado." ?>
                            </td>
                        </tr>

                    <?php endif; ?>

                </tbody>

            </table>

        </section>

        <footer class="footer-institucional">
            <div class="footer-marca">
                <a class="marca" href="index.php" aria-label="TecnoMarket, inicio">TM<span>.</span></a>
                <p>Inventario digital para una gestión tecnológica clara y eficiente.</p>
            </div>
            <div class="footer-creditos">
                <p>Proyecto académico desarrollado por <strong>Rodney Puertas</strong></p>
                <p>Aprendiz de Análisis y Desarrollo de Software · SENA</p>
            </div>
            <div class="footer-presentacion">
                <p><?= date("Y") ?> · TecnoMarket S.A.S.</p>
            </div>
        </footer>

    </div>

</body>

</html>
<?php
$conexion->close();
