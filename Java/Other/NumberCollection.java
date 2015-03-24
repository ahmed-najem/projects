/*-------------------------------------------------------------------------
// AUTHOR: Brandon Lacquement
// FILENAME: NumberCollection
// SPECIFICATION: Class to run compute various things for Assignment7.java
// Lab: I Huahong Tu
// FOR: CSE 110- homework #7 MWF and 12:55pm of your class
// TIME SPENT: 3hrs
//----------------------------------------------------------------------*/
/*-------------------------------------------------------------------------
// 1. 	char[] array = new char[12];
//		for(int i = 0; i < array.length; i++)
//			array[i] = '$';
// 2. 	'd'
// 3. 	int[] array = new int[6];
//		array[1] = 5;
// 4.	1
//----------------------------------------------------------------------*/

public class NumberCollection
{
	//Instance variables
	private int count;
	private int[] numberArray;
	private int[] temp;

	//Default constructor
	public NumberCollection(int arraySize)
	{
		numberArray = new int[arraySize];
		count = 0;
	}


	private int indexOf(int searching)
	{
		int index = -1;

		for(int i = 0; i < numberArray.length; i++)
		{
			if(numberArray[i] == searching)//When argument equals number in 'i' index
				index = i;// Sets the return value equal to the index of the number found
		}					// else returns -1

		return index;
	}


	private void doubleArrayCapacity()
	{
		if(count == numberArray.length)//if the count is equal to the length
		{
			NumberCollection[] temp;//making a temp array for the copy
			temp = new NumberCollection[numberArray.length * 2];//doubling the length
		}

			for(int i = 0; i <numberArray.length; i++)
				temp[i] = numberArray[i];//loop to copy old array onto temp

			numberArray = temp; //copying temp back to numberArray
	}


	public boolean addNumber(int numberToAdd)
	{
		boolean flag = false;

		if (numberArray.length == count)
			doubleArrayCapacity(); //doubling array if over the length

		if (indexOf(numberToAdd) == -1)
			flag = true; //won't add if its already in the array

		numberArray [count] = numberToAdd;//adds number to last index in array
		count++;//cont. count
		return flag;
	}


	public boolean removeNumber(int numberToRemove)
	{
		boolean flag = false;

		if (indexOf(numberToRemove) == -1)//if number isn't there, quits method
			return flag;

		if (indexOf(numberToRemove) != -1)
		{
			for (int i = 0; i < numberArray.length; i++)//copies each succeeding value to the proceeding
				numberArray[indexOf(numberToRemove)] = numberArray[indexOf(numberToRemove) + 1];
			flag = true;
		}

		return flag;
	}


	public int findMax()
	{
		int max = 0;

		for(int i = 0; i < numberArray.length; i++)
		{
			if(numberArray[i] > max)
				max = numberArray[i];//copying larger values to max
		}
		return max;
	}


	public int findMin()
	{
		int min = numberArray[0];//sets initial value to first term

		for(int i = 0; i < numberArray.length; i++)//scans for smaller terms
		{
			if(numberArray[i] <min)
				min = numberArray[i];//if smaller, assigns to min
		}

		return min;
	}


	public int computeSum()
	{
		int sum = 0;

		for(int i = 0; i < numberArray.length; i++)
		{
			sum += numberArray[i];
		}

		return sum;
	}

	public String toString()
	{
		String array = "{";

		for(int i = 0; i < numberArray.length; i++)
			array += numberArray[i] + " ";

		array += "}";

		return array;
	}
}

