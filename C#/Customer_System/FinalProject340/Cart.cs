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
    class Cart
    {
        private Item[] cartItems;
        private double salesTax;
        private double subtotal;
        private double totalPrice;
        private int itemCount = 0;

        public Cart()
        {
            cartItems = new Item[5]; //Extra protection so that the cart can't exceed 5 items
        }

        public void SetItems(Item[] input)
        {
            cartItems = input;
        }
        public Item[] GetItems()
        {
            return cartItems;
        }

        public void SetSalesTax(double input)
        {
            salesTax = input;
        }
        public double GetSalesTax()
        {
            return salesTax;
        }

        public void SetSubtotal(double input)
        {
            subtotal = input;
        }
        public double GetSubtotal()
        {
            return subtotal;
        }

        public void SetTotalPrice(double input)
        {
            totalPrice = input;
        }
        public double GetTotalPrice()
        {
            return totalPrice;
        }

        public void SetItemCount(int input)
        {
            itemCount = input;
        }
        public int GetItemCount()
        {
            return itemCount;
        }

        public void CalculateTotal()
        {
            double temp = 0; //Temp to add all values in cart

            for (int i = 0; i < itemCount; i++) //Adding all values from each item in cart
            {
                temp += cartItems[i].GetPrice();
            }

            subtotal = temp; //Setting subtotal
            totalPrice = subtotal * (1 + salesTax); //Setting total price
        }
        public void DisplayCart()
        {
            for (int i = 0; i < itemCount; i++) //Perusing array and displaying offered items
            {
                Console.WriteLine(cartItems[i].GetItemName() + "\t\t" + cartItems[i].GetPrice().ToString("C"));
            }
        }
        public void AddItem(Item input)
        {
            if (itemCount < 5) //Check that cart isn't full
            {
                if (input.GetQuantity() > 0) //Checking item is in stock. If so, adding to cart, updating quantity and adding to item count
                {
                    Console.Write("Oo that's nice! {0} added.\n", input.GetItemName());
                    cartItems[itemCount] = input;
                    input.UpdateQuantity(1);
                    itemCount++;
                }
                else //Out of stock case
                {
                    Console.WriteLine("Out of Stock for {0}.", input.GetItemName());
                }
            }
            else //Cart was full case
            {
                Console.WriteLine("Cart is full.");
            }
        }
    }
}
