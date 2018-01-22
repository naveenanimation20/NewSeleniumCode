package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.freecrm.com/register/");
		
		//total links on the page:
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//		System.out.println("total links on the page: "+ linksList.size());
//		
//		for(int i=0; i<linksList.size(); i++){
//			System.out.println(linksList.get(i).getText());
//			String linkText = linksList.get(i).getText();
//			Thread.sleep(5000);
//				if(linkText.equals("Sign Up")){
//					linksList.get(i).click();
//					break;
//				}
//		}
		
		//total text fields on the page:
		List<WebElement> textboxList = driver.findElements(By.tagName("input"));
		System.out.println("total text boxes: "+ textboxList.size());
		
		for(int i=0; i<textboxList.size(); i++){
			textboxList.get(i).sendKeys("admin");
		}
		
		List<WebElement> buttonList = driver.findElements(By.name("login"));
		buttonList.get(2).click();
		
		
		
		
	}

}
