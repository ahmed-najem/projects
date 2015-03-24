/*-------------------------------------------------------------------------
// AUTHOR:
// FILENAME: Assignment8.java
// SPECIFICATION:
// YOUR Lab Letter and Name of the TA for your Closed lab
// FOR: CSE 110- homework #8 days and time of your class
// TIME SPENT: how long it took you to complete the assignment
//----------------------------------------------------------------------*/
import java.io.*;
import java.util.*;

public class Assignment8
{

   public static void main (String[] args) throws IOException
   {

	  Scanner keyboard = new Scanner(System.in);

	  // get the size of the array
	  System.out.println("Please enter the array size:");
	  int size = keyboard.nextInt();

	  //instantiate an object of type TriangleCollection
	  TriangleCollection triangles = new TriangleCollection(size);



	 // Accept user option
	 System.out.println("Please enter a command or type \"?\" to see the menu:");
	 String command = keyboard.next();

	 while (command.charAt(0) != 'q')
	 {
		switch (command.charAt(0))
		{	case 'a':  System.out.println("Enter the sides:");
					   int side1 = keyboard.nextInt();
					   int side2 = keyboard.nextInt();
					   int side3 = keyboard.nextInt();
					   Triangle addTriangle = new Triangle(side1, side2, side3);
					   triangles.addToCollection(addTriangle);

		    case 'd': // Display information for all the Triangles (one at a time)
					  // Each time through the loop print information for one Triangle
						System.out.println(triangles.toString());
						break;

			case 's': // Sort all Triangles by area
				      // Array to sort is passed as a parameter.
	                  triangles.sort();
					  System.out.println();
					  System.out.println(triangles.toString());
					  break;

			case 'f': // Find a Triangle

					  System.out.println("Enter side one?");
					  int s1 = keyboard.nextInt();
					  System.out.println("Enter side two?");
					  int s2 = keyboard.nextInt();
					  System.out.println("Enter side three?");
					  int s3 = keyboard.nextInt();
					  // Call the method to search a given array for a given Triangle
					  // Method returns index in the array were Triangle is found
					  Triangle key = new Triangle(s1, s2, s3);
					  int index = triangles.search(key);

					  // index = -1 implies Triangle was not found in the array
					  if (index == -1)
						System.out.println("Triangle doesn't exist");
					  else
						 System.out.println(triangles.getCollection(index).toString());
					  break;

			case 'r': // Remove a Triangle from the array

					  System.out.println("Enter side one? ");
					  s1=keyboard.nextInt();
					  System.out.println("Enter side two?");
					  s2 = keyboard.nextInt();
					  System.out.println("Enter side two?");
					  s3 = keyboard.nextInt();
					  Triangle tobeRemoved= new Triangle(s1,s2,s3);
					  // Call the method to remove a given Triangle from array collection
					  boolean flag = triangles.remove(tobeRemoved);
					  if (!flag)
						  System.out.println("Triangle not found ");
					  else
					  {
					  	  System.out.println("Triangle found and removed");
						  // Decrement number of Triangles in the array by 1

					  }
					  break;



			case '?': // Help menu
					 System.out.println("a: Add a new Triangle to the collection ");
					 System.out.println("d: Display all Triangles ");
					 System.out.println("s: Sort Triangles by perimeters ");
					 System.out.println("f: Find a Triangle  ");
					 System.out.println("r: Remove a Triangle  ");
					 System.out.println("?: Help menu ");
					 System.out.println("q: Stop the program ");
					 break;

			case 'q':// Stop the program
					 break;

			default:
					System.out.println("Illegal cammand ");
			} // End of switch

			//Prompt user to enter next choice.
			System.out.println();
			System.out.println("Please enter a command or type \"?\" to see the menu:");
			command = keyboard.next();

		} //End of while
	  } // End of main
   }// End of class
