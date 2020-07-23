<?php 

echo "Resultado usando el ciclo FOR";
echo "<br>";
$num=0;
for ($i=30; $i <= 300; ($i+=4)) { 
	$num=$num+$i;
}
echo "La suma es $num";

echo "<br>";

echo "Resultado usando el ciclo WHILE";
echo "<br>";
$num=0;
$con=30;
while ( $con<= 300) {
	$num=$num+$con;	
	$con=$con+4;
}
echo "La suma es $num";

echo "<br>";

echo "Resultado usando el ciclo DO- WHILE";
echo "<br>";
$num=0;
$con=30;


do {
	$num=$num+$con;	
	$con=$con+4;
} while ( $con<= 300) ;

echo "La suma es $num";
?>
