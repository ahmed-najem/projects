public class FPlayer
{
	private String name;
	private int score;

	public FPlayer(String nm)
	{
		name = nm;
		score = 0;
	}

	public void add(int added)
	{
		score += added;
	}

	public int checkScore()
	{
		return score;
	}

	public String showScore()
	{
		String x = name + score;
		return x;
	}

	public String showName()
	{
		String y = name;
		return y;
	}
}