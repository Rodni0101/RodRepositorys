<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./css/Estilo.css" />
    <title>Prueba de conexion</title>
  </head>
  <body>
    <h1>Prueba de conexion para WorkBench</h1>

    <form action="logica.php" method="post">
      <div class="inputs">
        <label for="title">
          <strong>Nombre</strong>
          <input
            type="text"
            placeholder="Ingresa tu nombre"
            required
            name="nombre"
          />
        </label>

        <br />
        <br />

        <label for="title"
          ><strong>Apellido</strong>
          <input
            type="text"
            placeholder="Ingresa tu apellido"
            required
            name="apellido"
          />
        </label>

        <br />
        <br />

        <label for="title"
          ><strong>Carrera</strong>
          <input
            type="text"
            placeholder="Ingrese su carrera"
            required
            name="carrera"
          />
        </label>
      </div>

      <br/>
      <div class="boton">
        <button type="submit">
          Guardar
        </button>
      </div>
    </form>

  </body>
</html>
