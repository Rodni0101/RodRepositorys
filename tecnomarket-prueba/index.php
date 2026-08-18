<?php
include "PHP/conexion.php";
require_once __DIR__ . "/PHP/seguridad.php";
require_once __DIR__ . "/PHP/autenticacion.php";
requiereAutenticacion();

if (empty($_SESSION["csrf_token"])) {
    $_SESSION["csrf_token"] = bin2hex(random_bytes(32));
}

function subirImagenProducto(array $archivo, string $directorio): array
{
    if (!isset($archivo["name"]) || $archivo["error"] !== UPLOAD_ERR_OK) {
        return ["ok" => false, "mensaje" => "No se seleccionó una imagen válida.", "ruta" => ""];
    }

    if (!is_dir($directorio)) {
        mkdir($directorio, 0777, true);
    }

    $nombreOriginal = basename($archivo["name"]);
    $extension = pathinfo($nombreOriginal, PATHINFO_EXTENSION);
    $nombreArchivo = uniqid("prod_", true) . ($extension !== "" ? "." . strtolower($extension) : "");
    $rutaDestino = $directorio . "/" . $nombreArchivo;

    if (!move_uploaded_file($archivo["tmp_name"], $rutaDestino)) {
        return ["ok" => false, "mensaje" => "No se pudo guardar la imagen en el servidor.", "ruta" => ""];
    }

    return ["ok" => true, "mensaje" => "", "ruta" => "uploads/" . $nombreArchivo];
}

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
$imagen = "";

// Recuperar datos del formulario guardados en sesión (después de buscar o error)
if (isset($_SESSION["form_producto"])) {
    $codigo = $_SESSION["form_producto"]["codigo"] ?? "";
    $nombre = $_SESSION["form_producto"]["nombre"] ?? "";
    $categoria = $_SESSION["form_producto"]["categoria"] ?? "";
    $precio = $_SESSION["form_producto"]["precio"] ?? "";
    $cantidad = $_SESSION["form_producto"]["cantidad"] ?? "";
    $imagen = $_SESSION["form_producto"]["imagen"] ?? "";
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
    $imagen = trim($_POST["imagen_actual"] ?? "");
    $subidaError = "";

    if (isset($_FILES["imagen"]) && $_FILES["imagen"]["error"] !== UPLOAD_ERR_NO_FILE) {
        $resultadoSubida = subirImagenProducto($_FILES["imagen"], __DIR__ . "/uploads");
        if ($resultadoSubida["ok"]) {
            $imagen = $resultadoSubida["ruta"];
        } else {
            $subidaError = $resultadoSubida["mensaje"];
        }
    }

    $_SESSION["form_producto"] = [
        "codigo" => $codigo,
        "nombre" => $nombre,
        "categoria" => $categoria,
        "precio" => $precio,
        "cantidad" => $cantidad,
        "imagen" => $imagen,
    ];

    // BUSCAR

    if ($subidaError !== "") {
        $mensaje = $subidaError;
        $tipo = "error";
    } elseif ($accion === "buscar") {
        if ($codigo === "") {
            $mensaje = "Ingrese el código del producto a buscar.";
            $tipo = "error";
        } else {
            $stmt = $conexion->prepare("SELECT codigo, nombre, categoria, precio, cantidad, imagen FROM productos WHERE codigo = ?");
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
                $imagen = $fila["imagen"] ?? "";
                $_SESSION["form_producto"] = [
                    "codigo" => $codigo,
                    "nombre" => $nombre,
                    "categoria" => $categoria,
                    "precio" => $precio,
                    "cantidad" => $cantidad,
                    "imagen" => $imagen,
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
                    "INSERT INTO productos (codigo, nombre, categoria, precio, cantidad, imagen) VALUES (?, ?, ?, ?, ?, ?)"
                );
                $precio_num = (float) $precio;
                $cantidad_num = (int) $cantidad;
                $insertar->bind_param("sssdis", $codigo, $nombre, $categoria, $precio_num, $cantidad_num, $imagen);

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
                    "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, cantidad = ?, imagen = ? WHERE codigo = ?"
                );
                $precio_num = (float) $precio;
                $cantidad_num = (int) $cantidad;
                $actualizar->bind_param("ssdiss", $nombre, $categoria, $precio_num, $cantidad_num, $imagen, $codigo);

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

/* Productos recientes para la portada. Se consulta al final para reflejar
   inmediatamente cualquier alta, actualización o eliminación. */
$productosDestacados = [];
$estadisticasInventario = [
    "productos" => 0,
    "unidades" => 0,
    "categorias" => 0,
];

$consultaEstadisticas = $conexion->query(
    "SELECT
        COUNT(*) AS productos,
        COALESCE(SUM(cantidad), 0) AS unidades,
        COUNT(DISTINCT NULLIF(TRIM(categoria), '')) AS categorias
     FROM productos"
);

if ($consultaEstadisticas) {
    $estadisticasInventario = $consultaEstadisticas->fetch_assoc();
}

$consultaDestacados = $conexion->query(
    "SELECT codigo, nombre, categoria, precio, cantidad, imagen
     FROM productos
     ORDER BY codigo DESC
     LIMIT 8"
);

if ($consultaDestacados) {
    $productosDestacados = $consultaDestacados->fetch_all(MYSQLI_ASSOC);
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="CSS/formulario.css" />
    <link rel="shortcut icon" href="./Favicon/favicon_128x128.png" type="image/x-icon">
    <title>TecnoMarket | Inventario</title>
</head>

<body>
    <main class="pagina-principal">
        <header class="hero" aria-labelledby="titulo-principal">
            <nav class="navegacion" aria-label="Navegación principal">
                <a class="marca" href="index.php" aria-label="TecnoMarket, inicio">TM<span>.</span></a>
                <div class="enlaces-nav">
                    <a href="#catalogo">Productos</a>
                    <a href="#formulario">Registrar producto</a>
                    <a class="nav-dashboard" href="dashboard.php">Ver inventario <span aria-hidden="true"> ➤ </span></a>
                    <span class="separador-nav" aria-hidden="true"></span>
                    <form class="form-salir" action="PHP/acciones_auth.php" method="post">
                        <input type="hidden" name="csrf_token" value="<?= htmlspecialchars(tokenCsrf()) ?>">
                        <button class="btn-salir" type="submit" name="accion" value="logout">Cerrar sesión</button>
                    </form>
                </div>
            </nav>

            <div class="hero-contenido">
                <p class="eyebrow">Gestión inteligente de inventario</p>
                <h1 id="titulo-principal">Tus productos, <span>siempre bajo control.</span></h1>
                <p class="hero-texto">Registra, organiza y consulta el inventario de TecnoMarket desde un solo lugar.
                </p>
                <div class="hero-acciones">
                    <a class="btn-hero-principal" href="#formulario">Agregar producto<span aria-hidden="true">↓</span></a>
                    <a class="btn-hero-secundario" href="dashboard.php">Explorar inventario</a>
                </div>
            </div>

            <div class="hero-estadisticas" aria-label="Resumen del catálogo">
                <div>
                    <strong><?= number_format((int) $estadisticasInventario["productos"], 0, ",", ".") ?></strong><span>productos
                        registrados</span>
                </div>
                <div><strong><?= number_format((int) $estadisticasInventario["unidades"], 0, ",", ".") ?></strong><span>unidades
                        disponibles</span></div>
                <div>
                    <strong><?= number_format((int) $estadisticasInventario["categorias"], 0, ",", ".") ?></strong><span>categorías
                        registradas</span>
                </div>
            </div>
        </header>

        <section class="catalogo" id="catalogo" aria-labelledby="titulo-catalogo">
            <div class="seccion-encabezado">
                <div>
                    <p class="eyebrow">Catálogo visual</p>
                    <h2 id="titulo-catalogo">Productos destacados</h2>
                </div>
            </div>

            <?php if (count($productosDestacados) > 0): ?>
                <div class="carrusel-contenedor">
                    <button class="control-carrusel control-anterior" type="button" data-carrusel="anterior"
                        aria-label="Ver productos anteriores">‹</button>
                    <div class="carrusel" tabindex="0" aria-label="Carrusel de productos">
                        <div class="pista-carrusel">
                            <?php foreach ($productosDestacados as $producto): ?>
                                <article class="tarjeta-producto">
                                    <div class="imagen-producto">
                                        <?php if (!empty($producto["imagen"])): ?>
                                            <img src="<?= htmlspecialchars($producto["imagen"]) ?>"
                                                alt="<?= htmlspecialchars($producto["nombre"]) ?>" loading="lazy">
                                        <?php else: ?>
                                            <span class="sr-only">Producto sin imagen</span>
                                        <?php endif; ?>
                                        <span class="etiqueta-categoria"><?= htmlspecialchars($producto["categoria"]) ?></span>
                                    </div>
                                    <div class="tarjeta-contenido">
                                        <p class="codigo-producto"><?= htmlspecialchars($producto["codigo"]) ?></p>
                                        <h3><?= htmlspecialchars($producto["nombre"]) ?></h3>
                                        <div class="tarjeta-pie">
                                            <strong>$ <?= number_format((float) $producto["precio"], 0, ",", ".") ?></strong>
                                            <span><?= (int) $producto["cantidad"] ?> unidades</span>
                                        </div>
                                    </div>
                                </article>
                            <?php endforeach; ?>
                        </div>
                    </div>
                    <button class="control-carrusel control-siguiente" type="button" data-carrusel="siguiente"
                        aria-label="Ver productos siguientes">›</button>
                </div>
            <?php else: ?>
                <div class="catalogo-vacio">
                    <h3>Tu catálogo empezará aquí</h3>
                    <p>Registra el primer producto y aparecerá en esta sección.</p>
                    <a href="#formulario">Registrar producto</a>
                </div>
            <?php endif; ?>
        </section>

        <section class="formulario-seccion" id="formulario" aria-labelledby="titulo-formulario">
            <div class="formulario-intro">
                <p class="eyebrow">Nuevo registro</p>
                <h2 id="titulo-formulario">Añade un producto al inventario</h2>
                <p>Completa los datos esenciales para mantener tu catálogo actualizado y fácil de consultar.</p>
            </div>

            <form action="PHP/acciones_producto.php" method="post" enctype="multipart/form-data">
                <input type="hidden" name="csrf_token" value="<?= htmlspecialchars(tokenCsrf()) ?>">
                <h2 class="titulo-form">Datos del producto</h2>
                <p class="subtitulo-form">Los campos con información precisa facilitan la gestión del inventario.</p>

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

                    <label for="imagen">
                        Foto del producto
                        <input id="imagen" name="imagen" type="file" accept="image/*" />
                    </label>
                    <input type="hidden" name="imagen_actual" value="<?= htmlspecialchars($imagen) ?>">

                    <?php if ($imagen !== "") { ?>
                        <div class="preview-imagen">
                            <img src="<?= htmlspecialchars($imagen) ?>" alt="Imagen del producto" />
                            <a href="<?= htmlspecialchars($imagen) ?>" target="_blank" class="btn-link btn-ver-imagen">Ver
                                imagen</a>
                        </div>
                    <?php } ?>
                </fieldset>

                <div class="acciones">
                    <button type="submit" name="accion" value="guardar" class="btn-guardar">Guardar</button>
                    <button type="submit" name="accion" value="actualizar" class="btn-actualizar">Actualizar</button>
                    <button type="submit" name="accion" value="nuevo" class="btn-nuevo">Nuevo</button>
                    <a class="btn-link btn-dashboard" href="dashboard.php">Dashboard</a>
                </div>
            </form>
        </section>
    </main>

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

    <script>
        (() => {
            const carrusel = document.querySelector('.carrusel');
            const pista = document.querySelector('.pista-carrusel');
            if (!carrusel || !pista) return;

            const desplazar = (direccion) => {
                const tarjeta = pista.querySelector('.tarjeta-producto');
                const distancia = tarjeta ? tarjeta.getBoundingClientRect().width + 20 : 300;
                carrusel.scrollBy({ left: direccion * distancia, behavior: 'smooth' });
            };

            document.querySelector('[data-carrusel="anterior"]')?.addEventListener('click', () => desplazar(-1));
            document.querySelector('[data-carrusel="siguiente"]')?.addEventListener('click', () => desplazar(1));
            carrusel.addEventListener('keydown', (evento) => {
                if (evento.key === 'ArrowLeft') desplazar(-1);
                if (evento.key === 'ArrowRight') desplazar(1);
            });

            if (!window.matchMedia('(prefers-reduced-motion: reduce)').matches) {
                let intervalo = setInterval(() => {
                    const limite = carrusel.scrollWidth - carrusel.clientWidth;
                    carrusel.scrollTo({ left: carrusel.scrollLeft >= limite - 2 ? 0 : carrusel.scrollLeft + 300, behavior: 'smooth' });
                }, 4500);
                carrusel.addEventListener('mouseenter', () => clearInterval(intervalo), { once: true });
                carrusel.addEventListener('focusin', () => clearInterval(intervalo), { once: true });
            }
        })();
    </script>
</body>

</html>
<?php $conexion->close(); ?>
