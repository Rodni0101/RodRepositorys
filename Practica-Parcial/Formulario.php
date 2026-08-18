    <!doctype html>
    <html lang="en">
        <head>
            <meta charset="UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>Practica de Parcial</title>
            <link rel="stylesheet" href="styles.css" />
        </head>
        <body>
            <header>Practica para parcial</header>

            <hr />
            <form action="logica.php" method="post">
                <div class="inputs">
                    <label for="title">
                        Nombre
                        <input type="text" placeholder="Ingresa tu nombre" required name="Nombre" />
                    </label>

                    <label for="title">
                        Apellido
                        <input type="text" placeholder="Ingresa tu apellido" required name="Apellido" />
                    </label>

                    <label for="title">
                        Edad
                        <input type="text" placeholder="Ingresa tu edad" required name="Edad" />
                    </label>

                    <button type="submit">Enviar</button>
                </div>
            </form>

            <form action="Acciones/Buscar.php" method="post">
                <div class="Buscar">
                    <header>Seccion de Busqueda</header>
                    <label for="title">Buscar usuario</label>
                    <input type="search" placeholder="Buscar usuario por Nombre" name="Buscar"/>
                    <button type="submit">Buscar</button>
                    <button type="reset">Limpiar</button>
                </div>
            </form>
        </body>
    </html>
