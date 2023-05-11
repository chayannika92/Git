package Campaign;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.HomePage;
import POM_Repo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampWithProduct extends BaseClass {
 
	@Test
	public void createcampwithproduct() throws Throwable {
		WebDriver driver;
		Property_Utility plib = new Property_Utility();
		String BROWSER = plib.getStringKeyAndValue("browser");
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
		else
		{
			driver = new FirefoxDriver();
		}
		String URL = plib.getStringKeyAndValue("url");
		String USERNAME = plib.getStringKeyAndValue("username");
		String PASSWORD = plib.getStringKeyAndValue("password");
		driver.get(URL);
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.getWindowmax(driver);
		
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		FileInputStream fes = new FileInputStream("C:\\Users\\chaya\\Downloads\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String ProductName = cel.getStringCellValue()+ranNum;
		

		driver.findElement(By.name("productname")).sendKeys(ProductName);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
		home.moreLink(driver);
		home.campaignLinkText();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		
		FileInputStream fes1 = new FileInputStream("C:\\Users\\chaya\\Downloads\\TestData.xlsx");
		Workbook book1 = WorkbookFactory.create(fes1);
		Sheet sheet1 = book1.getSheet("Campaign");
		Row row1 = sheet1.getRow(0);
		Cell cel1 = row1.getCell(0);
		String excelData = cel1.getStringCellValue()+ranNum;
		
		
		driver.findElement(By.name("campaignname")).sendKeys(excelData);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Thread.sleep(3000);
		
		wlib.switchingWindow(driver, "Products&action");
		driver.findElement(By.name("search_text")).sendKeys(ProductName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
		
		wlib.switchingWindow(driver, "Campaigns&action");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
        String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if((actData).contains(excelData))
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


