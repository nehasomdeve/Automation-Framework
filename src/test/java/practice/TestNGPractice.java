package practice;

import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

import org.testng.annotations.Test;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test (invocationCount = 3, priority = 2, enabled = false)
	public void createCustomer() {
		
		System.out.println("create");
	}
	
	@Test (invocationCount = 2, priority = 1, dependsOnMethods = "createCustomer")
	public void modifyCustomer() {
	
		System.out.println("modify");
	}
	
	
	@Test  (invocationCount = 1, priority = 3)
	public void deletCustomer() {
		System.out.println("delet");
	}
}
