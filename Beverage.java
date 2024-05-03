package BradleyBeverageShop;

public abstract class Beverage
{
	private String name;
	private Type type;
	private Size size;
	final private double BASE_PRICE = 2.0;
	final private double SIZE_PRICE = 0.5;
	
	public Beverage(String name, Type type, Size size)
	{
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	public double addSizePrice()
	{
		if(size == Size.MEDIUM)
		{
			return BASE_PRICE + SIZE_PRICE;
		}
		else if(size == Size.LARGE)
		{
			return BASE_PRICE + 2*SIZE_PRICE;
		}
		return BASE_PRICE;
	}
	
	public abstract double calcPrice();

	public String getBevName()
	{
		return name;
	}
	
	/*public void setBevName(String name)
	{
		this.name = name;
	}*/

	public Type getType()
	{
		return type;
	}

	/*public void setType(Type type)
	{
		this.type = type;
	}*/

	public Size getSize()
	{
		return size;
	}

	/*public void setSize(Size size)
	{
		this.size = size;
	}*/
	
	public boolean equals(Beverage bev)
	{
		if(name.equals(bev.name) && size == bev.size && type == bev.type)
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return "\nName: " + name + "\nSize: " + size;
	}
}
