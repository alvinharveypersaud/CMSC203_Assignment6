package BradleyBeverageShop;

public class Customer
{
	private String name;
	private int age;
	
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public Customer(Customer c)
	{
		name = c.name;
		age = c.age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String toString()
	{
		return "Customer name: " + name + "\nCustomer age: " + age;
	}
}
