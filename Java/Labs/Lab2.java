/*---------------------------------------------------------------------------
// AUTHOR: 			Brandon Lacquement
// FILENAME: 		Lab2.java
// SPECIFICATION: 	This program is for practicing the use of primitive data
//					types, expressions.
// INSTRUCTIONS:	Read the following code skeleton and add your own code
//					according to the comments.  Ask your TA or your class-
//					mates for help and/or clarification.  When you see
//					//--> that is where you need to add code.
//-------------------------------------------------------------------------*/

import java.util.Random;
// class name matches the file name
public class Lab2
{
	// we must have a main method to run the program
	public static void main(String[] args)
	{

		// declare some variables of different types:
		// an int called age
		// a double called num
		// a String called firstName
		// a String called lastName
int age;
double num;
String firstName;
String lastName;
//-->

		// now we assign values to these variables
//-->	age = ???;
age = 18;
//-->	firstName= ???;
firstName = "Brandon";
//-->	lastName= ???;
lastName = "Lacquement";
//-->	num= ???;
num = 0;
		// let's practice string concatenation (digits are characters in the new strings)
		// print out "[firstName] is [age] years old" using the variables above
//-->
System.out.println(firstName + " is " + age + " years old.");
		// print out the name in "last, first" format (lastName, firstName)
//-->
System.out.println(lastName + " " + firstName);
		// print out "arbitrary number" [num]" where [num] is the double variable
//-->
Random generator = new Random(); // creating an object of Random class that create random numbers
num = generator.nextDouble();
System.out.println(num);
//First, call the nextDouble() method in generator to create a random double (number)
// and then store it into num (0-1)
		// let's look at mathematical operator precedence.
		// First, some temporary variables:
		int x1 = 3, x2 = 4;
		int y1 = 5, y2 = 6;

		// calculate the sum of products (add product of x's to product of y's)
		// assign the value to an integer variable sop, and then print it.
//-->
int sop;
sop = x1 * x2 + y1 * y2;
System.out.println(sop);
		// calculate product of sums (multiply sum of x's with sum of y's)
		// assign the value to an integer variable pos, and then print it.
//-->
int pos;
pos = (x1 + x2) * (y1 + y2);
System.out.println(pos);
	} // end main method
} // end class Lab 2