# JsonParsingTest
Its Very easy to parse json using volley

First you create a student database
then create register table inside student database with two field id and name

then create a php file name connection.php

<?php 
$dbHost = "localhost";
$dbUser = "root";
$dbPass = "";
$dbName = "student";

$con = mysqli_connect($dbHost,$dbUser,$dbPass,$dbName);

?>

Then addUser.php

<?php
include './connection.php';
if(!$con){
	die("Database connection failed;" . mysqli_connect_error() . "(" . mysqli_connect_errno() . ")");
}else{
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		$id = $_POST['id'];
		$name = $_POST['name'];
		
		$sql = "insert into register (id,name) values ('$id','$name')";
		
		if(mysqli_query($con,$sql)){
			echo "Successfully Registered";
        }else{
            echo "Could not register";
        }
	}
}
?>

After the showUser.php

<?php 
include './connection.php';
if(!$con){
	die("Database connection failed;" . mysqli_connect_error() . "(" . mysqli_connect_errno() . ")");
}else{
	
	$sql = "select * from register";
	$res = mysqli_query($con,$sql);
	$result = array();
	
	while($row = mysqli_fetch_array($res)){
		array_push($result,
		array('id'=>$row[0],
		'name'=>$row[1]));
	}
	echo json_encode(array("result"=>$result));
    mysqli_close($con);
}

?>
