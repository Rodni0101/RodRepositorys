<?php
//Operacion basica
$numero1 = 5;
$numero2 = 5;

//Aritmetica
$suma = $numero1 + $numero2;
$resta = $numero1 - $numero2;
$multi = $numero1 * $numero2;
$div = $numero1 / $numero2;

//concatenacion y salto de linea

echo "suma = " . $suma . "\n";
echo "resta = " . $resta . "\n";
echo "multiplicacion = " . $multi . "\n";
echo "Division = " . $div . "\n";

//Interpolacion
echo "Este es el primero numero, $numero1. Y ya";

//Ciclos

//for

for($v = 0; $v <=10; $v++){
    echo "Hola Rodney";
}

$valor = 1;
while($valor = 1){
    echo "El valor vale = , $valor";
}
?>