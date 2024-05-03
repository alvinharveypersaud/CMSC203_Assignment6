package BradleyBeverageShop;

import java.util.ArrayList;

public class Order implements OrderInterface, Comparable
{
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> list;
	private int orderNum;
	
	public Order(int orderTime, Day orderDay, Customer cust)
	{
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = new Customer(cust);
		list = new ArrayList<Beverage>();
	}
	
	public void generateOrder()
	{
		orderNum = (int)((Math.random()*80000)+10000);
	}
	
	public Day getDay()
	{
		return orderDay;
	}
	
	public Day getOrderDay()
	{
		return orderDay;
	}
	
	public int getOrderTime()
	{
		return orderTime;
	}
	
	@Override
	public int compareTo(Object o)
	{
		Order ord = (Order)o;
		return Integer.compare(orderNum, ord.orderNum);
	}

	@Override
	public boolean isWeekend()
	{
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
		{
			return true;
		}
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo)
	{
		try
		{
			return list.get(itemNo);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		Coffee bev = new Coffee(bevName, size, extraShot, extraSyrup);
		list.add(bev);
	}

	@Override
	public void addNewBeverage(String bevName, Size size)
	{
		Alcohol bev = new Alcohol(bevName, size, isWeekend());
		list.add(bev);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		Smoothie bev = new Smoothie(bevName, size, numOfFruits, addProtein);
		list.add(bev);
	}

	@Override
	public double calcOrderTotal()
	{
		double total = 0.0;
		for(int i = 0; i < list.size(); i++)
		{
			total += list.get(i).calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type)
	{
		int num = 0;
		for(Beverage bev : list)
		{
			if(bev.getType() == type)
			{
				num++;
			}
		}
		return num;
	}
	
	public int getTotalItems()
	{
		return list.size();
	}
	
	public int getOrderNumber()
	{
		return orderNum;
	}
	
	public void setOrderNumber(int orderNum)
	{
		this.orderNum = orderNum; 
	}

	public String toString()
	{
		String bevList = "";
		for(int i = 0; i < list.size(); i++)
		{
			bevList += list.get(i).toString();
		}
		return "\nOrder number: " + orderNum + "\nTime: " + orderTime + "\nDay: " + orderDay + "\n"
				+ cust.toString() + "\nList of beverages: " + bevList + "---------------------";
	}
}
