<!DOCTYPE html>

<!--
GEAR
CIS-425/78020
Fall 2014
Brandon Lacquement
-->

<!--
<?php
	include('local-connect.php');
	// Build product query
	$query1 = "SELECT * FROM products WHERE name = 'Gear 1'";
	$query2 = "SELECT * FROM products WHERE name = 'Gear 2'";
	$query3 = "SELECT * FROM products WHERE name = 'Gear 3'";
	
	// Run the Query
	$result1 = mysqli_query($dbc, $query1) or die('product read error!');
	$row1 = mysqli_fetch_array($result1);
	$result2 = mysqli_query($dbc, $query2) or die('product read error!');
	$row2 = mysqli_fetch_array($result2);
	$result3 = mysqli_query($dbc, $query3) or die('product read error!');
	$row3 = mysqli_fetch_array($result3);
	
	$name1 = $row1['name'];
	$descrip1 = $row1['description'];
	$price1 = $row1['price'];
	$image1 = $row1['image'];
	
	$name2 = $row2['name'];
	$descrip2 = $row2['description'];
	$price2 = $row2['price'];
	$image2 = $row2['image'];
	
	$name3 = $row3['name'];
	$descrip3 = $row3['description'];
	$price3 = $row3['price'];
	$image3 = $row3['image'];
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
	<link rel="icon" href="../images/favicon.ico" />

    <!-- Web Page Title -->
    <title>PHODAK: Camera 1</title>

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
						<ul>
							<li><a href="camera1.php">Camera 1</a></li>
							<li><a href="camera2.php">Camera 2</a></li>
							<li><a href="camera3.php">Camera 3</a></li>
						</ul>
				</li>
				
				<li>
					<a href="lenses.php">LENSES</a>
						<ul>
							<li><a href="lens1.php">LENS 1</a></li>
							<li><a href="lens2.php">LENS 2</a></li>
							<li><a href="lens3.php">LENS 3</a></li>
						</ul>
				</li>
				
				<li>
					<a href="gear.php">GEAR</a>
						<ul>
							<li><a href="gear1.php">GEAR 1</a></li>
							<li><a href="gear2.php">GEAR 2</a></li>
							<li><a href="gear3.php">GEAR 3</a></li>
						</ul>
				</li>
				
				<li>
					<a href="accessories.php">ACCESSORIES</a>
						<ul>
							<li><a href="accessory1.php">ACCESSORY 1</a></li>
							<li><a href="accessory2.php">ACCESSORY 2</a></li>
							<li><a href="accessory3.php">ACCESSORY 3</a></li>
						</ul>
				</li>
			</ul>
		</div>
  
	<div id="main">
		<form id="homeform" action="logout.php" method="post">
			<p class="bold">
				<?php
				date_default_timezone_set('MST');
				$time = date('H');
				if ($time < '12')
				{
					echo "Good morning!";
				}
				elseif ($time < '17')
				{
					echo "Good afternoon!";
				}
				else
				{
					echo "Good evening!";
				}
				?>
			</p>
			
			<p class="submit">
				<!-- Submit Button -->
				<input type="submit" value="Log Out!" />
			</p>
		</form>

	
		<div id = "item1">
			<p id = "name">
				<?php
					echo $name1;
				?>
			</p>
			<p id = "description">
				<?php
					echo $descrip1;
				?>
			</p>
			
			<p id = "price">
				<?php
					echo $price1;
				?>
			</p>
			
			<p id = "image">
				<?php
					echo "<img src='$image1' alt='Product Image!'/>"
				?>
			</p>
		</div>
		
		<div id = "item2">
			<p id = "name">
				<?php
					echo $name2;
				?>
			</p>
			<p id = "description">
				<?php
					echo $descrip2;
				?>
			</p>
			
			<p id = "price">
				<?php
					echo $price2;
				?>
			</p>
			
			<p id = "image">
				<?php
					echo "<img src='$image2' alt='Product Image!'/>"
				?>
			</p>
		</div>
		
		<div id = "item3">
			<p id = "name">
				<?php
					echo $name3;
				?>
			</p>
			<p id = "description">
				<?php
					echo $descrip3;
				?>
			</p>
			
			<p id = "price">
				<?php
					echo $price3;
				?>
			</p>
			
			<p id = "image">
				<?php
					echo "<img src='$image3' alt='Product Image!'/>"
				?>
			</p>
		</div>
	
	
		<div id = "footer">
				<p>
					&copy; 2014, Brandon Lacquement
				</p>
		</div>
	</div>
  </body>
</html>