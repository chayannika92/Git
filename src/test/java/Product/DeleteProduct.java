package Product;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProduct {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\chaya\\Downloads\\commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		
		FileInputStream fes=new FileInputStream("C:\\Users\\chaya\\Downloads\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String productName = cel.getStringCellValue()+ranNum;
		
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
        driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+productName+"']/../preceding-sibling::td[2]")).click();
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        Alert alt = driver.switchTo().alert();
        alt.accept();
    
       List<WebElement> Lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
        
        boolean flag=false;
        for(WebElement wb:Lists)
        {
        	String act = wb.getText();
        	if(act.contains(productName))
        	{
        		flag=true;
        		break;
        	}
        	}
        if(flag)
        {
        	System.out.println("deleted");
        	 }
        else
        {
        	System.out.println("not deleted");
        }

	}

}
