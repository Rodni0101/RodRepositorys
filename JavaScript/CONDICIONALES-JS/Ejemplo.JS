let nota1,nota2,nota3

nota1 = parseInt(prompt("Ingresa 1ra nota"))
nota2 = parseInt(prompt("Ingresa la 2da nota"))
nota3 = parseInt(prompt("Ingresa la 3ra nota"))

let pr = (nota1 + nota2 + nota3) / 3

if(pr >= 7){
    document.write("Promocionado")
}else{
    if(pr >= 4){
        document.write("regular")
    }else{
        document.write("Reprobado")
    }
}