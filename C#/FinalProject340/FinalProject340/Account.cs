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
    class Account
    {
        private string accName;
        private string address;
        private string city;
        private string state;
        private int zip;
        private int age = 0;
        private string userID;
        private string pin;
        private double balance;

        public Account(string newUserID, string newName, string newPin, double newBalance, int newAge, string newAddress, string newCity, string newState, int newZip)
        {
            userID = newUserID;
            accName = newName;
            pin = newPin;
            balance = newBalance;
            age = newAge;
            address = newAddress;
            city = newCity;
            state = newState;
            zip = newZip;

        }

        public void SetAccName(string input)
        {
            accName = input;
        }
        public string GetAccName()
        {
            return accName;
        }

        public void SetAddress(string input)
        {
            address = input;
        }
        public string GetAddress()
        {
            return address;
        }

        public void SetCity(string input)
        {
            city = input;
        }
        public string GetCity()
        {
            return city;
        }

        public void SetState(string input)
        {
            state = input;
        }
        public string GetState()
        {
            return state;
        }

        public void SetZip(int input)
        {
            zip = input;
        }
        public int GetZip()
        {
            return zip;
        }

        public void SetAge(int input)
        {
            age = input;
        }
        public int GetAge()
        {
            return age;
        }

        public void SetUserID(string input)
        {
            userID = input;
        }
        public string GetUserID()
        {
            return userID;
        }

        public void SetPin(string input)
        {
            pin = input;
        }
        public string GetPin()
        {
            return pin;
        }

        public void SetBalance(double input)
        {
            balance = input;
        }
        public double GetBalance()
        {
            return balance;
        }

        public void ExecutePurchase(Cart input)
        {
            //Displaying cart and total information
            input.DisplayCart();
            Console.WriteLine("-------------------------");
            Console.WriteLine("Subtotal: \t{0}", input.GetSubtotal().ToString("C"));

            //Checking for seniority
            if (age >= 65)
            {
                input.SetTotalPrice(input.GetTotalPrice() * 0.9);
            }

            //Displaying taxes and total price
            Console.WriteLine("Taxes: \t\t" + input.GetSalesTax() * 100 + "%");
            Console.WriteLine("Total Price: \t" + input.GetTotalPrice().ToString("C"));

            //Displaying senior savings if applicable
            if (age >= 65)
            {
                Console.WriteLine("Senior Savings: " + (input.GetTotalPrice() * 0.1).ToString("C"));
            }

            balance -= input.GetTotalPrice(); //Updating user's balance

            Console.WriteLine("\nConfirm this information and press any key to continue.");
            Console.ReadKey(); //Pausing for user to review
            Console.Clear();

            //Displaying important information to user after their purchase
            Console.WriteLine("Old Balance: " + (balance + input.GetTotalPrice()).ToString("C") + " minus Total Cost: " + input.GetTotalPrice().ToString("C"));
            Console.WriteLine("Remaining account balance: " + balance.ToString("C"));
            Console.WriteLine("\nShip To:\n");
            Console.WriteLine(accName + "\n" + address + "\n" + city + ", " + state + " " + zip);
            Console.WriteLine("\nConfirm this information. And then press any key to logout.");
        }
    }
}
