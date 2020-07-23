<?php
	echo "<center> <h2> Formulario llenado correctamente </h2> </center>";
	echo "<br>";
	$nombre = $_POST['nombre'];
	echo "Nombre : " . $nombre;
	echo "<br>";
	$usuario = $_POST['usuario'];
	echo "Usuario : " . $usuario;
	echo "<br>";
	$contraseña = $_POST['contraseña'];
	echo "Contrasena : " . $contraseña;
	echo "<br>";
	$correo = $_POST['correo'];
	echo "Correo : " . $correo;
	echo "<br>";
	$fecha = $_POST['fecha'];
	echo "Fecha de nacimiento : " . $fecha;
	echo "<br>";
	$telefono = $_POST['telefono'];
	echo "Telefono : " . $telefono;
	echo "<br>";
	$peso = $_POST['peso'];
	echo "Peso : " . $peso;
	echo "<br>";
	$URL = $_POST['URL'];
	echo "URL : " . $URL;
	echo "<br>";
	$Color = $_POST['Color'];
	echo "Color : " . $Color;
	echo "<br>";
	$terminos = $_POST['terminos'];
	if($terminos=="on") {
		echo "Acepta los terminos y condiciones";
	}
	echo "<br>";
?>