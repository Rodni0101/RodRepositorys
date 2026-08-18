# TecnoMarket — guía docente del proyecto

**Autor:** Rodney Puertas  
**Programa:** Análisis y Desarrollo de Software — SENA  
**Propósito:** presentación universitaria de un sistema CRUD para administrar inventario.

## 1. Qué problema resuelve

TecnoMarket evita llevar el inventario de productos en listas manuales. Permite registrar un producto con código, nombre, categoría, precio, cantidad e imagen; buscarlo, editarlo y eliminarlo. Además, presenta las existencias tanto en una tabla como en tarjetas visuales.

CRUD significa: **Create** (crear), **Read** (leer), **Update** (actualizar) y **Delete** (eliminar). La aplicación usa PHP, MySQL, HTML, CSS y JavaScript sin frameworks.

## 2. Mapa de archivos

| Archivo | Responsabilidad |
| --- | --- |
| `index.php` | Página principal, lógica CRUD, métricas, carrusel y formulario. |
| `dashboard.php` | Consulta y presentación tabular del inventario. |
| `PHP/conexion.php` | Sesión, conexión MySQL, codificación y compatibilidad de la columna `imagen`. |
| `CSS/formulario.css` | Diseño responsive de la portada, formulario, cards y footer. |
| `CSS/dashboard.css` | Diseño del dashboard y menú de acciones. |
| `uploads/` | Archivos de imagen cargados por los usuarios. |

## 3. Preparación local

1. Cree e importe la base de datos indicada en `database.sql`.
2. Configure las credenciales de MySQL en `PHP/conexion.php`. Para publicar el proyecto, guárdelas en variables de entorno; nunca las comparta en un repositorio público.
3. Ejecute `php -S localhost:8080` desde esta carpeta.
4. Abra `http://localhost:8080/index.php`.

## 4. Lectura guiada, archivo por archivo

La explicación sigue el orden del código. En CSS, varias reglas de una misma sección se agrupan porque forman una sola decisión de interfaz; cada selector y propiedad relevante está explicado.

### 4.1 `PHP/conexion.php`

```php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
```

- La condición comprueba si PHP no ha iniciado una sesión.
- `session_start()` habilita `$_SESSION`, que conserva mensajes y datos entre solicitudes.

```php
$host = "localhost";
$user = "root";
$pass = "...";
$db = "tecnomarket_db";
$conexion = new mysqli($host, $user, $pass, $db);
```

- Las cuatro primeras líneas definen servidor, usuario, clave y base de datos.
- `new mysqli(...)` crea el objeto de conexión que usan los demás archivos.

```php
if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}
$conexion->set_charset("utf8mb4");
```

- Si MySQL falla, `connect_error` tendrá información; `die()` detiene una página que no puede funcionar correctamente.
- `utf8mb4` guarda tildes, ñ y caracteres Unicode de forma segura.

```php
$verificarColumna = $conexion->query("SHOW COLUMNS FROM productos LIKE 'imagen'");
if ($verificarColumna && $verificarColumna->num_rows === 0) {
    $conexion->query("ALTER TABLE productos ADD COLUMN imagen VARCHAR(255) NULL");
}
```

- La primera línea pregunta a MySQL si existe la columna `imagen`.
- La condición valida que la consulta respondió y que no encontró filas.
- `ALTER TABLE` añade una ruta de hasta 255 caracteres solo en instalaciones antiguas que aún no la tenían.
- La última asignación de sesión identifica el nombre del sistema para el footer del dashboard.

### 4.2 `index.php`: arranque y seguridad

```php
include "PHP/conexion.php";
if (empty($_SESSION["csrf_token"])) {
    $_SESSION["csrf_token"] = bin2hex(random_bytes(32));
}
```

- `include` ejecuta la conexión antes de usar `$conexion`.
- `empty()` revisa si falta el token de seguridad.
- `random_bytes(32)` genera 32 byDATE
datetes aleatorios seguros y `bin2hex()` los convierte a texto. El token está preparado para validaciones CSRF; debe enviarse y comprobarse también en el formulario principal para endurecer aún más la seguridad.

```php
function subirImagenProducto(array $archivo, string $directorio): array
```

- Declara una función reutilizable. `array $archivo` exige el arreglo de `$_FILES`; `string $directorio` exige una ruta; `: array` establece que retornará un arreglo.

```php
if (!isset($archivo["name"]) || $archivo["error"] !== UPLOAD_ERR_OK) { ... }
if (!is_dir($directorio)) { mkdir($directorio, 0777, true); }
```

- La primera condición rechaza archivos inexistentes o con error de carga.
- La segunda crea `uploads/` si no existe. El tercer argumento permite crear carpetas intermedias.

```php
$nombreOriginal = basename($archivo["name"]);
$extension = pathinfo($nombreOriginal, PATHINFO_EXTENSION);
$nombreArchivo = uniqid("prod_", true) . (...);
$rutaDestino = $directorio . "/" . $nombreArchivo;
```

- `basename()` descarta directorDATE
dateios enviados por el navegador.
- `pathinfo()` extrae la extensión.
- `uniqid()` evita sobrescribir una foto previa; el prefijo ayuda a reconocer el tipo de archivo.
- La última línea compone la ruta física donde se moverá el archivo.

```php
if (!move_uploaded_file($archivo["tmp_name"], $rutaDestino)) { ... }
return ["ok" => true, "mensaje" => "", "ruta" => "uploads/" . $nombreArchivo];
```

- `move_uploaded_file()` solo acepta archivos recibidos por HTTP POST, una protección de PHP.
- El retorno uniforme contiene éxito, mensaje y ruta para que el controlador decida qué mostrar.

### 4.3 `index.php`: variables y mensajes

```php
$mensaje = ""; $tipo = "";
$codigo = ""; $nombre = ""; $categoria = "";
$precio = ""; $cantidad = ""; $imagen = "";
```

- Cada variable empieza vacía para que el HTML pueda pintarse incluso antes de la primera acción.
- `mensaje` y `tipo` controlan el aviso de éxito o error; las demás llenan los campos del formulario.

```php
if (isset($_SESSION["mensaje"])) { ... unset($_SESSION["mensaje"], $_SESSION["tipo"]); }
```

- Recupera un mensaje flash dejado por un redireccionamiento.
- `unset()` lo borra al leerlo para que no reaparezca en cada recarga.

```php
if (isset($_SESSION["form_producto"])) { ... }
```

- Restaura datos previamente buscados o enviados; así el usuario no pierde la información al corregir un error.

### 4.4 `index.php`: decisiones CRUD

```php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $accion = $_POST["accion"] ?? "";
}
```

- Esta condición separa una visita normal (`GET`) de un envío de formulario (`POST`).
- El operador `??` usa cadena vacía si no se recibió `accion`.

```php
if ($accion === "nuevo") {
    unset($_SESSION["form_producto"]);
    $_SESSION["mensaje"] = "Formulario limpiado correctamente.";
    header("Location: index.php"); exit;
}
```

- Borra los datos recordados.
- Crea el mensaje flash y redirecciona; `exit` impide que PHP continúe usando la solicitud anterior.

```php
$codigo = trim($_POST["codigo"] ?? "");
```

- La misma lógica se repite para nombre, categoría, precio y cantidad.
- `trim()` elimina espacios innecesarios; el valor queda disponible para todas las acciones siguientes.

```php
if (isset($_FILES["imagen"]) && $_FILES["imagen"]["error"] !== UPLOAD_ERR_NO_FILE) { ... }
$_SESSION["form_producto"] = [ ... ];
```

- Si el usuario seleccionó una imagen, llama a la función de carga.
- El arreglo de sesión conserva todos los valores, incluida la ruta nueva o anterior.

#### Buscar

```php
$stmt = $conexion->prepare("SELECT ... FROM productos WHERE codigo = ?");
$stmt->bind_param("s", $codigo);
$stmt->execute();
$resultado = $stmt->get_result();
```

- `prepare()` crea una consulta parametrizada: el `?` no concatena texto del usuario, por lo que reduce SQL injection.
- `bind_param("s", ...)` indica que el código es texto (`s`, string).
- `execute()` envía la consulta y `get_result()` obtiene filas.
- Si hay una fila, `fetch_assoc()` la convierte a arreglo asociativo y llena el formulario; si no, se muestra un error.

#### Guardar

```php
$verificar = $conexion->prepare("SELECT codigo FROM productos WHERE codigo = ?");
```

- Antes de insertar, busca el código. Evita que el usuario duplique un identificador existente.

```php
$insertar = $conexion->prepare("INSERT INTO productos (...) VALUES (?, ?, ?, ?, ?, ?)");
$precio_num = (float) $precio;
$cantidad_num = (int) $cantidad;
$insertar->bind_param("sssdis", ...);
```

- `INSERT` crea la fila.
- Los casteos garantizan un decimal para precio y un entero para cantidad.
- La firma `sssdis` significa: tres textos, un decimal, un entero y un texto.
- `execute()` confirma la operación; después se crea un mensaje de éxito o se informa el error.

#### Actualizar y eliminar

```php
UPDATE productos SET nombre = ?, categoria = ?, precio = ?, cantidad = ?, imagen = ? WHERE codigo = ?
DELETE FROM productos WHERE codigo = ?
```

- El primer SQL modifica solo la fila cuyo código coincide con el último parámetro.
- El segundo borra esa fila. `affected_rows > 0` confirma que realmente existía un registro eliminado.
- Cada `prepare()` se cierra con `close()` cuando termina, liberando el recurso de MySQL.

### 4.5 Métricas y productos destacados

```php
SELECT COUNT(*) AS productos,
       COALESCE(SUM(cantidad), 0) AS unidades,
       COUNT(DISTINCT NULLIF(TRIM(categoria), '')) AS categorias
FROM productos
```

- `COUNT(*)` cuenta todas las filas del inventario.
- `SUM(cantidad)` suma existencias; `COALESCE(..., 0)` devuelve cero si la tabla está vacía.
- `TRIM()` descarta espacios; `NULLIF(..., '')` no cuenta categorías vacías; `DISTINCT` evita repetirlas.
- El resultado alimenta `hero-estadisticas` al cargar la página, por lo que siempre refleja la base de datos actual.

```php
SELECT codigo, nombre, categoria, precio, cantidad, imagen
FROM productos ORDER BY codigo DESC LIMIT 8
```

- Obtiene los ocho productos más recien✦tes para las cards.
- `fetch_all(MYSQLI_ASSOC)` crea el arreglo que recorre `foreach` en el HTML.

### 4.6 HTML de la página principal

- `<!DOCTYPE html>` activa el estándar HTML5; `lang="es"` declara el idioma para navegadores y lectores de pantalla.
- El `meta viewport` hace que el ancho visual se adapte a móviles.
- `main` contiene la información principal; `header`, `nav`, `section`, `article` y `footer` dan significado semántico a cada área.
- Los enlaces `#catalogo` y `#formulario` navegan dentro de la página; el enlace a `dashboard.php` abre el inventario tabular.
- Cada métrica usa `number_format()` para legibilidad. `htmlspecialchars()` se usa al mostrar datos de productos y evita que HTML introducido por un usuario se ejecute.
- En el carrusel, cada `article.tarjeta-producto` muestra foto, categoría, código, nombre, precio y cantidad. Si falta foto, no se muestra un símbolo decorativo: queda el fondo y el texto solo para lectores de pantalla.
- `fieldset` y `legend` agrupan los campos del producto; cada `label for` se conecta con el `id` del input, favoreciendo accesibilidad y clic.
- `enctype="multipart/form-data"` es obligatorio para que el navegador pueda enviar una imagen.
- El footer identifica a **Rodney Puertas**, aprendiz de ADS del SENA, y sitúa el sistema como proyecto académico de presentación universitaria.

### 4.7 JavaScript del carrusel

```js
(() => { ... })();
```

- Es una función autoejecutable: sus variables no contaminan el ámbito global.

```js
const carrusel = document.querySelector('.carrusel');
const pista = document.querySelector('.pista-carrusel');
if (!carrusel || !pista) return;
```

- Localiza las dos piezas del carrusel. Si no hay cards, sale sin producir errores.

```js
const distancia = tarjeta ? tarjeta.getBoundingClientRect().width + 20 : 300;
carrusel.scrollBy({ left: direccion * distancia, behavior: 'smooth' });
```

- Mide una card y agrega el espacio de 20 px. Así cada clic se desplaza exactamente una tarjeta, incluso en pantallas distintas.

- Los listeners de `data-carrusel` conectan botones anterior/siguiente.
- El listener `keydown` permite usar flechas izquierda y derecha cuando el carrusel tiene foco.
- `matchMedia('(prefers-reduced-motion: reduce)')` respeta a quienes solicitan menos animaciones. En los demás casos, `setInterval` avanza cada 4.5 segundos y se detiene al pasar el cursor o enfocar el carrusel.

### 4.8 `dashboard.php`

- Incluye la conexión y garantiza el token CSRF.
- Al recibir `POST`, compara el token recibido con el de sesión usando `hash_equals()`, método resistente a comparaciones por tiempo.
- El menú lateral tiene formularios para buscar, cargar un producto en la página de edición o eliminarlo con confirmación del navegador.
- Si una búsqueda encuentra una fila, `$productoEncontrado` limita la tabla a esa fila; de lo contrario, el SQL ordena todos los productos por nombre.
- El `foreach ($productos as $fila)` genera una fila `tr` por producto. Sus `data-label` apoyan una futura vista móvil y cada valor se escapa con `htmlspecialchars()`.

## 5. Explicación de estilos

### `CSS/formulario.css`

- `:root` declara variables como `--bg-main`, `--primary`, `--text` y radios. Centralizarlas evita colores repetidos y facilita cambiar la identidad visual.
- El selector universal `*` aplica `box-sizing: border-box`, haciendo que el ancho incluya padding y bordes.
- `body` crea el fondo oscuro y dos gradientes radiales; `background-attachment: fixed` mantiene el efecto durante el desplazamiento.
- `.hero`, `.catalogo` y `form` comparten panel translúcido, borde y sombra. `backdrop-filter` aporta el efecto de vidrio.
- Flexbox organiza navegación, llamadas a la acción y estadísticas. Grid organiza formulario, footer y acciones de botones.
- `.carrusel` usa `overflow-x: auto` y `scroll-snap-type: x mandatory`; la pista horizontal conserva cada card alineada al desplazarse.
- `.tarjeta-producto:hover` y la imagen usan transiciones suaves. La foto usa `object-fit: cover` para llenar el contenedor sin deformarse.
- Los selectores `:focus` muestran un anillo azul al navegar con teclado; los media queries ajustan columnas, padding y tamaños bajo 840 px y 600 px.
- `prefers-reduced-motion` reduce transiciones para accesibilidad.

### `CSS/dashboard.css`

- Mantiene las mismas variables de color para que dashboard y portada se perciban como un solo producto.
- `.Burguer` es un panel lateral inicialmente fuera de pantalla; el checkbox `#menu-toggle:checked` lo traslada al área visible.
- La tabla usa `border-collapse: collapse`, encabezados diferenciados y estados hover para mejorar el escaneo de filas.
- Su media query habilita desplazamiento horizontal de la tabla en móviles sin ocultar columnas.

## 6. Flujo para demostrar en la presentación

1. Abrir la portada y explicar las métricas: se calculan con SQL, no son números escritos a mano.
2. Registrar un producto, idealmente con imagen, y enviar el formulario.
3. Recargar o volver a la portada: el contador, las unidades y el carrusel reflejan la nueva fila.
4. Abrir Dashboard, buscar por código y mostrar el resultado filtrado.
5. Cargar ese producto para actualizarlo; cambiar cantidad o precio y guardar.
6. Mostrar que el cambio aparece tanto en dashboard como en las métricas.

## 7. Mejoras recomendadas

- Validar tipo MIME y tamaño de imagen en servidor antes de mover el archivo.
- Añadir una clave única a `productos.codigo` en la base de datos, además de la comprobación PHP.
- Activar y validar el token CSRF también en todas las acciones de `index.php`.
- Mover credenciales a un archivo de entorno fuera del control de versiones.
- Agregar paginación al dashboard cuando el catálogo crezca.

Estas mejoras muestran criterio profesional: el proyecto ya cubre el flujo académico completo y tiene una ruta clara para evolucionar a producción.
