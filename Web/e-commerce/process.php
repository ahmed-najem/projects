<?php
	// Project Process (process.php)
	//Brandon Lacquement
	
	// connect to DB
	include('server-connect.php');
	
	// get php variables for email and password
	$email = $_POST['email'];
	$pword = $_POST['password'];
	$name=$_POST['fname'];	
	// Build email query
	$query = "SELECT * FROM customers WHERE email = '$email'";
	
	// Run the Query
	$result = mysqli_query($dbc, $query) or die('email read error!');
	
	// Do we have a row?
	if (mysqli_num_rows($result) == 0)
	{
		header('Location: index.php?rc=1');
		exit;
	}
	
	
	// Verify the email & password
	
	// Build password query
	$query = "SELECT * FROM customers WHERE email = '$email' AND password = '$pword'";
	
	// Run the Query
	$result = mysqli_query($dbc, $query) or die('Password read error!');
	
	// Do we have a row?
	if (mysqli_num_rows($result) == 0)
	{
		header('Location: index.php?rc=2');
		exit;
	}
	
	// If we got here, we can verify a email and password combo!
	// Close DB connection
	mysqli_close($dbc);
	
	// Start a php session
	session_name('customer');
	session_start('customer');
	
	// Get and store our php session variables
	$row = mysqli_fetch_array($result);
	$_SESSION['customer'] = $row['fname'];
	header('Location: home.php');
	exit;
	
	//This block MUST be the last block in this file!
	//Pass a 3 back to login.php for testing
	
	header('Location: index.php?rc=3');
	exit;
?>