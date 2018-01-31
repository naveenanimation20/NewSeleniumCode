package SeleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLangugaeLinks {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/naveenkhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("http://www.google.co.in");
		
		List<WebElement> linkLists = driver.findElements(By.xpath("//div[@id='_eEe']//a"));
		
		System.out.println("total number of language links: "+ linkLists.size());
		
		for(int i=0; i<linkLists.size(); i++){
			System.out.println(linkLists.get(i).getText());
			
			if(linkLists.get(i).getText().equals("मराठी")){
				linkLists.get(i).click();
				break;
			}
		}
		
		
		
		
	}

}
