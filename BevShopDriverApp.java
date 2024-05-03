package BradleyBeverageShop;

/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: (Give a brief description for each Class)
 * Due: 05/3/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Alvin Persaud
*/

import java.util.Scanner;

public class BevShopDriverApp
{
	public static void main(String[] args)
	{
		BevShop shop = new BevShop();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Bradley Beverage Shop!\n*----------------------------------------*");
		
		String continueOrders = "y";
		String inputVal = "y";
		
		while(continueOrders.equals("y"))
		{
			
			if(inputVal.toLowerCase().equals("y") || inputVal.toLowerCase().equals("yes"))
			{
				String name = "", theDay = "";
				int age = 0, time = 0;
				Day day = null;
				
				System.out.println("Enter your name: ");
				name = sc.nextLine();
				
				inputVal = "";
				while(inputVal.equals(""))
				{
					System.out.println("Enter your age: ");
					inputVal = sc.nextLine();
					try
					{
						age = Integer.parseInt(inputVal);
					}
					catch(Exception e)
					{
						System.out.println("Invalid input! Try again: ");
						inputVal = "";
					}
				}
				while(day == null)
				{
					System.out.println("Enter the day: (sunday, monday, tuesday, wednesday, thursday, friday, saturday)");
					theDay = sc.nextLine();
					if(theDay.toLowerCase().equals("sunday"))
						day = Day.SUNDAY;
					else if(theDay.toLowerCase().equals("monday"))
						day = Day.MONDAY;
					else if(theDay.toLowerCase().equals("tuesday"))
						day = Day.TUESDAY;
					else if(theDay.toLowerCase().equals("wednesday"))
						day = Day.WEDNESDAY;
					else if(theDay.toLowerCase().equals("thursday"))
						day = Day.THURSDAY;
					else if(theDay.toLowerCase().equals("friday"))
						day = Day.FRIDAY;
					else if(theDay.toLowerCase().equals("saturday"))
						day = Day.SATURDAY;
					else
						System.out.println("Invalid day! Try again:");
				}
				while(time == 0)
				{
					inputVal = "";
					while(inputVal.equals(""))
					{
						System.out.println("Enter the time: ");
						inputVal = sc.nextLine();
						try
						{
							time = Integer.parseInt(inputVal);
							if (shop.isValidTime(time) == false)
							{
								System.out.println("Time must be between " + shop.MIN_TIME + " - " + shop.MAX_TIME);
								time = 0;
							}
						}
						catch(Exception e)
						{
							System.out.println("Invalid input! Try again: ");
							inputVal = "";
						}
					}
				}
				shop.startNewOrder(time, day, name, age);
				shop.getCurrentOrder().generateOrder();
				String continueOrdering = "y";
				while(continueOrdering.toLowerCase().equals("y") || continueOrdering.toLowerCase().equals("yes"))
				{
					String drink = "";
					while(drink.equals(""))
					{
						if(shop.isValidAge(age))
						{
							System.out.println("Would you like to order alcohol, a smoothie, or coffee?");
						}
						else
						{
							System.out.println("Would you like to order a smoothie or coffee?");
						}
						drink = sc.nextLine();
						String drinkName = "";
						String drinkSize = "";
						Size size = Size.SMALL;
						if(drink.toLowerCase().equals("alcohol"))
						{
							if(shop.getNumOfAlcoholDrink() >= shop.getMaxOrderForAlcohol())
							{
								System.out.println("You can't order more than " + shop.getMaxOrderForAlcohol() + " in one order!");
							}
							else if(shop.isValidAge(age))
							{
								System.out.println("Enter drink name:");
								drinkName = sc.nextLine();
								System.out.println("Enter drink size:");
								size = stringToSize(drinkSize);
								shop.processAlcoholOrder(drinkName, size);
							}
							else
							{
								System.out.println("You must be at least " + shop.getMinAgeForAlcohol() + " to order alcohol!");
								drink = "";
							}
						}
						else if(drink.toLowerCase().equals("smoothie"))
						{
							int numFruits = -1;
							boolean protein = false;
							System.out.println("Enter drink name:");
							drinkName = sc.nextLine();
							System.out.println("Enter drink size:");
							size = stringToSize(drinkSize);
							while(numFruits < 0)
							{
								inputVal = "";
								while(inputVal.equals(""))
								{
									System.out.println("Would you like to add fruits? Max amount of fruits for one drink is " + shop.getMaxNumOfFruits());
									inputVal = sc.nextLine();
									try
									{
										numFruits = Integer.parseInt(inputVal);
										if(numFruits < 0 || numFruits > shop.getMaxNumOfFruits())
										{
											numFruits = -1;
											System.out.println("Invalid number of fruits!");
										}
									}
									catch(Exception e)
									{
										System.out.println("Invalid input! Try again: ");
										inputVal = "";
									}
								}
							}
							inputVal = "";
							while(inputVal.equals(""))
							{
								System.out.println("Would you like to add protein? (true or false)");
								inputVal = sc.nextLine();
								try
								{
									if(inputVal.toLowerCase().equals("true") || inputVal.toLowerCase().equals("true"))
									{
										protein = Boolean.parseBoolean(inputVal);
									}
									else
									{
										System.out.println("Invalid input! Try again: ");
										inputVal = "";
									}
								}
								catch(Exception e)
								{
									System.out.println("Invalid input! Try again: ");
									inputVal = "";
								}
							}
							shop.processSmoothieOrder(drinkName, size, numFruits, protein);
						}
						else if(drink.toLowerCase().equals("coffee"))
						{
							boolean extraShot = false, extraSyrup = false;
							System.out.println("Enter drink name:");
							drinkName = sc.nextLine();
							System.out.println("Enter drink size:");
							size = stringToSize(drinkSize);
							inputVal = "";
							while(inputVal.equals(""))
							{
								System.out.println("Would you like an extra shot? (true or false)");
								inputVal = sc.nextLine();
								try
								{
									if(inputVal.toLowerCase().equals("true") || inputVal.toLowerCase().equals("true"))
									{
										extraShot = Boolean.parseBoolean(inputVal);
									}
									else
									{
										System.out.println("Invalid input! Try again: ");
										inputVal = "";
									}
								}
								catch(Exception e)
								{
									System.out.println("Invalid input! Try again: ");
									inputVal = "";
								}
							}
							inputVal = "";
							while(inputVal.equals(""))
							{
								System.out.println("Would you like extra syrup? (true or false)");
								inputVal = sc.nextLine();
								try
								{
									if(inputVal.toLowerCase().equals("true") || inputVal.toLowerCase().equals("true"))
									{
										extraSyrup = Boolean.parseBoolean(inputVal);
									}
									else
									{
										System.out.println("Invalid input! Try again: ");
										inputVal = "";
									}
								}
								catch(Exception e)
								{
									System.out.println("Invalid input! Try again: ");
									inputVal = "";
								}
							}
							shop.processCoffeeOrder(drinkName, size, extraShot, extraSyrup);
						}
						else
						{
							System.out.println("Invalid drink! Try again!");
							drink = "";
						}
					}
					inputVal = "y";
					System.out.println("Would you like to order another drink? (y or n)");
					continueOrdering = sc.nextLine();
				}
				System.out.println(shop.getCurrentOrder());
				System.out.println("Total price for this order: " + shop.getCurrentOrder().calcOrderTotal());
			}
			System.out.println("\nWould you like to start a new order? y or n");
			continueOrders = sc.nextLine();
		}
		shop.sortOrders();
		System.out.println("*----------------------------------------*\n"
				+ "Total number of orders this month " + shop.totalNumOfMonthlyOrders() + "\n" + shop);
		
	}
	
	public static Size stringToSize(String size)
	{
		size = "";
		Scanner sc = new Scanner(System.in);
		
		while(size.equals(""))
		{
			size = sc.nextLine();
			if(size.toLowerCase().equals("small"))
			{
				return Size.SMALL;
			}
			else if(size.toLowerCase().equals("medium"))
			{
				return Size.MEDIUM;
			}
			else if(size.toLowerCase().equals("large"))
			{
				return Size.LARGE;
			}
			else
			{
				System.out.println("Invalid size! Try again!");
				size = "";
			}
		}
		return Size.SMALL;
	}
}
