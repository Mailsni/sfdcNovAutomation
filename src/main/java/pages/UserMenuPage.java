package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.FileUtils;

public class UserMenuPage {

	public UserMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(id = "chatterTab")
	public WebElement profilePage;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement MyProfile;

	@FindBy(xpath = "userNav-menuItems/a[2]")
	public WebElement MySettings;

	@FindBy(xpath = "userNav-menuItems/a[3]")
	public WebElement DevelopersConsole;

	@FindBy(xpath = "userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperiance;

	@FindBy(xpath = "//textarea[@id='aboutMe']")
	public WebElement editContactAboutMeTextArea;

	@FindBy(xpath = "userNav-menuItems/a[4]")
	public WebElement Logout;

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@class='contactInfoTitle']")
	public WebElement EditProfilePopupWindow;

	@FindBy(id = "contactInfoContentId")
	public WebElement IframeContentTab;

	@FindBy(id = "lastName")
	public WebElement AboutTabLastName;

	@FindBy(id = "firstName")
	public WebElement AboutTabFirstName;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement SaveAllButton;

	@FindBy(id = "editContactInfoCancelButton")
	public WebElement editContactInfoCancelButton;

	@FindBy(xpath = "//*[id=\"tailBreadCrumbNode\"]")
	public WebElement userProfilePageNameDisplay;

	@FindBy(xpath = "//span[normalize-space()='Post']")
	public WebElement Post;

	@FindBy(id = "contactInfoContentId")
	public WebElement IframeAboutTab;;

	@FindBy(id = "progressIcon")
	public WebElement progressIcon;

	@FindBy(id = "publisherAttachContentPost")
	public WebElement File;;

	@FindBy(id = "cke_publisherRichTextEditor")
	public WebElement postTextEditor;

	@FindBy(id = "publishersharebutton")
	public WebElement shareButton;

	@FindBy(id = "chatterUploadFileAction")
	public WebElement uploadFileFromComp;

	@FindBy(id = "chatterFile")
	public WebElement fileUpload;

	public boolean verifyUserMenuItems() throws IOException {
		boolean isAllOptionsVerified = true;
		String[] expectedUserMenuItems = FileUtils.readUserMenuTestData("usermenu.items").split(",");
		for (int i = 0; i < expectedUserMenuItems.length; i++) {
			String actualOption = userMenuOptions.get(i).getText();
			if (actualOption.equals(expectedUserMenuItems[i])) {
				System.out.println("UserMenuPage : verifyUserMenuItems : Expected Option: " + expectedUserMenuItems[i]
						+ " Actual Option: " + actualOption);
			} else {

				System.out.println("UserMenuPage : verifyUserMenuItems : Expected Option: " + expectedUserMenuItems[i]
						+ " Actual Option: " + actualOption);
				isAllOptionsVerified = false;
			}
		}
		return isAllOptionsVerified;
	}

	public boolean selectUserMenuOptions(WebDriver driver, String option) {
		boolean isOptionSelected = false;
		if (userMenu.isDisplayed()) {
			userMenu.click();
		}
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='" + option + "']"));
		if (CommonUtils.waitForElement(driver, userMenuOption)) {
			userMenuOption.click();
			isOptionSelected = true;
		}
		return isOptionSelected;
	}

	public boolean isMyProfilePageDisplayed() {
		return profilePage.isDisplayed();
	}

	public void selectUserMenu() {
		if (userMenu.isDisplayed()) {
			userMenu.click();
		} else {
			System.out.println("Page not displayed");
		}
	}

	public void selectEditContact(WebDriver driver) {
		if (CommonUtils.waitForElement(driver, editContactButton)) {
			editContactButton.click();
		}
	}

	public boolean verifyIfEditContactIsIframe(WebDriver driver) {
		boolean isIframeLoaded = false;
		if (CommonUtils.waitForElement(driver, IframeAboutTab)) {
			driver.switchTo().frame(IframeAboutTab);

			if (IframeAboutTab.isDisplayed() && IframeContentTab.isDisplayed()) {
				isIframeLoaded = true;
			}
		}

		return isIframeLoaded;
	}

	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String lastName) {
		boolean isLastNameChanged = false;
		if (IframeAboutTab.isDisplayed()) {
			IframeAboutTab.click();
			AboutTabLastName.clear();
			AboutTabLastName.sendKeys(lastName);
			SaveAllButton.click();
			driver.switchTo().parentFrame();
			if (userProfilePageNameDisplay.isDisplayed()) {
				String actualName = userProfilePageNameDisplay.getText();
				if (actualName.contains(lastName)) {
					isLastNameChanged = true;
				} else {
					System.out.println("LastName is not changed");
				}
			}
		}

		return isLastNameChanged;
	}

	public boolean verifyCreatePost(WebDriver driver, String message) {
		boolean isPostCreated = false;
		if (Post.isDisplayed()) {
			Post.click();
			driver.switchTo().frame(0);
			postTextEditor.sendKeys(message);
			driver.switchTo().defaultContent();
			if (shareButton.isDisplayed()) {
				shareButton.click();
				isPostCreated = true;

			}
		}
		return isPostCreated;
	}

	public boolean verifyFileUpload(WebDriver driver, String filePath) {
		boolean isFileUploadSuccessful = false;
		if (File.isDisplayed()) {
			File.click();
			if (CommonUtils.waitForElement(driver, uploadFileFromComp)) {
				uploadFileFromComp.click();
			}
			if (CommonUtils.waitForElement(driver, fileUpload))
				fileUpload.sendKeys(filePath);
			shareButton.click();
		}
		return isFileUploadSuccessful;
	}
//
//	public boolean moveToElement(WebDriver driver, WebElement element){
//		Actions action = new Actions(driver);
	//	action.moveToElement(element).
		
	}

