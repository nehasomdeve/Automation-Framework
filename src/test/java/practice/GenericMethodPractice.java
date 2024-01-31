package practice;

import java.io.IOException;
import java.util.Properties;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericMethodPractice {
	public static void main(String[] args) throws IOException {

		PropertyFileUtility p = new PropertyFileUtility();
		String val = p.readDataFromPropertyFile("url");
		System.out.println(val);
		

		ExcelFileUtility ex = new ExcelFileUtility();
        String value = ex.readDataFromExcel("contact", 1, 2);
		System.out.println(value);
		
		
	    JavaUtility j = new JavaUtility();
	    System.out.println(j.getSystemDate());
	
	
// addition example for generic method
	
		 int sum = add(90,50);
		 System.out.println(sum);

	}

	public static int add(int a, int b) {

		int c = a + b;
		return c;
	}
}
