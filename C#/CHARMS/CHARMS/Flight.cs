/*
 * Brandon Lacquement
 * CIS 345 T/TH 1:30 PM
 * Project: CHARMS: Flight
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UtilityLibrary;
using HomelandSecurity;

namespace CHARMS
{
    class Flight
    {
        // INSTANCE VARIABLES

        public int flightNumber { get; set; }
        public string flightOrigin { get; set; }
        public string flightDestination { get; set; }
        public List<Passenger> passengerManifest { get; set; } // List in lieu of array b/c no bound set
        public List<Passenger> waitlistManifest { get; set; }
        public int passengerCounter = 0; // Use of lists makes this redundant, but needed to call SecurityCheck Method
        public int waitingCounter = 0; // Keeps track of # of passengers on wait list

        // DEFAULT CONSTRUCTOR

        public Flight(int number, string origin, string destination)
        {
            flightNumber = number;
            flightOrigin = origin;
            flightDestination = destination;
            passengerManifest = new List<Passenger>();
            waitlistManifest = new List<Passenger>();
        }// END Flight constructor

        // METHODS

        public void DisplayManifest()
        {
            string flaggedOnScreen = "";

            if ((passengerCounter > 0) || (waitingCounter > 0)) // Only display if there is someone to show
            {
                Console.WriteLine("\t\t\tMainfest for Flight {0}\n\n", flightNumber);
                Console.WriteLine("{0,-12}{1,-12}{2,-12}{3,-12}{4,-12}{5,-12}\n", "Number", "FirstName", "LastName", "Loyalty#", "Flagged", "Waiting");

                for (int i = 0; i < passengerManifest.Count; i++) // Loop through NON-WAIT manifest
                {
                    if (passengerManifest[i].SecurityFlag)
                        flaggedOnScreen = "!!!";
                    else
                        flaggedOnScreen = "";

                    Console.WriteLine("{0,-12}{1,-12}{2,-12}{3,-12}{4,-12}{5,-12}", i + 1, passengerManifest[i].FirstName,
                        passengerManifest[i].LastName, passengerManifest[i].LoyaltyNumber, flaggedOnScreen, "N");
                }

                Console.WriteLine();

                for (int i = 0; i < waitlistManifest.Count; i++) // Loop through WAIT manifest
                {
                    if (waitlistManifest[i].SecurityFlag)
                        flaggedOnScreen = "!!!";
                    else
                        flaggedOnScreen = "";

                    Console.WriteLine("{0,-12}{1,-12}{2,-12}{3,-12}{4,-12}{5,-12}", i + 1, waitlistManifest[i].FirstName,
                        waitlistManifest[i].LastName, waitlistManifest[i].LoyaltyNumber, flaggedOnScreen, "Y");
                }
            }
            else
                Console.WriteLine("No Passengers Found.");
         
        }// END DisplayManifest

        public void EditFlightInfo()
        {
            string enteredNumber = "000";

            Console.WriteLine("\t\tEdit Flight Information - Flight {0}\n\n", flightNumber);
            Console.WriteLine("{0}\t{1}\t\t-->\t{2}", flightNumber, flightOrigin, flightDestination);

            Console.Write("\n\nEnter Flight Number (3 Digits between 000-999: ");
            enteredNumber = Console.ReadLine();

            if (!Utilities.IntegerValidation(enteredNumber, 3,3, 0,999)) // Bad input
                Utilities.FlashMessage("Bad Input.", 750);
            else
            {
                string[] questions = new string[2] { "Enter Flight Origin: ", "Enter Flight Destination: " };
                string[] userInput = Utilities.GetUserInput(questions);

                // Update all info
                flightNumber = Convert.ToInt32(enteredNumber);
                flightOrigin = userInput[0];
                flightDestination = userInput[1];

                Utilities.FlashMessage("\n\nInformation Updated!", 750);
            }
        }//END EditFlightInfo

        public void AddPassenger()
        {
            bool addedFlag = false; // Was a passenger added?

            Console.WriteLine("\t\tAdd Passenger - Flight {0}\n\n", flightNumber);

            string[] questions = new string[4] { "\nEnter First Name: ", "Enter Last Name: ", "Enter Loyalty Number: ", "Place on Wait List? (Y/N): " };
            string[] userInput = Utilities.GetUserInput(questions);

            switch (userInput[3]) // Should was add to the WAIT or NON-WAIT?
            {
                case "y":
                case "Y":
                    waitlistManifest.Add(new Passenger(userInput[0], userInput[1], userInput[2])); // Fname, Lname, L#
                    waitingCounter++;
                    addedFlag = true;
                    break;
                case "n":
                case "N":
                    passengerManifest.Add(new Passenger(userInput[0], userInput[1], userInput[2]));
                    passengerCounter++;
                    addedFlag = true;
                    break;
                default:
                    Utilities.FlashMessage("Bad input.", 750);
                    AddPassenger(); // Recursive call to try again
                    break;
            }

            if (addedFlag)
                Utilities.FlashMessage("\n\nPassenger Added!", 750);
            else
                Utilities.FlashMessage("\n\nNo passenger was added!", 750);
        }// END AddPassenger

        public void RemovePassenger() 
        {
            Console.WriteLine("\t\tRemove Passenger - Flight {0}\n\n", flightNumber);

            DisplayManifest();

            bool passengerFound = false;

            if ((passengerCounter > 0) || (waitingCounter > 0)) // Don't bother looking if no one is on the list
            {
                Console.WriteLine("\nEnter Name of Passenger to Delete");

                string[] questions = new string[2] { "\n\tEnter First Name: ", "\tEnter Last Name: " };
                string[] userInput = Utilities.GetUserInput(questions);

                for (int i = 0; i < passengerCounter; i++) // Looking through NON-WAIT
                {
                    if (userInput[0] == passengerManifest[i].FirstName && userInput[1] == passengerManifest[i].LastName)
                    {
                        passengerManifest.Remove(passengerManifest[i]); // Lovely feature of lists
                        passengerFound = true;
                        passengerCounter--;
                        break;
                    }
                }

                for (int i = 0; i < waitingCounter; i++) // Looking through WAIT
                {
                    if (userInput[0] == waitlistManifest[i].FirstName && userInput[1] == waitlistManifest[i].LastName)
                    {
                        waitlistManifest.Remove(waitlistManifest[i]); // Lovely feature of lists
                        passengerFound = true;
                        waitingCounter--;
                        break;
                    }
                }

                if (passengerFound)
                    Utilities.FlashMessage("\n\nPassenger Removed!", 750);
                else
                    Utilities.FlashMessage("\n\nNo Passenger was found.",750);
            }
        }// END RemovePassenger

        public void RunSecurityCheck()
        {
            FlaggedPassenger[] flaggedPassengers;
            Passenger[] tempArray; // Temp array used to store the passenger list
            TSA myTSA = new TSA();
            bool checkedFlag = false;

            if (passengerManifest.Count > 0) // Anyone to check in NON-WAIT?
            {
                checkedFlag = true;
                tempArray = passengerManifest.ToArray();
                flaggedPassengers = myTSA.RunSecurityCheck(tempArray, passengerCounter); // Run check and store flagged passengers
                for (int i = 0; i < flaggedPassengers.Length; i++)
                {
                    for (int j = 0; j < passengerManifest.Count; j++) // Update actual manifest with flags
                    {
                        if (flaggedPassengers[i].FirstName == passengerManifest[i].FirstName
                            && flaggedPassengers[i].LastName == passengerManifest[i].LastName)
                        {
                            passengerManifest[i].SecurityFlag = true;
                        }
                    }
                }
            }

            if (waitlistManifest.Count > 0) // Anyone to check in WAIT?
            {
                checkedFlag = true;
                tempArray = waitlistManifest.ToArray();
                flaggedPassengers = myTSA.RunSecurityCheck(tempArray, waitingCounter);

                for (int i = 0; i < flaggedPassengers.Length; i++)
                {
                    for (int j = 0; j < waitlistManifest.Count; j++)
                    {
                        if (flaggedPassengers[i].FirstName == waitlistManifest[i].FirstName
                            && flaggedPassengers[i].LastName == waitlistManifest[i].LastName)
                        {
                            waitlistManifest[i].SecurityFlag = true;
                        }
                    }
                }
            }

            if (checkedFlag) // Make it look like we're doing something really tough
            {
                Console.Write("Running security check.");
                System.Threading.Thread.Sleep(500);
                Console.Write(".");
                System.Threading.Thread.Sleep(500);
                Console.Write(".");
                System.Threading.Thread.Sleep(500);
                Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System");
                Utilities.ClearAndDisplayHeader("-- CHARMS --\n\n\n");
                Utilities.FlashMessage("Complete: Passenger Manifest Updated!", 1000);
            }
            else
                Utilities.FlashMessage("Complete: No passengers found!", 1000);
            
        }// END RunSecurityCheck

        public void WaitingListMover() 
        {
            // NON-WAIT
            bool matchFound = false;
            int foundIndex = -1;
            Passenger tempPassenger;

            // WAIT
            bool matchFoundW = false;
            int foundIndexW = -1;  
            Passenger tempPassengerW;

            DisplayManifest();

            if ((passengerCounter > 0) || (waitingCounter > 0)) // Any passengers to move?
            {
                string[] questions = new string[2] { "\n\nEnter the Loyalty Number of the Passenger: ", "\nMove To Waiting (W) or Not Waiting (N): " };
                string[] userInput = Utilities.GetUserInput(questions);

                for (int i = 0; i < passengerManifest.Count; i++) // Mark the locations of a NON-WAIT passenger
                {
                    if (passengerManifest[i].LoyaltyNumber == userInput[0])
                    {
                        matchFound = true;
                        foundIndex = i;
                        tempPassenger = passengerManifest[i];
                    }
                }

                for (int i = 0; i < waitlistManifest.Count; i++) // Mark the locations of a WAIT passenger
                {
                    if (waitlistManifest[i].LoyaltyNumber == userInput[0])
                    {
                        matchFoundW = true;
                        foundIndexW = i;
                        tempPassengerW = waitlistManifest[i];
                    }
                }

                if (!matchFound && !matchFoundW)
                    Utilities.FlashMessage("\nNo such loyalty number.", 1000);
                else
                {
                    // Moves a NON-WAIT to WAIT
                    if (matchFound)
                    {
                        switch (userInput[1])
                        {
                            case "W":
                            case "w":
                                waitlistManifest.Add(passengerManifest[foundIndex]);
                                waitingCounter++;
                                passengerManifest.Remove(passengerManifest[foundIndex]);
                                passengerCounter--;
                                break;
                            case "N":
                            case "n":
                                break;
                            default:
                                break;
                        }
                    }

                    // Moves a WAIT to a NON-WAIT
                    if (matchFoundW)
                    {
                        switch (userInput[1])
                        {
                            case "W":
                            case "w":
                                break;
                            case "N":
                            case "n":
                                passengerManifest.Add(waitlistManifest[foundIndexW]);
                                passengerCounter++;
                                waitlistManifest.Remove(waitlistManifest[foundIndexW]);
                                waitingCounter--;
                                break;
                            default:
                                break;
                        }
                    }

                    if (matchFound || matchFoundW) // Did we move someone?
                    {
                        Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System");
                        Utilities.ClearAndDisplayHeader("-- CHARMS --\n\n\n");
                        Utilities.FlashMessage("\nSuccess: Manifests Updated!", 1000);
                    }
                }  
            }    
        }// END WaitingListMover
    }// END Flight class
}// END CHARMS
