<!DOCTYPE html>
<!--
    Project CART (cart.php)
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
<?php
    include("db.php");
    include("productfunctions.php");
    
    if($_REQUEST['command'] == 'delete' && $_REQUEST['productid'] > 0)
    {
    	remove_product($_REQUEST['productid']);
    }
    elseif($_REQUEST['command'] == 'clear')
    {
    	unset($_SESSION['cart']);
    }
    elseif($_REQUEST['command'] == 'update')
    {
    	$max = count($_SESSION['cart']);
    	
    	for($i = 0; $i < $max; $i++)
    	{
    		$product_id = $_SESSION['cart'][$i]['productid'];
    		$quantity = intval($_REQUEST['product' . $product_id]);
    		
    		if($quantity > 0 && $quantity <= 1000)
    		{
    			$_SESSION['cart'][$i]['quantity'] = $quantity;
    		}
    		elseif($quantity <= 0 && $quantity > 1000)
    		{
    			$message = 'Some products were not updated! Item quantity must be between 1 and 1000.';
    		}
    	}
    }
    elseif($_REQUEST['command'] == 'complete')
    {
    	unset($_SESSION['cart']);
    	header("Location: cartthankyou.php");
    }
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
        <link rel="icon" href="images/favicon.png" />
        <!-- Web Page Title -->
        <title>PHODAK: Cart</title>
        <script type="text/javascript">
            function del(productid)
            {
            	if(confirm('Are you sure you want to delete this item?'))
            	{
            		document.cartform.productid.value = productid;
            		document.cartform.command.value = 'delete';
            		document.cartform.submit();
            	}
            }
            
            function clear_cart()
            {
            	if(confirm('Are you sure you want to empty your cart?'))
            	{
            		document.cartform.command.value = 'clear';
            		document.cartform.submit();
            	}
            }
            
            function update_cart()
            {
            	document.cartform.command.value = 'update';
            	document.cartform.submit();
            }
            
            function complete_order()
            {
            	document.cartform.command.value = 'complete';
            	document.cartform.submit();
            }
        </script>
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
            
			<form name="cartform" method="post">
                <input type="hidden" name="productid" />
                <input type="hidden" name="command" />
                <span id="cont_shop">
                <input id ="cont_button" type="button" value="Continue Shopping" onclick="window.location.href='home.php'" />
                </span>
                <div id="formerror"><?php echo $message ?></div>
                <table id="cart_table">
                    <?php		
                        if(count($_SESSION['cart']))
                        {
                        	echo '<tr>
                        	<th>Name</th>
                        	<th>Price</th>
                        	<th>Qty</th>
                        	<th>Amount</th>
                        	<th>Options</th>
                        	</tr>';
                        	
                        	$max = count($_SESSION['cart']);
                        	for($i = 0; $i < $max; $i++)
                        	{
                        		$product_id = $_SESSION['cart'][$i]['productid'];
                        		$quantity = $_SESSION['cart'][$i]['quantity'];
                        		$product_name = get_product_name($dbc, $product_id);
                        		$product_price = get_price($dbc, $product_id);
                        	
                        		if($quantity == 0)
                        		{
                        			continue;
                        		}
                        		
                        		if($product_price > 0)
                        		{
                        			echo '<tr>
                        			<td>' . $product_name . '</td>
                        			<td>&#36; ' . $product_price . '</td>
                        			<td><input type="text" name="product' . $product_id . '" value="' .
                        				$quantity . '" maxlength="4" size="2" /></td>
                        				<td>&#36; ' . $product_price*$quantity . '</td>
                        				<td><a href="javascript:del(' . $product_id . ')">Remove Item</a></td>
                        				</tr>';
                        		}
                        	}
                        	
                        	echo '<tr>
                        	<td colspan="2"><strong>Order Total: &#36;' . get_order_total($dbc) . '</strong></td>
                        	<td colspan="3" id="cart_buttons">
                        	<input type="submit" value="Clear Cart" onclick="clear_cart()">
                        	<input type="submit" value="Update Cart" onclick="update_cart()">
                        	<input type="submit" value="Complete Order" onclick="complete_order()">
                        	</td>
                        	</tr>';
                        }
                        else
                        {
                        	echo '<tr><td>There are no items in your shopping cart.</td></tr>';
                        }
                        ?>
                </table>
            </form>
            
			<div id = "footer">
                <p>
                    &copy; 2014, Brandon Lacquement
                </p>
            </div>
        </div>
    </body>
</html>