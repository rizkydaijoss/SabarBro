<?php  
 include 'koneksi.php'; 
 $hasil         = mysql_query("SELECT * FROM restoran") or die(mysql_error());
 $json_response = array();
 
if(mysql_num_rows($hasil)> 0){
 while ($row = mysql_fetch_array($hasil)) {
     $json_response[] = $row;
 }
 echo json_encode(array('datarestoran' => $json_response));
} 
?>