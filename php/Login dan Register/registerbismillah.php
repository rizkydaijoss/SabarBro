<?php
include 'dbConnect.php';  //memanggil file db.php
 
//mengecek variabel
if(isset($_POST["username"]) && isset($_POST["password"]) && isset ($_POST["email"])){
$username = $_POST['username'];
$password = $_POST['password'];
$email= $_POST['email'];
 
//perintah SQL untuk memasukan data
$query = "INSERT INTO login (username,password,email) VALUES ('$username','$password','$email')";
$hasil  = mysql_query($query);
if($hasil)
{
    $response["success"]= true ;
    $response["message"]= "Register berhasil,silakan login";
    echo json_encode($response);
 
}
else {
    $response['success']= false ;
    $response['message']="maaf,terjadi kesalahan";
    echo json_encode($response);
}
}else{
    $response['success']= false ;
    $response['message']="maaf, data salah";
    echo json_encode($response);
}
?>