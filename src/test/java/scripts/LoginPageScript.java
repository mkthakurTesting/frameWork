package scripts;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fileReader.ExcelReader;
import helper.Browser;
import invokeBrowser.StartBrowser;
import pages.LoginPage;

public class LoginPageScript extends StartBrowser {
	private static Logger logger = Logger.getLogger(LoginPageScript.class);

	@Test(priority = 1)
	public void verifyLoginPageExistance(Method m) {

		logger.info(m.getName() + " Execution Started ");
		String loginPanel = LoginPage.loginPanelVerification(driver);
		Assert.assertEquals(loginPanel, "LOGIN Panel");
		logger.info(m.getName() + " Execution ended ");
	}

	@Test(priority = 2)
	public void verify_Username_Password_LoginButtonField(Method m) {
		logger.info(m.getName() + " Execution Started ");
		boolean Username_Password_LoginButtonFieldExist = LoginPage.check_userName_password_loginFields(m, driver);
		Assert.assertTrue(Username_Password_LoginButtonFieldExist);
		logger.info(m.getName() + " Execution ended ");
	}

	@Test(priority = 3)
	public void verifyUserIsAbleToEnterDataOrNotIn_userNameAndPasswordSection(Method m) {
		logger.info(m.getName() + " Execution Started ");
		boolean userIsAbleToEnterData = LoginPage.isUserAbleToEnterDataIn_userNameAndPasswordSection(driver);
		Assert.assertTrue(userIsAbleToEnterData);

		logger.info(m.getName() + " Execution ended ");

	}

	@Test(priority = 4)
	public void verifyOrangeHrMLink() {

		String orangeHrmTitle = LoginPage.checkOrangeHRmLink(driver);

		Assert.assertTrue(orangeHrmTitle.contains("HR Management System"));
		Browser.closeBrowser(driver);
		Browser.switchToParentWindow(driver);
	}
	//@Test(priority=5)
	public void verifyLinkedinLink(){
		String linkedinTitle = LoginPage.checkLinkdinLink(driver);
		Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
		Browser.closeBrowser(driver);
		Browser.switchToParentWindow(driver);
	}
	
	@Test(priority=6)
	public void verifyFacebookLink(){
		String  facebookTitle = LoginPage.checkFacebookLink(driver);
		Assert.assertTrue(facebookTitle.contains("Facebook"));
		Browser.closeBrowser(driver);
		Browser.switchToParentWindow(driver);
	}
	@Test(priority=7)
	public void verifyTwitterLink(){
		String twitterLink = LoginPage.checkTwitterLink(driver);
		Assert.assertTrue(twitterLink.contains("Twitter"));
		Browser.closeBrowser(driver);
		Browser.switchToParentWindow(driver);
	}
	@Test(priority=8)
	public void verifyYoutubeLink(){
		String youtubeLink = LoginPage.checkYoutubeLink(driver);
		Assert.assertTrue(youtubeLink.contains("YouTube"));
		Browser.closeBrowser(driver);
		Browser.switchToParentWindow(driver);
	}
	@Test(priority = 9)

	public void verifyLogin(Method m) {
		logger.info(m.getName() + " Execution Started ");
		LoginPage.loginValidator(driver);
		logger.info(m.getName() + " Execution ended ");

	}

}
