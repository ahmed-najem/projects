/*	Brandon Lacquement
	CIS 340 Assignment #6 */

/*	1. 	(5) How many employees have the same job? Store the result in JobEmployeeCount. 
	Display the job and the number of employees. */

CREATE VIEW JobEmployeeCount(Job, Number)
AS SELECT S.Job, COUNT(S.Job)
FROM STAFF S
GROUP BY Job;

SELECT * FROM JobEmployeeCount;

/*	Error is because I had to create the view, then run the select without the view in the query. Then I put
	the create view statement back in there so you can see it all at once with the results. */














