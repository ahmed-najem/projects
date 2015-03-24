/* 2. 	(5) Display the number of employees and the average salary for all employees in each department (department name). 
		Include the location of the department. Round the average salary to two decimal places. 
		Label the columns Department, Location, Number of People, and Average Salary. Show highest averages first. */

SELECT D.DName AS "Department", D.Location AS "Location", COUNT(S.DeptNo) AS "Number of People", 
	   AVG(S.Salary) AS "Average Salary"
FROM DEPARTMENTS D, STAFF S
WHERE S.DeptNo = D.DeptNo
GROUP BY D.DName, D.Location
ORDER BY 4 DESC;