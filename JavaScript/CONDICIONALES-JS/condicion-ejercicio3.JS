let num = parseInt(prompt("Ingresa un numero entre 1-99"))

if(num >= 100){
    document.write("Numero fuera del rango" + "<br>")
}

if(num >= 0 && num < 10){
    document.write("Numero ingresado = " + num + "<br>")
    document.write("Valor un solo digito")
}else{
    document.write("Numero ingresado = " + num + "<br>")
    document.write("Valor con dos digitos")
}