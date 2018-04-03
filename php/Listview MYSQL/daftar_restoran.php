<?php
$link = mysql_connect('localhost', 'amranswandy_sabarbrologin', 'budiluhur14') or die('Cannot connect to the DB');
mysql_select_db('amranswandy_sabarbro', $link) or die('Cannot select the DB');

/* grab the posts from the db */
$query = "SELECT id_restoran, namarestoran, alamat, menu, harga, fasilitas, hp, latitude, longitude FROM restoran";
$result = mysql_query($query, $link) or die('Errorquery:  '.$query);

$rows = array();
while ($r = mysql_fetch_assoc($result)) {
    $rows[] = $r;
}
$data = "{datarestoran:".json_encode($rows)."}";
echo $data;
?>