import java.util.Scanner;
public class Assignment5 {

   //===========================================================
   // Create and determine properties of various triangles.
   //===========================================================
   public static void main (String[] args) {

      Scanner console = new Scanner(System.in);
      int num1, num2, num3;
      String another;
      do
      {
      	 System.out.println("Enter the sides of the triangle: ");
      	 num1 = console.nextInt();
      	 num2 = console.nextInt();
      	 num3 = console.nextInt();

         Triangle myTriangle = new Triangle (num1, num2, num3);



      	System.out.println(myTriangle.toString() + " triangle:");

      	// check the right triangle
      	if (myTriangle.is_right())
         	System.out.println("\tIt is a right triangle");
        else
         	System.out.println("\tIt is not a right triangle");
        //check the isosceles
      	if (myTriangle.is_isosceles())
      	   System.out.println("\tIt is isosceles");
      	else
      	   System.out.println("\tIt is not isosceles");
        //check the equilateral
      	if (myTriangle.is_equilateral())
      	   System.out.println("\tIt is equilateral");
      	else
      	   System.out.println("\tIt is not an equilateral");
        //check the scalene
      	if (myTriangle.is_scalene())
      	   System.out.println("\tIt is scalene");
      	else
      	   System.out.println("\tIt is not scalene");


      	System.out.println();
      	System.out.print("Check another Triangle (y/n)? ");
      	another = console.next();

	} while (another.equalsIgnoreCase("y"));


   }  // method main

}  // class Assignment5
