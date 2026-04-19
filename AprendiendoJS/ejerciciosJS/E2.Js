// 1. Crea una variable para cada operación aritmética
    let a = 4;
    let b = 6;

    console.log("Suma = " + (a + b));
    console.log("Resta = " + (a - b));
    console.log("Multiplicacion = " + (a * b));
    console.log("Division = " + (a / b));
    console.log("Residuo de divion = " + (a % b));
    console.log("Exponente = " + (a ** b));

// 2. Crea una variable para cada tipo de operación de asignación,
//    que haga uso de las variables utilizadas para las operaciones aritméticas

console.log();
let variable = 5;
console.log("Variable = " + variable);
console.log();

variable += 5;
console.log("Incremento = " + variable);
console.log();

variable -= 5;
console.log("Decremento = " + variable);
console.log();

variable *= 5;
console.log("Multiplicacion con asignacion = " + variable);
console.log();

variable /= 5;
console.log("Division con asignacion = " + variable);
console.log();

variable %= 5;
console.log("Residuo con asignacion = " + variable);
console.log();

variable **= 5;
console.log("Exponente con asignacion = " + variable);
console.log();

// 3. Imprime 5 comparaciones verdaderas con diferentes operadores de comparación
    let num1 = 10;
    let num2 = 20;

console.log("Comparaciones verdaderas");
    console.log(num1 < num2);
    console.log();

    console.log(num2 > num1);
    console.log();

    console.log(num1 != num2);
    console.log();

    console.log(num1 <= num2);
    console.log();

    console.log(num2 >= num1);
    console.log();

// 4. Imprime 5 comparaciones falsas con diferentes operadores de comparación
console.log("Comparaciones falsas");
    console.log(num1 > num2);
    console.log();

    console.log(num2 < num1);
    console.log();

    console.log(num1 >= num2);
    console.log();

    console.log(num2 <= num1);
    console.log();

    console.log(num1 == num2);
    console.log();

// 5. Utiliza el operador lógico and
console.log("--Uso de and--");
//VERDADERO
    console.log(num1 < num2 && num2 > num1);
    console.log();
//FALSO
    console.log(num2 < num1 && num1 > num2);
    console.log();

// 6. Utiliza el operador lógico or
console.log("--Uso de Or--");
//FALSO
    console.log(num1 > num2 || num2 < num1);
    console.log();

//VERDADERO
    console.log(num2 > num1 || num1 < num2);
    console.log();
// 7. Combina ambos operadores lógicos
console.log("Combinacionde AND y OR");
let num3 = 50;
console.log(num1 < num2 && num2 > num1 || num2 < num3);
console.log();

// 8. Añade alguna negación
//Negacion del resultado anterior usando ! (De true pasa a false)
console.log(!(num1 < num2 && num2 > num1 || num2 < num3));
console.log();

// 9. Utiliza el operador ternario
    //Un tipo de if else
let hayComida = false;
hayComida ? console.log("Si hay comida") : console.log("No hay comida");
console.log();

// 10. Combina operadores aritméticos, de comparáción y lógicas
let edad = 20;
let dinero = 30;
let tieneEntrada = true;

dinero += 30;

console.log((edad >= 18 && dinero > 50) || tieneEntrada);