<?php
	
	$server		= "localhost"; // sesuaikan alamat server anda
	$user		= "amranswandy_sabarbrologin"; // sesuaikan user web server anda
	$password	= "budiluhur14"; // sesuaikan password web server anda
	$database	= "amranswandy_sabarbro"; // sesuaikan database web server anda
	
	$connect = mysql_connect($server, $user, $password) or die ("Koneksi gagal!");
	mysql_select_db($database) or die ("Database belum siap!");
?>