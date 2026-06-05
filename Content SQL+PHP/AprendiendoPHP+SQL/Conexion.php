<?php

$conexion = new mysqli("localhost", "root", "", "Practica");

if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $nombre = $_POST['nombre'];
    $id = $_POST['id'];
    $numero = $_POST['numero'];
    $edad = $_POST['edad'];
    $carrera = $_POST['carrera'];

    $sql = "INSERT INTO Personas (Nombre, ID, Numero, Edad, Carrera)
            VALUES ('$nombre', '$id', '$numero', '$edad', '$carrera')";

    if ($conexion->query($sql) === TRUE) {
        echo "✅ Registro guardado correctamente";
    } else {
        die("Error SQL: " . $conexion->error);
    }
}
?>

