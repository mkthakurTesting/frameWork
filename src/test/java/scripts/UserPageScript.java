package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import invokeBrowser.StartBrowser;
import pages.UserPage;

public class UserPageScript extends StartBrowser {
	String expectedUserPageHeading = "System Users";
	@Test
	public void verifyUserPageNavigation(){
		
	String heading =	UserPage.checkUserPageNavigation(driver);
	Assert.assertEquals(heading, expectedUserPageHeading);
	}

}
