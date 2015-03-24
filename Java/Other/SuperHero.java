// Define a public class SuperHero
public class SuperHero
{
	private static int numberOfHeroes;
	private String heroName;
	private String secretIdentity;
	private int numberOfLifeChances;
	private int numberOfPeopleSaved;

	public SuperHero(String hName, String sIden, int numSaved)
	{
		// increment the numberOfHeroes
		numberOfHeroes++;
		// assign 2 to numberOfLifeChances
		numberOfLifeChances = 2;
		// assign the input hName to variable heroName
		heroName = hName;
		// assign the input sIden to variable secretIdentity
		secretIdentity = sIden;
		// assign the input numSaved to variable numberOfPeopleSaved
		numberOfPeopleSaved = numSaved;

	}

	// Pass a String variable hName as parameter
	public SuperHero(String hName)
	{
		// increment the numberOfHeroes
		numberOfHeroes++;
		// assign 2 to numberOfLifeChances
		numberOfLifeChances = 2;
		// assign the input hName to variable heroName
		heroName = hName;
		// assign "unknown" to variable secretIdentity
		secretIdentity = "unknown";
		// initialize numberOfPeopleSaved to 0
		numberOfPeopleSaved = 0;
	}

	// This method returns the numberOfHeroes
	public static int getNumberOfHeroes()
	{
		return numberOfHeroes;
	}

	public void recordSave()
	{
		numberOfPeopleSaved++;
	}

	// Define a overloaded method recordSaved with integer num as input. Inside the method increment numberOfPeopleSaved by num
	public void recordSaved(int num)
	{
		numberOfPeopleSaved+= num;
	}

	public void killHero()
	{
		// Write an if-else statement, if numberOfLifeChances equals 0 print "<heroName> does not live any more!"
		// else decrement numberOfLifeChances
		if (numberOfLifeChances == 0)
			System.out.println(heroName + " does not live any more!");
		else
			numberOfLifeChances--;
	}

	// define a public method with the name printSuperHeroRecord and return type void which prints the Super Hero record
	public  void printSuperHeroRecord()
	{

		System.out.println("\nSuperHero's name:\t"+ heroName);
		System.out.println("Secret Identity:\t"+ secretIdentity);
		System.out.print("Status:");

		if(numberOfLifeChances ==0)
			System.out.println("\tNot Alive");
		else
			System.out.println("\tAlive");
		System.out.println("Num of Lives Saved:\t"+ numberOfPeopleSaved);
	}
}