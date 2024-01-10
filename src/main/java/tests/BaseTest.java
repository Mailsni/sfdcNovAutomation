package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import pages.BasePage;

/**
 * @author mails
 *The purpose is to have common methods across the diff tests
 */
public class BaseTest{
	
	

	/**
	 * The method configures and returns browser Type objects
	 * @param browserName eg : chrome, firefox
	 * @return WedDriver Obj
	 *The purpose is to have common methods across the diff tests
	 */

	public static WebDriver getBrowserType(String browserName) {
		WebDriver driver;
		String browser = browserName.toLowerCase();

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			System.out.println("ChromeDriver is configured");
			break;

		case "safari":
			driver = new SafariDriver();
			System.out.println("SafariDriver is configured");
			break;

		case "firefox":
			driver = new FirefoxDriver();
			System.out.println("FirefoxDriver is configured");
			break;

		case "edge":
			driver = new EdgeDriver();
			System.out.println("EdgeDriver is configured");
			break;

		default:
			driver = null;
			System.out.println("Invalid browser ");
			break;


		}
		return driver;
	}

}
