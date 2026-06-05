<<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario Personas</title>
</head>
<body>

<h2>Registro de Personas</h2>

<form action="Conexion.php" method="POST">

    <input type="text" name="nombre" placeholder="Nombre" required>
    <br><br>

    <input type="number" name="id" placeholder="ID" required>
    <br><br>

    <input type="number" name="numero" placeholder="Número" required>
    <br><br>

    <input type="number" name="edad" placeholder="Edad" required>
    <br><br>

    <input type="text" name="carrera" placeholder="Carrera" required>
    <br><br>

    <button type="submit">Guardar</button>

</form>

</body>
</html>