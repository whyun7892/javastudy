


class TopTier {
	public void getTopTier()
	{
		System.out.println("getTopTier has been called");
	}
}

class SecondTier extends TopTier {
	public void getSecondTier()
	{
		System.out.println("secondTier has been called");
	}
}


public class MyClass {
	public static void main(String[] args)
	{
		SecondTier tier=new SecondTier();
		tier.getSecondTier();
		tier.getTopTier();
	}
}

