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

$conexion->query("CREATE TABLE IF NOT EXISTS usuarios (id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL, correo VARCHAR(150) NOT NULL UNIQUE, password_hash VARCHAR(255) NOT NULL, creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4");

$verificarGoogleSub = $conexion->query("SHOW COLUMNS FROM usuarios LIKE 'google_sub'");
if ($verificarGoogleSub && $verificarGoogleSub->num_rows === 0) {
    $conexion->query("ALTER TABLE usuarios ADD COLUMN google_sub VARCHAR(255) NULL UNIQUE AFTER correo");
}

$verificarColumna = $conexion->query("SHOW COLUMNS FROM productos LIKE 'imagen'");
if ($verificarColumna && $verificarColumna->num_rows === 0) {
    $conexion->query("ALTER TABLE productos ADD COLUMN imagen VARCHAR(255) NULL");
}

$_SESSION["sistema"] = "TecnoMarket Inventario";
