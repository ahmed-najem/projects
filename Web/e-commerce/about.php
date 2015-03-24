<!DOCTYPE html>
<!--
    Project About (about.php)
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
        <title>PHODAK: About</title>
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
                            	echo "Good morning " . $_SESSION["customer"] . "!";
                            }
                            elseif ($time < '17')
                            {
                            	echo "Good afternoon " . $_SESSION["customer"] . "!";
                            }
                            else
                            {
                            	echo "Good evening " . $_SESSION["customer"] . "!";
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
        <div id="about">
            <p class="fh3">
                About Phodak
            </p>
            <div id="aboutpic">
                <img src="images/bear.jpg" alt="Wow!">
            </div>
            <p id="abouttext">
                Enter- Phodak. Your one stop stop for cameras and lenses. Without us, the world would just
                be sitting around trying to figure out which photography products are good and which ones
                are not. Luckily, we have finally finished our web site and are out to conquer the e-commerce
                scene with our amazing array of products. We specialize in outdoor camera equipment because
                those are the people that take the best pictures, obviously. Why even bother trying to target
                a different market. Besides that, our site currently sells three different cameras and lenses
                although they are not all compatible with each other and our web development team felt that
                they couldn't be bothered to let our online shoppers know. So our position is, if you know what
                you need, then buy it. If not, it isn't out problem. Phodak OUT! Click <a href="http://www.redbull.com/">here</a>
				if you like Redbull!
            </p>
        </div>
        <div id = "footer">
            <p>
                &copy; 2014, Brandon Lacquement
            </p>
        </div>
    </body>
</html>