package BradleyBeverageShop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent
{

	Order orderOne, orderTwo, orderThree, orderFour;

	@BeforeEach
	public void setUp() throws Exception
	{
		orderOne = new Order(8, Day.MONDAY, new Customer("Alvin", 18));
		orderTwo = new Order(10, Day.WEDNESDAY, new Customer("John", 21));
		orderThree = new Order(14, Day.SATURDAY, new Customer("Eric", 40));
	}

	@AfterEach
	public void tearDown() throws Exception
	{
		orderOne = orderTwo = orderThree = null;
	}

	@Test
	public void testCompareTo()
	{
		orderOne.setOrderNumber(12000);
		orderTwo.setOrderNumber(13000);
		orderThree.setOrderNumber(12000);
		
		assertTrue(orderOne.compareTo(orderTwo) < 0);
		assertTrue(orderTwo.compareTo(orderOne) > 0);
		assertTrue(orderOne.compareTo(orderThree) == 0); 
	}
	
	@Test
	public void isWeekend()
	{
		assertFalse(orderOne.isWeekend());
		assertFalse(orderTwo.isWeekend());
		assertTrue(orderThree.isWeekend());
	}
	
	@Test
	public void testGetBeverage()
	{
		orderTwo.addNewBeverage("alcohol", Size.SMALL);
		assertTrue(orderTwo.getBeverage(0).getType() == Type.ALCOHOL);
		orderTwo.addNewBeverage("coffee", Size.SMALL, false, false);
		assertTrue(orderTwo.getBeverage(1).getType() == Type.COFFEE);
		orderTwo.addNewBeverage("smoothie", Size.SMALL, 0, false);
		assertTrue(orderTwo.getBeverage(2).getType() == Type.SMOOTHIE);
	}

	@Test
	public void testAddNewBeverage() throws NullPointerException
	{
		orderTwo.addNewBeverage("alcohol", Size.SMALL);
		assertTrue(orderTwo.getBeverage(0).getType() == Type.ALCOHOL);
		orderTwo.addNewBeverage("coffee", Size.SMALL, false, false);
		assertTrue(orderTwo.getBeverage(1).getType() == Type.COFFEE);
		orderTwo.addNewBeverage("smoothie", Size.SMALL, 0, false);
		assertTrue(orderTwo.getBeverage(2).getType() == Type.SMOOTHIE);
	}

	@Test
	public void testCalcOrderTotal()
	{
		orderTwo.addNewBeverage("alcohol", Size.LARGE);
		orderTwo.addNewBeverage("coffee", Size.SMALL, true, false);
		orderTwo.addNewBeverage("smoothie", Size.MEDIUM, 4, true);
		assertEquals(11.5, orderTwo.calcOrderTotal(), .01);
	}

	@Test
	public void testFindNumOfBevType()
	{
		orderThree.addNewBeverage("coffee", Size.SMALL, false, false);
		orderThree.addNewBeverage("coffee", Size.MEDIUM, true, false);
		orderThree.addNewBeverage("smoothie", Size.LARGE, 2, true);
		orderThree.addNewBeverage("coffee", Size.SMALL, true, true);
		orderThree.addNewBeverage("alcohol", Size.MEDIUM);
		orderThree.addNewBeverage("smoothie", Size.SMALL, 4, false);
		
		assertEquals(3, orderThree.findNumOfBeveType(Type.COFFEE));
		assertEquals(2, orderThree.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(1, orderThree.findNumOfBeveType(Type.ALCOHOL));
	}
	
	@Test
	public void testGetTotalItems()
	{
		orderThree.addNewBeverage("coffee", Size.SMALL, false, false);
		orderThree.addNewBeverage("coffee", Size.MEDIUM, true, false);
		orderThree.addNewBeverage("smoothie", Size.LARGE, 2, true);
		orderThree.addNewBeverage("coffee", Size.SMALL, true, true);
		orderThree.addNewBeverage("alcohol", Size.MEDIUM);
		orderThree.addNewBeverage("smoothie", Size.SMALL, 4, false);
		
		assertEquals(6, orderThree.getTotalItems());
	}
	
	@Test
	public void testGenerateOrder()
	{
		orderOne.generateOrder();
		if(orderOne.getOrderNumber() > 90000 || orderOne.getOrderNumber() < 10000)
		{
			fail("Test failed!");
		}
	}
	
	@Test
	public void testGetDay()
	{
		assertEquals(Day.MONDAY, orderOne.getDay());
		assertEquals(Day.WEDNESDAY, orderTwo.getDay());
		assertEquals(Day.SATURDAY, orderThree.getDay());
	}
	
	@Test
	public void testGetOrderDay()
	{
		assertEquals(Day.MONDAY, orderOne.getOrderDay());
		assertEquals(Day.WEDNESDAY, orderTwo.getOrderDay());
		assertEquals(Day.SATURDAY, orderThree.getOrderDay());
	}
	
	@Test
	public void testGetOrderTime()
	{
		assertEquals(8, orderOne.getOrderTime());
		assertEquals(10, orderTwo.getOrderTime());
		assertEquals(14, orderThree.getOrderTime());
	}
	
	@Test
	public void testGetOrderNumber()
	{
		orderOne.setOrderNumber(12000);
		orderTwo.setOrderNumber(13000);
		orderThree.setOrderNumber(14000);
		
		assertEquals(12000, orderOne.getOrderNumber());
		assertEquals(13000, orderTwo.getOrderNumber());
		assertEquals(14000, orderThree.getOrderNumber());
	}
	
	
}
