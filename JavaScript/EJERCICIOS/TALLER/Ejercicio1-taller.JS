let aprobados = 0
let desaprobados = 0

let nombre = prompt("Ingresa el nombre del estudiante")
for(let v = 1; v <= 10; v++){
    let nota = parseFloat(prompt(`Ingrese sus notas, Corte#${v}`))
    if(nota >= 7){
        aprobados++
    }else{
        desaprobados++
    }
}
document.write("Nombre del estudiante : " + nombre + "<br>")
document.write("Numero de estudiantes con notas mayores o iguales a '7' = " + aprobados + "<br>")
document.write("Numero de estudiandes con notas menores a '7' = " + desaprobados + "<br>")