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

public class Scenario1WithDDT {
	public static void main(String[] args) throws IOException, InterruptedException {
		// read the required data in java readable format
		/* Read Common data from property file */
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		/* Read test Data from excel file */
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue();

		// step 1 Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// step 2: trigger the url
		driver.get(URL);

		// step 3 : login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

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
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

		Thread.sleep(1000);

		driver.findElement(By.linkText("Sign Out")).click();

		// close the browser
		driver.quit();

	}

}
