package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class will provide implementation to IRetryAnalyser Interface of testNG
 * @author ASUS
 *
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer{
           int count = 0;
           int retryCount =3; // from  manual analysis we got this number 
	public boolean retry(ITestResult result) {
		     //  0<3 1<3 2<3 3<3-no (so it will come out of the loop and return false means it will stop retrying)
		while(count < retryCount) {
			
			count ++; //1 2 3
			return true; // retry retry retry
		}
		
		return false; // means stop the retry process so make it true we will write java logic 
	}
	
	

}
