package Generic_Utility;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
public class WebDriver_Utility 
{
	
	public void getWindowmax(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
     /**
      * used to switch to any window based on window title
      * @param driver
      * @param PartialText
      */
     public void switchingWindow(WebDriver driver, String PartialText)
     {
    	 Set<String> allWin = driver.getWindowHandles();
 		Iterator<String> id = allWin.iterator();
 		while(id.hasNext())
 		{
 			String wid = id.next();
 			driver.switchTo().window(wid);
 			String title = driver.getTitle();
 			if(title.contains(PartialText))
 			{
 				break;
 			}		
 		}
     }
     
     public void Alertaccept(WebDriver driver)
     {
    	 Alert a = driver.switchTo().alert();
 		 a.accept();
     }
     
     public void AlertDismiss(WebDriver driver)
     {
    	 Alert a = driver.switchTo().alert();
 		 a.dismiss();
     }
     
     public void signout(WebDriver driver)
     {
    	WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 		Actions act = new Actions(driver);
 		act.moveToElement(data).perform();
 		driver.findElement(By.linkText("Sign Out")).click();
     }
     
     /**
      * used to switch to frame window based on Index
      * @param driver
      * @param index
      */
     public void switchToFrame(WebDriver driver, int index)
     {
         driver.switchTo().frame(index);	 
     }
     
     /**
      * used to switch to frame window based on id or name attribute
      * @param driver
      * @param id_name_attribute
      */
     public void switchToFrame(WebDriver driver, String id_name_attribute)
     {
    	 driver.switchTo().frame(id_name_attribute);
     }
     
     /**
      * used to select the value from dropDown based on index
      * @param element
      * @param index
      */
     public void select(WebElement element, int index)
     {
    	 
    	 Select sel = new Select(element);
    	 sel.selectByIndex(index);
     }
     
     /**
      * used to select the value from dropDown based on text
      * @param element
      * @param text
      */
     public void select(WebElement element, String text)
     {
    	 Select sel = new Select(element);
    	 sel.selectByVisibleText(text);
     }
     
     
     /**
      * used to place mouse cursor on specified element
      * @param driver
      * @param element
      */
     public void mouseOverOnElement(WebDriver driver, WebElement element)
     {
    	 Actions act = new Actions(driver);
    	 act.moveToElement(element).perform();
     }
     
     /**
      * used to right click on specific element
      * @param driver
      * @param element
      */
     public void rightClickOnElement(WebDriver driver, WebElement element)
     {
    	 Actions act = new Actions(driver);
    	 act.contextClick(element).perform();
     }
     
     
     public void moveByOffset(WebDriver driver, int x , int y)
     {
    	 Actions act = new Actions(driver);
    	 act.moveByOffset(x, y).click().perform();
     }
     
     public String takeScreenshot(WebDriver driver, String methodname)
     
     {
    	 Date date = new Date();
    	 date.toString().replace("   ", "    ").replace(":", "-");
    	 //TakesScreenshot ts = (TakesScreenshot)driver;
		return null;
    	 
     }
     
     /**
      * wait for page to load before identifying any synchronized element in POM
      * @param driver
      */
     public void waitforPageToLoad(WebDriver driver)
     {
    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
     
     
     /**
      * After every action it will for next action to perform
      * @param driver
      */
     public void scriptTimeOut(WebDriver driver)
     {
    	 driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
     }
     
     
     /**
      * used to wait for element to be clickable in GUI and Check for specific element for every 500 milliseconds
      * @param driver
      * @param Element
      * @param pollingTime
      */
     public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement Element, int pollingTime)
     {
    	 FluentWait wait = new FluentWait(driver);
    	 wait.pollingEvery(Duration.ofSeconds(20));
    	 wait.until(ExpectedConditions.elementToBeClickable(Element));
     }
}
