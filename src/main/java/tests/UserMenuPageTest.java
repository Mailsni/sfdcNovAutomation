package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import constants.FileConstants;
import constants.WaitConstants;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonUtils;
import utils.FileUtils;

public class UserMenuPageTest extends BaseTest{
	private WebDriver driver;

	@BeforeMethod
	public void preCondition() throws IOException{
		driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
	}
	
	
	@AfterMethod		
		public void tearDown() {
			driver.close();
		}
	
	
	@Test (enabled = true)

	public void selectMyProfile_TC06() throws IOException, InterruptedException{
		UserMenuPage ump = new UserMenuPage(driver);
		Thread.sleep(5000);
		ump.selectUserMenu();
	Assert.assertFalse(ump.verifyUserMenuItems(), "Usermenu options should be according to expected order	");
	Assert.assertTrue(ump.selectUserMenuOptions(driver, FileUtils.readUserMenuTestData("usermenu.items")), " ");
		CommonUtils.waitForElement(driver, ump.profilePage);
		Assert.assertTrue(ump.isMyProfilePageDisplayed(), "Failed to load MyProfilePage	");
		ump.selectEditContact(driver);
		Assert.assertTrue(ump.verifyIfEditContactIsIframe(driver),"Failed to load iFrame");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, "user.newLastName"));
		Assert.assertTrue(ump.verifyCreatePost(driver, FileUtils.readUserMenuTestData("post.message")));
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.FILE_UPLOAD_PATH));
		
		
		
		

	}

	
}