<?php 
require "conn.php";
$id = $_POST["id"];
$type = $_POST["type"];
//$id = 'irene';

if(($type == 'eventPrueba')==1){
$mysql_qry = "select * from eventos where national='$id';";
$result = mysqli_query($conn ,$mysql_qry);
//$result = mysqli_store_result()
if(mysqli_num_rows($result) > 0) {
//echo "ID encontrado";
$array = mysqli_fetch_array($result,MYSQLI_ASSOC);
echo $array["id_event"],",",$array["autor"],",",$array["national"],",",$array["date"],",",$array["country"],",",$array["city"],",",$array["address"],",",$array["participant"],",",$array["description"];
}
else{
	echo "ID no encontrado";
}
}else if(($type=='unirse')==1){
$mysql_qry = "SELECT us.id FROM `users` us INNER JOIN `participantes` par ON us.id_user = par.id_usuario INNER JOIN `eventos` event2 ON par.id_evento = event2.id_event WHERE event2.id_event = '$id';";
$result = mysqli_query($conn,$mysql_qry);
$array = mysqli_fetch_all($result,MYSQLI_ASSOC);
foreach($array as $valor){
echo $valor["id"],",";
}
}

?>