# TecnoMarket CRUD (SENA Lab 2)

Proyecto sencillo al estilo de un portafolio PHP: carpetas `PHP/`, `CSS/`, `mysqli`, formulario con `fieldset` y dos páginas principales.

## Archivos

- `index.php` — Formulario con Guardar, Buscar, Actualizar, Eliminar y Limpiar
- `dashboard.php` — Tabla con todos los productos
- `PHP/conexion.php` — `session_start()` + conexión MySQL
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

Abrir `http://localhost:8080/index.php`

## Requisitos del laboratorio

- HTML5, CSS3, PHP, MySQL
- `$_SESSION`, `$_POST`, SQL, `include()`, mensajes de éxito/error
- Confirmación antes de eliminar (`confirm` en JavaScript)
