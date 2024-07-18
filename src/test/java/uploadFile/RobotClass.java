package uploadFile;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class RobotClass {
	
	
	
	public static WebDriver driver;
	public static Robot robot;
	public static Actions ac;
	
	public static void uploadDocuments(String path) throws Throwable {
		//put path to your image in a clipboard
	    StringSelection ss = new StringSelection(path);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	    //imitate mouse events like ENTER, CTRL+C, CTRL+V
	    robot = new Robot();
	    robot.delay(2000);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void main(String[] args) throws Throwable   {

		System.setProperty("webdriver.chrome.driver",
				"F:\\Projects\\revision\\src\\test\\java\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		ac = new Actions(driver);
		Robot rbt = new Robot();
		try {
			driver.get("https://demo.guru99.com/test/upload/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			String filePath = "C:\\Users\\tanmo\\OneDrive\\Desktop\\pdf24_converted.pdf";
			WebElement inputBox = driver.findElement(By.cssSelector("input.upload_txt"));
			ac.moveToElement(inputBox).click().perform();
			uploadDocuments(filePath);
			Alert alert = driver.switchTo().alert();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
