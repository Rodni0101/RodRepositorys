<?php
require_once __DIR__ . '/PHP/conexion.php';
require_once __DIR__ . '/PHP/seguridad.php';
require_once __DIR__ . '/PHP/autenticacion.php';
if (usuarioActual())
    redirigir('index.php');
[$mensaje, $tipo] = obtenerMensaje();
?>
<!doctype html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Iniciar sesión | TecnoMarket</title>
    <link rel="stylesheet" href="CSS/auth.css">
    <link rel="shortcut icon" href="./Favicon/favicon_128x128.png" type="image/x-icon">
</head>

<body>
    <main class="auth">
        <a class="marca" href="login.php">TM<span>.</span></a>
        <section>
            <h1>Bienvenido de nuevo</h1>
            <p>Ingresa para administrar el inventario.</p>
            <?php if ($mensaje): ?>
                <div class="mensaje <?= escapar($tipo) ?>"><?= escapar($mensaje) ?></div>
            <?php endif; ?>
            <form action="PHP/acciones_auth.php" method="post">
                <input type="hidden" name="csrf_token" value="<?= escapar(tokenCsrf()) ?>">
                <label>Correo<input type="email" name="correo" required autocomplete="email"></label>
                <label>Contraseña<input type="password" name="contrasena" required
                        autocomplete="current-password"></label>
                <button name="accion" value="login">Iniciar sesión</button>
            </form>
            <div class="separador-auth"><span>o</span></div>
            <a class="btn-google" href="PHP/google_login.php" aria-label="Continuar con Google">
                <svg aria-hidden="true" viewBox="0 0 24 24">
                    <path fill="#4285F4"
                        d="M21.8 12.2c0-.7-.1-1.3-.2-1.9H12v3.6h5.5a4.7 4.7 0 0 1-2 3.1v2.4h3.2c1.9-1.8 3.1-4.3 3.1-7.2Z" />
                    <path fill="#34A853"
                        d="M12 22c2.7 0 5-.9 6.7-2.5l-3.2-2.4c-.9.6-2 .9-3.5.9-2.6 0-4.8-1.7-5.6-4.2H3.1v2.5A10 10 0 0 0 12 22Z" />
                    <path fill="#FBBC05"
                        d="M6.4 13.8A6 6 0 0 1 6 12c0-.6.1-1.3.4-1.8V7.7H3.1A10 10 0 0 0 3.1 16l3.3-2.2Z" />
                    <path fill="#EA4335"
                        d="M12 6c1.5 0 2.8.5 3.8 1.5l2.9-2.9C17 3 14.7 2 12 2a10 10 0 0 0-8.9 5.7l3.3 2.5C7.2 7.7 9.4 6 12 6Z" />
                </svg>
                Continuar con Google
            </a>
            <p class="nota-google">Usa tu cuenta de Google para acceder de forma segura.</p>
            <p class="enlace">¿No tienes cuenta? <a href="registro.php">Regístrate</a></p>
        </section>
    </main>
</body>

</html>
