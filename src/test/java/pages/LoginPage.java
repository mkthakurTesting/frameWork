package pages;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fileReader.ExcelReader;
import helper.Browser;
import helper.Wait;
import scripts.LoginPageScript;
import staticDataManager.PathManager;
import uiAction.Element;

public class LoginPage {
	private static Logger logger = Logger.getLogger(LoginPage.class);
	private static By loginPanel = By.id("logInPanelHeading");
	private static By userName = By.name("txtUsername");
	private static By password = By.name("txtPassword");
	private static By loginButton = By.name("Submit");
	private static By OrangeHRMLink = By.linkText("OrangeHRM, Inc");
	private static By LinkdInLink = By.xpath("//img[contains(@alt,'LinkedIn')]");
	private static By facebookLink = By.xpath("//img[contains(@alt,'Facebook')]");
	private static By twitterLink = By.xpath("//img[contains(@alt,'twitter')]");
	private static By youtubeLink = By.xpath("//img[contains(@alt,'youtube')]");

	public static String loginPanelVerification(WebDriver driver) {

		return Element.getText(driver, loginPanel);

	}

	public static boolean check_userName_password_loginFields(Method m, WebDriver driver) {
		boolean result = false;
		boolean isUserNamefieldExist = Wait.checkElementExistance(driver, 30, 5, userName);
		boolean isPasswordFieldExist = Wait.checkElementExistance(driver, 30, 5, password);
		boolean isLoginButtonExist = Wait.checkElementExistance(driver, 30, 5, loginButton);

		if (isUserNamefieldExist && isPasswordFieldExist && isLoginButtonExist) {

			result = true;

		}
		return result;
	}

	public static boolean isUserAbleToEnterDataIn_userNameAndPasswordSection(WebDriver driver) {
		boolean b = false;
		Element.sendKeys(driver, userName, "userNameChecker");
		Element.sendKeys(driver, password, "password");
		Element.click(driver, loginButton);
		String url = Browser.getCurrentUrl(driver);

		if (url.contains("/auth/validateCredentials")) {

			b = true;
		}
		return b;

	}

	public static String checkOrangeHRmLink(WebDriver driver) {
		return Element.verifyAnyLink(driver, OrangeHRMLink);

	}

	public static String checkLinkdinLink(WebDriver driver) {
		return Element.verifyAnyLink(driver, LinkdInLink);
	}

	public static String checkFacebookLink(WebDriver driver) {
		return Element.verifyAnyLink(driver, facebookLink);
	}

	public static String checkTwitterLink(WebDriver driver) {
		return Element.verifyAnyLink(driver, twitterLink);
	}

	public static String checkYoutubeLink(WebDriver driver) {
		return Element.verifyAnyLink(driver, youtubeLink);
	}

	public static void loginValidator(WebDriver driver) {

		boolean b = false;

		ExcelReader excelreader = new ExcelReader(PathManager.getExcelFileLocation("TestDataForOrangeHRM.xlsx"));
		int i = 0;
		int rowCount = excelreader.TotalRowNumber("Login");
		for (i = 1; i <= rowCount; i++) {
			String userNameValue = excelreader.getColumnData("Login", "UsrName", i);
			String passwordValue = excelreader.getColumnData("login", "Password", i);
			Element.sendKeys(driver, userName, userNameValue.trim());
			Element.sendKeys(driver, password, passwordValue.trim());
			Element.click(driver, loginButton);

			String url = Browser.getCurrentUrl(driver);

			if (url.contains("dashboard")) {
				logger.info("Loging Success With [ " + userNameValue + " ] And [ " + passwordValue + " ]");

			} else {

				logger.info("Loging Failed With [ " + userNameValue + " ] And [ " + passwordValue + " ]");
			}

		}

	}

	public static void login_in_Application(WebDriver driver) {
		Element.sendKeys(driver, userName, "Admin");
		Element.sendKeys(driver, password, "admin123");
		Element.click(driver, loginButton);

	}
}
