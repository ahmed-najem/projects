/*-------------------------------------------------------------------------
// AUTHOR: Brandon Lacquement
// FILENAME: Geek.java
// SPECIFICATION: A class that computes various values when called
// YOUR Lab Letter: I Huahong Tu
// FOR: CSE 110- homework #6 12:55 pm
// TIME SPENT: 3 hours
//----------------------------------------------------------------------*/
public class Geek
{
	private String geekName;
	private static int NumberOfQuestions; //static since all methods use it

	public Geek (String name, int numQuestions)
	{
		 geekName = name;
		 NumberOfQuestions += numQuestions;
	}

	public String getName()
	{
		geekName.toString(); // turning geekName into a string
		return geekName;
	}

	public int getNumberOfQuestions()
	{
		return NumberOfQuestions;
	}

	public boolean isEven (int num1, int num2)
	{
		boolean even = true;
		int add = num1 + num2;
		if ((add)%2 != 0) //testing if the sum of the values divided by two leaves a remainder
			even = false; // if so, it is not even
		NumberOfQuestions ++;
		return even;
	}

	public boolean isPrime (int number)
	{
		boolean prime = true;
		for (int x = 2; x < number; x++) // dividing each int below the int number and checking to make
										// sure each has a remainder. otherwise, it is not prime
		{
			if(number%x == 0)
				prime = false;
		}
		NumberOfQuestions ++;
		return prime;
	}

	public int sum (int num1, int num2)
	{
		int sum = 0;
		if (num1 > num2)
		{
			for (int x = num2; x <= num1; x++) //1st case where num1 is greater than num2
			{
				sum += x;

			}

		}
		if (num1 < num2)
		{
			for (int x = num1; x <= num2; x++) // 2cd case where num2 is greater than num1
			{
				sum += x;

			}

		}

		if (num1 == num2) // 3rd case where num1 equals num2
			sum = num1;
		NumberOfQuestions ++;
		return sum;
	}

	public boolean leapYear (int year)
	{
		boolean leapYear = false;

		if(year%4 == 0) // is divisible by 4?
			leapYear = true;
		if(year%100 == 0) // can't be divisible by 100
			leapYear = false;
		if(year%400 == 0) // is divisible by 400?
			leapYear = true;
		if (year < 1582) // years before 1582 aren't important for this
			leapYear = false;

		NumberOfQuestions ++;
		return leapYear;
	}

}
