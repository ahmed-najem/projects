/*---------------------------------------------------------------------------
// AUTHOR:      	Brandon Lacquement
// FILENAME:    	Lab5.java
// SPECIFICATION: 	This program is for practicing the switch statement, do-while, while and for loops.
// 					Using a while loop calculate the sum of integers from 1 to n.
// 					Using a for loop find the factorial of n.
// INSTRUCTIONS:  	Read the following code skeleton and add your own code
//          		according to the comments.  Ask your TA or your class-
//          		mates for help and/or clarification.  When you see
//          		//--> that is where you need to add code.
// LAB LETTER:		I
//-------------------------------------------------------------------------*/

//	Import required packages
import java.util.Scanner;

//	Declare class (Lab5)

public class Lab5{

//	Declare the main method

	public static void main(String[] args){
	//	Declare Constant integers SUM = 1, FACTORIAL = 2, QUIT = 3.
	final int SUM= 1;
	final int FACTORIAL = 2;
	final int QUIT = 3;

	//	Create an integer variable named choice.
	int choice;

	//	Create a Scanner object (you may need to import the class)
	Scanner scan = new Scanner(System.in);

	//	Create a do-while loop that exits only when the user chooses quit (choice = QUIT)
	//	Have the do-statement here
	do {
		//	Print the following options:
		//	"This proram does the following:"
		//-->"
		System.out.println("This proram does the following:");
		//	"1. Sum of numbers from 1 to n"
		System.out.println("1. Sum of numbers from 1 to n");
		//-->
		//	"2. Factorial of n"
		System.out.println("2. Factorial of n");
		//-->
		//	"3. Quit"
		System.out.println("3. Quit");
		//-->
		//	"Please choose an option "
		System.out.println("Please choose an option ");
		//-->
		//	Read the value the user enters and store it in an integer variable <choice>
		//-->
		choice = scan.nextInt();

		//	Create a switch statement with <choice> as input for the 3 cases
		switch (choice)	{
			//	case SUM:
			case SUM:
				//	Ask the user to enter a number,
				System.out.print("Please enter a number: ");
				// Take user input and put it into the variable <num1>
				//-->
				int num1 = scan.nextInt();
				// Define 2 integer variables <sum> and <count> and initialize them to 0
				//-->
				int sum = 0;
				int count = 0;
				//	Use a while loop to calculate the sum of numbers from 1 to n
				//	Add the while-statement with the condition that <count> variable is less than <num1>
				while (count < num1){
					// increment <count> variable;
					count++;
					// Calculate the <sum> by adding <count> to <sum>
					sum = count + sum;
				}
				//	Print the answer saying, 'Sum of numbers from 1 - ' <num1> ' is ' <sum>
				//-->
				System.out.println("Sum of numbers from 1 - " + num1 + " is " + sum);
				//	exit from the switch with a break statement, what happens if you don't use one?
				break;
			//	case FACTORIAL:
				case FACTORIAL:
			//-->
				//	Ask the user to enter a number
				System.out.println("Please enter a number: ");
				//-->
				// Take user input and put it into the variable <num2>
				int num2 = scan.nextInt();
				// Declare an long variable <fact> and initialize it to 1
				long fact = 1;
				//-->
				//	Use a for loop to calculate the factorial of n
				//	Write a for loop with an integer variable <i> and initialize it to <num2>,
				//  condition that <i> greater than 1, increment <i> by 1
				for(int i= num2; i > 1 ; i--){
					// write the expression <fact> = <fact> * <i>
					fact *= i; //Same as fact = fact*1
					//-->
				}
				//	Print the answer saying, 'Factorial of' <num2> 'is' <fact>
				//-->
				System.out.println("Factorial of " + num2 + " is " + fact);
				//	exit from the switch with a break statement.
				break;
				//-->
			//	case QUIT:
			case QUIT:
			//-->
				//	Print 'Your choice was <QUIT>, Quitting the program, Have a good day'
				//-->
				System.out.println("Your choice was " + QUIT + ", Quitting the program. Have a good day.");
				//	exit from the switch with a break statement
				break;
				//-->
			//	default:
			default:
				//	Print 'Incorrect choice, ' <choice> ' Please choose again'
				System.out.println("Incorrect choice, " + choice + " Please choose again.");
				//-->
				//	break statement here is optional, why?
				break;
				//-->
		//	Close the switch statement
	}
		//-->
	//	Close the do-while loop with a condition <choice> is not equal to <QUIT>
}	while(choice!= QUIT);
	//	Close the main method
	}
	//-->
//Close the Class
}
//-->


//  Outline of the code is given below:
/*
			  do{
			  		print statements;
			  		choice = read from key board the users choice;
			  		switch(choice)
			  		{
			  			case SUM:
			  				read num1 from user
			  				while loop calculating sum
			  				print sum
			  				break;
			  			case FACTORIAL:
			  				read num2 from user
			  				for loop calculating factorial
			  				print factorial
			  				break
			  			case QUIT:
			  				print user has Quit
			  				break;
			  			default:
			  				print Incorrect choice, choose again
			  		}
			   }while(choice!=QUIT);
*/


/*
 *  QUESTIONS FOR THOUGHT
    ---------------------
	1. Why does the factorial of large numbers become negative or zero,
		Can you find the size of <int> using this information?
	2. What is an infinite loop, can you write an infinite for loop.
	3. What is the difference between a while loop and a do-while loop
	4. Given any positive odd integer n, can you print the formation like below
		This is for n = 5
		    *
		   * *
		  * * *
		 * * * *
		* * * * *
		 * * * *
		  * * *
		   * *
		   	*
	5. Write a program to print the Fibonacci sequence for n numbers using while/for loops
		The Fibonacci sequence with 11 terms is
	 	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
	 	NOTE: Every number is the sum of two numbers ahead of it, the first two numbers being 0 and 1

*/