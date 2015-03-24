/*	4. 	(7) List all employees who earn more than the average salary for the company. Show employee last name, salary, 
		and department name, highest salary first. (Join & nest) */

SELECT S.Ename AS "Last Name", S.Salary, D.DName AS "Department Name"
FROM STAFF S, DEPARTMENTS D
WHERE S.DeptNo = D.DeptNo
AND S.Salary > 
	(SELECT AVG(Salary)
	FROM STAFF)
ORDER BY 2 DESC;