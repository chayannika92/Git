package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreationPage1 
{
	public CampaignCreationPage1(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
	
	   //Declaration
	   @FindBy(xpath="//img[@alt='Create Campaign...']")
	   private WebElement CampaignCreateImage;
	   
	   @FindBy(name="campaignname")
	   private WebElement CampaignNameTextField;
	   
	   @FindBy(xpath="//input[@type='submit']")
	   private WebElement saveButton;

	public WebElement getCampaignCreateImage() {
		return CampaignCreateImage;
	}

	public WebElement getCampaignNameTextField() {
		return CampaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
   
	/*
	 * this method is used for ClickOn + img   
	 */
	public void clickCampaignCreateImage()
	{
		CampaignCreateImage.click();
	}
	
	/*
	 * This method is used to pass value to Campaign TextField
	 */
	public void CampaignNamesTextField(String CampName)
	{
		CampaignNameTextField.sendKeys(CampName);
	}
	
	/*
	 * This method is used to Save CampName
	 */
	public void saveButton()
	{
		saveButton.click();
	}
	   
}
