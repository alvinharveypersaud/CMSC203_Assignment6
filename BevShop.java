package BradleyBeverageShop;

import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface
{
	int MIN_AGE_FOR_ALCOHOL = 21;
	int MAX_ORDER_FOR_ALCOHOL= 3;
	int MIN_TIME= 8;
	int MAX_TIME= 23;
	int MAX_FRUIT = 5;
	private ArrayList<Order> orders = new ArrayList();

	@Override
	public boolean isValidTime(int time)
	{
		if(time >= MIN_TIME && time <= MAX_TIME)
		{
			return true;
		}
		return false;
	}

	@Override
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits)
	{
		if(numOfFruits > MAX_FRUIT)
		{
			return true;
		}
		return false;
	}

	@Override
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	@Override
	public boolean isEligibleForMore()
	{
		if(getNumOfAlcoholDrink() < MAX_ORDER_FOR_ALCOHOL)
		{
			return true;
		}
		return false;
	}

	@Override
	public int getNumOfAlcoholDrink()
	{
		int num = 0;
		for(int i = 0; i < orders.get(orders.size()-1).getTotalItems(); i++)
		{
			if(orders.get(orders.size()-1).getBeverage(i).getType() == Type.ALCOHOL)
			{
				num++;
			}
		}
		return num;
	}

	@Override
	public boolean isValidAge(int age)
	{
		if(age >= MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		return false;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge)
	{
		Customer cust = new Customer(customerName, customerAge);
		Order ord = new Order(time, day, cust);
		orders.add(ord);
		
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		orders.get(orders.size()-1).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size)
	{
		orders.get(orders.size()-1).addNewBeverage(bevName, size);
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		orders.get(orders.size()-1).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	@Override
	public int findOrder(int orderNo)
	{
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getOrderNumber() == orderNo)
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo)
	{
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getOrderNumber() == orderNo)
			{
				return orders.get(i).calcOrderTotal();
			}
		}
		return -1;
	}

	@Override
	public double totalMonthlySale()
	{
		double sales = 0.0;
		for(int i = 0; i < orders.size(); i++)
		{
			sales += orders.get(i).calcOrderTotal();
		}
		return sales;
	}

	@Override
	public int totalNumOfMonthlyOrders()
	{
		return orders.size();
	}

	@Override
	public Order getCurrentOrder()
	{
		return orders.get(orders.size()-1);
	}

	@Override
	public Order getOrderAtIndex(int index)
	{
		return orders.get(index);
	}

	@Override
	public void sortOrders()
	{
        for (int i = 0; i < orders.size()-1; i++)
        {
            int min = i;
            for (int j = i+1; j < orders.size(); j++)
            {
                if (orders.get(j).getOrderNumber() < orders.get(min).getOrderNumber())
                {
                    min = j;
                }
            }
            Collections.swap(orders, i, min);
        }
	}
	
	public String toString()
	{
		String orderList = "";
		for(int i = 0; i < orders.size(); i++)
		{
			orderList += orders.get(i).toString();
		}
		return "List of orders: " + orderList + "\nTotal monthly sales: " + totalMonthlySale();
	}
}
