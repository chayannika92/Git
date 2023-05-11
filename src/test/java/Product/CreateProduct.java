package Product;
import org.testng.annotations.Test;
import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import POM_Repo.HomePage;
import POM_Repo.ProductCreationPage1;

public class CreateProduct extends BaseClass {
    
	@Test(groups="smokeTest")
	public void createProduct() throws Throwable 
	{
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
		ProductCreationPage1 pro = new ProductCreationPage1(driver);
		pro.clickProductCreateImage();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String ExcelData = elib.getExcelData("Product", 0, 0)+ranNum;
		
		pro.ProductNamesTextField(ExcelData);
		pro.saveButton();
	}

}
