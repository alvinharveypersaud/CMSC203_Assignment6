package BradleyBeverageShop;

public class Alcohol extends Beverage
{
	private boolean isWeekend;
	private final double EXTRA_PRICE = 0.60;
	
	public Alcohol(String name, Size size, boolean isWeekend)
	{
		super(name, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	public boolean isWeekend()
	{
		return isWeekend;
	}
	
	public boolean equals(Alcohol bev)
	{
		if(isWeekend == bev.isWeekend)
		{
			return super.equals(bev);
		}
		return false;
	}

	@Override
	public double calcPrice()
	{
		double extraPrice = 0.0;
		if(isWeekend)
		{
			extraPrice += EXTRA_PRICE;
		}
		return super.addSizePrice() + extraPrice;
	}

	public String toString()
	{
		return super.toString() + "\nWeekend: " + isWeekend;
	}
}
