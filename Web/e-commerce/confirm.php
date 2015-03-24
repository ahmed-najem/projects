<!DOCTYPE html>
<!--
    Project Confirm (confirm.php)
    CIS-425/78020
    Fall 2014
    Brandon Lacquement
    -->
<?php
    // Connect to DB
    include('server-connect.php');
    $ofname = $_POST['fname'];
    $fname = mysqli_real_escape_string($dbc,$ofname);
    $olname = $_POST['lname'];
    $lname = mysqli_real_escape_string($dbc,$olname);
    $pword = $_POST['password'];
    $email = mysqli_real_escape_string($dbc,$_POST['email']);
    $phone = $_POST['phone'];
    $zip = $_POST['zip'];
    
    
    
    // Build SQL statement
    $query =
    	"INSERT INTO customers(fname,lname,email,password,phone,zip)" . 
    	"VALUES('$fname','$lname','$email','$pword','$phone','$zip')";
    	
    // Run it!
    $result = mysqli_query($dbc, $query) or die('Unable to write to database!');
    
    // Close connection
    mysqli_close($dbc);
    ?>
<html lang="en">
    <head>
        <!-- Meta tag -->
        <meta charset="utf-8" />
        <meta name="robots" content="noindex,nofollow" />
        <!-- Link tag for CSS -->
        <link type="text/css" rel="stylesheet" href="../stylesheets/pcss.css" />
        <!-- JavaScript Tag -->
        <script type="text/javascript" src="../jscode/a3focus.js"></script>
        <!-- <script type="text/javascript" src="jscode/msgs.js"></script> -->
        <!-- Favicon link -->
        <link rel="icon" href="../images/favicon.ico" />
        <!-- Web Page Title -->
        <title>Phodak Confirm</title>
    </head>
    <body>
        <div id="header">
            <p> 
                <img src="images/header.png" alt="Header!" />
            </p>
        </div>
        <div id="main">
            <form id="joinform" action="index.php" method="get">
                <p id="thankyou_text">
                    Thank you for registering! Please head back to Log In.
                </p>
                <!-- Return Button -->
                <div id="extra_button">
                    <input type="submit" value="Return To Log In!"/>
                </div>
                <br />
            </form>
            <div id = "footer">
                <p>
                    &copy; 2014, Brandon Lacquement
                </p>
            </div>
        </div>
    </body>
</html>