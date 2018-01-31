package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ModelPopUp {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.freecrm.com");

		driver.findElement(By.xpath("//input[@name='username' and @type = 'text']")).sendKeys("naveenk");
		driver.findElement(By.xpath("//input[@name='password' and @type = 'password']")).sendKeys("test@123");
		Thread.sleep(5000);
		driver.switchTo().frame("intercom-borderless-frame");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
		
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
		
		driver.findElement(By.xpath("//input[@value='Login' and @type='submit']")).click();
		
		
	}

}
