/*---------------------------------------------------------------------------
// AUTHOR:          Brandon Lacquement
// FILENAME:        Lab13.java
// SPECIFICATION:   This program helps to understand how arrays of object work
//		    and introduce 2 dimensional arrays
// INSTRUCTIONS:    Read the following code skeleton and add your own code
//                  according to the comments.  Ask your TA or your class-
//                  mates for help and/or clarification.  When you see
//                  //--> that is where you need to add code.
// LAB LETTER:	   I
//-------------------------------------------------------------------------*/

import java.util.Scanner;

class Lab13 {

	public static void main(String[] args){

		int numOfStudents= 0;
		Scanner scan= new Scanner(System.in);

		System.out.println("Please enter the total number of students:");

		// Take the number of students as input from the user and assign it to <numOfStudents>
		numOfStudents = scan.nextInt();
		scan.nextLine(); // Dont remove this line

		// Define an array of <Student> (1st ???) objects, <studentsArray> (2nd ???) and set its size to <numOfStudents> (3rd ???)
		Student[] studentsArray = new Student[numOfStudents];

		double maxGPA = 4.0;
		int maxGPAIndex= 0;
		// Take the details of the students using a for loop
		for(int i=0; i < numOfStudents; i++)
		{
			String stdName;
			double stdGPA;
			System.out.println("Enter Student "+ (i+1) + " Details:");
			System.out.print("\tName: ");

			// Take the name as input and assign it to <stdName>
			stdName = scan.nextLine();
			System.out.print("\tGPA (between 1 and 4): ");
			// Take the gpa as input and assign it to <stdGPA>
			stdGPA = scan.nextDouble();
			scan.nextLine(); // Dont remove this line

			// Create a <Student> object <newStudent> with <stdName> and <stdGPA> as inputs in the constructor
			Student newStudent = new Student(stdName, stdGPA);

			// assign the <newStudent> to the <i> index of array <studentsArray>
			studentsArray[i]= newStudent;

			// Now check if this students GPA <stdGPA> is greater than <maxGPA>
			if(stdGPA > maxGPA)
			{
				// assign <stdGPA> to <maxGPA>
				maxGPA = stdGPA;
				// assign <i> to <maxGPAIndex>
				i = maxGPAIndex;
			}

		}

		// print out the details of all the students using for loop
		System.out.println("Printing Student Details ...");
		for(int i=0; i<maxGPAIndex ; i++)
		{
			// call the <printStudentDetails> method using the <i> element of array <studentsArray>
			studentsArray[i].printStudentDetails();
		}

		// Print the name of student with highest GPA who is the <maxGPAIndex> of array <studentsArray> by calling <getName> method
		System.out.println("\nThe name of the student with highest GPA is: " + studentsArray[maxGPAIndex].getName());

		// Define a 2 dimensional int array <smallMatrix>
		int[][] smallMatrix= new int[2][2];

		// The first for loop goes till the length of <smallMatrix>
		for(int i=0; i < smallMatrix.length; i++){
			// The second for loop goes till the length of <smallMatrix[i]>
			for(int j=0; j < smallMatrix[i].length; j++){
				// assign the sum <i+j> to the element at <i> row and <j> column of array <smallMatrix>
				smallMatrix[i][j] = i+j;
			}
		}
		// Print out the matrix
		System.out.println("\nPrinting the small matrix:");
		for(int i=0; i < smallMatrix.length; i++){
			// The second for loop goes till the length of <smallMatrix[i]>
			for(int j=0; j < smallMatrix[i].length; j++){
				// Print the element at <i> row and <j> column of array <smallMatrix>
				System.out.print(smallMatrix[i][j]+ " ");
			}
			System.out.println();
		}
	}

}