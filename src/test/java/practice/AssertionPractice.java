package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	@Test
	public void sample() {//hard assert
		String a = "neha ";
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertTrue(a.contains("7"));
		//Assert.assertEquals(0, 1);//fail
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		System.out.println("Step 5");
		
	}
	@Test
	public void sample1() {// soft assert
		
		SoftAssert sa = new SoftAssert();
		
		String a = "neha ";
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		//sa.assertTrue(a.contains("7"));
		sa.assertEquals(0, 1);//fail
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		System.out.println("Step 5");
		sa.assertAll();// it will log all assertion failure
		
	}


	
}
