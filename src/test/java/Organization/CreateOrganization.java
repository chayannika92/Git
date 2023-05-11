package Organization;
import org.openqa.selenium.By;
import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import POM_Repo.HomePage;
import POM_Repo.OrganizationCreationPage1;
import POM_Repo.ValidationAndVerificationPage;

//@Listeners(Generic_Utility.ListenersImpl.class)
public class CreateOrganization extends BaseClass {

	@Test(retryAnalyzer=Generic_Utility.RetryAnalyzerImple.class)
	//@Test(groups= {"smokeTest","RegressionTest"})
	public  void createOrganization() throws Throwable 
	{
		HomePage home = new HomePage(driver);
		home.organizationLinkClick();
		
		OrganizationCreationPage1 org = new OrganizationCreationPage1(driver);
		org.clickOrganizationCreateImage();
		Assert.assertEquals(false, true);
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String ExcelData = elib.getExcelData("Organization", 0, 0)+ranNum;
		//String phoneNum = elib.getExcelUsingDataFormatter("Organization", 2, 0)+ranNum;
		
		org.organizationNamesTextField(ExcelData);
		//driver.findElement(By.id("phone")).sendKeys(phoneNum);
		org.saveButton();
        Thread.sleep(3000);
        ValidationAndVerificationPage validate = new ValidationAndVerificationPage(driver);
        validate.organisationValidation(driver, ExcelData);
		String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
       // String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		System.out.println(actData);
		Assert.assertEquals(actData, ExcelData);
		/*if((actData).contains(ExcelData))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
			
		}*/
		
	}

}
