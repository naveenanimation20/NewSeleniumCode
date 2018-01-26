package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.yahoo.com");
		
		//1. id: --I
//		WebElement email = driver.findElement(By.id("login-username"));
//		email.sendKeys("testadmin@yahoo.com");
//		
//		//driver.findElement(By.id("login-username")).sendKeys("testadmin@yahoo.com");
//		WebElement next_btn = driver.findElement(By.id("login-signin"));
//		next_btn.click();
		
		//2. name: --II
//		WebElement email = driver.findElement(By.name("username"));
//		email.sendKeys("testadmin@yahoo.com");
//		
//		WebElement next_btn = driver.findElement(By.name("signin"));
//		next_btn.click();
		
		//3. xpath: ---III
//		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("testadmin@yahoo.com");
//		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		
		//4. CSS Selector: --II,III
//		driver.findElement(By.cssSelector("#login-username")).sendKeys("testadmin@yahoo.com");
//		driver.findElement(By.cssSelector("#login-signin")).click();
		
		//5. link text: only for links: 
		//driver.findElement(By.linkText("Help")).click();
		
		//6. partial link text: not recommended:
		//driver.findElement(By.partialLinkText("Difficulty")).click();
		
		//7. class name: not recommended (its not unique) --V
		driver.findElement(By.className("phone-no")).sendKeys("test@yahoo.com");
		
		
		//8. tag name: will cover later
		
		//driver.quit();
		
		
		
	}

}
