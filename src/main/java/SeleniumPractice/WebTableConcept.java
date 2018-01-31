package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTableConcept {

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
		
    		Thread.sleep(3000);
    		driver.switchTo().frame("mainpanel");
    		WebElement contacts = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
    		contacts.click();
    		
//    		driver.switchTo().frame("intercom-borderless-frame");
//    		Actions action = new Actions(driver);
//    		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
//    		
//    		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
//    		    		
//    		driver.switchTo().frame("mainpanel");


		// *[@id="vContactsForm"]/table/tbody/tr[4]/td[2]
		// *[@id="vContactsForm"]/table/tbody/tr[5]/td[2]
		// *[@id="vContactsForm"]/table/tbody/tr[6]/td[2]
		// *[@id="vContactsForm"]/table/tbody/tr[24]/td[2]
    		
    		String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
    		String after_xpath = "]/td[3]";
    		
    		for(int i=4; i<=24; i++){
    			for(int j=2; j<=3; j++){
    			
    			WebElement col = driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[" + i + "]/td["+j+"]"));
    			//WebElement col = driver.findElement(By.xpath(before_xpath+ i +after_xpath));
    			String colVal = col.findElement(By.tagName("a")).getText();
    			System.out.print(colVal);
    			System.out.println();
    		}
    		}
    		
    		
	}

}
