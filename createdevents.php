<?php 
require "conn.php";

$type = $_POST["type"];
$id = $_POST["id"];


$mysql_qry = "select * from eventos where autor like '$id';";
$result = mysqli_query($conn ,$mysql_qry);
if(mysqli_num_rows($result) > 0){
	while($row = mysqli_fetch_row($result)){
		echo $row["1"],",",$row["2"],",",$row["3"],",",$row["4"],",",$row["5"],",",$row["7"],",",$row["0"],"--";
		
	}
}else{
	echo "You didn't create any event!";
}

?>