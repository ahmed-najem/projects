/*---------------------------------------------------------------------------
// AUTHOR:      (Put your name here)
// FILENAME:    Lab3.java
// SPECIFICATION:   This program is for practicing the Scanner class,
//          decimal formatting and string functions
//          It takes the Users name and prints out various String operations
// LAB LETTER: (Put your Lab Letter)
//-------------------------------------------------------------------------*/


// this import statement will allow us to use the Scanner class later in the code
import java.util.Scanner;
import java.text.DecimalFormat;

// class name matches the file name
public class Lab3
{
  // we must have a main method to run the program
  public static void main(String[] args)
  {
			// declare some variables of different types:
			// a double called decimalNum
			double decimalNum;
	//-->

			// a String called userName
			String userName;
	//-->

			// a String called courseNum
			String courseNum;
	//-->

			// Define a variable scan of the type Scanner
			Scanner scan= new Scanner(System.in);

			// Prompt the user to enter his first name
			System.out.print("Please enter your first name and last name with space in between: ");

			// Take the input from the user using nextLine() method and assign it to <userName> variable
			userName= scan.nextLine();

			// Prompt the user to enter the course number like (MATH200)
			System.out.print("Please enter your Course number (like MATH200): ");

			// Take the input from the user using next() method and assign it to <courseNum> variable
			courseNum= scan.next();

			// Prompt the user to enter any decimal number with 5 digits after the decimal point like 45.43567
			System.out.print("Please enter a number with 5 digits after decimal (like 45.4367): ");

			// Take the input from the user using nextDouble() method and assign it to <decimalNum> variable
			decimalNum= scan.nextDouble();

			// Print the user name as "User's name is: " <userName>
	//-->
			System.out.println("User's name is: " + userName);
			// Print the course number as "The Course number is: " <courseNum>
	//-->
			System.out.println("The course number is: " + courseNum);
			DecimalFormat fmt= new DecimalFormat("0.##");

			// print the decimal number <decimalNum> with only 2 digits after the decimal by calling the format() method
			System.out.println("The formatted decimal number is: "+ fmt.format(decimalNum));

			// Performing the string operations and displaying the results
			// Complete the program by inserting the appropriate method in the place of ???

			System.out.println("Length of name \t\t" + (userName.length()-1));
			System.out.println("Case conversions \t\t"+ userName.toUpperCase());
			System.out.println("Character at position 1 \t" + userName.charAt(0));
			System.out.println("Substring from user name \t" + userName.substring(0,3));
			System.out.println("Equality using compare to \t" + userName.compareTo(courseNum));
			System.out.println("Equality using equals \t\t" + userName.equals(courseNum));
			System.out.println("Equality ignoring case \t\t" + userName.equalsIgnoreCase(courseNum));


  }//end main method
}//end Lab3 class