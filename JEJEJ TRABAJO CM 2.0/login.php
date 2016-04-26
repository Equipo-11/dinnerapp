<?php 
require "conn.php";
$id = $_POST["id"];
$pass = $_POST["pass"];
$mysql_qry = "select * from practica where id like '$id' and pass like '$pass';";
$result = mysqli_query($conn ,$mysql_qry);
if(mysqli_num_rows($result) > 0) {
echo "Login success";
}
else {
echo "Login not success";
}

?>