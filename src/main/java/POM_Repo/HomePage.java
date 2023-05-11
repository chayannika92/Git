package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class HomePage 
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLinkText;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLinkText;
	

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}
	
	public void organizationLinkClick()
	{
		OrganizationLink.click();	
	}
	
	
	public WebElement getProductLinkText() 
	{
		return productLinkText;
	}

	public WebElement getMorelink() 
	{
		
		return morelink;
	}

	public WebElement getCampaignsLinkText() 
	{
				return campaignsLinkText;
	}

	public void moreLink(WebDriver driver)
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.mouseOverOnElement(driver, morelink);
	}
	
	public void campaignLinkText()
	{
		campaignsLinkText.click();
	}

	public void clickProductLink()
	{
		productLinkText.click();
	}
	
}
