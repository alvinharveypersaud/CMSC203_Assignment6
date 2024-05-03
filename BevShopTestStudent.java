package BradleyBeverageShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BevShopTestStudent
{
	BevShop shop;

	@BeforeEach
	public void setUp() throws Exception
	{
		shop = new BevShop();
		shop.startNewOrder(8, Day.MONDAY, "Alvin", 18);
		shop.processCoffeeOrder("coffee", Size.SMALL, false, false);
		shop.processSmoothieOrder("smoothie", Size.MEDIUM, 4, true);
		shop.startNewOrder(10, Day.WEDNESDAY, "John", 21);
		shop.processSmoothieOrder("smoothie", Size.LARGE, 2, true);
		shop.processCoffeeOrder("coffee", Size.SMALL, true, true);
		shop.startNewOrder(14, Day.SATURDAY, "Eric", 40);
		shop.processAlcoholOrder("alcohol", Size.MEDIUM);
		shop.processSmoothieOrder("smoothie", Size.SMALL, 4, false);
	}

	@AfterEach
	public void tearDown() throws Exception
	{
		shop = null;
	}

	@Test
	public void testIsValidTime()
	{
		assertTrue(shop.isValidTime(10));
		assertFalse(shop.isValidTime(6));
	}

	@Test
	public void testGetMaxNumOfFruits()
	{
		assertEquals(5, shop.getMaxNumOfFruits());
	}
	
	@Test
	public void testGetMinAgeForAlcohol()
	{
		assertEquals(21, shop.getMinAgeForAlcohol());
	}
	
	@Test
	public void testIsMaxFruit()
	{
		assertTrue(shop.isMaxFruit(6));
		assertFalse(shop.isMaxFruit(4));
	}
	
	@Test
	public void testGetMaxOrderForAlcohol()
	{
		assertEquals(3, shop.getMaxOrderForAlcohol());
	}
	
	@Test
	public void testGetNumOfAlcoholDrink()
	{
		assertEquals(1, shop.getNumOfAlcoholDrink());
		shop.processAlcoholOrder("alcohol", Size.LARGE);
		shop.processSmoothieOrder("smoothie", Size.SMALL, 0, false);
		shop.processAlcoholOrder("alcohol", Size.SMALL);
		assertEquals(3, shop.getNumOfAlcoholDrink());
	}
	
	@Test
	public void testIsValidAge()
	{
		assertTrue(shop.isValidAge(21));
		assertFalse(shop.isValidAge(18));
	}
	
	@Test
	public void testStartNewOrder()
	{
		shop.startNewOrder(20, Day.FRIDAY, "pete", 22);
		assertTrue(shop.getCurrentOrder().getOrderDay() == Day.FRIDAY);
	}
	
	@Test
	public void testProcessCoffeeOrder()
	{
		shop.processCoffeeOrder("covfefe", Size.LARGE, true, true);
		assertTrue(shop.getCurrentOrder().getBeverage(shop.getCurrentOrder().getTotalItems()-1).getType() == Type.COFFEE);
	}
	
	@Test
	public void testProcessAlcoholOrder()
	{
		shop.processAlcoholOrder("alc", Size.SMALL);
		assertTrue(shop.getCurrentOrder().getBeverage(shop.getCurrentOrder().getTotalItems()-1).getType() == Type.ALCOHOL);
	}
	
	@Test
	public void testProcessSmoothieOrder()
	{
		shop.processSmoothieOrder("smooth", Size.MEDIUM, 1, true);
		assertTrue(shop.getCurrentOrder().getBeverage(shop.getCurrentOrder().getTotalItems()-1).getType() == Type.SMOOTHIE);
	}
	
	@Test
	public void testFindOrder()
	{
		shop.getCurrentOrder().setOrderNumber(15000);
		assertEquals(2, shop.findOrder(15000));
	}
	
	@Test
	public void testTotalOrderPrice()
	{
		shop.getCurrentOrder().setOrderNumber(15000);
		assertEquals(7.1, shop.totalOrderPrice(15000));
		shop.processAlcoholOrder("alcohol", Size.LARGE);
		shop.processSmoothieOrder("smoothie", Size.SMALL, 0, false);
		shop.processCoffeeOrder("covfefe", Size.SMALL, true, true);
		assertEquals(15.7, shop.totalOrderPrice(15000));
	}
	
	@Test
	public void testTotalMonthlySale()
	{
		assertEquals(23.6, shop.totalMonthlySale());
	}
	
	@Test
	public void testTotalNumOfMonthlyOrders()
	{
		assertEquals(3, shop.totalNumOfMonthlyOrders());
	}
	
	@Test
	public void testGetOrderAtIndex()
	{
		assertTrue(shop.getOrderAtIndex(0).getDay() == Day.MONDAY);
		assertTrue(shop.getOrderAtIndex(1).getDay() == Day.WEDNESDAY);
		assertTrue(shop.getOrderAtIndex(2).getDay() == Day.SATURDAY);
	}
	
	@Test
	public void testSortOrders()
	{
		shop.getOrderAtIndex(0).setOrderNumber(25000);
		shop.getOrderAtIndex(1).setOrderNumber(15000);
		shop.getOrderAtIndex(2).setOrderNumber(16000);
		
		shop.sortOrders();
		
		assertTrue(shop.getOrderAtIndex(0).getDay() == Day.WEDNESDAY);
		assertTrue(shop.getOrderAtIndex(1).getDay() == Day.SATURDAY);
		assertTrue(shop.getOrderAtIndex(2).getDay() == Day.MONDAY);
		
		shop.startNewOrder(20, Day.FRIDAY, "pete", 22);
		shop.getOrderAtIndex(3).setOrderNumber(20000);
		
		shop.sortOrders();
		
		assertTrue(shop.getOrderAtIndex(0).getDay() == Day.WEDNESDAY);
		assertTrue(shop.getOrderAtIndex(1).getDay() == Day.SATURDAY);
		assertTrue(shop.getOrderAtIndex(2).getDay() == Day.FRIDAY);
		assertTrue(shop.getOrderAtIndex(3).getDay() == Day.MONDAY);
	}
}
