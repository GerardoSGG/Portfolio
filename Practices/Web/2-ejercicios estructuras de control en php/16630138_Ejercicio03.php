<?php 
$num = $_POST['numero'];
if(( ($num %4 == 0 && $num %100 != 0) || $num %400 == 0 )){
	echo "Año bisiesto";
} else {
	echo "Año no bisiesto";
}
?>