package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import invokeBrowser.StartBrowser;
import pages.UserPage;

public class UserPageScript extends StartBrowser {
	String expectedUserPageHeading = "System Users";
	String noRecordFoundText = "No Records Found";
	String admin = "Admin";
	String ess = "ESS";

	@Test(priority = 1)
	public void verifyUserPageNavigation() {

		String heading = UserPage.checkUserPageNavigation(driver);
		Assert.assertEquals(heading, expectedUserPageHeading);
	}

	@Test(priority = 2)
	public void verifyUserSearchWithInvalidUserName() {

		String result = UserPage.checkUserNameSearchWithInvalidData(driver);
		Assert.assertEquals(result, noRecordFoundText);

	}

	@Test(priority = 3)
	public void SearchWithValidUser() {

		boolean b = UserPage.searchUserNameUsingValidData(driver, "Username", 2);

		Assert.assertTrue(b);

	}

	@Test(priority = 4)
	public void SearchByAdmin() {

		boolean b = UserPage.SearchByUserRole(driver, admin);

		Assert.assertTrue(b);

	}
	@Test(priority=5)
	public void searchByEss(){
		
<<<<<<< HEAD
	
	boolean b = UserPage.searchUserNameUsingValidData(driver, "Username", 2);
	
	Assert.assertTrue(b);
	
	 
=======
		boolean b =	UserPage.SearchByUserRole(driver, ess);
		Assert.assertTrue(b);
>>>>>>> 56670173d99bb7628481224a49fac4ac3e47dc24
	}
}
