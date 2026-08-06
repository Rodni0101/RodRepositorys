# Guía para leer y entender este proyecto PHP CRUD

Este proyecto es un ejemplo pequeño pero muy útil para aprender a leer código real. No necesitas entenderlo todo de una vez: lo importante es aprender a leerlo por bloques, identificar qué hace cada parte y relacionarlo con la lógica del negocio.

---

## 1. ¿Qué hace este proyecto?

Este sistema permite:
- registrar productos,
- buscarlos por código,
- actualizar sus datos,
- eliminarlos,
- verlos en un dashboard,
- subir una imagen para cada producto.

En otras palabras, es un CRUD: Create, Read, Update, Delete.

---

## 2. Estructura del proyecto

- `index.php`: formulario principal para crear, buscar, actualizar y eliminar productos.
- `dashboard.php`: página donde se muestran los productos en una tabla.
- `PHP/conexion.php`: archivo que conecta la aplicación con la base de datos MySQL.
- `CSS/formulario.css`: estilos del formulario.
- `CSS/dashboard.css`: estilos del dashboard.
- `database.sql`: script SQL para crear la base de datos y la tabla `productos`.
- `uploads/`: carpeta donde se guardan las imágenes subidas.

---

## 3. Cómo leer este código paso a paso

Cuando veas código como este, no lo leas de arriba hacia abajo como un texto normal. Mejor sigue esta estrategia:

1. Identifica la finalidad del archivo.
2. Busca las secciones principales:
   - variables,
   - formularios,
   - lógica de acciones,
   - consultas a base de datos,
   - HTML/CSS.
3. Lee primero las partes más importantes.
4. Revisa qué datos entran y qué datos salen.
5. Prueba el flujo real del sistema.

---

## 4. Explicación por archivo

### Archivo: `PHP/conexion.php`

Este archivo se encarga de conectar PHP con MySQL.

```php
<?php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}
```

- `session_start()` inicia la sesión del usuario.
- La sesión permite guardar información como mensajes, datos del formulario o el token CSRF.

```php
$host = "localhost";
$user = "root";
$pass = "1048442903";
$db   = "tecnomarket_db";
```

- Aquí están los datos para entrar a la base de datos.
- `localhost` es el servidor local.
- `root` es el usuario por defecto de MySQL en muchos ambientes.
- `tecnomarket_db` es el nombre de la base de datos.

```php
$conexion = new mysqli($host, $user, $pass, $db);
```

- `mysqli` es la clase de PHP para trabajar con MySQL.
- Con `new mysqli(...)` se abre la conexión.

```php
if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}
```

- Si la conexión falla, el programa se detiene y muestra el error.

```php
$conexion->set_charset("utf8mb4");
```

- Esto permite guardar texto en español correctamente.

```php
$verificarColumna = $conexion->query("SHOW COLUMNS FROM productos LIKE 'imagen'");
```

- Esta línea revisa si en la tabla `productos` ya existe una columna llamada `imagen`.

```php
if ($verificarColumna && $verificarColumna->num_rows === 0) {
    $conexion->query("ALTER TABLE productos ADD COLUMN imagen VARCHAR(255) NULL");
}
```

- Si la columna no existe, se agrega para guardar la ruta de la imagen.

---

### Archivo: `index.php`

Este archivo contiene el formulario principal para manejar los productos.

#### 1. Inicio del archivo

```php
include "PHP/conexion.php";
```

- Incluye el archivo de conexión para usar la base de datos.

```php
if (empty($_SESSION["csrf_token"])) {
    $_SESSION["csrf_token"] = bin2hex(random_bytes(32));
}
```

- Genera un token de seguridad para evitar envíos falsos del formulario.
- `bin2hex(random_bytes(32))` crea una cadena aleatoria segura.

#### 2. Variables iniciales

```php
$mensaje = "";
$tipo = "";
```

- Estas variables se usan para mostrar mensajes al usuario.
- Por ejemplo: “Producto registrado correctamente” o “Error al guardar”.

```php
$codigo = "";
$nombre = "";
$categoria = "";
$precio = "";
$cantidad = "";
$imagen = "";
```

- Son las variables que guardan los datos del formulario.

#### 3. Recuperar datos de sesión

```php
if (isset($_SESSION["form_producto"])) {
```

- Si el usuario viene de una búsqueda o de un error, el sistema recupera los datos del producto desde la sesión.

#### 4. Procesar el formulario

```php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
```

- Revisa si el usuario envió datos desde el navegador.
- `POST` significa que el formulario fue enviado.

```php
$accion = $_POST["accion"] ?? "";
```

- Identifica qué botón pulsó el usuario: guardar, actualizar, buscar o eliminar.

#### 5. Botón Nuevo

```php
if ($accion === "nuevo") {
```

- Limpia el formulario y vuelve a mostrar la página en blanco.

#### 6. Recoger datos del formulario

```php
$codigo = trim($_POST["codigo"] ?? "");
```

- `trim()` quita espacios al inicio y al final.
- `$_POST` recibe datos enviados por el formulario.

#### 7. Subir una imagen

```php
function subirImagenProducto(array $archivo, string $directorio): array {
```

- Esta función recibe un archivo y la carpeta donde guardarlo.

```php
if (!isset($archivo["name"]) || $archivo["error"] !== UPLOAD_ERR_OK) {
```

- Comprueba si se seleccionó una imagen válida.

```php
$nombreArchivo = uniqid("prod_", true) . ($extension !== "" ? "." . strtolower($extension) : "");
```

- Genera un nombre único para la imagen para evitar conflictos.

```php
move_uploaded_file($archivo["tmp_name"], $rutaDestino)
```

- Guarda el archivo en la carpeta `uploads/` del proyecto.

#### 8. Guardar producto

```php
$insertar = $conexion->prepare(
    "INSERT INTO productos (codigo, nombre, categoria, precio, cantidad, imagen) VALUES (?, ?, ?, ?, ?, ?)"
);
```

- Prepara una consulta SQL para guardar un producto nuevo en la base de datos.
- Los signos `?` son marcadores para valores que se pasan después.

```php
$insertar->bind_param("sssdis", $codigo, $nombre, $categoria, $precio_num, $cantidad_num, $imagen);
```

- `bind_param` enlaza los valores a la consulta.
- `sssdis` indica el tipo de cada valor:
  - `s` = string
  - `d` = double/decimal
  - `i` = integer

#### 9. Actualizar producto

```php
$actualizar = $conexion->prepare(
    "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, cantidad = ?, imagen = ? WHERE codigo = ?"
);
```

- Actualiza los datos de un producto existente.
- `WHERE codigo = ?` indica qué producto modificar.

---

### Archivo: `dashboard.php`

Este archivo muestra los productos en una tabla y ofrece acciones rápidas.

#### 1. Mostrar mensajes

```php
if (isset($_SESSION["mensaje"])) {
```

- Si el sistema guardó un mensaje de error o éxito en la sesión, lo muestra al usuario.

#### 2. Buscar producto

```php
SELECT codigo, nombre, categoria, precio, cantidad, imagen FROM productos WHERE codigo = ?
```

- Busca un producto por código en la base de datos.

#### 3. Redirigir al formulario para editar

```php
header("Location: index.php");
```

- Redirige al usuario hacia el formulario con los datos cargados para editar.

#### 4. Mostrar la tabla

```php
$sql = "SELECT ... FROM productos ORDER BY nombre ASC";
```

- Trae todos los productos ordenados por nombre.

```php
foreach ($productos as $fila) {
```

- Recorre cada producto y lo imprime en la tabla.

---

### Archivo: `database.sql`

Este archivo crea la base de datos y la tabla.

```sql
CREATE TABLE productos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  codigo VARCHAR(20) NOT NULL UNIQUE,
  nombre VARCHAR(120) NOT NULL,
  categoria VARCHAR(80) NOT NULL,
  precio DECIMAL(12, 2) NOT NULL,
  cantidad INT NOT NULL,
  imagen VARCHAR(255) NULL
);
```

- `id` es la llave principal.
- `codigo` debe ser único.
- `imagen` guarda la ruta de la foto.

---

## 5. Cómo aprender a leer este tipo de código

### Estrategia 1: leer por bloques
No leas todo el archivo de golpe. Divide el código en secciones:
- variables,
- formularios,
- acciones,
- consultas SQL,
- HTML/CSS.

### Estrategia 2: preguntar “¿qué entra? ¿qué pasa? ¿qué sale?”
Por ejemplo:
- ¿Qué datos recibe el formulario?
- ¿Qué hace el servidor con esos datos?
- ¿Dónde se guardan?
- ¿Qué se muestra al usuario?

### Estrategia 3: aprender los conceptos base
Los más importantes para este proyecto son:
- `$_POST`: recibir datos del formulario.
- `$_SESSION`: guardar información entre páginas.
- `include`: traer otro archivo PHP.
- `mysqli`: conectar y consultar MySQL.
- `prepare()` y `bind_param()`: preparar consultas seguras.
- HTML: estructura del formulario y la tabla.
- CSS: diseño y presentación.

### Estrategia 4: practicar con pequeños cambios
Haz cambios pequeños y prueba:
- cambia un texto,
- cambia un color,
- cambia un nombre de botón,
- agrega un campo nuevo.

Eso te enseña mucho más que copiar y pegar.

### Estrategia 5: leer el flujo completo de una acción
Por ejemplo, el flujo de “guardar producto”:
1. el usuario llena el formulario,
2. el navegador envía los datos,
3. PHP recibe los datos,
4. PHP valida la información,
5. PHP inserta en la base de datos,
6. PHP muestra un mensaje de éxito.

---

## 6. Cómo pensar cuando lees código

Una buena pregunta es:

> “¿Qué hace esta línea en el flujo completo?”

Por ejemplo:

```php
$codigo = trim($_POST["codigo"] ?? "");
```

Esto significa:
- toma el valor del campo `codigo` del formulario,
- lo recibe desde `POST`,
- y limpia espacios innecesarios.

Otro ejemplo:

```php
$insertar->execute();
```

Esto ejecuta la consulta SQL para guardar el producto.

---

## 7. Recomendación para seguir aprendiendo

Si quieres avanzar realmente con PHP, aprende en este orden:

1. HTML básico
2. CSS básico
3. PHP básico
4. Formularios y métodos `POST`
5. Variables, condicionales y bucles
6. Conexión con bases de datos
7. Consultas SQL
8. Sessions y seguridad básica
9. Subida de archivos

---

## 8. Consejos para ti

Lo que hiciste con “vibe coding” es normal y muy común. La diferencia ahora es que ya no necesitas copiar todo ciegamente: puedes empezar a preguntar:
- ¿qué hace esta parte?
- ¿por qué está aquí?
- ¿qué dato entra?
- ¿qué dato sale?

Eso es lo que hace a un desarrollador más fuerte.

---

## 9. Mini ejercicio para practicar

Intenta responder estas preguntas sobre el proyecto:

1. ¿Qué archivo recibe los datos del formulario?
2. ¿Qué hace la función `subirImagenProducto()`?
3. ¿Qué pasa cuando presionas “Guardar”?
4. ¿Dónde se guarda la imagen?
5. ¿Qué archivo muestra la tabla de productos?
6. ¿Qué hace `bind_param()`?

Si puedes responder esas preguntas, ya estás leyendo el código con más profundidad.

---

## 10. Resumen final

Leer código no es solo “entender palabras”. Es entender:
- la estructura,
- el flujo,
- los datos,
- los archivos,
- y la intención del programador.

Este proyecto es perfecto para practicar porque es pequeño, visible y te permite ver el resultado de cada cambio en la pantalla.

Si quieres, en el siguiente paso puedo hacerte también una versión más visual de esta guía con:
- diagramas del flujo,
- explicaciones de cada botón,
- y una tabla “línea → significado”.
