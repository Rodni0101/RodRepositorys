# TecnoMarket CRUD (SENA Lab 2)

Proyecto sencillo al estilo de un portafolio PHP: carpetas `PHP/`, `CSS/`, `mysqli`, formulario con `fieldset` y dos páginas principales.

## Archivos

- `login.php` / `registro.php` — Pantallas de autenticación.
- `index.php` — Formulario de inventario (requiere sesión).
- `dashboard.php` — Tabla de inventario (requiere sesión).
- `PHP/conexion.php` — Sesión, conexión y creación de la tabla `usuarios`.
- `PHP/autenticacion.php` — Registro, login, cierre de sesión y control de acceso.
- `PHP/seguridad.php` — CSRF, mensajes flash, escapes y redirecciones.
- `PHP/productos.php` / `PHP/imagenes.php` — Operaciones del inventario y carga segura de imágenes.
- `PHP/acciones_auth.php`, `PHP/acciones_producto.php`, `PHP/acciones_dashboard.php` — Controladores de formularios.
- `CSS/formulario.css` / `CSS/dashboard.css`
- `database.sql`

## Configuración

1. Importar base de datos:

```bash
mysql -u root -p < database.sql
```

2. En `PHP/conexion.php` coloca tu contraseña de MySQL (como en tu proyecto personal).

3. Servir la carpeta (XAMPP en `htdocs` o):

```bash
cd tecnomarket-crud
php -S localhost:8080
```

Abrir `http://localhost:8080/registro.php` para crear la primera cuenta y luego iniciar sesión.

## Usuarios

La tabla `usuarios` se crea automáticamente en la primera conexión. Las contraseñas no se guardan en texto plano: se almacenan con `password_hash()`. Para reiniciar las cuentas de desarrollo:

```sql
DELETE FROM usuarios;
```

## Requisitos del laboratorio

- HTML5, CSS3, PHP, MySQL
- `$_SESSION`, `$_POST`, SQL, `include()`, mensajes de éxito/error
- Confirmación antes de eliminar (`confirm` en JavaScript)
