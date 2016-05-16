<?php 
require "conn.php";

$type = $_POST["type"];
$id = $_POST["id"];


$mysql_qry = "select * from eventos where autor like '$id';";
$result = mysqli_query($conn ,$mysql_qry);
while($row = mysqli_fetch_row($result)){
	echo $row['0'],",",$row["1"],",",$row["2"],",",$row["3"],",",$row["4"],",",$row["6"],"--";
	
}

?>