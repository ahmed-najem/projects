<?php
	//local-connect.php
	
	$host 	= 'localhost';
	$user 	= 'root';
	$pw 	= '';
	$db		= 'project';
	
	// Connect to the database
	$dbc	= mysqli_connect($host, $user, $pw, $db)
				or die('Connection error! (LOCAL)');
?>