<?php 
require "conn.php";

$type = $_POST["type"];
$id = $_POST["id"];

$sql = "select * from users where id like '$id' ";  
 $result = mysqli_query($conn,$sql);
  $array = mysqli_fetch_array($result,MYSQLI_ASSOC);
 $id_user = $array["id_user"];
$mysql_qry = "SELECT * FROM `eventos` ev INNER JOIN `participantes` par ON ev.id_event = par.id_evento  WHERE par.id_usuario = '$id_user';";
$result = mysqli_query($conn ,$mysql_qry);
while($row = mysqli_fetch_row($result)){
	echo $row["1"],",",$row["2"],",",$row["3"],",",$row["4"],",",$row["5"],",",$row["7"],",",$row["0"],"--";
	
}

?>