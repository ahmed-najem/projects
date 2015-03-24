/*---------------------------------------------------------------------------
// AUTHOR:          Brandon Lacquement
// FILENAME:        Lab12.java
// SPECIFICATION:   This program implements more operations on arrays
//                  including max, min and average for an array
//                  the user enters the numbers into.
// INSTRUCTIONS:    Read the following code skeleton and add your own code
//                  according to the comments.  Ask your TA or your class-
//                  mates for help and/or clarification.  When you see
//                  //--> that is where you need to add code.
// LAB LETTER:		I
//-------------------------------------------------------------------------*/

import java.util.Scanner;

public class Lab12
{
	    //This method takes an array of integers and the size of the array as parameters
	    //and returns how the elements of the elements of the array separated by commas inside brackets.
	    public String arrayToString(int[] a, int size)
	    {
	        String s = "[";
	        for (int i=0; i<size; i++)
	            if (i==size-1)
	                s += a[i];
	            else
	                s += a[i] + ", ";
	        return s + "]";
	    }


	    //This method takes an array of integers and the size of the array as parameters
	    // and returns the minimum element in the array

	    public int min(int[] a, int size)
	    {
	        int min;
	        if (size > 0)
	            min = a[0];
	        else
	            min = 0;

	        for (int i=1; i<size; i++)
	            if (a[i]<min)
	                min=a[i];

	        return min;
	    }

	    //WRITE THE FOLLOWING METHOD int max(int[], int)
	    //See the min method above as an example
		public int max(int[] a, int size)
		{
	    	int max;
	    	if (size > 0)
				max = a[0];
			else
	            max = 0;

	        for (int i=1; i<size; i++)
	        	// Check if the <i>th value of <a> is greater than <max>,
				if (a[i] > max)
					// Assign <i> th value of <a> to <max>
				   max=a[i];

			// return max;
	        return max;

		}


	    //This method takes an array of integers and the size of the array as parameters
	    // and returns the sum of the elements in the array
	    public int sum(int[] a, int size)
	    {
	        int sum=0;
	        for (int i=0; i<size; i++)
	            sum += a[i];
	        return sum;
	    }

	    public double average(int[] a, int size)
	    {
	        //If the <size> is zero
	        if(size == 0){
	        	// return zero
		        return 0;
			}
		    else {
	        	//return the sum of elements (call the sum() method above) divided by <size>.
	        	return (double)sum(a,size)/size;
			}

	    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
		Lab12 myObject= new Lab12();

        //Create an array of integers called 'a' of length 10 that will hold user input.
		int[] a= new int[10];

        //Declare an integer called 'size' and initialize it to 0.  This will be the number
        //integers the user enters.
		int size = 0;

        //A boolean for rather the user has entered all the numbers they want into the array.
        boolean quit = false;

        // The conditions for this loop are:
        // 1. Check if <i> is less than 10 and
        // 2. Check if <quit> is false
	   	for(int i=0; i < 10 & quit == false;i++)
        {
            System.out.print("Enter an integer into the array (0 to quit): ");

            //Use the Scanner to read in the next integer and store it into the <i>th position of the array <a>
			a[i]= scan.nextInt();

            //If the number at index <i> of <a> is not zero then increase <size> by 1
            if(a[i] != 0){
				size += 1;
			}
            //Otherwise set the <quit> to true
            else{
				quit = true;
			}

        }


        //Call arrayToString method below with the integer array <a> and <size> as inputs.
        System.out.println("\nThe array: " + myObject.arrayToString(a, size));

        System.out.println("\nComputing the statistics of the array");
        System.out.println("----------------------------------------");
        // Print out the minimum by calling min method with <a> and <size> as inputs
        System.out.println("The smallest number in the array:\t\t " + myObject.min(a,size));

        //Print out the largest number as above by calling myObject.max method with <a> and <size> as inputs
		System.out.println("The largest number in the array:\t\t " + myObject.max(a,size));

		//Print out the average to 2 decimal points by calling the average method with <a> and <size> as inputs
        System.out.println("The average of the numbers in the array is:\t " + myObject.average(a,size));


    }




}

/* Questions for thought:
//  1. Why in the min and max methods is the variable that holds the min and max initialized how it is?
//      Why are they not just initialized to 0?
//  2. How are arrays passed as parameters?  Why must you be careful if you change an array inside a method?
//  3. Write a method that returns an array that contains every other element in a given array. Every third element. etc..
//  4. Why did we use a variable size for the array in this lab rather than using the length of the array?
//  5. Write a method that returns an array that contains the elements of a given array in reverse order.
//  6. In this lab we used a search technique called Linear Search.  What is the maximum number of elements in an array
//      that can be examined?  When does this maximums occur.  What are some other search techniques and when are they
//      better and worse than Linear Search?
*/