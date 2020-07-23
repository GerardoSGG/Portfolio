<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Consultar</title>
	<!--Import Google Icon Font-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
</head>
<body>

	<nav>
    <div class="nav-wrapper blue darken-2">
      <a href="agenda.html" class="brand-logo"><img src="TecNM.png" height="65px"></a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="agenda.html">Agregar</a></li>
        <li><a href="modificar.html">Modificar</a></li>
        <li><a href="eliminar.html">Eliminar</a></li>
        <li><a href="consultar.html">Consultar</a></li>
      </ul>
    </div>
  </nav>

	<?php
	$nombre = $_POST['nombre'];
	$celular = $_POST['celular'];
	$fijo = $_POST['fijo'];
	$domicilio = $_POST['domicilio'];
	$email = $_POST['email'];
	$fecha = $_POST['fecha'];

	
	$nombre = $_POST['nombre'];
	 $celular = $_POST['celular'];
	 $fijo = $_POST['fijo'];
	 $domicilio = $_POST['domicilio'];
	 $correo = $_POST['email'];
	 $fecha = $_POST['fecha'];
	 	$usuario = "id11858353_gera";
		$contrasena = "sagg971108hjcnrr08";
		$servidor = "localhost";
		$basededatos = "id11858353_agenda_bd";
		$conexion = mysqli_connect( $servidor, $usuario, $contrasena)or die ( "Upps! Pues va a ser que no se ha podido conectar a la base de datos" );
		mysqli_select_db($conexion,$basededatos) or die("Error en la base de datos");
		$consulta= "UPDATE `Datos` SET `nombre`='$nombre', `celular`=$celular,`fijo`=$fijo,`domicilio`='$domicilio',`correo`='$correo',`fecha`='$fecha' WHERE `nombre`=$nombre";
    $resultado = mysqli_query( $conexion, $consulta ) or die(mysqli_error($conexion));
				mysqli_close($conexion);
				if ($resultado) {
					echo "<div class = container center> 
			<h1 class=black-text center>Contacto modificado correctamente </h1> </div>";
				}else{
					echo "<div class = container center> 
			<h1 class=black-text center>No se encontro el nombre </h1> </div>";
				}
	


?>	
</body>
</html>