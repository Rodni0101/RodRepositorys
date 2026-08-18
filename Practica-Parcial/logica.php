<?php
$conexion = new mysqli("localhost", "root", "1048442903", "Practica_Parcial");

if ($conexion->connect_error) {
    die("Error" . $conexion->connect_error);
}

if ($_SERVER['REQUEST_METHOD'] === "POST") {
    $nombre = $_POST['Nombre'];
    $apellido = $_POST['Apellido'];
    $edad = $_POST['Edad'];

    $consulta = "INSERT INTO Persona(Nombre, Apellido, Edad) VALUES (?, ?, ?)";
    $preparacion = $conexion->prepare($consulta);

    if ($preparacion === false) {
        echo "<script>
            alert('No se pudo preparar el registro: " . addslashes($conexion->error) . "');
            window.history.back();
        </script>";
        exit;
    }

    $preparacion->bind_param("ssi", $nombre, $apellido, $edad);

    if ($preparacion->execute()) {
        echo "<script>
            alert('Usuario guardado correctamente.');
            window.location.href = 'Formulario.php';
        </script>";
    } else {
        echo "<script>
            alert('No se pudo guardar el usuario: " . addslashes($preparacion->error) . "');
            window.history.back();
        </script>";
    }

    $preparacion->close();

    $conexion->close();
}
?>
    