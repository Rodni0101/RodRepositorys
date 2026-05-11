let num = parseInt(prompt("Ingresa un numero entre 1-99"))

document.write("---Ejercicio 3---" + "<br>")
if (num >= 100) {
    document.write("Numero fuera del rango" + "<br>")
}

if (num >= 0 && num < 10) {
    document.write("Numero ingresado = " + num + "<br>")
    document.write("Valor un solo digito <br>")
} else {
    document.write("Numero ingresado = " + num + "<br>")
    document.write("Valor con dos digitos <br>")
}


document.write("--------------------------")
document.write("<br>")
alert("Ejercicio 3 terminado")