package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {

	@Test (retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void sample() {// script is passed so retryanalyser doesnt come into picture so for that ewe have to fail the script
		
		Assert.fail();
		
	System.out.println("hi");	
	
	}
	
	
	
	
	
}
