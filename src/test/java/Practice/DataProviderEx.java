package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx 
{
	@Test(dataProvider="dataProviderMethod")
   public void bookTickets(String src,String dest)
   {
	   System.out.println("Book Tickets from "+src+" to "+dest);
   }
   @DataProvider
   public Object[][] dataProviderMethod()
   {
	 Object[][] obj =new Object[3][2];
	 
	 obj[0][0]="Bangalore";
	 obj[0][1]="Goa";
	 
	 obj[1][0]="Bangalore";
	 obj[1][1]="Mysuru";
	 
	 obj[2][0]="Bangalore";
	 obj[2][1]="Hyd";
	 
	return obj;
	 
	 
	 
   }
}
