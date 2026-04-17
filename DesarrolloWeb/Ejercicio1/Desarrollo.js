let nombre = prompt("Ingresa tu nombre: ");

if (nombre == "Rodney") {
  document.getElementById("mensaje").textContent = "Bienvenido " + nombre;

  let numero = Number(prompt("Ingresa un numero: "));
  let resultado = "";

  for (let v = 1; v <= 10; v++) {
    resultado += numero + " x " + v + " = " + (numero * v) + "<br>";
  }

  document.getElementById("resultado").innerHTML = resultado;

} else {
  alert("Largo " + nombre);
}