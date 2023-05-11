package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationPage1 
{
	public ProductCreationPage1(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
	
	  //Declaration
	   @FindBy(xpath="//img[@alt='Create Product...']")
	   private WebElement ProductCreateImage;
	   
	   @FindBy(name="productname")
	   private WebElement ProductNameTextField;
	   
	   
	   @FindBy(xpath="//input[@type='submit']")
	   private WebElement saveButton;

   //getter methods
	public WebElement getProductCreateImage() {
		return ProductCreateImage;
	}


	public WebElement getProductNameTextField() {
		return ProductNameTextField;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/*
	 * this method is used for ClickOn + img   
	 */
	public void clickProductCreateImage()
	{
		ProductCreateImage.click();
	}
	
	/*
	 * This method is used to pass value to Product TextField
	 */
	public void ProductNamesTextField(String ProName)
	{
		ProductNameTextField.sendKeys(ProName);
	}
	
	/*
	 * This method is used to Save ProName
	 */
	public void saveButton()
	{
		saveButton.click();
	}
	   
	   
}
