package udemyAssignments;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Go to https://rahulshettyacademy.com/AutomationPractice/
 * Select any checkbox
 * Grab the label of the selected checkbox
 * from the text of the label got from previous step,Select the same option from the dropdown
 * Get the grabbed text from step 3 and enter in the editor box
 * Click on the alert and validate that the text from step3 is present in Alert text(pop up message)
 */
public class assignment6 {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) {

		boolean res = false;
		String rootdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootdir + "\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Practice Page']")));
		try {
			String input_txt = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
			System.out.println(input_txt);
			Select slct = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
			slct.selectByVisibleText(input_txt);
			driver.getWindowHandles().iterator();
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys(input_txt);
			driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
			Alert alrt = driver.switchTo().alert();
			String alrt_txt = alrt.getText();
			System.out.println("Alert msg :: "+alrt_txt);
			alrt.accept();

			Assert.assertTrue("Alert not found", alrt_txt.contains(input_txt));

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.close();
		}
	}

}
