package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Action;
import helper.DropDown;
import staticDataManager.ApplicationLevelMethod;
import uiAction.Element;
import utility.RandomData;

public class UserPage {
	private static By AdminLink = By.id("menu_admin_viewAdminModule");
	private static By userManagementLink = By.id("menu_admin_UserManagement");
	private static By userLink = By.id("menu_admin_viewSystemUsers");
	private static By systemUserHeading = By.xpath("//h1[text()='System Users']");
	private static By userNameField = By.id("searchSystemUser_userName");
	private static By searchButton = By.id("searchBtn");
	private static By noRecordsFound = By.xpath("//td[text()='No Records Found']");
	private static By resetButton = By.id("resetBtn");
	private static By SearchedUserNameLoc = By.xpath("(//tr)[2]/td[2]/a");
	private static By userRole = By.id("searchSystemUser_userType");
	

	public static String checkUserPageNavigation(WebDriver driver) {
		LoginPage.login_in_Application(driver);
		Action.mouseHover(driver, AdminLink);
		Action.mouseHover(driver, userManagementLink);
		Element.click(driver, userLink);
		String heading = Element.getText(driver, systemUserHeading);
		return heading;

	}

	public static String checkUserNameSearchWithInvalidData(WebDriver driver) {
		String result = Element.verifyTextboxRelatedSearch(driver, userNameField, RandomData.getPersonFullName(),
				searchButton, noRecordsFound);
		Element.click(driver, resetButton);

		return result;

	}

	public static boolean searchUserNameUsingValidData(WebDriver driver, String columnName, int recordsForYourChoise) {
		boolean b = false;
		String validData = ApplicationLevelMethod.getColumnData(driver, columnName, recordsForYourChoise);
		Element.sendKeys(driver, userNameField, validData);
		Element.click(driver, searchButton);
		String actualResult = Element.getText(driver, SearchedUserNameLoc);
		if (validData.equalsIgnoreCase(actualResult)) {
			b = true;
			Element.click(driver, resetButton);
		}
		return b;

	}
    public static void searchByUserRole(WebDriver driver ,String Value){
       String admin = "Admin";
    	 
     if( DropDown.checkDropDownValueExistance(driver, userRole, "Admin")){
    	 DropDown.SelectByValue(driver, userRole, admin);
    	 Element.click(driver, searchButton);
    	 
     }else {
    	 
     }
    	    
    	  
      
    	
         
    }
 }
