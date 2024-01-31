package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility {//Rule no. 1
	// Declaration
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(css = "input[type='submit']")
	private WebElement Savebtn;
	
	@FindBy (name= "leadsource")
	private WebElement leadSourceDropDown;
	
	//Inicialisation


	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this );
	}

	
	//Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}
	
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	
	
	//Business Library
	/**
	 * this method will create contact with mandatory details
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		LastNameEdt.sendKeys(LASTNAME);
		Savebtn.click();
	}
	
	/**
	 * this method will create contact with lead source drop down value
	 * @param LASTNAME
	 * @param LEADSOURCE
	 */
	public void createNewContact(String LASTNAME,String LEADSOURCE  ) {
		LastNameEdt.sendKeys(LASTNAME);
		handleDropDown(leadSourceDropDown, LEADSOURCE);
		Savebtn.click();
		
	}
	

}
