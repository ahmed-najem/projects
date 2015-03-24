<!DOCTYPE html>
<!--
    PROJECT CART THANK YOU
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
<html lang="en">
    <head>
        <!-- Meta tag -->
        <meta charset="utf-8" />
        <meta name="robots" content="noindex,nofollow" />
        <!-- Link tag for CSS -->
        <link type="text/css" rel="stylesheet" href="../stylesheets/pcss.css" />
        <!-- Favicon link -->
        <link rel="icon" href="images/favicon.png" />
        <!-- JavaScript Tag -->
        <script type="text/javascript" src="../jscode/a3focus.js"></script>
        <script type="text/javascript" src="../jscode/msgs.js"></script>
        <!-- Web Page Title -->
        <title>PHODAK: Thank You!</title>
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
            <form id="joinform" action="home.php" method="get">
                <p id="thankyou_text">
                    Thank you for your order, <?php echo $_SESSION["customer"];?>! 
                    <i>We know where you live</i> and it will arrive at your doorstep within 14 business days.
                </p>
                <br />
                <!-- Return Button -->
                <div id="extra_button">
                    <input type="submit" value="Return To Home!"/>
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