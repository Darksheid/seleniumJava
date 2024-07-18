package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class learnLocators {
	
	
//	driver.findElement(By.cssSelector(cssSelector));
//	driver.findElement(By.className(className));
//	driver.findElement(By.id(id));
//	driver.findElement(By.xpath(xpathExpression));
//	driver.findElement(By.linkText(linkText));
//	driver.findElement(By.partialLinkText(partialLinkText));
//	driver.findElement(By.name(name));
//	driver.findElement(By.tagName(tagName));

	private static WebDriver driver ;
	private static WebDriverWait wait;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Projects\\revision\\src\\test\\java\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,10);
		WebElement iframe = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//iframe"))));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[text()='Stay signed out']")).click();
		Thread.sleep(3000);
		driver.quit();
		
	}
}
