const nombre = prompt("Ingresa tu nombre:");

if (nombre === "Rodney") {

    document.getElementById("mensaje").textContent = `Bienvenido ${nombre}`;

    const numero = Number(prompt("Ingresa un número:"));
    const tbody = document.getElementById("resultado");

    for (let i = 1; i <= 10; i++) {
        const fila = document.createElement("tr");

        const operacion = document.createElement("td");
        operacion.textContent = `${numero} x ${i}`;

        const resultado = document.createElement("td");
        resultado.textContent = numero * i;

        fila.appendChild(operacion);
        fila.appendChild(resultado);
        tbody.appendChild(fila);
    }

} else {
    alert(`Largo ${nombre}`);
}