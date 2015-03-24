<?php

	function get_product_name ($db, $product_id)
	{
		$query = "SELECT name FROM products WHERE id = $product_id";
		$result = mysqli_query($db, $query);
		$row = mysqli_fetch_array($result);
		return $row['name'];
	}
	
	function get_price ($db, $product_id)
	{
		$query = "SELECT price FROM products WHERE id = $product_id";
		$result = mysqli_query($db, $query);
		$row = mysqli_fetch_array($result);
		return $row['price'];
	}
	
	function remove_product($product_id)
	{
		$product_id = intval($product_id);
		$max = count($_SESSION['cart']);
		
		for($i = 0; $i < $max; $i++)
		{
			if($product_id == $_SESSION['cart'][$i]['productid'])
			{
				unset($_SESSION['cart'][$i]);
				break;
			}
		}
		$_SESSION['cart'] = array_values($_SESSION['cart']);
	}
	
	function get_order_total($db)
	{
		$max = count($_SESSION['cart']);
		$sum = 0;
		
		for($i = 0; $i < $max; $i++)
		{
			$product_id = $_SESSION['cart'][$i]['productid'];
			$quantity = $_SESSION['cart'][$i]['quantity'];
			$price = get_price($db, $product_id);
			$sum += $price * $quantity;
		}
		
		return $sum;
	}
	
	function add_to_cart($product_id, $quantity)
	{
		if($product_id < 1 || $quantity < 1)
		{
			return;
		}
		
		if (is_array($_SESSION['cart']))
		{
			$exists_results = product_exists($product_id);
			$exists = $exists_results[0];
			$position = $exists_results[1];
			
			if($exists)
			{
				$new_quantity = intval($_SESSION['cart'][$position]['quantity']);
				$new_quantity++;
				$_SESSION['cart'][$position]['quantity'] = $new_quantity;
			}
			
			else
			{
				$max = count($_SESSION['cart']);
				$_SESSION['cart'][$max]['productid'] = $product_id;
				$_SESSION['cart'][$max]['quantity'] = $quantity;
			}
		}
		else
		{
			$_SESSION['cart'] = array();
			$_SESSION['cart'][0]['productid'] = $product_id;
			$_SESSION['cart'][0]['quantity'] = $quantity;
		}
	}
	
	function product_exists($product_id)
	{
		$product_id = intval($product_id);
		$max = count($_SESSION['cart']);
		$flag = 0;
		
		for($i = 0; $i < $max; $i++)
		{
			if($product_id == $_SESSION['cart'][$i]['productid'])
			{
				$flag = 1;
				break;
			}
		}
		return array ($flag, $i);
	}
?>