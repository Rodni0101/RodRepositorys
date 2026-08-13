<?php

function escapar(?string $valor): string
{
    return htmlspecialchars((string) $valor, ENT_QUOTES, 'UTF-8');
}
function tokenCsrf(): string
{
    if (empty($_SESSION['csrf_token']))
        $_SESSION['csrf_token'] = bin2hex(random_bytes(32));
    return $_SESSION['csrf_token'];
}
function csrfValido(): bool
{
    return hash_equals(tokenCsrf(), (string) ($_POST['csrf_token'] ?? ''));
}
function establecerMensaje(string $mensaje, string $tipo = 'exito'): void
{
    $_SESSION['mensaje'] = $mensaje;
    $_SESSION['tipo'] = $tipo;
}
function obtenerMensaje(): array
{
    $resultado = [$_SESSION['mensaje'] ?? '', $_SESSION['tipo'] ?? 'exito'];
    unset($_SESSION['mensaje'], $_SESSION['tipo']);
    return $resultado;
}
function redirigir(string $ruta): never
{
    header('Location: ' . $ruta);
    exit;
}
