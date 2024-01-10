package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.WaitConstants;

public class CommonUtils {
	
	public static boolean waitForElement(WebDriver driver, WebElement element) {
		boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		 isElementClickable = true;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return isElementClickable;
}
	
	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
		boolean isElementInvisible = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
	 isElementInvisible = true;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return isElementInvisible;
}
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		
	}
	
	
}
