package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import POM_Repo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
  public static WebDriver sdriver;
  public WebDriver driver;
  @BeforeSuite(groups= {"smokeTest","RegressionTest"})
  public void BS()
  {
	  System.out.println("DataConnection");
  }
  @BeforeTest(groups= {"smokeTest","RegressionTest"})
  public void BT()
  {
	  System.out.println("parallel Execution");
  }
  //@Parameters("BROWSER")
  @BeforeClass(groups= {"smokeTest","RegressionTest"})
  public void BC() throws Throwable 
 // public void BC(String BROWSER) throws Throwable 
  {
	  Property_Utility plib = new Property_Utility();
		String BROWSER = plib.getStringKeyAndValue("browser");
	  //WebDriver driver;
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		sdriver = driver;
		
		System.out.println("Launching the browser");
  }
  @BeforeMethod(groups= {"smokeTest","RegressionTest"})
  public void BM() throws Throwable
  {
	  Property_Utility plib = new Property_Utility();
		String URL = plib.getStringKeyAndValue("url");
		String USERNAME = plib.getStringKeyAndValue("username");
		String PASSWORD = plib.getStringKeyAndValue("password");
			
		driver.get(URL);
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.getWindowmax(driver);
		
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
	System.out.println("Login from Application");
  }
  @AfterMethod(groups= {"smokeTest","RegressionTest"})
  public void AM()
  {
	  System.out.println("Logout from Application");
  }
  
  @AfterClass(groups= {"smokeTest","RegressionTest"})
  public void AC()
  {
	  System.out.println("Close the browser");
  }
  @AfterTest(groups= {"smokeTest","RegressionTest"})
  public void AT()
  {
	  System.out.println("parallel Execution done");
  }
  
 @AfterSuite(groups= {"smokeTest","RegressionTest"})
  public void AS()
  {
	  System.out.println("DataBase Closed");
  }
}
