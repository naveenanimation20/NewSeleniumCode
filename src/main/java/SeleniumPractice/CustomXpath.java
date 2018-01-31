package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CustomXpath {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.freecrm.com");

		driver.findElement(By.xpath("//input[@name='username' and @type = 'text']")).sendKeys("naveenk");
		// input[@name='username']
		// input[@name='username' and @type = 'text']
		driver.findElement(By.xpath("//input[@name='password' and @type = 'password']")).sendKeys("test@123");

		// for login button:
		// input[@value='Login']
		// input[@value='Login' and @type='submit']

		// login button:
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);

		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.xpath("//a[@title='Contacts' and text()='Contacts']")).click();
		
		Thread.sleep(5000);
		driver.switchTo().frame("intercom-borderless-frame");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-blocks')]"))).build().perform();
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click(); 
		
		driver.switchTo().frame("mainpanel");

//		driver.findElement(By.xpath("//a[text()='AAAXXX fsfsf']//parent::td[@class='datalistrow']"
//				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
		List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@type='checkbox' and @name='contact_id']"));
		System.out.println(checkboxList.size());

		for(int i=1; i<checkboxList.size(); i=i+2){
			checkboxList.get(i).click();
		}

		//String text = driver.findElement(By.xpath("//a[contains(text(),'Features')]")).getText();
		//System.out.println(text);
		// a[text()='Features']
		// a[contains(text(),'Features')]

		//System.out.println(driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).isDisplayed());

		// absolute xpath:
		// html/body/div/div[1]/div[3]/input/span/a

		// a[@title='Contacts' and text()='Contacts']

	}

}
