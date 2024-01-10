import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class SeleniumTestng {
	
	public void demoTest() {

	WebDriver driver = new ChromeDriver();
	driver.get("https://selenium-prd.firebaseapp.com");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(20));
	driver.manage().window().maximize();
		
	driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
	
	driver.findElement(By.id("password_field")).sendKeys("admin123");

	 
WebElement login = driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
login.click();

driver.findElement(By.partialLinkText("Ho")).click();
driver.quit();

}
}