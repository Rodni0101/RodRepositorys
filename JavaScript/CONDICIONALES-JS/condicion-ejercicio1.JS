let num1 = parseInt(prompt("Ingrese un numero"))
let num2 = parseInt(prompt("Ingrese otro numero"))

if(num1 > num2){
    suma = num1 + num2
    diferencia = num1 - num2
    document.write("---Ejercicio 1---" + "<br>") 
    document.write("Numeros ingresados = " + num1 + " Y " + num2 + "<br>")
    document.write("Suma total = " + suma + "<br>")
    document.write("Diferencia = " + diferencia)
}else{
    multi = num1 * num2
    div = num1 / num2
    document.write("Producto = " + multi + "<br>")
    document.write("Division = " + div)
}