/*---------------------------------------------------------------------------
// AUTHOR:      Brandon Lacquement
// TITLE:		Assignment2.java
// FILENAME:    Lab3.java
// LAB LETTER:	Huahong Tu
// DESCRIPTION: This program will print the prices of items on the menu
//                as well as take user input to calculate total cost of
//                the order.
// TIME SPENT:	2.5 hrs
// DATE:		9/9/11
//-------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------
// 	1.  String myString;
		int count;

		myString= "Brandon Lacquement";
		count = myString.length();
		System.out.println(count);

	2.	double num;
		num = 0;

		Random generator = new Random();
		num = generator.nextDouble();
		System.out.println(num);
		num = generator.nextInt(20);
		System.out.println(num);
		num = generator.nextInt(100) -50;
		System.out.println(num);

		(a)	(0,19)
		(b) (-50,49)

	3.	double decimalNum;

		decimalNum = generator.nextDouble();
		System.out.println(decimalNum);
		DecimalFormat fmt= new DecimalFormat("0.####");
		fmt.format(decimalNum);
		System.out.println(fmt.format(decimalNum));

/*-------------------------------------------------------------------------*/

// These import statements will allow the program to use Scanner class
// and DecimalFormat class in the code.
import java.util.*;
import java.text.DecimalFormat;

public class Assignment2
{
	public static void main (String[] args)
	{	// Using "System.out.println()" to print text to screen.
		// '\t' used to put space between items and costs.
		// '\n' used to start new lines of text.
		System.out.println("Welcome to the In-N-Out Burger menu:");
		System.out.println("------------------------------------------------------");
		System.out.println("Hamburger\t\t$2.75\nCheesburger\t\t$3.25");
		System.out.println("French Fries\t\t$2.50\nShake & Beverage:\t$1.50");

		// Declaring all variables used to calculate costs.
		// Also declaring total variable which will be used to print the total
		// cost in the correct format.
		double hamburgers;
		double cheesburgers;
		double frenchFries;
		double drinks;
		double total;

		// Introducing new scanner for "System.in".
		Scanner scan= new Scanner(System.in);
		// Printing the prompt for the user and using "Scan.nextDouble()" to
		// scan the user input and then store it as the respective variable.
		System.out.println("\nHow many hamburger(s) would you like to buy?");
		hamburgers = scan.nextDouble();
		System.out.println("How many cheeseburger(s) would you like to buy?");
		cheesburgers = scan.nextDouble();
		System.out.println("How many French fries would you like to buy?");
		frenchFries = scan.nextDouble();
		System.out.println("How many drinks would you like to buy?");
		drinks = scan.nextDouble();

		// Introducing new decimal formatting (0.00) with "Decimal Format".
		DecimalFormat fmt= new DecimalFormat("#0.00");
		// Printing the text and then printing the correctly formatted totals with "fmt.format()".
		System.out.println("\nThe total cost for the hamburger(s): $" + fmt.format(hamburgers*2.75));
		System.out.println("The total cost for the cheeseburger(s): $" + fmt.format(cheesburgers*3.25));
		System.out.println("The total cost for the fries: $" + fmt.format(frenchFries*2.50));
		System.out.println("The total cost for the drink(s): $" + fmt.format(drinks*1.50));
		System.out.println("\nThe total cost for your order: $" + fmt.format((hamburgers*2.75 + cheesburgers*3.25 + frenchFries*2.50 + drinks*1.50)));

		// Computing the total items ordered.
		total = (hamburgers + cheesburgers + frenchFries + drinks);
		// Storing "double total" as "int x" so the number prints in the correct format.
		int x = (int)total;
		System.out.println("Who ordered the extra large side of Stephen's mom's vagina?");
	} // End of main method
} // End of Assignent2.java