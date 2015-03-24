/*-------------------------------------------------------------------------
// AUTHOR: Brandon Lacquement
// FILENAME: Triangle.java
// SPECIFICATION: 	Contains various methods that check properties of
// 					a triangle.
// YOUR Lab Letter: I
// FOR: CSE 110- homework #5 MWF 12:55-1:45pm
// TIME SPENT: 1 hour
//----------------------------------------------------------------------*/

public class Triangle
{
	// Instance variables
	private int side1;
	private int side2;
	private int side3;

	// Constructor
	public Triangle(int s1, int s2, int s3)
	{
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}

	// Method to find largest side
	// (private) since it is a helper method
	private int largest()
	{
		int largest = 0;

		if (side1 > side2 && side1 > side2)
		largest = side1;
		if (side2 > side1 && side2 > side3)
		largest = side2;
		if (side3 > side1 && side3 > side2)
		largest = side3;

		return largest;
	}

	// Method to find shortest side
	// (private) since it is a helper method
	private int shortest()
	{
		int shortest = 0;

		if (side1 < side2 && side1 < side2)
		shortest = side1;
		if (side2 < side1 && side2 < side3)
		shortest = side2;
		if (side3 < side1 && side3 < side2)
		shortest = side3;

		return shortest;
	}

	// Method to determine if triangle is right
	public boolean is_right()
	{
		boolean right;

		// Using a^2 + b^2 = c^2
		if (side1*side1 + side2*side2 == side3*side3)
		right = true;

		else if (side1*side1 + side3*side3 == side2*side2)
		right = true;

		else if (side3*side3 + side2*side2 == side1*side1)
		right = true;

		else
		right = false;

		return right;
	}

	// Method to determine if triangle is equilateral
	public boolean is_equilateral()
	{
		boolean equil;

		// Calling helper methods from this class
		if (shortest() == largest())
		equil = true;

		else
		equil = false;

		return equil;

	}

	// Method to determine if triangle is isosceles
	public boolean is_isosceles()
	{
		boolean iso;

		// Checking if one side equals another but also
		// making sure all three sides are nto equal
		if ( side1 == side2 && (side2 != side3))
		iso = true;

		else if ( side2 == side3 && (side3 != side1))
		iso = true;

		else if ( side3 == side1 && (side1 != side2))
		iso = true;

		else
		iso = false;

		return iso;
	}

	// Method to determine if triangle is scalene
	public boolean is_scalene()
	{
		boolean scal;

		// Checking if all of the sides are not equal to each other
		if (side1 != side2 && side1 != side3 && side2 != side3)
		scal = true;

		else
		scal = false;

		return scal;
	}

	// Method to print the sides of the triangle
	public String toString()
	{
		String side = (side1 + " " + side2 + " " + side3);
		return side;
	}


}