let val = parseInt(prompt("Ingresa un valor"))

if (val > 0) {
    document.write("Numero positivo")
} else {
    if (val < 0) {
        document.write("El numero es negativo")
    } else {
        if (val == 0) {
            document.write("El numero es igual a 0")
        }
    }
}