/*	Assignment 3	Brandon Lacquement	(Creating, populating, and displaying Courses)*/
CREATE TABLE COURSES (
CourseID		Char(7)			NOT NULL		UNIQUE,
FacID			Char(4)			NOT NULL,
Sched			VarChar(12),
Room			VarChar(8),

PRIMARY KEY (CourseID),
FOREIGN KEY (FacID) REFERENCES FACULTY (FacId),
);

INSERT INTO COURSES
	VALUES('ART103A', 'F101', 'MWF9', 'H221');

INSERT INTO COURSES
	VALUES('CSC201A', 'F105', 'TUTHF10', 'M110');

INSERT INTO COURSES
	VALUES('HST205A', 'F202', 'MWF11', 'H221');

SELECT * FROM COURSES;