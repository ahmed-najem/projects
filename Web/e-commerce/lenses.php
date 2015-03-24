<!DOCTYPE html>
<!--
    LENSES
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
        <title>PHODAK: Lenses</title>
        <script type="text/javascript">
            function addtocart(prod_id)
            {
            	document.productform.productid.value = prod_id;
            	document.productform.command.value = 'add';
            	document.productform.submit();
            }
        </script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
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
            <form name="productform">
                <input type="hidden" name="productid" />
                <input type="hidden" name="command" />
            </form>
            <table id="product_table">
                <?php
                    $query = "SELECT * FROM products WHERE id = '4' OR id = '5' OR id='6'";
                    $result = mysqli_query($dbc, $query) or die ("Error querying");
                    
                    while($row = mysqli_fetch_array($result))
                    {
                    	$id = 'lens' . $row['id'] . '.php';
                    	$idimg = 'shopping_img' . $row['id'];
                    	echo '<tr>
                    	<td><img id="' . $idimg . '" src="' . $row['image'] . '" alt="Product image!" /></td>
                    	<td><p><strong>' . $row['name'] . '</strong></p>
                    	<p>' . $row['description'] . '</p>
                    	<p>Price:<strong>&#36;' . $row['price'] . '</strong></p>
                    	</td>
                    	<td><form action="' . $id . '">
                    			<input type="submit" value="Details">
                    		</form>
                    	</td>
                    	</tr>';
                    }
                    ?>
            </table>
            <div id = "footer">
                <p>
                    &copy; 2014, Brandon Lacquement
                </p>
            </div>
        </div>
    </body>
</html>