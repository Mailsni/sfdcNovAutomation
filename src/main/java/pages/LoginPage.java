package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.FileUtils;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")     //pageobject web elements
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(name = "Login")
	public WebElement login;

	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;
	
	@FindBy(id = "#error")
	public WebElement loginErrorMsg;

	@FindBy(id = "un")
	public WebElement forgotUsername;

	@FindBy(partialLinkText = "Forgot")
	public WebElement forgotPassword;
	
	@FindBy(id = "continue")
	public WebElement continueButton;

	@FindBy(id = "forgotPassForm")
	public WebElement passwordResetScreen;

	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnToLoginButton;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;
	
	@FindBy(id = "userNavLabel")
	public WebElement homeUserMenu;

	public void enterUserName(String emailID) {
		if (username.isDisplayed()) {
			username.sendKeys(emailID);
		}else {
			System.out.println("UserName is not displayed");
			
		}
	}
	
	public void enterPassword(String pass) {
		if (password.isDisplayed()) {
			password.sendKeys(pass);
		}else {
			System.out.println("Password element is not displayed");
			
		}
	}
	
	public void clickLoginButton() {
		if (login.isDisplayed()) {
			login.click();
		}else {
			System.out.println("Login element is not displayed");
			
		}
	}
	
	
	public void selectRememberMeCheckBox() {
		if(!rememberMe.isSelected()) {
			rememberMe.click();
		}
	}
	
	
	
	public String isLoginPageOpened(WebDriver driver) {	
		return driver.getTitle();
	}

	public String getLoginErrorText() {
		if(loginErrorMsg.isDisplayed()) {
			return loginErrorMsg.getText();
			} else {
				return null;
			}
		
	}
	
	public String getUserName() {
		return username.getText();
	}
	
	
	public String getPassword() {
		return password.getText();
	}
	
	public void loginToApp(WebDriver driver) throws IOException {
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
		driver.manage().window();
		if(CommonUtils.waitForElement(driver,username)) {
		username.sendKeys(FileUtils.readLoginTestData("prod.username"));
		password.sendKeys(FileUtils.readLoginTestData("prod.password"));
		clickLoginButton();
		} else {
			
			System.out.println("Failed to loginx");
		}
		
	}
	
}
