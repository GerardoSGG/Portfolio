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
	

	
	$usuario = "id11858353_gera";
		$contrasena = "sagg971108hjcnrr08";
		$servidor = "localhost";
		$basededatos = "id11858353_agenda_bd";
		$conexion = mysqli_connect( $servidor, $usuario, $contrasena)or die ( "Upps! Pues va a ser que no se ha podido conectar a la base de datos" );
		mysqli_select_db($conexion,$basededatos) or die("Error en la base de datos");
	$consulta = "SELECT * FROM `Datos` WHERE nombre = '$nombre'";
    $resultado = mysqli_query( $conexion, $consulta ) or die(mysqli_error($conexion));	

    if ($resultado) {
		echo "
      <table class ='blue lighten-1'>
		<tr>
			<th>Nombre</th>
			<th>Celular</th>
			<th>Telefono Fijo</th>
			<th>Domicilio</th>
			<th>Correo</th>
			<th>Fecha Nacimiento</th>
        </tr>
        ";	
		
		while($row = mysqli_fetch_assoc($resultado)) {
                    echo "<tr>";
                    foreach ($row as $key => $id) {
                      echo "<td>";
                      echo "$id";
                      echo "</td>";
                    }
                    echo "</tr>";
                }
		echo "</table>";

		
				}else{
					echo "<div class = container center> 
			<h1 class=black-text center>No se encontro el nombre </h1> </div>";
				}
    mysqli_close($conexion);
	
	

?>	
</body>
</html>