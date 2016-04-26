<?php 
require "conn.php";
$id = $_POST["id"];
//$id = 'irene';
$mysql_qry = "select * from practica where id='$id';";
$result = mysqli_query($conn ,$mysql_qry);
//$result = mysqli_store_result()
if(mysqli_num_rows($result) > 0) {
//echo "ID encontrado";
$array = mysqli_fetch_array($result,MYSQLI_ASSOC);
echo $array["id"],",",$array["email"],",",$array["phone"],",",$array["country"];
}
else{
	echo "ID no encontrado";
}

?>