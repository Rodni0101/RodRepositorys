<?php
if (session_status() === PHP_SESSION_NONE) {
    session_start();
}

$host = "localhost";
$user = "root";
$pass = "1048442903";
$db = "tecnomarket_db";

$conexion = new mysqli($host, $user, $pass, $db);

if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}

$conexion->set_charset("utf8mb4");

$verificarColumna = $conexion->query("SHOW COLUMNS FROM productos LIKE 'imagen'");
if ($verificarColumna && $verificarColumna->num_rows === 0) {
    $conexion->query("ALTER TABLE productos ADD COLUMN imagen VARCHAR(255) NULL");
}

$_SESSION["sistema"] = "TecnoMarket Inventario";
