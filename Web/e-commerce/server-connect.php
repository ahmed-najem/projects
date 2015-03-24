<?php
	//server-connect.php
	
	$host 	= 'localhost';
	$user 	= 'blacquem';
	$pw 	= 'cis425';
	$db		= 'blacquem';
	
	// Connect to the database
	$dbc	= mysqli_connect($host, $user, $pw, $db)
				or die('Connection error! (SERVER)');
?>