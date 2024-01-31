package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {// rule no. 1
	
	// Rule no. 2 - Declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt ; // username is variable & edt is textfield kinda element
	
	@FindBy(name= "user_password")
	private WebElement passwordEdt;
	
	@FindBy (id= "submitButton")
	private WebElement loginBtn;// login button is button type webelement dats y btn 
	
	// Rule no. 3 - Initialisation
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	// Rule no. 4 - Utilisation
		public WebElement getUsernameEdt() {
			return usernameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		
			//Business library
		/**
		 * this method will login to application using valid credentials
		 * @param USERNAME
		 * @param PASSWORD
		 */
		public void loginToAppl(String USERNAME, String PASSWORD) {
			usernameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			loginBtn.click();
		}
	}
		
		
		
		
		
		
		
		
		
		
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	


