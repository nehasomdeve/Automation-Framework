package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

    //Declaration 
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;

	// Inicialisation
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilisation

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
/**
 * this mwthod will capture the header text and return it to caller
 * @return
 */
	//Business library
	
	public String captureHeaderText() {
		 return ContactHeaderText.getText();// capturing the text for validation purpose tho we cant do validation in business library
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
