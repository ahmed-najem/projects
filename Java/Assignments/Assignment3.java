/*-------------------------------------------------------------------------
// AUTHOR: Brandon Lacquement
// FILENAME: assignment3.java
// SPECIFICATION: The program reads in the string and performs the following:
 					-checks if each string's length is odd or even.
 					-checks if two strings are same or different.
 					-checks which string is lexically larger, or they are same.
					-prints out the first character (index 0) of each string
 					-prints out a new string consisting of the first string concatenated (appended) with the second string.
					-prints out two strings using upper case letters.
// YOUR Lab: I
// FOR: CSE 110 homework #3 MWF 12:55-1:45
// TIME SPENT: 1.5 hours
//----------------------------------------------------------------------*/
/*-------------------------------------------------------------------------
// 	1.
		if (score >= 90)
			System.out.println(grade = 'A');
		else if (score >= 80 && score < 90)
			System.out.println(grade = 'B');
		else if (score >= 70 && score < 80)
			System.out.println(grade = 'C');
		else if (score >= 60 && score < 70);
			System.out.println(grade = 'D');
		else
			System.out.println(grade = 'F');
	2.
		switch (letter)
		{
			case "A": case "a":
				System.out.println("Excellent");
				break;
			case "B": case "b":
				System.out.println("You can do better");
				break;
			case "C": case "c":
				System.out.println("Try harder");
				break;
			case "D": case "d":
				System.out.println("Try much harder");
				break;
			case "F": case "f":
				System.out.println("Try another major!");
				break;
		}

//----------------------------------------------------------------------*/
import java.util.Scanner; // Import Scanner class to store strings from System.in with scan
public class Assignment3
{

	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in); // Making a scanner to store the strings

		System.out.println("Please enter a string.");
		String str1 = new String(scan.nextLine()); // Storing string from user input with scan
		System.out.println("Please enter a another string.");
		String str2 = new String(scan.nextLine());

		if (str1.length()%2 > 0) // If string length divided by two gives a remainder greater than 0, the length was odd.
			System.out.println("The first sting's length is odd.");
		else //  If string length divided by two gives no remainder, the length was even.
			System.out.println("The first string's length is even.");
		if (str2.length()%2 > 0) // Same logic applied here from above
			System.out.println("The second sting's length is odd.");
		else // Same logic applied here from above
			System.out.println("The second string's length is even.");

		if (str1.equals(str2)) // Using equals to compare st1 and str1
			System.out.println("\nThe two strings are the same.");
		else
			System.out.println("\nThe two strings are different.");

		if (str1.compareTo(str2) > 0) // Using nested if statement to compare lexical value of strings
			System.out.println("\nThe first string is lexically larger.");
		else if (str2.compareTo(str1) > 0)
			System.out.println("\nThe second string is lexically larger.");
		else
			System.out.println("\nThe strings are lexically equal.");

		System.out.println("\nThe first character of the first string is " + str1.charAt(0)); // Using charAt to find character at index 0
		System.out.println("The first character of the second string is " + str2.charAt(0));

		System.out.println("\nThe concatenation of the two strings is " + str1 + str2); // Concatenation using '+'

		System.out.println("\nThe first string using upper case letters: " + str1.toUpperCase()); // Using toUpperCase to change str1 and str2 to all uppercase letters
		System.out.println("The second string using upper case letters: " + str2.toUpperCase());

	}
}