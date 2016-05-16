<?php 
require "conn.php";
$autor = $_POST["autor"];
$national = $_POST["national"];
$date = $_POST["date"];
$country = $_POST["country"];
$city = $_POST["city"];
$address = $_POST["address"];
$participant = $_POST["participant"];
$description = $_POST["description"];
$sql = "SELECT * FROM eventos where autor like '$autor' and date like '$date'";
$result = mysqli_query($conn,$sql);
if(mysqli_num_rows($result) > 0) {
	//Ya tiene un evento para ese dia
}else{
	$mysql_qry = "INSERT INTO `eventos`(`autor`, `national`, `date`, `country`, `city`, `address`, `participant`, `description`) VALUES ('$autor','$national','$date','$country','$city','$address','$participant','$description');";
$result = mysqli_query($conn ,$mysql_qry);
//Cogemos id de usuario
$sql = "select * from users where id like '$autor' ";  
$result = mysqli_query($conn,$sql);
$array = mysqli_fetch_array($result,MYSQLI_ASSOC);
$id_user = $array["id_user"];
//Cogemos id de evento
$mysql_qry = "select * from eventos where national='$national';";
$result = mysqli_query($conn ,$mysql_qry);
$array = mysqli_fetch_array($result,MYSQLI_ASSOC);
$id_evento = $array['id_event'];
//nos unimos al evento
$unirse = "INSERT INTO `participantes`(`id_evento`, `id_usuario`) VALUES ('$id_evento','$id_user')";
$result = mysqli_query($conn,$unirse);

}

?>