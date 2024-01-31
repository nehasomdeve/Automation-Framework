package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * this class consist of basic configration annotations of TestNG 
 * @author ASUS
 *
 */
public class BaseClass {// possible routin steps req for test script will be written in base class
	public ExcelFileUtility eUtil= new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver ; // declaring globally so that we can acess to all the below methods
	
	//for listeners
	public static WebDriver sDriver;
	
	@BeforeSuite (groups = { "SmokeSuite", "RegressionSuite"})
	public void bsConfig() {
		System.out.println("==============DB Connection Sucessful==============");
		//in v tiger db connection is not accessible so just only we will write print statement 
	}
	//@Parameters("Browser") revert back all the changes after parellel and cross browser execution
    //@BeforeTest
	@BeforeClass (alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException {
	String URL = pUtil.readDataFromPropertyFile("url");
	
		driver = new ChromeDriver();
		
	
	  // if(BROWSER.equals("chrome")) {
		//   driver = new ChromeDriver(); 
	  // }
	 //  else if (BROWSER.equals("edge")) {
		 //  driver = new EdgeDriver();
		   
	   //}
		sUtil.maximiseWindow(driver);
		sUtil.addImplicitlyWait(driver);
		driver.get(URL);
		
		System.out.println("==============Browser Launch Sucessful==============");
		
		//For Listeners
		sDriver = driver;
		
	}
	
	@BeforeMethod (alwaysRun = true)
	public void bmConfig() throws IOException {
		
	String USERNAME = pUtil.readDataFromPropertyFile("username");
    String PASSWORD = pUtil.readDataFromPropertyFile("password");
    
    LoginPage lp= new LoginPage(driver);
    lp.loginToAppl(USERNAME, PASSWORD);
    
    System.out.println("==============Login to App Sucessful==============");
    
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void amConfig() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("==============Logout of App Sucessful==============");
		
	}
	//@AfterTest
	@AfterClass (alwaysRun = true)
	public void acConfig() {
		
		driver.quit();
		
		System.out.println("==============Browser closure Sucessful==============");
	}
	
	@AfterSuite (alwaysRun = true)
	public void asConfig() {
		
		System.out.println("==============DB Closure Sucessful==============");
	}
	
	
	
}
