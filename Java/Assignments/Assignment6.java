/*-------------------------------------------------------------------------
// AUTHOR: Brandon Lacquement
// FILENAME: Assignment6.java
// SPECIFICATION: Test Driver for Geek.java (provided skeleton)
// YOUR Lab Letter: I Huahong Tu
// FOR: CSE 110- homework #6 12:55 pm
// TIME SPENT: 3 hours
//----------------------------------------------------------------------*/
import java.util.Scanner;

public class Assignment6
{
	public static void main(String[] args)
	{
		Geek marty = new Geek("Marty", 0);

		Scanner scan = new Scanner(System.in);

		String choice;
	   	char command;

		printMenu(); //calling method from below

		do{
			System.out.println("\nPlease enter a command or type ?");
			choice = scan.next().toLowerCase();
	        command = choice.charAt(0);

			switch (command)
			{
				case 'a':
					System.out.println(marty.getName());
					break;
				case 'b':
					System.out.println(marty.getNumberOfQuestions());
					break;
				case 'c':
					System.out.println("Please enter the first number.");
					int x = scan.nextInt();
					System.out.println("Please enter the second number.");
					int y = scan.nextInt();
					int add = x+y; // adding the numbers for print statement
					if (marty.isEven(x,y)) // calling isEven for int x and int y
						System.out.println(add + " is even.");
					else
						System.out.println(add + " is not even.");
					break;
				case 'd':
					System.out.println("Please enter a number.");
					int num = scan.nextInt();
					if (marty.isPrime(num))
						System.out.println(num + " is prime.");
					else
						System.out.println(num + " is not prime.");
					break;
				case 'e':
					System.out.println("Please enter the first number.");
					int numb1 = scan.nextInt();
					System.out.println("Please enter the second number.");
					int numb2 = scan.nextInt();
					int sum = marty.sum(numb1, numb2);
					System.out.println("The sum between " + numb1 + " and " + numb2 + " is " + sum);
					break;
				case 'f':
					System.out.println("Enter a year.");
					int year = scan.nextInt();
					if (marty.leapYear(year))
						System.out.println("It is a leap year!");
					else
						System.out.println("It is not a leap year.");
					break;
				case '?':
					printMenu();
					break;
				case 'q':
					break;
				default:
		        	System.out.println("Invalid input");
			}
		}while(command != 'q');
	}


	 public static void printMenu()
			   {
			    System.out.print("\nCommand Options\n"
			                   + "-----------------------------------\n"
			                   + "a: get name\n"
			                   + "b: number of questions asked\n"
			                   + "c: is Even\n"
			                   + "d: is prime\n"
			                   + "e: sum between two integers\n"
			                   + "f: leap year\n"
			                   + "?: display the menu again\n"
			                   + "q: quit this program\n\n");

		    } // end of the printMenu method
}
