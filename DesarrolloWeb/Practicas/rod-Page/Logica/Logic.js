// Espera a que cargue el HTML
document.addEventListener("DOMContentLoaded", function () {

    const boton = document.getElementById("button");
    const correo = document.getElementById("correo");
    const password = document.getElementById("password");

    boton.addEventListener("click", function () {

        const email = correo.value.trim();
        const pass = password.value.trim();

        // Validación básica
        if (email === "" || pass === "") {
            alert("Por favor completa todos los campos");
            return;
        }

        // Validar formato de correo
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!regex.test(email)) {
            alert("Correo no válido");
            return;
        }

        if (!esCorreoCorporativo(email)) {
            alert("Solo se permiten correos corporativos");
            return;
        }

        // Mostrar resultado
        alert("Correo: " + email + "\nContraseña: " + pass);

        // También lo puedes ver en consola
        console.log("Correo:", email);
        console.log("Contraseña:", pass);
    });
    correo.addEventListener("keydown", verificarEnter);
    password.addEventListener("keydown", verificarEnter);

    function verificarEnter(event) {
        if (event.key === "Enter") {
            boton.click(); // simula el clic del botón
        }
    }

    function esCorreoCorporativo(correo) {
        const dominiosPublicos = ["gmail.com", "hotmail.com", "outlook.com", "yahoo.com"];

        const partes = correo.split("@");
        if (partes.length !== 2) return false;

        const dominio = partes[1].toLowerCase();

        return !dominiosPublicos.includes(dominio);
    }
});