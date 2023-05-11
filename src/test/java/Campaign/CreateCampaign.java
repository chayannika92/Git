package Campaign;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.CampaignCreationPage1;
import POM_Repo.HomePage;


public class CreateCampaign extends BaseClass 
{
    @Test(groups="RegressionTest")
	public  void createCampaign() throws Throwable {
    	
    	WebDriver_Utility wlib = new WebDriver_Utility();
		HomePage home = new HomePage(driver);
		home.moreLink(driver);
		home.campaignLinkText();
		CampaignCreationPage1 camp = new CampaignCreationPage1(driver);
		camp.clickCampaignCreateImage();
	
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String ExcelData = elib.getExcelData("Campaign", 0, 0)+ranNum;
		
		camp.CampaignNamesTextField(ExcelData);
		camp.saveButton();
		
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
