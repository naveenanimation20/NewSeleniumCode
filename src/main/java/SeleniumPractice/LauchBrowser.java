package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LauchBrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver(); //launch browser
		
		driver.get("http://www.freecrm.com"); //enter URL
		
		String title = driver.getTitle(); //get the title
		
		System.out.println("The title of page is: "+ title);
		
		//validation point:
		if(title.equals("#1 Free CRM for Any Business: Online Customer Relationship Software")){
			System.out.println("correct title");
		}else{
			System.out.println("in-correct title");
		}
		
		System.out.println("the current url :"+ driver.getCurrentUrl());
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("index.html")){
			System.out.println("current url is having index.html");
		}else{
			System.out.println("current url is not redirecting to index.html");
		}
		
		//System.out.println("page source of web page: "+ driver.getPageSource());
		
		//driver.quit();//close the browser
		
		
	}

}
