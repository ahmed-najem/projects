/*	Assignment 3	Brandon Lacquement	(Creating, populating, and displaying Students)*/
CREATE TABLE STUDENTS (
StuID		Char(5)			NOT NULL		UNIQUE,
StuName		VarChar(60)		NOT NULL,
Major		VarChar(10),
Credits		Int,

PRIMARY KEY (StuID),
CONSTRAINT Credits_Ck CHECK (Credits BETWEEN 0 AND 199)
);

INSERT INTO STUDENTS
	VALUES ('S1001', 'Peters, Terry', 'History', 95);

INSERT INTO STUDENTS
	VALUES ('S1010', 'Bennette, Eddie', 'Art', 63);

INSERT INTO STUDENTS
	VALUES ('S1015', 'Jasper, Marnie', 'Math', 24);

SELECT * FROM STUDENTS;