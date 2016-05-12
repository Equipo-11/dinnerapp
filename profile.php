<?php 
require "conn.php";
$type = $_POST["type"];
$id = $_POST["id"];

if(($type=='userProfile')==1){
	$mysql_qry = "select * from practica where id='$id';";
	$result = mysqli_query($conn ,$mysql_qry);
	if(mysqli_num_rows($result) > 0) {
		$array = mysqli_fetch_array($result,MYSQLI_ASSOC);
		echo $array["id"],",",$array["email"],",",$array["phone"],",",$array["country"];
	}
else{
	echo "ID no encontrado";
}}else if(($type=='editProfile')==1){
	$email = $_POST["email"];
	$phone = $_POST["phone"];
	$country = $_POST["country"];
	$mysql_qry = "UPDATE practica SET email='$email', phone='$phone', country='$country' WHERE id='$id'";
	$result = mysqli_query($conn ,$mysql_qry);
	echo "Actualizacion exitosa";
}
?>