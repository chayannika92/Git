
package Practice;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.ContactCreationPage1;
public class CreateContact extends BaseClass {

	@Test
	public void createContact() throws Throwable 
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		driver.findElement(By.linkText("Contacts")).click();
		
		ContactCreationPage1 con = new ContactCreationPage1(driver);
		con.clickContactCreateImage();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String ExcelData = elib.getExcelData("Contact", 0, 0)+ranNum;

		con.ContactNamesTextField(ExcelData);
		con.saveButton();
		
		String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if((actData).contains(ExcelData))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
			
		}
		wlib.signout(driver);
	}

}
