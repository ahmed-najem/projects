<!DOCTYPE html>
<!--
    PEOJECT EMAIL FORM
    
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
        <title>PHODAK: Contact Us</title>
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
            <form id="joinform" action="https://webapp4.asu.edu/pubtools/Mail" method="post">
                <p class="fh1">
                    Email Form:
                </p>
                <p>
                    <input name="sendto" type="hidden" value="brlacquement@gmail.com" />
                    <input name="subject" type="hidden" value="Website Comments" />
                    <input name="location" type="hidden"
                        value="http://cis425.wpcarey.asu.edu/blacquem/project/emthankyou.php" />
                </p>
                <p>
                    <!-- Name -->
                    <label for ="name">Name:</label>
                    <input type="text" id="name" name="name" 
                        required 
                        autofocus 
                        pattern="[a-zA-Z-' ]{4,30}"
                        title="Please enter 4-30 chars, UPPER/lower case and - or ' only"
                        />
                    <br />
                    <!-- Email Address -->
                    <label for ="email">Email Address:</label>
                    <input type="email" id="email" name="email" 
                        required
                        pattern="[a-z0-9-_$.]+@[a-z0-9-_.]+\.[a-z]{2,20}"
                        title="Please enter a valid email address."
                        />
                    <br />
                    <!-- Why? -->
                    Comments:
                    <br />
                    <textarea name="consider" id="consider" rows="2" cols="49"  
                        required maxlength="500" title="Please enter between 1 and 500 characters"></textarea>
                </p>
                <p class="submit">
                    <!-- Submit Button -->
                    <input type="submit" value="Send Email!" />
                    <!-- Reset Button -->
                    <span class="reset">
                    <input type="reset" value="Clear Form!" onclick="history.go(0)"/>
                    </span>
                </p>
            </form>
            <div id = "footer">
                <p>
                    &copy; 2014, Brandon Lacquement
                </p>
            </div>
        </div>
    </body>
</html>