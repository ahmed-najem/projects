<!DOCTYPE html>
<!--
    Project Home (home.php)
    CIS-425/78020
    Fall 2014
    Brandon Lacquement
-->
<!--
<?php
	include('server-connect.php');
	session_name("customer");
	session_start("customer");
	?>
-->
<!--
<?php
	//Import necessary globals and functions
	include("db.php");
	include("productfunctions.php");
	
	if($_REQUEST['command'] == 'add' && $_REQUEST['productid'] > 0)
	{
		$product_id = $_REQUEST['productid'];
		add_to_cart($product_id, 1);
		header("Location: cart.php");
		exit();
	}
	?>
-->
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
        <link rel="icon" href="images/favicon.png" />
        <!-- Web Page Title -->
        <title>PHODAK: Home</title>
    </head>
    <body>
        <div id="header">
            <p> 
                <img src="images/header.png" alt="Header!" />
            </p>
        </div>
        <div id="navbar">
            <ul id="nav">
                <li>
                    <a href="home.php">HOME</a>
                </li>
                <li>
                    <a href="cameras.php">CAMERAS</a>
                </li>
                <li>
                    <a href="lenses.php">LENSES</a>
                </li>
                <li>
                    <a href="about.php">ABOUT US</a>
                </li>
                <li>
                    <a href="emform.php">CONTACT US</a>
                </li>
                <li>
                    <a href="cart.php">MY CART</a>
                </li>
            </ul>
        </div>
		
        <div id="main">
            <div id="controls">
                <form id="homeform" action="logout.php" method="post">
                    <p class="bold">
                        <?php
                            date_default_timezone_set('MST');
                            $time = date('H');
                            if ($time < '12')
                            {
                            	echo "Good morning, " . $_SESSION["customer"] . "!";
                            }
                            elseif ($time < '17')
                            {
                            	echo "Good afternoon, " . $_SESSION["customer"] . "!";
                            }
                            else
                            {
                            	echo "Good evening, " . $_SESSION["customer"] . "!";
                            }
                            ?>
                    </p>
                    <p class="submit">
                        <!-- Submit Button -->
                        <input type="submit" value="Log Out!" /> 
                    </p>
                </form>
            </div>
        </div>
        <div id="feature">
            <img src="images/homephoto.jpg" alt="Wow!">
        </div>
        <div id = "footer">
            <p>
                &copy; 2014, Brandon Lacquement
            </p>
        </div>
    </body>
</html>