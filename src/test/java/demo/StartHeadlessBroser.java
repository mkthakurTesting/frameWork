package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class StartHeadlessBroser {
	
	WebDriver driver ;
	
	@Test
	public void configureHeadlessBrowser() throws Exception{
		
		  driver = new HtmlUnitDriver();
		  
		 driver.get("https://www.facebook.com");
		 String title = driver.getTitle();
		  System.out.println(title);
		  
		}
}
