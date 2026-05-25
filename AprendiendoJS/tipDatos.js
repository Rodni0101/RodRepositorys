// TIPOS DE DATOS PRIMITIVOS

// String texto y uso de comillas

let name = ("Rodney");
let sobrenombre = ('Rod');
let emal = (`Rod44332211emal.com`);

//Numeros
let edad = 18; //entero
let altura = 1.83 //decimal

//Booleanos (boolean)
let isStudent = true;
let isProfesor = false;

//Undefined (La variable esta declarada pero no tiene valor, osea, no tiene nada(NoDefinido))
let Undefined;

//Null
let valorNull = null;

//Symbol
let unSymbol = Symbol("Un simbolo");

// BigInt
let bigInt = BigInt(15151534400529385298352973529735287352873528735);

// Imprenta de datos
// typeof(tipo de objeto)

//Strings
console.log(typeof name);
console.log(typeof sobrenombre);
console.log(typeof emal);

//Numeros
console.log(typeof edad);
console.log(typeof altura);

//Booleanos
console.log(typeof isStudent);
console.log(typeof isProfesor);

//Indefinido
console.log(typeof undefined);

//Nulo
console.log(typeof valorNull);

//Simbolo
console.log(typeof unSymbol);

//Numero enorme
console.log(typeof bigInt);
