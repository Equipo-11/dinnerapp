<?php 
require "conn.php";
$id = $_POST["id"];
$pass = $_POST["pass"];
$email = $_POST["email"];
$phone = $_POST["phone"];
$country = $_POST["country"];
$mysql_qry = "insert into practica values ('$id','$pass','$email','$phone','$country');";
$result = mysqli_query($conn ,$mysql_qry);


?>