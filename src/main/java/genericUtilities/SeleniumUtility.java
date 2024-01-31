package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consist of generic method related to selenium
 * 
 * @author ASUS
 *
 */
public class SeleniumUtility {
	/**
	 * this method will maximise the window
	 * 
	 * @param driver
	 */

	public void maximiseWindow(WebDriver driver) {

		driver.manage().window().maximize();
	}

	/**
	 * this method will minimize the window
	 * 
	 * @param driver
	 */

	public void minimiseWindow(WebDriver driver) {

		driver.manage().window().minimize();
	}

	/**
	 * this method will add 10 sec of implicitly wait
	 * 
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	/**
	 * this method will wait for 10s for an element to be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method will handle dropdown by index (we are achiving method overloading
	 * here in this project by this dropdwon method in intervie we can tell)
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * this method will handle the dropdown by value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * this method will handle the dropdown by visible text
	 * 
	 * @param element
	 * @param text
	 */
	public void handleDropDown(String text, WebElement element) {

		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * this method will perform mouse over action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * this method will perform right click on web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * this method will perform double click on web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * this method will perform drag and drop operation
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target) {

		Actions act = new Actions(driver);
		act.dragAndDrop(src, target);
	}

	/**
	 * this method will scroll down the page for 500 units
	 * 
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500);", "");
	}

	/**
	 * this method will scroll up the page for 500 units
	 * 
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,-500);", "");
	}

	/**
	 * this method will handle frame using Frame Index
	 * 
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex) {

		driver.switchTo().frame(frameIndex);

	}

	/**
	 * this method will handle frame using Frame Name and ID
	 * 
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, String frameNameOrID) {

		driver.switchTo().frame(frameNameOrID);

	}

	/**
	 * this method will handle frame using Web Element
	 * 
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement) {

		driver.switchTo().frame(frameElement);

	}

	/**
	 * this method will accept the alert popup
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	/**
	 * this method will dismiss the alert popup
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

	/**
	 * whwnevr ew use getter method we have to return it tot the caller this method
	 * will capture the alert text and return it to the caller
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {

		return driver.switchTo().alert().getText();
	}

	/**
	 *This method will capture the screenshot and return the path to caller
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShot\\"+screenShotName+".png");
		
		Files.copy(src, dst);
		
		return dst.getAbsolutePath(); // extent Reports

	}

}
