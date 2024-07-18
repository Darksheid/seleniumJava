package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class configurations {

	public static String getValue(String key) throws Throwable {
		Properties prop = new Properties();
		String fileName = "prop.config";
		try (FileInputStream fis = new FileInputStream(fileName)) {
		    prop.load(fis);
		} catch (FileNotFoundException ex) {
		     ex.printStackTrace();
		     System.out.println("Config file not found");
		}
		return prop.getProperty(key).toString().trim();
	}
	
	
}
