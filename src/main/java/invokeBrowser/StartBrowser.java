package invokeBrowser;



import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Reports.ExtentReport;

import helper.Browser;
import helper.Wait;
import staticDataManager.PathManager;
import utility.ScriptExecutor;

public class StartBrowser {

	public static WebDriver driver;
	private static Logger logger = Logger.getLogger(StartBrowser.class);

	@Parameters("browserName")
	@BeforeSuite
	public void openBrowser(@Optional("chrome") String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./driverFile/chromedriver.exe");

			driver = new ChromeDriver();
			logger.info(" * Test case Execution Start On chrome Browser *");
			startBasicOperationOnBrowser(driver, "https://opensource-demo.orangehrmlive.com/");

		} else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "./driverFile/geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info(" * Test case Execution Start On firefox Browser * ");
		}

	}

	public void startBasicOperationOnBrowser(WebDriver driver, String enterUrl) {
		Browser.maximizeBrowser(driver);
		Wait.implicitWait(driver, 30);
		Browser.loadUrl(driver, enterUrl);

	}

	@AfterMethod
	public void fatchReportInformation(ITestResult result) {

		ExtentReport.getTestCaseStatus(result);

	}

	@AfterSuite
	public void stopFatchingReportInformation() {

		ExtentReport.endReport();

		ScriptExecutor.openNewTab(driver);
		Browser.switchToWindowUsingIndex(driver, 1);
		driver.get(PathManager.getExtentReportFileLocation());
		ScriptExecutor.openNewTab(driver);
		Browser.switchToWindowUsingIndex(driver, 2);
		driver.get(PathManager.getLoggerFileLocation());

	}

}
