package BradleyBeverageShop;

public class Smoothie extends Beverage
{
	private int numFruits;
	private boolean addProtein;
	private final double PROTEIN_COST = 1.50;
	private final double FRUIT_COST = 0.50;
	
	public Smoothie(String name, Size size, int numFruits, boolean addProtein)
	{
		super(name, Type.SMOOTHIE, size);
		this.numFruits = numFruits;
		this.addProtein = addProtein;
	}

	@Override
	public double calcPrice()
	{
		double extraPrice = numFruits*FRUIT_COST;
		if(addProtein)
		{
			extraPrice += PROTEIN_COST;
		}
		return super.addSizePrice() + extraPrice;
	}

	public int getNumFruits()
	{
		return numFruits;
	}

	public boolean getAddProtein()
	{
		return addProtein;
	}

	public boolean equals(Smoothie bev)
	{
		if(numFruits == bev.numFruits && addProtein == bev.addProtein)
		{
			return super.equals(bev);
		}
		return false;
	}
	
	public String toString()
	{
		return super.toString() + "\nNumber of fruits: " + numFruits + "\nAdded protein: " + addProtein;
	}
	
}
