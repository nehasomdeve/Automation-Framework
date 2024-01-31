package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	// Rule no. 2 - Declaration
	@FindBy(css = "img[alt='Create Contact...']")
	private WebElement CreateContactLookupImg ;

	// Rule no. 3 Inisialisation
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}

	//Rule no. Utilization
	
	public WebElement getCreateContactLookupImg() {
		return CreateContactLookupImg;
	}
	
	// Business Library
	/**
	 * this method will click on lookup img
	 */
	public void clickonCreateContactLookupImg() {
		CreateContactLookupImg.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
