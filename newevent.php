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
$mysql_qry = "insert into event values ('$autor','$national','$date','$country','$city','$address','$participant','$description');";
$result = mysqli_query($conn ,$mysql_qry);


?>