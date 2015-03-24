import java.util.Scanner;
public class Lab9
{
	public static void main(String[] args)
	{

		System.out.println("Creating Spider-Man.......");
		// Create a SuperHero spiderman with the name "Spider-Man", secret identity "Peter Parker"
		// and he has not saved any one yet
		SuperHero spiderMan = new SuperHero("Spider-Man", "Peter Parker", 0);

		// Ask the user to enter his super hero's name
		System.out.println("\nWhat is your super hero's name?");

		// Creating Scanner object
		Scanner scan = new Scanner(System.in);

		// Take the super hero's name as input and assign it to a String variable heroName
		String heroName = scan.nextLine();

		System.out.println("What is his secret identity?");
		// Take the super hero's secret identity as input and assign it to a String variable secretIdentity
		String secretIdentity = scan.nextLine();

		System.out.println("Creating your super hero.......");
		// Create a yourHero object of the class SuperHero with the heroName and secretIdentity as inputs and
		// with numberOfPeopleSaved 10
		SuperHero yourHero = new SuperHero(heroName, secretIdentity, 10);

		System.out.println("\nSpider-Man just saved a flight and saved 100 lives!");
		// Call the recordSave(D?!?!) method with 100 as input
		yourHero.recordSaved(100);

		System.out.println("Oh just learnt that Spider-Man was shot dead twice in this incident");
		// Call the method that will kill the hero twice
		yourHero.killHero();
		yourHero.killHero();

		System.out.println("\nYour hero saved a kidnapped kid but unfortunately was shot once");
		// Call the method that will kill the hero
		yourHero.killHero();
		// Call the method that will add 1 more to the lives saved
		yourHero.recordSaved(1);

		System.out.println("\nNow printing the super hero database:\n*************************************\n");
		// for the ??? call the method in the SuperHero class that will return numberOfHeroes
		System.out.println("There are " + SuperHero.getNumberOfHeroes() + " known superheroes.");
		// Print out the record of spiderMan
		spiderMan.printSuperHeroRecord();
		// Print the record of yourHer
		yourHero.printSuperHeroRecord();

	}
}