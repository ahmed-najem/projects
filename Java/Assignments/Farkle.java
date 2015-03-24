import java.util.*;

public class Farkle
{
	public static void main (String[] args)
	{
		String p1;
		String p2;
		int score;

		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter Player 1's name: ");
		p1 = scan.nextLine();
		FPlayer player1 = new FPlayer(p1);

		System.out.println("Please enter Player 2's name: ");
		p2 = scan.nextLine();
		FPlayer player2 = new FPlayer(p2);


		while((player1.checkScore() < 10000) && (player2.checkScore() < 10000))
		{
			System.out.println("Player 1's Total Turn Score: ");
			score = scan.nextInt();
			player1.add(score);

			System.out.println("Player 2's Total Turn Score: ");
			score = scan.nextInt();
			player2.add(score);

			System.out.println("Current Scores:\n0
			" + player1.showName() + " : " + player1.checkScore()
								+ "\n" + player2.showName() + " : " + player2.checkScore());
		}

		if (player1.checkScore() >= 10000)
			{
				System.out.println("Player 1 is over 10,000!");
				System.out.println("Player 2's Final Turn Score: ");
				score = scan.nextInt();
				player2.add(score);

				if(player1.checkScore() > player2.checkScore())
					System.out.println("Player 1 Wins!");
				else if (player1.checkScore() == player2.checkScore())
					System.out.println("TIE!");
				else
					System.out.println("Player 2 Wins!");
			}

		if(player2.checkScore() >= 10000)
			{
				System.out.println("Player 2 is over 10,000!");
				System.out.println("Player 1's Final Turn Score: ");
				score = scan.nextInt();
				player1.add(score);

				if(player2.checkScore() > player1.checkScore())
					System.out.println("Player 2 Wins!");
				else if (player1.checkScore() == player2.checkScore())
					System.out.println("TIE!");
				else
					System.out.println("Player 1 Wins!");
			}


	}
}