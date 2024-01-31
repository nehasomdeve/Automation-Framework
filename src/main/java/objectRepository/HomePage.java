package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{ // to use mouseover action we only need sel utility dats why we wextend not created the object of genric utility 
	
	//Rule no. 2 Declaration
	@FindBy(linkText="Contacts")
	private WebElement contactslnk ;
	
	 @FindBy (css ="img[src='themes/softed/images/user.PNG']")
	 private WebElement administratorImg;
	 
	 @FindBy (linkText = "Sign Out")
	 private WebElement signoutlnk;
	 
	 //Rule no. 3 Initialization 
	  public HomePage(WebDriver driver ) {
		  PageFactory.initElements(driver, this);
		  
	  }

	  // Utilisation
	public WebElement getContactslink() {
		return contactslnk;
	}

	public WebElement getAdminimg() {
		return administratorImg;
	}

	public WebElement getSignoutlink() {
		return signoutlnk;
	}
	 //Business Library
	/**
	 * this methid will click on Contacts link
	 */
	public void clickonContactsLink() {
		contactslnk.click();
	}
/**
 * this method will logout of application
 * @param driver
 * @throws InterruptedException
 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException {
		mouseOverAction(driver, administratorImg);
		Thread.sleep(1000);
		signoutlnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
