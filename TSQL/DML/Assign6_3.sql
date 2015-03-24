/*	3. 	(9) Write the nested query to display the employee last name and salary for all employees in the same 
		department as Blake. Exclude Blake from the output. Store the result in Employees_of_Blake. */

CREATE VIEW Employees_of_Blake("Last Name","Salary")
AS SELECT  S.Ename, S.Salary
FROM STAFF S
WHERE S.Ename != 'Blake'
AND S.DeptNo = 
	(SELECT DeptNo
	FROM STAFF
	Where EName = 'Blake');

SELECT * FROM Employees_of_Blake;

/*	Error is because I had to create the view, then run the select without the view in the query. Then I put
	the create view statement back in there so you can see it all at once with the results. */
