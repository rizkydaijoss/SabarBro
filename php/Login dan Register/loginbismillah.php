<?php
header("Content-Type:application/json");
include "dbConnect.php";
if ((isset($_GET['username'])) or (isset($_GET['password']))) {
	
$username = htmlspecialchars(mysql_real_escape_string($_GET["username"]));
$password = htmlspecialchars(mysql_real_escape_string($_GET["password"]));
$email = htmlspecialchars(mysql_real_escape_string($_GET["email"]));

$query = "select * from login where username ='$username' and password='$password'";

$hasil = mysql_query($query);
if (mysql_num_rows($hasil) > 0) {
$response = array();
$response["login"] = array();
while ($data = mysql_fetch_array($hasil))
{
$h['username']  		= $data['username'];
 array_push($response["login"], $h);
}
	$response["success"] = "1";
	header('Content-type: application/json; charset=utf-8');
	echo json_encode($response);

}else {
    $response["success"] = "0";
    $response["message"] = "Tidak ada data";
	header('Content-type: application/json; charset=utf-8');
	echo json_encode($response);
}
}else {
    $response["success"] = "0";
    $response["message"] = "Tidak ada data";
	header('Content-type: application/json; charset=utf-8');
	echo json_encode($response);
}
?>