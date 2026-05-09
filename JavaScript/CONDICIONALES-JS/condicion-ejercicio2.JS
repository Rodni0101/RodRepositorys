let nota1 = parseInt(prompt("Ingresa la primera nota"))
let nota2 = parseInt(prompt("Ingresa la segunda nota"))
let nota3 = parseInt(prompt("Ingresa la tercera nota"))

let promedio = (nota1 + nota2 + nota3) / 3

if(promedio >= 4.0){
    document.write("Nota final = " + promedio + "<br>")
    document.write("Regular")
}else{
    document.write("Nota final = " + promedio + "<br>")
    document.write("Reprobado")
}