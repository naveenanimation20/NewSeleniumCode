package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitsInSelenium {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//implicit wait: global wait--applicable for all the elements used by driver
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.freecrm.com");
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		
		//login button:
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
    		js.executeScript("arguments[0].click();", loginBtn);	
    		
    		//Explicit Wait: is specific to element
    		//it is used to tell selenium webdriver to wait for certain condition -- Expected Conditions
    		//OR
    		//if the given time is over
    		//Then thrown an exception -- Element NOT Visible /Not Found Exception
    		// WebDriverWait and ExpectedConditions
    		driver.switchTo().frame("mainpanel");
    		WebDriverWait wait = new WebDriverWait(driver, 20);
    		WebElement username;
    		username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'User: Naveen K')]")));
    		System.out.println(username.getText());
    		
		//1. an element is visible and enabled: elementToBeClickable(By locator)
    		//2. an element is selected: elementToBeSelected(By locator)
    		//3. presence of an element: presenceOfElementLocated(By locator)
    		//4. specific text present in an element: textToBePresentInElement(By locator, String text)
    		
    		
    		
    		WebElement searchField = driver.findElement(By.name("search"));
    		sendKeyValue(driver, searchField, 15, "test");
    		
    		//click on logout:
    		//WebElement logoutLink = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
    		//clickOn(driver, logoutLink, 10);
    		
	}
	
	
	/*
	 * custom clickOn method: click on element on the basis of some
	 * ExpectedConditions to avoid StaleElementReferenceException
	 */
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	/*
	 * custom sendKeyValue method: enter value in element on the basis of some
	 * ExpectedConditions to avoid StaleElementReferenceException
	 */
	public static void sendKeyValue(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);

	}

}
