package BradleyBeverageShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent
{
	Coffee cof1, cof2, cof3, cof4;

	@BeforeEach
	void setUp() throws Exception
	{
		cof1 = new Coffee("coffee", Size.SMALL, false, false);
		cof2 = new Coffee("espresso", Size.MEDIUM, false, true);
		cof3 = new Coffee("cappucino", Size.LARGE, true, true);
		cof4 = new Coffee("espresso", Size.MEDIUM, false, true);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		cof1 = cof2 = cof3 = cof4 = null;
	}

	@Test
	void testGetExtraShot()
	{
		assertFalse(cof1.getExtraShot());
		assertFalse(cof2.getExtraShot());
		assertTrue(cof3.getExtraShot());
	}
	
	@Test
	void testGetExtraSyrup()
	{
		assertFalse(cof1.getExtraSyrup());
		assertTrue(cof2.getExtraSyrup());
		assertTrue(cof3.getExtraSyrup());
	}
	
	@Test
	void testEquals()
	{
		assertFalse(cof1.equals(cof2));
		assertFalse(cof2.equals(cof3));
		assertFalse(cof1.equals(cof3));
		assertFalse(cof3.equals(cof4));
		assertTrue(cof2.equals(cof4));
	}
	
	@Test
	void testCalcPrice()
	{
		assertEquals(2.0, cof1.calcPrice());
		assertEquals(3.0, cof2.calcPrice());
		assertEquals(4.0, cof3.calcPrice());
	}

}
