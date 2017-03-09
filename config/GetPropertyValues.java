package restservice.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {

	String result="";
	InputStream inputStream;
	
	public Properties getPropValues(String fileName) throws IOException {
		
		Properties prop = new Properties();
		
		try {
			
			//String propFileName = "config.properties";
 
			//inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			InputStream inputStream = new FileInputStream(fileName);
			 
			if (inputStream != null) {
				prop.load(inputStream);
			}
			
} catch (Exception e) {
	System.out.println("Exception: " + e);
} 
		return prop;
		
	}
}
