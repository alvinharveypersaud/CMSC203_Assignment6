package BradleyBeverageShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent
{
	Smoothie sm1, sm2, sm3, sm4;

	@BeforeEach
	void setUp() throws Exception
	{
		sm1 = new Smoothie("mango", Size.SMALL, 0, false);
		sm2 = new Smoothie("strawberry", Size.MEDIUM, 2, false);
		sm3 = new Smoothie("banana", Size.LARGE, 4, true);
		sm4 = new Smoothie("mango", Size.SMALL, 0, false);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		sm1 = sm2 = sm3 = sm4 = null;
	}

	@Test
	void testCalcPrice()
	{
		assertEquals(2.0, sm1.calcPrice());
		assertEquals(3.5, sm2.calcPrice());
		assertEquals(6.5, sm3.calcPrice());
	}
	
	@Test
	void testGetNumFruit()
	{
		assertEquals(0, sm1.getNumFruits());
		assertEquals(2, sm2.getNumFruits());
		assertEquals(4, sm3.getNumFruits());
	}
	
	@Test
	void testGetAddProtein()
	{
		assertFalse(sm1.getAddProtein());
		assertFalse(sm2.getAddProtein());
		assertTrue(sm3.getAddProtein());
	}
	
	@Test
	void testEquals()
	{
		assertFalse(sm1.equals(sm2));
		assertFalse(sm2.equals(sm3));
		assertTrue(sm1.equals(sm4));
	}
}
