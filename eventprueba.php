<?php 
require "conn.php";

$type = $_POST["type"];
//$id = 'irene';

if(($type == 'eventPrueba')==1){
	$id = $_POST["id"];
$mysql_qry = "select * from eventos where national='$id';";
$result = mysqli_query($conn ,$mysql_qry);
if(mysqli_num_rows($result) > 0) {
//echo "ID encontrado";
$array = mysqli_fetch_array($result,MYSQLI_ASSOC);
echo $array["id_event"],",",$array["autor"],",",$array["national"],",",$array["date"],",",$array["country"],",",$array["city"],",",$array["address"],",",$array["participant"],",",$array["description"];
}
else{
	echo "ID no encontrado";
}
}else if(($type=='mostrarParticipantes')==1){
	$id = $_POST["id"];
$mysql_qry = "SELECT us.id FROM `users` us INNER JOIN `participantes` par ON us.id_user = par.id_usuario INNER JOIN `eventos` event2 ON par.id_evento = event2.id_event WHERE event2.id_event = '$id';";
$result = mysqli_query($conn,$mysql_qry);
$array = mysqli_fetch_all($result,MYSQLI_ASSOC);
foreach($array as $valor){
echo $valor["id"],",";
}
}else if(($type=='unirseAlEvento')==1){
	$id_event = $_POST["id_event"];
	$username = $_POST["username"];
	$sql = "select * from users where id like '$username' ";  
	$result = mysqli_query($conn,$sql);
$array = mysqli_fetch_array($result,MYSQLI_ASSOC);
	$id_user = $array["id_user"];
	$sql = "SELECT * FROM participantes pa WHERE pa.id_evento = '$id_event' and pa.id_usuario = '$id_user'";
	$result = mysqli_query($conn,$sql);
	if(mysqli_num_rows($result) > 0) {
		echo "hay coincidencia";
		$sql = "DELETE FROM participantes WHERE id_evento like '$id_event' and id_usuario like '$id_user'";
		$result = mysqli_query($conn,$sql);
	}else{
		//echo "no hay coincidencia";
		$unirse = "INSERT INTO `participantes`(`id_evento`, `id_usuario`) VALUES ('$id_event','$id_user')";
	$result = mysqli_query($conn,$unirse);

		echo "no hay coincidencia";
	}
}

?>