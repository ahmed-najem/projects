/* Brandon Lacquement */

/* Q1. (3) What products do we sell? Names and price. Highest price first. */

SELECT P.Descrip AS "Name", P.Price AS "Price"
FROM PRODUCTS P
ORDER BY 2 DESC;


/* Q2. (4) I need the name and city of the customers from zip code ending in 301. Alphabetically by city. */

SELECT C.Name AS "Name", C.City AS "City"
FROM CUSTOMERS C
WHERE C.Zip LIKE '%301'
ORDER BY 2;


/* Q3. (2) How many customers do we have? Label the result column Total Customers.  */

SELECT COUNT(C.CustID) AS "Total Customers"
FROM CUSTOMERS C;
 

/* Q4. (3) Which department is in Chicago? List the name of the department and its location. */

SELECT D.DName AS "Department Name", D.Location AS "Location"
FROM DEPARTMENTS D
WHERE D.Location = 'Chicago';

 
/* Q5. (4) Someone’s on the phone and wants to know what tennis balls we sell. I need the id number and 
		price also. List cheapest first. */

SELECT P.ProdID AS "ID Number", P.Price AS "Price"
FROM PRODUCTS P
WHERE P.Descrip LIKE '% tennis balls%'
ORDER BY 2;


/* Q6. (4) HR needs a list of employee names and the date they were hired for all employees hired in 2012. 
		List by hire date within department, oldest first. */

SELECT S.Ename AS "Name", S.Hiredate AS "Hire Date"
FROM Staff S
WHERE S.Hiredate > '31-Dec-11'
AND S.Hiredate < '01-Jan-13'
ORDER BY S.DeptNo, S.Hiredate; 

 
/* Q7. (6) Which employees earn more than $2500? We don't need the President. Include the department 
		name, employee name, and salary in the result - highest salary first. Keep all employees in the same 
		department together. */

SELECT D.DName AS "Department", S.Ename AS "Name", S.Salary AS "Salary"
FROM Staff S, DEPARTMENTS D
WHERE S.DeptNo = D.DeptNo
AND S.Salary > 2500
AND S.Job != 'President'
ORDER BY 3 DESC;

 
/* Q8. (5) List all employees that are in department 20. Include the location of the department and order the 
		result by name. List the location first. */

SELECT D.Location AS "Location", S.Ename AS "Name"
FROM STAFF S, DEPARTMENTS D
WHERE D.DeptNo = 20
ORDER BY 2;


/* Q9. (5) Display the employee name, salary, department name, and location of all employees who earn a 
		commission. Highest commission first. Use Commission as the header for commissions. */

SELECT S.Ename AS "Name", S.Salary AS "Salary", D.DName AS "Department", D.Location AS "Location", S.Comm AS "Commissions"
FROM STAFF S, DEPARTMENTS D
WHERE S.DeptNo = D.DeptNo
AND S.Comm IS NOT NULL
ORDER BY 5 DESC;

 
/* Q10. (5) Display the employee name and customer name for all employees who are in departments 20 and 
		30. List in alphabetical order of employee. */

SELECT S.Ename AS "Employee", C.Name AS "Customer"
FROM STAFF S, CUSTOMERS C
WHERE S.StaffID = C.RepID
AND S.DeptNo IN (20,30)
ORDER BY 1;

 
/* Q11. (5) List the employees, their jobs and hire dates for those employees who work in Dallas. Order the 
		output by most recent hire date. Include the location in the output. */

SELECT S.Ename AS "Employee", S.Job AS "Job", S.Hiredate AS "Hire Date", D.Location AS "Location"
FROM STAFF S, DEPARTMENTS D
WHERE S.DeptNo = D.DeptNo
AND D.Location = 'Dallas'
ORDER BY 3 DESC;

 
/* Q12. (3) List the number of days delay to ship each order out that was delayed (order date is not the same 
		date as the ship date). Include order number and 'Shipment Delay' in the output - highest number first. 
		What does the output tell you? */
/* This tells you the time lapse between orders being placed and orders shipping from inventory. */
SELECT O.OrdID AS "Order Number", DATEDIFF(DAY, O.OrderDate, O.ShipDate) AS "Shipment Delay"
FROM ORDERS O
WHERE O.ShipDate != O.OrderDate
ORDER BY 2 DESC;


/* Q13. (4) I was supposed to increase an employee’s salary by 20% but I’ve forgotten which salary I was to 
		increase. I think the employee’s name started with the letter “M”. I also seem to recall that the 
		employee worked in department 10. List any employees that match these conditions. Include 
		department number and name so that I can check for sure. */

SELECT S.DeptNo AS "Department Number", S.Ename AS "Name"
FROM STAFF S
WHERE S.Ename LIKE 'M%'
AND S.DeptNo = 10;

 
/* Q14. (4) List all employees and their managers alphabetically by manager name. Label the columns 
		appropriately. */

SELECT S.Ename AS "Employee", S.MGR AS "Manager"
FROM STAFF S
ORDER BY 2;

 
/* Q15. (3) Which customers have placed orders? Display the customer name (alphabetically) only once if they 
		have ordered multiple times*/

SELECT DISTINCT(C.Name)
FROM CUSTOMERS C, ORDERS O
WHERE C.CustID = O.CustID;

 
/* Q16. (5) Display the employee name, department number, and all the employee's colleagues that work in 
		the same department. List alphabetically by department number first, then the Employee name, then 
		the colleague names. Label the columns appropriately. */

SELECT S.Ename AS "Employee", S.DeptNo AS "Department Number", S.Ename AS "Colleague"
FROM STAFF S
ORDER BY 2, 1, 3;

 
/* Q17. (3) What is the annual salary for each employee? Include the employee's job, name, and annual salary. 
		List the result by salary within job. Use appropriate column headings. (weekly salary is stored) */

SELECT S.Job AS "Job", S.Ename AS "Name", (S.Salary * 52) AS "Salary"
FROM STAFF S
ORDER BY 1, 3 DESC;

 
/* Q18. (2) What is the difference between the highest and lowest salary? Label the result Salary Difference. */

SELECT (MAX(S.Salary) - MIN(S.Salary)) AS "Salary Difference"
FROM STAFF S;-----------------*/

 
/* Q19. (5) We finally hired a number of employees to work in our operations department. Add the following 
		information to the database. Display these records to ensure they populated correctly. (Show all 
		statements to add and display data in one query window) */

insert into STAFF values (8000,'Richardson','Super',7839,'28-Oct-13',2530,null,40);
insert into STAFF values (8101,'Kennedy','Maint',8000,'28-Oct-13',1938,null,40);
insert into STAFF values (8102,'Fredricks','Maint',8000,'28-Oct-13',1978,null,40);
insert into STAFF values (8103,'Edwards','Maint',8000,'28-Oct-13',950,null,40);

SELECT *
FROM STAFF S
WHERE S.DeptNo = 40;


/* Q20. (5) **What is the average salary for the operations staff? Label output Average Salary for Operations. 
		 This question is extra credit only to show the output with 2 decimal places. */

SELECT CONVERT(DECIMAL(10,2) ,AVG(S.Salary)) AS "Average Salary for Operations"
FROM STAFF S
WHERE S.DeptNo = 40;
