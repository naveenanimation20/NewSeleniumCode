package SeleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertPopUpHandling {

	public static void main(String[] args) throws InterruptedException {

		//how to handle alert:
		//1. using ALert API in Selenium
		//Accept, dismiss, gettext
		
		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click(); //go button
		
		Alert alert =  driver.switchTo().alert();
		
		String text = alert.getText();
		System.out.println("Alert message: "+text);
		
		if(text.equals("Please enter a valid user name")){
			System.out.println("correct error messg");
		}else{
			System.out.println("in-correct error messg");
		}
		Thread.sleep(3000);
		
		//ok button:
		alert.accept();
		
		//cancel button:
		//alert.dismiss();
		
		
		
		
		
		
	}

}
