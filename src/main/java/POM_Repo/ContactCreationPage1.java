package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactCreationPage1 
{
	public ContactCreationPage1(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
	
	   //Declaration
	   @FindBy(xpath="//img[@alt='Create Contact...']")
	   private WebElement ContactCreateImage;
	   
	   @FindBy(name="lastname")
	   private WebElement ContactNameTextField;
	   
	   @FindBy(xpath="//input[@type='submit']")
	   private WebElement saveButton;

	public WebElement getContactCreateImage() {
		return ContactCreateImage;
	}

	public WebElement getContactNameTextField() {
		return ContactNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	/*
	 * this method is used for ClickOn + img   
	 */
	public void clickContactCreateImage()
	{
		ContactCreateImage.click();
	}
	
	/*
	 * This method is used to pass value to Contact TextField
	 */
	public void ContactNamesTextField(String ConName)
	{
		ContactNameTextField.sendKeys(ConName);
	}
	
	/*
	 * This method is used to Save ConName
	 */
	public void saveButton()
	{
		saveButton.click();
	}
	   
}
