package Generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility {
    public String getStringKeyAndValue(String Key) throws Throwable
    {
    	//FileInputStream fis = new FileInputStream("C:\\Users\\chaya\\OneDrive\\Documents\\commondata.properties");
    	FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
    }
}
