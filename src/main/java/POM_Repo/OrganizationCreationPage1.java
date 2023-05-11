package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreationPage1 
{
   public OrganizationCreationPage1(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   //Declaration
   @FindBy(xpath="//img[@alt='Create Organization...']")
   private WebElement organizationCreateImage;
   
   @FindBy(name="accountname")
   private WebElement organizationNameTextField;
   
   @FindBy(xpath="//input[@name='button']")
   private WebElement saveButton;

//getter methods   
public WebElement getOrganizationCreateImage() 
{
	return organizationCreateImage;
}

public WebElement getOrganizationNameTextField() 
{
	return organizationNameTextField;
}

public WebElement getSaveButton() 
{
	return saveButton;
}
   
/*
 * this method is used for ClickOn + img
 */
public void clickOrganizationCreateImage()
{
	organizationCreateImage.click();
}

/*
 * This method is used to pass value to Organization TextField
 */

public void organizationNamesTextField(String orgName)
{
	organizationNameTextField.sendKeys(orgName);
}

/*
 * This method is used to Save OrgName
 */

public void saveButton()
{
	saveButton.click();
}

}
