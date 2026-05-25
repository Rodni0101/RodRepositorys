let val = parseInt(prompt("Ingresa un valor"))

document.write("---Ejercicio 4---" + "<br>")
if (val > 0) {
    document.write("Numero positivo <br>")
} else {
    if (val < 0) {
        document.write("El numero es negativo <br>")
    } else {
        if (val == 0) {
            document.write("El numero es igual a 0 <br>")
        }
    }
}


document.write("--------------------------")
document.write("<br>")
alert("Ejercicio 4 terminado")