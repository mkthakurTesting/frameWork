package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import invokeBrowser.StartBrowser;
import pages.UserPage;

public class UserPageScript extends StartBrowser {
	String expectedUserPageHeading = "System Users";
	String noRecordFoundText = "No Records Found";
	@Test(priority=1)
	public void verifyUserPageNavigation(){
		
	String heading =	UserPage.checkUserPageNavigation(driver);
	Assert.assertEquals(heading, expectedUserPageHeading);
	}
	@Test(priority=2)
    public void verifyUserSearchWithInvalidUserName(){
    
    String result =	UserPage.checkUserNameSearchWithInvalidData(driver);
      Assert.assertEquals(result, noRecordFoundText);
      
      
    }
	public void verifyResetButtonInUserNameSection(){
		
	}
}
