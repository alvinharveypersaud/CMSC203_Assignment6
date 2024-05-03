package BradleyBeverageShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent
{
	Customer cust;

	@BeforeEach
	void setUp() throws Exception
	{
		cust = new Customer("Alvin", 18);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		cust = null;
	}

	@Test
	void testGetName()
	{
		assertEquals("Alvin", cust.getName());
	}
	
	@Test
	void testGetAge()
	{
		assertEquals(18, cust.getAge());
	}
	
	@Test
	void testSetName()
	{
		cust.setName("name");
		assertEquals("name", cust.getName());
	}
	
	@Test
	void testSetAge()
	{
		cust.setAge(21);
		assertEquals(21, cust.getAge());
	}

}
