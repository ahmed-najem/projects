/*	6. 	**(10) Write the nested query to display the employee number, name, and salary for all employees who earn more 
		than the average salary and who work in a department with any employee with a T in their name (T might be upper or lower case). */

SELECT StaffID AS "Employee Number", Ename AS "Name", Salary
FROM STAFF
WHERE Salary >
	(SELECT AVG(Salary)
	FROM STAFF)
AND DeptNo IN 
	(SELECT DeptNo
	FROM STAFF
	WHERE Ename LIKE '%t%'
	OR Ename LIKE '%T%');