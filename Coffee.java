package BradleyBeverageShop;

public class Coffee extends Beverage
{
	private boolean extraShot, extraSyrup;
	private final double EXTRA_PRICE = 0.5;

	public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup)
	{
		super(name, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	public boolean getExtraShot()
	{
		return extraShot;
	}
	
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
	
	public boolean equals(Coffee bev)
	{
		if(extraShot == bev.extraShot && extraSyrup == bev.extraSyrup)
		{
			return super.equals(bev);
		}
		return false;
	}

	@Override
	public double calcPrice()
	{
		double extraPrice = 0.0;
		if(extraShot)
		{
			extraPrice += EXTRA_PRICE;
		}
		if(extraSyrup)
		{
			extraPrice += EXTRA_PRICE;
		}
		return addSizePrice() + extraPrice;
	}
	
	public String toString()
	{
		return super.toString() + "\nExtra shot: " + extraShot + "\nExtra syrup: " + extraSyrup;
	}
}
