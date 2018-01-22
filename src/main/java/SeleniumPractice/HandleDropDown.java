package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebElement month = driver.findElement(By.id("month"));
		Select select = new Select(month);
		
		select.selectByIndex(3);
		select.selectByVisibleText("May");
		
		//to print all the values of dropbox:
		List<WebElement> monthList = driver.findElements(By.xpath("//select[@id='month']//option"));
		System.out.println(monthList.size());
		
		for(int i=0; i<monthList.size(); i++){
			System.out.println(monthList.get(i).getText());
			if(monthList.get(i).getText().equals("Aug")){
				monthList.get(i).click();
				break;
			}
		}
		
		
		
		
	}

}
