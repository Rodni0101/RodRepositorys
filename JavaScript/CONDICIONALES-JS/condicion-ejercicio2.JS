let nota1 = parseInt(prompt("Ingresa la primera nota"))
let nota2 = parseInt(prompt("Ingresa la segunda nota"))
let nota3 = parseInt(prompt("Ingresa la tercera nota"))

let promedio = (nota1 + nota2 + nota3) / 3

document.write("---Ejercicio 2---" + "<br>")
if (promedio >= 4.0) {
    document.write("Nota final = " + promedio + "<br>")
    document.write("Excelente <br>")
}
else if (promedio >= 3.0) {
    document.write("Nota final = " + promedio + "<br>")
    document.write("Regular <br>")
}
else {
    document.write("Nota final = " + promedio + "<br>")
    document.write("Reprobado <br>")
}


document.write("--------------------------")
document.write("<br>")
alert("Ejercicio 2 terminado")