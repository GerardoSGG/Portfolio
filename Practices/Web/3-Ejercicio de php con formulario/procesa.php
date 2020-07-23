<?php 
$nombres = $_POST['nombre'];
$paterno = $_POST['ap_pat'];
$materno = $_POST['ap_mat'];
$fecha = $_POST['fecha'];
$correo = $_POST['email'];
$civil = $_POST['EstadoCivil'];

echo "Tu nombre es $nombres $paterno $materno ";
$nombres = strtoupper($nombres);
$paterno = strtoupper($paterno);
$materno = strtoupper($materno);

$letra1 = substr($paterno, 0, 1);
$letra2= "a";
for ($i=1; $i < strlen($paterno); $i++) { 
	$letra2 = substr($paterno, $i, 1);
	if($letra2=="A") {
		break;
	} elseif ($letra2=="E") {
		break;
	}  elseif ($letra2=="I") {
		break;
	}  elseif ($letra2=="O") {
		break;
	}  elseif ($letra2=="U") {
		break;
	}
}

//calculamos el RFC
$letra3 = substr($materno, 0, 1);
$letra4 = substr($nombres, 0, 1);
$año = substr($fecha, 2,2);
$mes = substr($fecha, 5,2);
$dia = substr($fecha, 8,2);
 
echo "con RFC $letra1$letra2$letra3$letra4$año$mes$dia <br>";


//calculamos el dia en que nacio
$num_mes = 4;
if($mes==01){
	$num_mes = 0;	
} elseif ($mes==02) {
	$num_mes = 3;
} elseif ($mes==03) {
	$num_mes = 3;
} elseif ($mes==04) {
	$num_mes = 6;
} elseif ($mes==05) {
	$num_mes = 1;
} elseif ($mes==06) {
	$num_mes = 4;
} elseif ($mes==07) {
	$num_mes = 6;
} elseif ($mes==08) {
	$num_mes = 2;
} elseif ($mes==09) {
	$num_mes = 5;
} elseif ($mes==10) {
	$num_mes = 0;
} elseif ($mes==11) {
	$num_mes = 3;
} elseif ($mes==12) {
	$num_mes = 5;
}

$div_año = ($año/4);

$x = $dia+$num_mes+$año+$div_año;

$nacio = ($x%7);

if($nacio==0){
	echo "Naciste el dia Domingo $dia del mes $mes en el a&ntilde;o $año <br>";
} elseif ($nacio==1) {
	echo "Naciste el dia Lunes $dia del mes $mes en el a&ntilde;o $año <br>";
} elseif ($nacio==2) {
	echo "Naciste el dia Martes $dia del mes $mes en el a&ntilde;o $año <br>";
} elseif ($nacio==3) {
	echo "Naciste el dia Miercoles $dia del mes $mes en el a&ntilde;o $año <br>";
} elseif ($nacio==4) {
	echo "Naciste el dia Jueves $dia del mes $mes en el a&ntilde;o $año <br>";
} elseif ($nacio==5) {
	echo "Naciste el dia Viernes $dia del mes $mes en el a&ntilde;o $año <br>";
} elseif ($nacio==6) {
	echo "Naciste el dia Sabado $dia del mes $mes en el a&ntilde;o $año <br>";
} 

//Deporte(s)
$deporte = $_POST['Deporte'];
echo "Tu correo electronico es $correo y actualmente estas $civil y tu deporte favorito es $deporte <br>";

//fecha actual
$diaA=date("j");
$mesA=date("n");
$añoA=date("Y");

//fecha de nacimiento


$año = substr($fecha, 0,4);

//si el mes es el mismo pero el día inferior aun no ha cumplido años, le quitaremos un año al actual

if (($mes == $mesA) && ($dia > $diaA)) {
$añoA=($añoA-1); }

//si el mes es superior al actual tampoco habrá cumplido años, por eso le quitamos un año al actual

if ($mes > $mesA) {
$añoA=($añoA-1);}

//ya no habría mas condiciones, ahora simplemente restamos los años y mostramos el resultado como su edad

$edad=($añoA-$año);
$m = $edad*12;
$d = $edad*365;
$etapa = ":v ";
if($edad>=0 && $edad<=6){
	$etapa = "Primera infancia";
} elseif ($edad>=6 && $edad<=11) {
	$etapa = "Infancia";
} elseif ($edad>=12 && $edad<=18) {
	$etapa = "Adolecencia";
} elseif ($edad>=19 && $edad<=26) {
	$etapa = "Juventud";
} elseif ($edad>=27 && $edad <=59 ) {
	$etapa = "Adultez";
} elseif ($edad>60) {
	$etapa = "Vejez";
}
echo "Has vivido  $edad a&ntilde;os con $m meses y  $d dias y esta en la etapa de $etapa";


?>