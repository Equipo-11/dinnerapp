<?php 
require "conn.php";

$country = $_POST["country"];
$city = $_POST["city"];
$date = $_POST["date"];
$food = $_POST["food"];

$mysql_qry = "select * from eventos where country='$country' and city='$city' and date='$date' and national='$food';";
$result = mysqli_query($conn ,$mysql_qry);

while($row = mysqli_fetch_row($result)){
	echo $row['0'],",",$row["1"],",",$row["2"],",",$row["3"],",",$row["4"],",",$row["5"],",",$row["6"],",",$row["7"],"--";
	
}

?>