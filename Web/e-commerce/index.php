<!DOCTYPE html>
<!--
    Project Login (index.php)
    CIS-425/78020
    Fall 2014
    Brandon Lacquement
 -->
 
<!--
    <?php
        // Start a php session
        session_name("customer");
        session_start("customer");
        
        //Check to see if user is already logged in
        if(isset($_SESSION['customer']))
        {
        	header('Location: home.php');
        	exit;
        }
        ?>
    -->
<html lang="en">
    <head>
        <!-- Meta tag -->
        <meta charset="utf-8" />
        <meta name="robots" content="noindex,nofollow" />
        <!-- ADD REDIRECT META TAG HERE -->
        <!-- Link tag for CSS -->
        <link type="text/css" rel="stylesheet" href="../stylesheets/pcss.css" />
        <!-- JavaScript Tag -->
        <script type="text/javascript" src="../jscode/a3focus.js"></script>
        <script type="text/javascript" src="../jscode/msgs.js"></script>
        <!-- Favicon link -->
        <link rel="icon" href="images/favicon.png" />
        <!-- Web Page Title -->
        <title>PHODAK: Login</title>
    </head>
    <body>
        <div id="header">
            <p> 
                <img src="images/header.png" alt="Header!" />
            </p>
        </div>
        <div id="mainlog">
            <form id="joinform" action="process.php" method="post">
                <p class="fh1">
                    Sign In
                </p>
                <?php
                    // Check return code from process.php
                    if($_GET["rc"] == 1)
                    {
                    	echo '<p class="logerr">Bad Login Info!</p>';
                    }
                    if($_GET["rc"] == 2)
                    {
                    	echo '<p class="logerr">Bad Login Info!</p>';
                    }
                    if($_GET["rc"] == 3)
                    {
                    	echo '<p class="logerr">Returned from process.php...</p>';
                    }
                    ?>
                <p>
                    <!-- Email Address -->
                    <label for ="email">Email Address:</label>
                    <input type="email" id="email" name="email" 
                        required
                        autofocus
                        pattern="[a-z0-9-_$.]+@[a-z0-9-_.]+\.[a-z]{2,20}"
                        title="Please enter a valid email address."
                        placeholder="Email..."
                        />
                    <br />
                    <!-- Password -->
                    <label for ="password">Password:</label>
                    <input type="password" id="password" name="password" 
                        required
                        pattern="[a-zA-Z0-9-_!$]{5,15}"
                        title="Please enter 5-15 characters, UPPER/lower case letters, numbers, -, _, !, $ only. No Spaces."
                        placeholder="Password..."
                        />
                    <br />
                <p class="submit">
                    <!-- Submit Button -->
                    <input type="submit" value="Sign In" />
                </p>
            </form>
        </div>
		
        <div id="extra_button">
            <form action="register.htm">
                <input type="submit" value="Need to Register?">
            </form>
        </div>
		
        <div id = "footer">
            <p>
                &copy; 2014, Brandon Lacquement
            </p>
        </div>
    </body>
</html>