<?php 
require "conn.php";
$type = $_POST["type"];
$id = $_POST["id"];
$pass1 = $_POST["pass1"];
$pass2 = $_POST["pass2"];

if(($type=='password')==1){
	$mysql_qry = "select * from users where id='$id';";
	$result = mysqli_query($conn ,$mysql_qry);
	if(mysqli_num_rows($result)==1){
		$array = mysqli_fetch_array($result,MYSQLI_ASSOC);
		$pass = $array["pass"];
		if(($pass==$pass1)==1){
			$mysql_qry2 = "UPDATE users SET pass='$pass2' WHERE id='$id'";
			$result2 = mysqli_query($conn ,$mysql_qry2);
			echo "Actualizacion exitosa";
		}else{
		echo "La contraseña no es correcta";
		}
		
	}
}
?>