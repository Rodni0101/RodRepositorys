<?php

$conection = new mysqli("localhost", "root", "", "Data1");

if($conection -> connect_error){
    die("Error de conexion" . $conection -> connect_error);
}

if($_SERVER["REQUEST_METHOD"] == "POST") {
$nombre = $_POST["nombre"];
$apellido = $_POST["apellido"];
$carrera = $_POST["carrera"];

$sql ="INSERT INTO Usuarios(Nombre,Apellido,Carrera)
        VALUES('$nombre', '$apellido', '$carrera')";

    if($conection -> query($sql)) {
    echo "Conexion Exitosa";
    }else{
        echo "Conexion fallida . $conection->error";
    }
}
?>