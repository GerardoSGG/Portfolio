<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
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
	
	<br>
	<?php
	 

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
		$conexion = mysqli_connect( $servidor, $usuario, $contrasena)or die ( "Upps! no se ha podido conectar a la base de datos" );
				mysqli_select_db($conexion,$basededatos) or die("Error en la base de datos");
$consulta= "INSERT INTO `Datos`(`nombre`, `celular`, `fijo`, `domicilio`, `correo`, `fecha`) VALUES ('$nombre',$celular,$fijo,'$domicilio','$correo','fecha')";
    $resultado = mysqli_query( $conexion, $consulta ) or die(mysqli_error($conexion));
				mysqli_close($conexion);
				echo "<h4>Datos guardados</h4>";
    
	?>
</body>
</html>