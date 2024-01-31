package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndGU {
	public static void main(String[] args) throws InterruptedException, IOException {
		// 1st step... create the object of utilities
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();

		// read the required data in java readable format
		/* Read Common data from property file */

		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		/* Read test Data from excel file */
		String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2);

		// step 1 Launch the browser
		WebDriver driver = new ChromeDriver();
		sUtil.maximiseWindow(driver);
		sUtil.addImplicitlyWait(driver);

		// step 2: trigger the url
		driver.get(URL);

		// step 3 : login to application
		// create the obj of pom class
		LoginPage lp = new LoginPage(driver);
		lp.loginToAppl(USERNAME, PASSWORD);
		
//				lp.getUsernameEdt().sendKeys(USERNAME);
//				lp.getPasswordEdt().sendKeys(PASSWORD);
//				lp.getLoginBtn().click();
//				
		// driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		// driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		// driver.findElement(By.id("submitButton")).click();

		// step 4 : Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();

		// step 5 : click on create contact lookup image
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		// step 6 create a new contact with mandatory details
		driver.findElement(By.name("lastname")).sendKeys("Sangeeta");

		// step 7 : save
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		// step 8 : validate
		String conHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (conHeader.contains(LASTNAME)) {
			System.out.println("pass");
			System.out.println(conHeader);
		} else {
			System.out.println("fail");
		}

		// step 9 : logout of application
		WebElement ele = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		sUtil.mouseOverAction(driver, ele);
		Thread.sleep(1000);

		driver.findElement(By.linkText("Sign Out")).click();

		// close the browser
		driver.quit();

	}

}
