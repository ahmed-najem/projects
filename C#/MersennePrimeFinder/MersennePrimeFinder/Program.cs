using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UtilityLibrary;
using System.Timers;

namespace MersennePrimeFinder
{
    class Program
    {
        static void Main(string[] args)
        {
            UInt64 answer = 0;
            UInt64 possible = 0;
            UInt64 divider = 0;
            bool divisible = false;
            UInt64 numFound = 0;
            UInt64 power = 0;
            System.Timers.Timer timer;
            timer = new System.Timers.Timer();
            Utilities.WriteCenteredText("Mersenne Prime Finder");

            answer = Utilities.ReadInteger("\nHow many would you like to find?");
            System.Threading.Thread.Sleep(1000);
            Console.Clear();
            Utilities.WriteCenteredText("Finding " + answer + " Merenne Primes...\n");
            timer.Start();

            for (int i = 0; i <= answer; i++)
            {
                while (numFound < answer)
                {
                    possible = Power(2, power) - 1;
                    divider = possible;
                    for (int j = divider; j > 0 ; j--)
                    {
                        if (possible % j == 0 && divider != possible)
                        {
                            divisible = true;
                            break;
                        }
                    }

                    if (!divisible && possible >= 1)
                    {
                        Console.Write("{0}, ", possible);
                        numFound++;
                    }
                    power++;
                    divisible = false;
                }
            }

            timer.Stop();

            string time = "";

            Console.WriteLine("", answer, time);

            Utilities.WriteCenteredText("\n" + answer + " Mersenne Primes found in " + time + " seconds!");
            Console.ReadKey();
        }

        static int Power(int number, int power)
        {
            int temp = number;
            if (power == 0)
            {
                return 1;
            }
            if (power == 1)
            {
                return number;
            }
            else
            {
                for (int i = 1; i < power; i++)
                {
                    temp = temp * number;
                }
            }

            return temp;
        }
    }
}
