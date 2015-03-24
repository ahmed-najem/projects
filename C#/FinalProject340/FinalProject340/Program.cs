/*
 * Brandon Lacquement
 * CIS 340 10:30 AM
 * Final Project
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FinalProject340
{
    class Program
    {
        static void Main(string[] args)
        {
            
            bool runApp = true; //Loops logins until user decides to exit
            bool loginFlag = false; //Flags matching attempted userIDs and PINs
            int currentAcc = 2; //Used to track logged in account from array--default to Guest
            string input; //Used throughout to gather input from user
            string attemptID = "Guest"; //Gathers user's ID input during login
            string attemptPIN = "0000"; //Gathers user's PIN input during login

            //Creating account classes for testing
            Account Brandon = new Account("BL", "Brandon Lacquement", "1111", 25.75, 20, "123 Whatever Rd", "Tempe", "AZ", 85281); //Me
            Account George = new Account("GB", "George Bush", "2222", 5000, 100, "456 Old Man's Walk Ct.", "Phoenix", "AZ", 85087); //Random Celeb
            Account Guest = new Account("GT", "Guest", "0000", 0, 18, "Nowhere Since I Didn't Do The Extra Credit Lane",
                                        "Too Bad You Can't Enter Your Personal Info", "But Oh Look Here's A ZIP", 85087); //Guest default

            Account[] accounts = new Account[3] { Brandon, George, Guest }; //Populating an array with accounts for later use

            //Creating item classes for testing
            Item Pen = new Item("Pen", 1.25, 10);
            Item DVD = new Item("DVD", 19.99, 3);
            Item TV = new Item("TV", 1239.99, 1);

            Item[] items = new Item[3] { Pen, DVD, TV }; //Populating an array with accounts for later use

            do //Loops logins until user decides to exit
            {
                //Resetting values so nothing carries over between log ins
                bool runLogin = true;
                Cart cart = new Cart();
                currentAcc = 2;
                loginFlag = false;

                //Saving original quantities in case of insufficient funds
                int penQuan = items[0].GetQuantity();
                int dvdQuan = items[1].GetQuantity();
                int tvQuan = items[2].GetQuantity();

                //Displaying the opening menu and capturing selection
                Console.Clear();
                Console.WriteLine("Welcome! To place an order, please log in.");
                Console.WriteLine("\n\t1. Login");
                Console.WriteLine("\t2. Exit");
                Console.Write("\nSelection: ");
                input = Console.ReadLine();

                if (input == "1") //Proceed with log in, authentication and user menu
                {
                    Console.Clear();
                    Console.WriteLine("Enter your log in information.");
                    Console.Write("\n\tID: ");
                    attemptID = Console.ReadLine();
                    Console.Write("\tPIN: ");
                    attemptPIN = Console.ReadLine();

                    for (int i = 0; i < accounts.Length; i++) //Checking if attempted entries match any accounts
                    {
                        if (accounts[i].GetUserID() == attemptID)
                        {
                            if (accounts[i].GetPin() == attemptPIN)
                            {
                                loginFlag = true; //Used later to display user's name if matched
                                currentAcc = i; //Setting logged in account
                            }
                        }
                    }

                    do //Loops menu until user decides to log out
                    {
                        Console.Clear();

                        //Checking the current account's city and setting Cart's sales tax
                        if (accounts[currentAcc].GetCity() == "Tempe")
                        {
                            cart.SetSalesTax(0.08);
                        }
                        else
                        {
                            cart.SetSalesTax(0.1);
                        }

                        //Displaying the welcome and name to user
                        if (loginFlag)
                        {
                            Console.Clear();
                            Console.WriteLine("Welcome {0}!", accounts[currentAcc].GetAccName());
                        }
                        else
                        {
                            Console.WriteLine("No matching crudentials found--Welcome Guest!");
                        }

                        //Capturing user selection
                        Console.WriteLine("\nPlease indicate your selection:");
                        DisplayMenu();
                        Console.Write("\nSelection: ");
                        input = Console.ReadLine();

                        //Taking action on user's selection
                        switch (input)
                        {
                            case "1": //Add item option
                                Console.Clear();
                                Console.WriteLine("Select an item to add or press anything else to cancel:\n");
                                for (int i = 0; i < items.Length; i++) //Displaying available items
                                {
                                    Console.Write("\t" + (i + 1) + ". " + items[i].GetItemName() 
                                                      + "\t" + items[i].GetQuantity() + " remain at " + items[i].GetPrice().ToString("C") + " each\n");
                                }
                                Console.Write("\nSelection: ");
                                input = Console.ReadLine();

                                switch (input) 
                                {
                                    case "1": //Adding the selected item
                                        Console.Clear();
                                        cart.AddItem(items[0]); //Add pen
                                        Console.WriteLine("\nPress any key to return to menu.");
                                        Console.ReadKey();
                                        break;
                                    case "2":
                                        Console.Clear();
                                        cart.AddItem(items[1]); //Add DVD
                                        Console.WriteLine("\nPress any key to return to menu.");
                                        Console.ReadKey();
                                        break;
                                    case "3":
                                        Console.Clear();
                                        cart.AddItem(items[2]); //Add TV
                                        Console.WriteLine("\nPress any key to return to menu.");
                                        Console.ReadKey();
                                        break;
                                    default: //Bad input--Solly Cholly.
                                        Console.Clear();
                                        Console.WriteLine("Bad input.");
                                        Console.ReadKey();
                                        break;
                                }
                                break;
                            case "2": //Displaying cart
                                Console.Clear();
                                if (cart.GetItemCount() == 0) //Check for an empty cart
                                {
                                    Console.WriteLine("There are no items in your cart!");
                                }
                                else
                                {
                                    cart.DisplayCart();
                                    cart.CalculateTotal();
                                    Console.WriteLine("-------------------------");
                                    Console.WriteLine("Subtotal: \t{0}", cart.GetSubtotal().ToString("C"));
                                }
                                Console.WriteLine("\nPress any key to return to menu.");
                                Console.ReadKey();
                                break;
                            case "3": //Executing purchase
                                Console.Clear();
                                if (cart.GetItemCount() > 0) //Empty cart check
                                {
                                    cart.CalculateTotal();
                                    if (accounts[currentAcc].GetBalance() < cart.GetTotalPrice()) //Check for insufficient funds
                                    {
                                        Console.WriteLine("Insufficient funds!");

                                        //Resetting quantities
                                        items[0].SetQuantity(penQuan);
                                        items[1].SetQuantity(dvdQuan);
                                        items[2].SetQuantity(tvQuan);
                                        Console.WriteLine("\nPress any key to return to menu.");
                                    }
                                    else if (accounts[currentAcc].GetBalance() >= cart.GetTotalPrice()) //User purchases and is logged out
                                    {
                                        accounts[currentAcc].ExecutePurchase(cart);
                                        runLogin = false;
                                    }
                                }
                                else //Empty cart case
                                {
                                    Console.WriteLine("There are no items in your cart to purchase!");
                                    Console.WriteLine("\nPress any key to return to the menu.");
                                }
                                Console.ReadKey();
                                break;
                            case "4": //Display balance
                                Console.Clear();
                                Console.WriteLine("Current Balance: {0}", accounts[currentAcc].GetBalance().ToString("C"));
                                Console.WriteLine("\nPress any key to return to menu.");
                                Console.ReadKey();
                                break;
                            case "5": //Log out and cancel sale
                                Console.Clear();
                                runLogin = false;
                                break;
                            default: //Bad input--Solly Cholly.
                                Console.Clear();
                                Console.WriteLine("Bad input.");
                                Console.ReadKey();
                                break;
                        }
                    } while (runLogin);
                }
                else if (input == "2") //User decides to exit program
                {
                    runApp = false;
                    break;
                }
                else
                {
                    Console.Clear();
                    Console.WriteLine("Bad input.");
                    Console.ReadKey();
                }
            } while (runApp);
        }

        //Simple method used to display logged in options to user
        static void DisplayMenu()
        {
            Console.WriteLine("\n\t1. Add Item");
            Console.WriteLine("\t2. Display Cart");
            Console.WriteLine("\t3. Purchase");
            Console.WriteLine("\t4. Display Account Balance");
            Console.WriteLine("\t5. Cancel Order and Logout");
        }
    }    
}
