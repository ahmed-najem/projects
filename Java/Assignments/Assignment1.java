//***********************************************************
// Name: Brandon Lacquement
// Title: Assignment1.java
// Author: Brandon Lacquement
// Lab I :
// Description: Tell you about me through printed text
// value
// Time spent:  minutes
// Date: 8/31/11
//**************************************************************
//Questions:
//a. The compiler finds an error in the syntax of the tempconverter.java.
//   The compiler does not recognize the synax because it is not capitalized.
//   Therefore, the program did not compile and did not run.
//b. The compiler finds four errors although there is only one. The compiler
//   cannot find the string to system.prinln because it is not defined by an
//   open and closed set of parenthesis. Therfore, the program does not compile
//   and will not run.
//c. The compiler finds an error at the end of the first statement. The compiler
//   expects a ";" to end the statement but one is not present. The ";" provides
//   the compiler a point at which to end the statement and process the next.
//   Therefore, the program will not compile and will not run.
//d. The compiler finds one error. The compiler is looking for another method.
//   However, there isn't another method in the class and the compiler cannot
//   compile the program and the program will not run.
//e. The compiler cannot find a saved variable for "farhenheit" and therefore
//   cannot process the statements. The program will not compile or run because
//   of this.
//*****************************************************************
public class Assignment1
{
	public static void main (String[] args)
	//Uses print and println to provide information about myself.
	{
		//"System.out.println" used to display the text in quotes
		System.out.println("First name: Brandon");
		System.out.println("Last name: Lacquement");
		System.out.println("Status: Freshman");
		System.out.println("Major:" + " Computer Science");
		System.out.println("Favorite subject: Math");
		System.out.println("Favorite book: Madame Bovary");
		System.out.println("Graduated from" + " Boulder Creek High School");
		System.out.print("Hobby: Playing music");
		//"\n" used to seperate the "System.out.print" line from the above line
		//when displayed in command prompt.
		System.out.print("\nFavorite ice cream: Cookies\'n\'Cream\n");
		//"\'" used to display the " ' "s that appear in text between "Cookies"
		//and "n" and "Cream" and "n"
	}
}