<?php
	
	//SQL Connection Variables
	$host 		= 'localhost';
	$user 		= 'blacquem';
	$password 	= 'cis425';
	$database 	=	'blacquem';
	
	//Set up MySQL connection
	$dbc = mysqli_connect($host, $user, $password, $database)
			or die('Error connecting to MySQL server');
			
	//BeginSession
	session_start();
?>