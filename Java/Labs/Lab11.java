/*---------------------------------------------------------------------------
// AUTHOR:      	Brandon Lacquement
// FILENAME:    	Lab11.java
// SPECIFICATION: 	This program introduces arrays.
// INSTRUCTIONS:  	Read the following code skeleton and add your own code
//          		according to the comments.  Ask your TA or your class-
//          		mates for help and/or clarification.  When you see
//          		//--> that is where you need to add code.
// LAB LETTER:		I
//-------------------------------------------------------------------------*/


public class Lab11 {

	//This function converts the contents of the array of Strings into a single String with
	//appropriate spaces and returns it.
	//For example if String[] s = {"I", "am", "doing", "good."}; is an input to the function
	//The result is a String, I am doing good.

	public static String concatenateStrings(String[] strArray){

		//Create a String variable <concatenatedStr> and initialize it to "";
		String concatenatedStr = " ";

		//Implement a for loop where the loop variable <i> goes from the 0 to the length of <strArray> (not included)
		for(int i=0; i < strArray.length;i++)
		{
			//Concatenate the string at index <i> of <strArray> to <concatenatedStr>
			concatenatedStr+= " " + strArray[i];
		}

		//return <concatenatedStr>
		return concatenatedStr;
	}


	//This function calculates the sum of the array of integers and returns it.
	//For example if int[] s = {1, 2, 3}; is an input to the function
	//The result is an Integer, 6

	public static double findSumOfArray(int[] intArray)
	{
		//Create an integer variable <sum> and initialize it to 0;
		int sum = 0;

		//Implement a for loop where the loop variable <i> goes from the 0 to the length of <intArray> (not included)
		for(int i=0; i < intArray.length; i++)
		{
			//Add the integer at index <i> of <intArray> to <sum>
			sum += intArray[i];
		}

		//return <sum>
		return sum;
	}


	//The main method begins here. The methods defined above will be used inside the main method.
	public static void main(String[] args) {

		//Create an array of Strings
		String[] brokenString = {"I", " was", "broken", "and", "you", "fixed", "me."};

		//Create an array of first ten Natural numbers.
		int[] tenNaturalNos = new int[10];

		//Write a loop to initialize the array
		//Implement a for loop where the loop variable i goes from 0 to tenNaturalNos.length-1
		for(int i = 0;i <= (tenNaturalNos.length-1);i++)
		{
			//Set the value of tenNaturalNos at index i to i+1, tenNaturalNos[i] = i+1;
			tenNaturalNos[i] = i + 1;
		}

		//Print the <brokenString> array
		System.out.println("The array of Strings : ");
		for(int i=0; i<brokenString.length; i++){
			// print the string at i index of brokenString
			System.out.println(brokenString[i]);
		}

		System.out.println("The array of Integers : ");
		//Print the array <tenNaturalNos> in the same manner using a for loop
		for(int i=0; i<tenNaturalNos.length; i++){
					// print the string at i index of tenNaturalNos
					System.out.println(tenNaturalNos[i]);
		}

		//Invoke the concatenateStrings method using the array <brokenString> as input
		System.out.println("The array of Strings now becomes : "+ concatenateStrings(brokenString));

		//Similarly invoke the findSumOfArray method using the <tenNaturalNos> as input
		System.out.println("The sum of the integers in the array is : " + findSumOfArray(tenNaturalNos));

	}

}

/*
QUESTIONS FOR THOUGHT:
1. If int[] a = new int[10]; What happens when you try to access a[10] or a[11]?
2. Why cannot arrays be created with variable size. What is the benefit gained(in terms of speed)
   from imposing such a limitation?
3. How does java.util.ArrayList overcome this limitation of fixed size.
4. Write a method to combine two Integer arrays to form a single array. There is
   a method in the java.lang.System class that does this, check it out.
5. What are multi-dimensional arrays, How would you represent a matrix in Java.
6. The main method is declared as
   public static void main(String[] args)
   What does (String[] args) stand for?
7. java.lang.StringBuffer is a class that efficiently creates Strings and has methods to append Strings and reverse Strings.
   Try implementing the first and second method using a StringBuffer
8. java.util.Arrays is a class that has common functions for arrays of different datatypes. Use the Arrays class to print
   arrays we have created.
*/