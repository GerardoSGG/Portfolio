<?php
$dia=date("l");
if ($dia=="Monday")$dia="Lunes";
if($dia=="Tuesday")$dia="Martes";
if($dia=="Wednesday")$dia="Miercoles";
if($dia=="Thursday")$dia="Jueves";
if($dia=="Friday")$dia="Viernes";
if($dia=="Saturday")$dia="Sabado";
if($dia=="Sunday")$dia="Domingo";

$dia2=date("d");
$mes=date("F");

if($mes=="January")$mes="Enero";
if($mes=="February")$mes="Febrero";
if($mes=="March")$mes="Marzo";
if($mes=="April")$mes="Abril";
if($mes=="May")$mes="Mayo";
if($mes=="June")$mes="Junio";
if($mes=="July")$mes="Julio";
if($mes=="August")$mes="Agosto";
if($mes=="September")$mes="Septiembre";
if($mes=="October")$mes="Octubre";
if($mes=="November")$mes="Noviembre";
if($mes=="December")$mes="Diciembre";

$año=date("Y");

echo "Hoy es $dia $dia2 de $mes del año $año. y son las", date('h:i')," Horas"; 

?>