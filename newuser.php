<?php 
require "conn.php";
$id = $_POST["id"];
$pass = $_POST["pass"];
$email = $_POST["email"];
$phone = $_POST["phone"];
$country = $_POST["country"];
$sql = "select * from users where id like '$id' ";  
$result = mysqli_query($conn,$sql);
if(mysqli_num_rows($result) > 0) {
	echo "The ID already exists";
}else{
$mysql_qry = "INSERT INTO `users`(`id`, `pass`, `email`, `phone`, `country`) VALUES ('$id','$pass','$email','$phone','$country');";
$result = mysqli_query($conn ,$mysql_qry);
echo "User created";
}



?>