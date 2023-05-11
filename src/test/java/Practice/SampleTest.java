package Practice;

import org.testng.annotations.Test;

public class SampleTest 
{

	@Test(invocationCount = 3)
	public void createcontact()
	{
		System.out.println("created");
	}
	@Test(dependsOnMethods = "createcontact")
	public void Modifycontact()
	{
		System.out.println("modified");
	}
	@Test(dependsOnMethods = "createcontact")
	public void deletecontact()
	{
		System.out.println("deleted");
	}
}
