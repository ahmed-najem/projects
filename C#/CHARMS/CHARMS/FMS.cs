/*
 * Brandon Lacquement
 * CIS 345 T/TH 1:30 PM
 * Project: CHARMS: FMS
 */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UtilityLibrary;
using HomelandSecurity;
using System.IO;

namespace CHARMS
{
    class FMS
    {
        // INSTANCE VARIABLES

        public int flightCounter { get; set; }

        //METHODS

        // Accepts a flight array and returns it loaded with data from a text file
        public Flight[] LoadSampleDataFromFile(Flight[] flightList) 
        {
            StreamReader flightReader = new StreamReader("flightData.txt");
            StreamReader passengerReader = new StreamReader("passengerData.txt");
            string flight = "";
            string passenger = "";
            int flightIndex = 0;
            Passenger tempPassenger; // Used to store parsed data before adding to flight

            // Store interpreted data from the file
            string[] parsedFlight = new string[3]; 
            string[] parsedPassenger = new string[3];
            
            // Add the flights from the file
            while (true)
            {
                flight = flightReader.ReadLine();
                if (flight == null) // End of data
                    break;
                parsedFlight = flight.Split(','); // Using comma seperations
                flightList[flightCounter] = new Flight(Convert.ToInt32(parsedFlight[0]), parsedFlight[1], parsedFlight[2]);
                flightCounter++;
            }

            // Add the passengers from the file
            while (true)
            {
                passenger = passengerReader.ReadLine();
                if (passenger == null) // End of data
                    break;
                parsedPassenger = passenger.Split(','); // Using comma seperations
                flightIndex = Convert.ToInt32(parsedPassenger[0]);
                tempPassenger = new Passenger(parsedPassenger[1], parsedPassenger[2], parsedPassenger[3]);
                flightList[flightIndex].passengerManifest.Add(tempPassenger); 
               
                flightList[flightIndex].passengerCounter++;
            }
            return flightList;
        }// END LoadSampleDataFromFile

        // Gives user's options and returns the user's selection
        public int DisplayMainMenu() 
        {
            string userInput = ""; // Store user input 
            int userSelection = 0; // Returned, converted from userInput

            Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System", "-- CHARMS --\n\n\n");
            Utilities.WriteCenteredText("-- Main Menu --\n\n");

            // MENU LIST
            Utilities.DisplayAMenu(new string[6]{"Display Flight List", "Add new Flight", 
                "Select Flight", "Search by Passenger", "Remove A Flight", "Exit"}); // Utility that formats strings into a menu

            // SELECT
            Console.Write("\n\nSelect Menu Option:\t");

            // USER INPUT
            userInput = Console.ReadLine();
            if (Utilities.IntegerValidation(userInput, 1,1, 1,6)) // Validation utility with 1,1 length and 1,6 range
                userSelection = Convert.ToInt32(userInput);

            return userSelection;
        }// END DisplayMainMenu

        // Accepts a flight array and displays data about each flight
        public void DisplayFlightList(Flight[] flightList) 
        { 
            // SUB-HEADER
            Utilities.WriteCenteredText("Current Flights\n");

            //Flight List
            for (int i = 0; i < flightCounter; i++)
            {
                Console.WriteLine("\n\t{0}. {1}\t\t{2}\t\t-->\t{3}", 
                    i + 1, flightList[i].flightNumber, flightList[i].flightOrigin, flightList[i].flightDestination);
            }
        }// END DisplayFlightList

        // Accepts a flight array and returns it after adding a flight
        public Flight[] CreateNewFlight(Flight[] flights) 
        {
            bool flightNoExists = false; // Tracks if the desired flight No already exists

            if (flightCounter < flights.Length)
            {
                string enteredNumber = "000";

                Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System", "-- CHARMS --\n\n\n");
                
                Utilities.WriteCenteredText("Add New Flight");

                Console.Write("\n\nEnter Flight Number (3 Digits 000-999): ");
                enteredNumber = Console.ReadLine();

                if (!Utilities.IntegerValidation(enteredNumber, 3,3, 000,999)) // The user entered an invalid flight #
                {
                    Utilities.FlashMessage("\nBad Input.", 750);
                    CreateNewFlight(flights); // Recursive call to try again
                }
                else
                {
                    // Checking if that flight # was already taken
                    for (int i = 0; i < flightCounter; i++)
                    {
                        if (Convert.ToInt32(enteredNumber) == flights[i].flightNumber)
                        {
                            Utilities.FlashMessage("\nFlight No. already exists. Choose a different number...", 1000);
                            flightNoExists = true;
                            CreateNewFlight(flights); // Recursive call to try again

                        }
                    }

                    if (!flightNoExists)
                    {
                        string[] questions = new string[2] { "Enter Flight Origin: ", "Enter Flight Destination: " };
                        string[] userInput = Utilities.GetUserInput(questions); // Utility that accepts an array of questions
                                                                                // and returns the user's answers

                        flights[flightCounter] = new Flight(Convert.ToInt32(enteredNumber), userInput[0], userInput[1]);
                        flightCounter++;

                        Utilities.FlashMessage("\nFlight Added!", 750); // Utility that shows the string for 750 msecs
                    }
                }
            }
            else
            {
                Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System", "-- CHARMS --\n\n\n");

                Utilities.FlashMessage("Maximum number of flights added!", 1000); // Flightlist is full (20)
            }
            return flights;
        }// END CreateNewFlight

        // Accepts a flight array and calls the sub menu for the selected flight
        public void SelectAFlight(Flight[] flights) 
        {
            int optionInput = 0;

            Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System", "-- CHARMS --\n\n\n");
            
            DisplayFlightList(flights);
            Console.Write("\n\n\nEnter Option Number: ");

            try // User might not enter a valid #
            {
                optionInput = Convert.ToInt32(Console.ReadLine()); // Exception possible

                if (optionInput > 0 && optionInput <= flightCounter)
                    FlightMenu(flights[optionInput - 1]);
                else
                {
                    Utilities.FlashMessage("\nBad Input.", 750);
                    SelectAFlight(flights);
                }      
            }
            catch (Exception)
            {
                Utilities.FlashMessage("\nBad Input.", 750);
                SelectAFlight(flights); // Recursive call to try again
            }
        }// END SelectAFlight

        // Accepts a flight and passes it to a user's selected function
        public void FlightMenu(Flight flight) 
        {
            int selection = 0;

            do
            {
                Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System", "-- CHARMS --\n\n\n");
                Console.WriteLine("\t\t\tFlight Menu - Flight {0}", flight.flightNumber);
                Console.WriteLine("\n\t\t{0}\t{1}\t\t-->\t{2}\n\n", flight.flightNumber, flight.flightOrigin, flight.flightDestination);

                Utilities.DisplayAMenu(new string[7] {"Display Passenger Manifest","Edit Flight Information", "Add New Passenger to Manifest", 
                    "Run Passenger Security Check", "Remove a Passenger", "Change Wait Status", "Exit to Charms" });
                
                Console.Write("\n\nSelect an Option: ");

                try // User may have made invalid input
                {
                    selection = Convert.ToInt32(Console.ReadLine()); // Exceptions possible
                    Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System", "-- CHARMS --\n\n\n");
                    
                    switch (selection)
                    {
                        case 1:
                            flight.DisplayManifest();
                            Console.Write("\n\nPress any key to continue...");
                            Console.ReadKey();
                            break;
                        case 2:
                            flight.EditFlightInfo();
                            break;
                        case 3:
                            flight.AddPassenger();
                            break;
                        case 4:
                            flight.RunSecurityCheck();
                            break;
                        case 5:
                            flight.RemovePassenger();
                            break;
                        case 6:
                            flight.WaitingListMover(); // Moves passengers from and to wait list
                            break;
                        case 7:
                            break;
                        default:
                            Utilities.FlashMessage("Unknown Error", 1000);
                            Environment.Exit(0);
                            break;
                    }
                }
                catch (Exception)
                {
                    Utilities.FlashMessage("\nBad Input.", 750);
                    FlightMenu(flight);
                }
            } while (selection != 7); // 7 will exit the loop
        }// END FlightMenu

        // Accepts a flight array and displays info about searched passengers in all flights
        public void SearchAllFlights(Flight[] flightsToSearch) 
        {
            bool foundFlag = false; // Tracks if a passenger was found

            Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System", "-- CHARMS --\n\n\n");
            
            Utilities.WriteCenteredText("Find Passenger\n\n");

            string[] questions = new string[2]{"\nEnter First Name: ", "Enter Last Name: "};
            string[] userInput = Utilities.GetUserInput(questions); // Getting the desired search parameters

            Console.WriteLine("\n");

            // Loops through all NON-WAIT passengers in all mainfast in all flights
            for (int i = 0; i < flightCounter; i++) // Flights
            {
                for (int j = 0; j < flightsToSearch[i].passengerCounter; j++) // Manifests
                {
                    if (flightsToSearch[i].passengerManifest[j].FirstName == userInput[0]
                        && flightsToSearch[i].passengerManifest[j].LastName == userInput[1]) // Passenger found
                    {
                        foundFlag = true;
                        Console.WriteLine("Flight   {0}\t{1}\t{2}\t{3}", flightsToSearch[i].flightNumber,
                            flightsToSearch[i].passengerManifest[j].FirstName, flightsToSearch[i].passengerManifest[j].LastName,
                            flightsToSearch[i].passengerManifest[j].LoyaltyNumber);
                    }
                }
            }

            // Loops through all WAIT passengers in all mainfast in all flights
            for (int i = 0; i < flightCounter; i++)
            {
                for (int j = 0; j < flightsToSearch[i].waitingCounter; j++)
                {
                    if (flightsToSearch[i].waitlistManifest[j].FirstName == userInput[0]
                        && flightsToSearch[i].waitlistManifest[j].LastName == userInput[1])
                    {
                        foundFlag = true;
                        Console.WriteLine("Flight   {0}\t{1}\t{2}\t{3}", flightsToSearch[i].flightNumber,
                            flightsToSearch[i].waitlistManifest[j].FirstName, flightsToSearch[i].waitlistManifest[j].LastName,
                            flightsToSearch[i].waitlistManifest[j].LoyaltyNumber);
                    }
                }
            }

            if (!foundFlag) // Never found a passenger
                Console.WriteLine("No Records Found!");

            Console.WriteLine("\n\nPress any key to continue...");
            Console.ReadKey();
        }// END SearchAllFlights

        // Accepts a flight array and returns it after removing a flight
        public Flight[] RemoveAFlight(Flight[] flights) 
        {
            Flight[] flightsToReturn = new Flight[20]; // Temp array that will store the list after a flight is removed
            string userSelection = "";
            int indexToRemove;
            int returnArrayCounter = 0; // Tracks the number of flights that will be in the new array

            Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System", "-- CHARMS --\n\n\n");
            Utilities.WriteCenteredText("--Remove A Flight--\n");

            if (flightCounter > 0) // Do we have any flights to remove?
            {
                DisplayFlightList(flights);

                Console.Write("\n\nSelect which flight to remove: ");
                userSelection = Console.ReadLine();

                // Remove the selected flight
                if (Utilities.IntegerValidation(userSelection, 1, 3, 1, flights.Length))
                {
                    indexToRemove = Convert.ToInt32(userSelection) - 1;

                    for (int i = 0; i < flights.Length; i++)
                    {
                        if (flights[i] != flights[indexToRemove]) // Don't add a flight if it was the one to be removed
                        {
                            flightsToReturn[returnArrayCounter] = flights[i]; // Adds a flight to the new array
                            returnArrayCounter++;
                        }
                    }

                    flightCounter--;
                    Utilities.FlashMessage("\nFlight Removed!", 1000);
                }
                else // User entered something bad
                {
                    Utilities.FlashMessage("Bad Input", 750);
                    RemoveAFlight(flights);
                }
            }
            else // There were no flights to remove
            {
                Utilities.FlashMessage("No flights to remove!", 1000);
            }

            return flightsToReturn;
        }// END RemoveAFlight
    }// END FMS
}// END CHARMS
