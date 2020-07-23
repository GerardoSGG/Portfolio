<?php 

$numero = rand(1,30);
echo "Tabla con el ciclo FOR";
echo "<br>";
$aux=1;
for ($i=1; $i <=10 ; $i++) { 
	$aux=$i*$numero;
	echo $numero."x".$i."=". $aux;
	echo "<br>";
}
echo "<br>";
echo "Tabla con el ciclo WHILE";
echo "<br>";
$aux=1;
$contador=1;
while ($contador<= 10) {
	$aux=$contador*$numero;
	echo $numero."x".$contador."=".$aux;
	$contador++;
	echo "<br>";
}

echo "<br>";
echo "Tabla con el ciclo DO-WHILE";
echo "<br>";

$aux=1;
$contador=1;
do {
	$aux=$contador*$numero;
	echo $numero."x".$contador."=".$aux;
	$contador++;
	echo "<br>";
} while ( $contador<= 10) ;

	
?>