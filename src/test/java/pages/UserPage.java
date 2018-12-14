package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Action;
import uiAction.Element;
import utility.RandomData;

public class UserPage {
  private static By AdminLink = By.id("menu_admin_viewAdminModule");
  private static  By userManagementLink = By.id("menu_admin_UserManagement");
  private static By userLink = By.id("menu_admin_viewSystemUsers");
  private static By systemUserHeading = By.xpath("//h1[text()='System Users']");
  private static By userNameField = By.id("searchSystemUser_userName");
  private static By searchButton = By.id("searchBtn");
  private static By noRecordsFound = By.xpath("//td[text()='No Records Found']");
  
	public static String checkUserPageNavigation(WebDriver driver){
		LoginPage.login_in_Application(driver);
		Action.mouseHover(driver, AdminLink);
		Action.mouseHover(driver, userManagementLink);
		Element.click(driver, userLink);
	String heading =	Element.getText(driver, systemUserHeading);
	    return heading ;
		
	}
	public static String checkUserNameSearchWithInvalidData(WebDriver driver){
		String result = null ;
		Element.sendKeys(driver, userNameField, RandomData.getPersonFullName());
		Element.click(driver, searchButton);
	result =	Element.getText(driver, noRecordsFound);
		return result ;
		
	}
	
	
}
