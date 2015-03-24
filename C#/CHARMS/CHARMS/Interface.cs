/*
 * Brandon Lacquement
 * CIS 345 T/TH 1:30 PM
 * Project: CHARMS: Interface
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
    class Interface
    {
        static void Main(string[] args)
        {
            FMS myFMS = new FMS(); // Create an instance of the application FMS
            myFMS.flightCounter = 0; // Keeps track of # of flights in array
            Flight[] flights = new Flight[20]; // This will create a max of 20 flights
            flights = myFMS.LoadSampleDataFromFile(flights);  // Loading samples from file

            do
            {
                // MAIN MENU SWITCH
                switch (myFMS.DisplayMainMenu())
                {
                    case 1:
                        Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System", "-- CHARMS --\n\n\n");
                        myFMS.DisplayFlightList(flights);
                        Console.Write("\n\n\nPress any key to return...");
                        Console.ReadKey();
                        break;
                    case 2:
                        Utilities.ClearAndDisplayHeader("Chandler Air Reporting and Management System", "-- CHARMS --\n\n\n");
                        flights = myFMS.CreateNewFlight(flights);
                        break;
                    case 3:
                        myFMS.SelectAFlight(flights);
                        break;
                    case 4:
                        myFMS.SearchAllFlights(flights);
                        break;
                    case 5:
                        flights = myFMS.RemoveAFlight(flights);
                        break;
                    case 6:
                        Environment.Exit(0);
                        break;
                    default:
                        Utilities.FlashMessage("Unknown Error", 1000); // Utility prints string and waits 1000 msecs
                        Environment.Exit(0);
                        break;
                }
            } while (true);
        }// END Main
    }// END Interface
}// END CHARMS
