package BradleyBeverageShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent
{
	Alcohol alc1, alc2, alc3, alc4, alc5;
	
	@BeforeEach
	void setUp() throws Exception
	{
		alc1 = new Alcohol("beer", Size.SMALL, false);
		alc2 = new Alcohol("whiskey", Size.MEDIUM, false);
		alc3 = new Alcohol("wine", Size.LARGE, true);
		alc4 = new Alcohol("wine", Size.LARGE, true);
		alc5 = new Alcohol("water", Size.LARGE, true);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		alc1 = alc2 = alc3 = alc4 = null;
	}

	@Test
	void testIsWeekend()
	{
		assertFalse(alc1.isWeekend());
		assertFalse(alc2.isWeekend());
		assertTrue(alc3.isWeekend());
	}
	
	@Test
	void testEquals()
	{
		assertFalse(alc1.equals(alc2));
		assertTrue(alc3.equals(alc4));
		assertFalse(alc3.equals(alc5));
	}
	
	@Test
	void testCalcPrice()
	{
		assertEquals(2.0, alc1.calcPrice());
		assertEquals(2.5, alc2.calcPrice());
		assertEquals(3.6, alc3.calcPrice());
	}

}
