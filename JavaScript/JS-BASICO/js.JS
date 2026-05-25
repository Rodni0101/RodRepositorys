let numero1 = parseInt(prompt("Ingresa un numero: "))
let numero2 = parseInt(prompt("Ingresa otro numero: "))

let suma = numero1 + numero2
let multi = numero1 * numero2
let div = numero1 / numero2
let resta = numero1 - numero2

document.write("Suma = " + suma)
document.write("<br>")
document.write("Resta = " + resta)
document.write("<br>")
document.write("Multiplicacion = " + multi)
document.write("<br>")
document.write("Division = " + div)
document.write("<br>")

document.write("<br>")
let numero3 = parseInt(prompt("Ingresa un numero"))
for(let v = 1; v <= 10; v++){
    let resultado = numero3 * v
    document.write(numero3 + " X " + v + " = " + resultado)
        document.write("<br>")
}

