package contactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateNewContactTest extends BaseClass {// we want the libraries from base class so first extend from base class
	
	@Test (groups = "SmokeSuite")
	public void createContactWithMandatoryFeilds() throws IOException, InterruptedException
 {
	
			/* Read test Data from excel file */
			String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2);// we cannot remove it coz its a test data not common data so it wont be in base class 

		

            // step 4 : Navigate to contact link
			HomePage hp = new HomePage(driver);
			hp.clickonContactsLink();
			
			// step 5 : click on create contact lookup image
			ContactsPage cp = new ContactsPage(driver);
			cp.clickonCreateContactLookupImg();

			// step 6 create a new contact with mandatory details and save
			CreateNewContactPage cncp = new CreateNewContactPage(driver);
			cncp.createNewContact(LASTNAME);// save step is not needed as in this method save is already done 

			// step 8 : validate
			ContactInfoPage cip= new ContactInfoPage(driver);
			String conHeader = cip.captureHeaderText();// in this method we are returning the value so it will get save in conHeader ref so all validation process we can keep as it is
			Assert.assertTrue(conHeader.contains(LASTNAME));
				System.out.println(conHeader);
			
			
	
}
	@Test
	public void sample() {
		System.out.println("Hi");
		
		//Assert.fail();
	}
}
