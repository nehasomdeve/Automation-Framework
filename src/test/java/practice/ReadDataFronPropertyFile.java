package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFronPropertyFile {
	public static void main(String[] args) throws IOException {
		// step 1 : open the doc in java readable formate
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		
		// step 2 : create the object of properties from java.util
                    Properties p = new Properties();
		
		
		//Step: 3 load fis to the properties class 
                    p.load(fis);
		
		
		//step4: provide the key and read the value
                  String value = p.getProperty("url");
                  System.out.println(value);
		
		
		
		
		
	}

}
