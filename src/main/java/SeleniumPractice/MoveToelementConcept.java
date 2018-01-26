package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToelementConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		
		//login button:
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
    		js.executeScript("arguments[0].click();", loginBtn);		
		
    		Thread.sleep(5000);
    		driver.switchTo().frame("mainpanel");
    		WebElement contacts = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
    		WebElement deals = driver.findElement(By.xpath("//a[contains(text(),'Deals')]"));
    		WebElement tasks = driver.findElement(By.xpath("//a[contains(text(),'Tasks')]"));
    		WebElement cases = driver.findElement(By.xpath("//a[contains(text(),'Cases')]"));

    		
    		Actions action = new Actions(driver);
    		action.moveToElement(contacts).build().perform();
//    		action.moveToElement(deals).build().perform();
//    		action.moveToElement(tasks).build().perform();
//    		action.moveToElement(cases).build().perform();
    		//Thread.sleep(2000);
    		WebElement newContact = driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
    		newContact.click();
    		
    		
		
	}

}
