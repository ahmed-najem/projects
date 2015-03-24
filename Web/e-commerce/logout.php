<?php
	// Project Logout (logout.php)
	//Brandon Lacquement
	
	session_name("customer");
	session_start("customer");
	session_unset("customer");
	session_destroy();
	
	header('Location: index.php');
?>