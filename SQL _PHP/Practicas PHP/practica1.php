<?php
echo "Bienveido a PHP <br>"; 

/*Dos formas para hacer salto de linea}
-Forma 1
"\n"
-Forma 2
"<br>"
*/

 //Para colocar barra invertida es alt Gr + tecla barra invertida

echo $Numerito = 5 . "<br>";

echo $Numerito - 2 . "<br>";

$Numerito2 = 10;

echo $Numerito2 . "<br>" . "<hr>";

for($v = 0; $v <= 10; $v++){
	echo $v . "\n" . "<br>";
}

$N1 = 120;

if($N1 > 10){
	echo "<br>";
	echo "El numero es mayor a 10" . "<br>";
	echo "El valor del numero es = " . $N1 . "\n" . "<br>";
}
else if($N1 == 10){
    	 echo "El numero es igual a 10" . "<br>";
         echo "El valor del numero es = " . $N1 . "\n" . "<br>";
}else{
	echo "<br>";
	echo "El numero es menor a 10" . "<br>";
	echo "El valor del numero es = " . $N1 . "\n" . "<br>";
	"<br>";
}

echo "HOLA A TODOS";

?>
