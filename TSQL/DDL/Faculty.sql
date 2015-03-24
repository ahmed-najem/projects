/*	Assignment 3	Brandon Lacquement	(Creating, populating, and displaying Faculty)*/
CREATE TABLE FACULTY (
FacID		Char(4)			NOT NULL		UNIQUE,
FacName		VarChar(60)		NOT NULL		UNIQUE,
Dept		VarChar(10),
Rank		VarChar(15)

PRIMARY KEY (FacId),
);

INSERT INTO FACULTY
	VALUES('F101', 'Wells', 'Art', 'Professor');

INSERT INTO FACULTY
	VALUES('F202', 'Carrington', 'History', 'Associate');

INSERT INTO FACULTY
	VALUES('F105', 'Blake', 'CSC', 'Instructor');

SELECT * FROM FACULTY;