let sueldo = parseFloat(prompt("Digite su sueldo"))

if(sueldo > 3000){
    document.write("Sueldo = " + sueldo + "<br>" + "Debe abonar impuestos")
}else{
    document.write("Sueldo = " + sueldo + "<br>" + "No debe abonar impuestos")
}