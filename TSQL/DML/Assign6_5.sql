/*	5. 	(12) We want to send a promotion letter to our best customers. Retrieve the customer's name for those 
		customers who have purchased more than 5 different items on a single order. (Fully nested query - 2 nests) 
		Store the result in PROMOTIONS. */

CREATE VIEW PROMOTIONS("Customer Name")
AS SELECT Name
FROM CUSTOMERS 
WHERE CustID IN
	(SELECT CustID
	FROM ORDERS
	WHERE OrdID = 
		(SELECT OrdID
		FROM ITEMS
		GROUP BY OrdID
		HAVING COUNT(OrdID) > 5));

SELECT * FROM PROMOTIONS;

/*	Error is because I had to create the view, then run the select without the view in the query. Then I put
	the create view statement back in there so you can see it all at once with the results. */