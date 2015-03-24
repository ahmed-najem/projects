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
    class Item
    {
        private string itemName;
        private double price;
        private int quantity;

        public Item(string name, double newPrice, int newQuantity)
        {
            itemName = name;
            price = newPrice;
            quantity = newQuantity;
        }

        public void SetItemName(string input)
        {
            itemName = input;
        }
        public string GetItemName()
        {
            return itemName;
        }

        public void SetPrice(double input)
        {
            price = input;
        }
        public double GetPrice()
        {
            return price;
        }

        public void SetQuantity(int input)
        {
            quantity = input;
        }
        public int GetQuantity()
        {
            return quantity;
        }

        public void UpdateQuantity(int input) //Takes in the positive amount of items to subract from the total
        {
            quantity -= input;
        }
    }
}
