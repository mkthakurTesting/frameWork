package methodTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import helper.Browser;
import helper.DropDown;

public class methodTesting {

	static WebDriver driver;
	static WebDriverWait wait;
	static String url = "http://demo.guru99.com/popup.php";

	By clickButton = By.linkText("Click Here");
	By enterEmailId = By.name("emailid");

	String emailId = "murariraj.wroing@murari.com";

	public static void startBrowser() {

		System.setProperty("webdriver.chrome.driver", "./driverFile/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public static void clickOnElement(By enterLocator) {

		driver.findElement(enterLocator).click();
	}

	public static void enterDataInTextBox(By enterLocator, String enterValue) {

		driver.findElement(enterLocator).sendKeys(enterValue);
	}

	public static void WaitForElementVisibility(WebDriver driver, By enterLocator, int time) {
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(enterLocator));

	}

	public void handleWindow() {

		startBrowser();
		driver.get(url);

		clickOnElement(clickButton);
		// Browser.handleTabUsingIndexValue(driver, 2);
		Browser.switchToWindowUsingIndex(driver, 1);
		enterDataInTextBox(enterEmailId, emailId);
		Browser.switchToParentWindow(driver);
		// Browser.switchTomainWindow(driver);
		clickOnElement(clickButton);
	}

	@Test
	public void handleDropDown() {
		startBrowser();
		driver.get("https://www.facebook.com");
		// select day from drop down
		By day = By.id("day");
		String dayVisibility = "30";
		DropDown.SelectByVisiableText(driver, day, dayVisibility);

		// select month from drop down
		By month = By.id("month");
		String monthValue = "3";
		DropDown.SelectByValue(driver, month, monthValue);
		int count =	DropDown.getTotalDropDownValueCount(driver, month);
		   System.out.println("====== "+count);
		boolean b =  DropDown.checkDropDownValueExistance(driver, month, "Maar") ;
		    System.out.println(b);
	//  DropDown.checkDropDownValueExistance(driver, month);

		// select month from drop down
		By year = By.id("year");
		int yearIndex = 30;
		DropDown.SelectByIndex(driver, year, yearIndex);
		
	
	   
	}

}
