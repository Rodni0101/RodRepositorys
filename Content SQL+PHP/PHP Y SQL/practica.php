<?php

$conexion = new mysqli("localhost", "root", "", "Analisis");

if ($conexion->connect_error) {
    die("Error de conexion mi papa aca salgase " . $conexion->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $nombre = $_POST["name"];
    $id = $_POST["ide"];
    $edad = $_POST["age"];

    $sql = "INSERT INTO Repaso(Nombre, Edad, ID)
            VALUES ('$nombre', '$edad', '$id')";

    if ($conexion->query($sql)) {
        echo "Conexion bien hecha mi hermano";
    } else {
        echo "Error: " . $conexion->error;
    }
}
?>