/*-------------------------------------------------------------------------
// AUTHOR: CSE110 solution
// FILENAME: Assignment7.java
// SPECIFICATION: This class prompts a user to enter a size for the array
//                and create a NumberCollection object. Then it displays
//                a menu to a user, and process a requested task accordingly.
// YOUR Lab Letter and Name of the TA for your Closed lab
// FOR: CSE 110- homework #7- days and time of your class
// TIME SPENT: how long it took you to complete the assignment
//----------------------------------------------------------------------*/

import java.util.Scanner;
 public class Assignment7
 {
  public static void main(String[] args)
   {
      int number, size;
      String choice;
      char command;

      Scanner keyboard = new Scanner(System.in);
      // ask a user for a array size
      System.out.println("Please enter a size for the array.\n");
      size = keyboard.nextInt();

      // instantiate a NumberCollection object
      NumberCollection collection = new NumberCollection(size);

      // print the menu
      printMenu();

      do
       {
           // ask a user to choose a command
           System.out.println("\nPlease enter a command or type ?");
           choice = keyboard.next().toLowerCase();
           command = choice.charAt(0);

           switch (command)
            {
                 case 'a': // add a number
                      System.out.println("\nPlease enter an integer to add.");
                      number = keyboard.nextInt();
                      collection.addNumber(number);
                      break;
                 case 'b': // remove a number
                      System.out.println("\nPlease enter an integer to remove.");
                      number = keyboard.nextInt();
                      collection.removeNumber(number);
                      break;
                 case 'c': // display the array
                      System.out.print(collection);
                      break;
                 case 'd': // compute and display the maximum
                      System.out.println("\nThe maximum is: " + collection.findMax());
                      break;
                 case 'e': // compute and display the minimum
                      System.out.println("\nThe minimum is: " + collection.findMin());
                      break;
                 case 'f': // compute and display the sum
                      System.out.println("\nThe sum is: " + collection.computeSum());
                      break;
                 case '?':
                      printMenu();
                      break;
                 case 'q':
                      break;
                 default:
                 	  System.out.println("Invalid input!");

            }

        } while (command != 'q');

    }  //end of the main method


  // this method prints out the menu to a user
  public static void printMenu()
   {
    System.out.print("\nCommand Options\n"
                   + "-----------------------------------\n"
                   + "a: add an integer in the array\n"
                   + "b: remove an integer from the array\n"
                   + "c: display the array\n"
                   + "d: compute and display the maximum\n"
                   + "e: compute and display the minimum\n"
                   + "f: compute and display the sum\n"
                   + "?: display the menu again\n"
                   + "q: quit this program\n\n");

    } // end of the printMenu method


 } // end of the Assignment7 class