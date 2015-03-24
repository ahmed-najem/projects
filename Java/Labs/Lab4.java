/*---------------------------------------------------------------------------
// AUTHOR:      Brandon Lacquement
// FILENAME:    Lab4.java
// SPECIFICATION:   This program is for practicing the use of if-else conditional
//          expressions.  It also reviews some previous topics.
//          It asks the user for a string and determines some properties of the string.
//          It also asks the user to guess a random number after giving the user some hints.
// LAB LETTER: I
//-------------------------------------------------------------------------*/


//Import the Random and Scanner classes from the java.util package
import java.util.Scanner;
import java.util.Random;
//-->
//-->

//Declare the class (Lab4)
public class Lab4
{
	public static void main(String args[])
	{


//-->

     //Declare the main method

//-->


        //Instantiate an object of type Scanner to read input from the keyboard
		Scanner scan = new Scanner(System.in);
//-->


        //Prompt the user to enter a word
		System.out.println("Enter a word: ");
//-->

        //Read in the word from the user and store it in a variable (What type of variable would you use?)

		String word = scan.nextLine();

        //If the word entered is 'computer' (that is the word equals 'computer') print out 'OK computer'
        //Do nothing otherwise

		if (word.equals("computer")){
			System.out.println("OK Computer");
		}

		if (word.length() > 7) {
			System.out.println(word + "is a long word!");
		}
		//-->

        //If the word has more than 7 letters in it  (that is its length is greater than 7)
        //   print out: <the word> ' is a long word!'
        //Do nothing otherwise


		//-->

        //Instantiate an object of type Random

		Random rand= new Random();

        //Generate and store a random integer number with possible values between 1 and 30, inclusive
		int num = rand.nextInt(30)+1;

        //Print out 'I'm thinking of a number between 1 and 30.'
//-->
		System.out.println("I'm thinking of a number between 1 and 30.");
        //Tell the user if the number is greater than/equal to or strictly less than 15, either way
		if (num >= 15){
			System.out.println("The number is greater than/equal to 15.");
		}
		else {
			System.out.println("The number is strictly less than 15.");
	}
        //Tell the user if the number is between 10 and 20, inclusively, or if it is not
        //(Hint: number greater/equal than 10 and number less than/equal 20).
		if(num >= 10 && num <= 20) {
            System.out.println ("The number is between 10 and 20, inclusive");
	}
        else {
			System.out.println("The number is not between 10 and 20, inclusive");
	}


        //If the number is either (less than 5 or greater than 25) print out
        //  'The number is an extreme number' and 'The number is less than 5 or greater than 25' using two println statements
        //Otherwise tell the user 'The number is not less than 5 and not greater than 25'
		if (num < 5 || num > 25)
		{
			System.out.println("The number is an extreme number.");
			System.out.println("The number is less than 5 or greater than 25.");
		}
		else
		{

			System.out.println("The number is not less than 5 and not greater than 25.");
		}

//-->

        //Ask the user to guess the number and store their input in a variable

        System.out.print ("Guess the number: ");
        int guess = scan.nextInt();

        //If they guess right, print out 'Correct! The number was ' <the number>
        //Otherwise print out 'Sorry, that is not correct' and 'The number was ' + <the number>, using two println statements

        if (guess == num) {
			System.out.println("Correct!The number was" + num);
	}
//-->
        else
        {
            System.out.println ("Sorry, that is not correct");
//-->
        }

	}

}
   //Remember to close your braces for the main method and class.

/**************************************************************************************************
** Questions for thought:
**    1.  What type of conditions are conditionals (if-else statements) based on? True/False.
**    2.  What type of values do the equality and relational operators return? True/False.
**    3.  a) What are the different boolean, equality operators and relational operators? ==, >=, <=, >, <
**        b) What is the order of operations among the operators?
**    4.  What is the difference between the equality and assignment operators?
**    5.  What is a block statement?  When are they used in conditional statements?
**    6.  What is a nested if statement?
**    7.  How do we compare two strings for equality in Java?
**************************************************************************************************/