let nombre = prompt("Ingresa tu nombre")
let preguntasTotales = parseInt(prompt("Ingresa la cantidad de preguntas"))
let acertadas = parseInt(prompt("Cantidad de preguntas acertadas"))

let porcentaje = (acertadas * 100) / preguntasTotales
/*FIXED PARA ELIMINAR DECIMALES*/
document.write("---Ejercicio 5---" + "<br>")
document.write("Porcentajde de acierto : " + porcentaje.toFixed(2) + "<br>")

if (porcentaje >= 90) {
    document.write("Nivel superior" + "<br>")
    document.write("Nombre del participante : " + nombre + "<br>")
} else {
    if (porcentaje >= 75) {
        document.write("Nivel intermedio" + "<br>")
        document.write("Nombre del participante : " + nombre + "<br>")
    } else {
        if (porcentaje >= 50) {
            document.write("Nivel regular" + "<br>")
            document.write("Nombre del participante : " + nombre + "<br>")
        } else {
            document.write("Fuera de alcance" + "<br>")
            document.write("Nombre del participante : " + nombre + "<br>")
        }
    }
}


document.write("--------------------------")
document.write("<br>")
alert("Ejercicio 5 terminado")