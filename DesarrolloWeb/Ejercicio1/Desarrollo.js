let nombre = prompt("Ingresa tu nombre: ");

if (nombre == "Rodney") {
  document.getElementById("mensaje").textContent = "Bienvenido " + nombre;

  let numero = Number(prompt("Ingresa un numero: "));
  let resultado = "";

  for (let v = 1; v <= 10; v++) {
    resultado += "<tr><td>" + numero + " x " + v + "</td><td>" + (numero * v) + "</td></tr>";
  }

  document.getElementById("resultado").innerHTML = resultado;

} else {
  alert("Largo " + nombre);
}