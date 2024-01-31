package genericUtilities;

import java.util.Date;

/**
 * this class consist of Generic methods related to java
 * @author ASUS
 *
 */
public class JavaUtility {
	/**
	 * this method will capture the system date in required format
	 * @return
	 */
	public String getSystemDate() {
        Date d = new Date();
      String[] dArr = d.toString().split(" ");
      String date = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+"_"+dArr[3].replace(":", "-");
      return date;
        
	}

}
