package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consist of genreic method related to property file
 * 
 * @author Neha
 *
 */
public class PropertyFileUtility {
	/**
	 * this method will read the data from property file and return the value to the caller
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
        return value;
	}

}
