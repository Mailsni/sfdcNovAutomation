package tests;

import java.awt.Checkbox;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.FileUtils;

public class LoginTest extends BaseTest {


	@Test	(enabled = false)
	public void login() throws IOException{
		WebDriver driver = BaseTest.getBrowserType("chrome");
		//WebDriver driver1 =new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		lp.username.sendKeys(FileUtils.readLoginTestData("prod.username"));
		lp.password.sendKeys(FileUtils.readLoginTestData("prod.password"));
		lp.login.sendKeys(FileUtils.readLoginTestData("prod.login"));
		lp.clickLoginButton();
	}

	@Test (enabled = false)
	public void checkRememberMe_TC03() throws IOException{
		WebDriver driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		lp.enterUserName(FileUtils.readLoginTestData("prod.username"));
		lp.enterPassword(FileUtils.readLoginTestData("prod.password"));
		lp.selectRememberMeCheckBox();
		lp.clickLoginButton();
	}

	@Test (enabled = false)
	public void validateLoginError_TC04() throws IOException{
		WebDriver driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		lp.enterUserName(FileUtils.readLoginTestData("inc.username"));
		lp.enterPassword(FileUtils.readLoginTestData("inc.password"));
		lp.clickLoginButton();


	}
	@Test 
	public void validateLoginError_TC04B() throws IOException{
		WebDriver driver = BaseTest.getBrowserType("chrome");
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		Assert.assertEquals(lp.isLoginPageOpened(driver), FileUtils.readLoginTestData("loginPage.title"));
		lp.enterUserName(FileUtils.readLoginTestData("inc.username"));
		Assert.assertEquals(lp.getUserName(), FileUtils.readLoginTestData("inc.username"));
		lp.enterPassword(FileUtils.readLoginTestData("inc.password"));
		Assert.assertNotNull(lp.getPassword());
		lp.clickLoginButton();
		Assert.assertEquals(lp.getLoginErrorText(), FileUtils.readLoginTestData("invalid.login.errorText"));


	}



}
