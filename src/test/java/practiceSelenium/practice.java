package practiceSelenium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class practice {

	public static WebDriver driver;
	public static Actions ac;
	public static Alert alert;

	public static void navigateToUrl(String url) {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Projects\\revision\\src\\test\\java\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//h1[text()='Practice Page']"));

	}

	public static void changeWindow() {
		String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String childWindow : windows) {
			if (!childWindow.equals(currentWindow)) {
				driver.switchTo().window(childWindow);
				break;
			}

		}
		try {
			driver.findElement(By.xpath("(//img[@src='images/qaclick1.png'])[1]"));
			System.out.println("Sucessfully changed to new window!!");
			System.out.println(driver.getWindowHandle());
		} catch (Exception e) {
			System.out.println("Didnot changed to new Window");
		}
	}

	public static void test1() throws InterruptedException {
		List<WebElement> chkboxs = driver.findElements(By.xpath("//fieldset//input[@type='checkbox']"));
		for (WebElement box : chkboxs) {
			box.click();
			String value = box.getAttribute("value");
			driver.findElement(By.xpath("//select//option[@value='" + value + "']")).click();
			Thread.sleep(3000);
			box.click();
		}
	}

	public static void testSuggestions(String input) {
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).sendKeys(input);
		List<WebElement> suggestBox = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		System.out.println("Suggestions shown are below:");
		for (WebElement element : suggestBox)
			System.out.println(element.getText().trim());

	}

	public static void changeTab() {
		changeWindow();
	}

	public static void alertDismiss(String text) {
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Alert alert = driver.switchTo().alert();
		String alrtMsg = alert.getText().trim();
		if (alrtMsg.equals("Hello " + text + ", share this practice page and share your knowledge"))
			System.out.println("Alert Displayed correctly with msg :\n" + alrtMsg);
		alert.dismiss();
	}

	public static void alertConfirm(String text) {
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Alert alert = driver.switchTo().alert();
		String alrtMsg = alert.getText().trim();
		if (alrtMsg.equals("Hello " + text + ", share this practice page and share your knowledge"))
			System.out.println("Alert Displayed correctly with msg :\n" + alrtMsg);
		alert.accept();
	}

	public static void validateElementPresence() {
		WebElement textBox = driver.findElement(By.xpath("//input[@id='displayed-text']"));
		Boolean isVisible = textBox.isDisplayed();
		if (isVisible)
			System.out.println("TextBox :: Displayed");
		else
			System.out.println("TextBox :: Invisible");
	}

	public static void hideNSeek() {
		validateElementPresence();
		driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		System.out.println("After hiding the textbox");
		validateElementPresence();
		driver.findElement(By.xpath("//input[@id='show-textbox']")).click();
		System.out.println("After Showing the textbox");
		validateElementPresence();
	}

	public static void iframesValidation() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='courses-iframe']")));
		String text = driver.findElement(By.xpath("//div[@id='showHeader']//div[@class='clearfix']")).getText().trim()
				+ " " + driver.findElement(By.xpath("//span[@id='salesEndsIn']//b")).getText().trim();
		System.out.println("Output text ::\n" + text);
	}

	public static void mouseHover() {
		WebElement hoverBox = driver.findElement(By.xpath("//button[@id='mousehover']"));
		ac = new Actions(driver);
		ac.moveToElement(hoverBox).build().perform();
		WebElement topBtnLink = driver.findElement(By.xpath("//a[text()='Top']"));
		System.out.println("Top Btn link is Displayed:: " + topBtnLink.isDisplayed());
		ac.moveToElement(topBtnLink).click().build().perform();

	}

	public static void getTableData() {
		WebElement table = driver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']"));
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		List<WebElement> rows = driver
				.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody//tr"));
		List<WebElement> headers = driver
				.findElements(By.xpath(("//div[@class='tableFixHead']//table[@id='product']//thead//th")));
		for (int i = 1; i <= rows.size(); i++) {
			HashMap<String, String> data = new HashMap<String, String>();
			for (int j = 1; j <= headers.size(); j++) {
				String key = headers.get(j - 1).getText().trim();
				String value = driver.findElement(By.xpath(
						"(//div[@class='tableFixHead']//table[@id='product']//tbody//tr)[" + i + "]//td[" + j + "]"))
						.getText().trim();
				data.put(key, value);
			}
			mylist.add(data);
		}
		String msg = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().trim();
		System.out.println("Message :: " + msg);

		int amount = Integer.valueOf(msg.split(": ")[1]);
		System.out.println("Amount :: " + amount);

		int actualAmount = 0;
		for (HashMap<String, String> record : mylist)
			actualAmount = actualAmount + Integer.valueOf(record.get("Amount"));

		if (actualAmount == amount)
			System.out.println("Value matching :: Validation successful!!");
		else
			System.out.println("Value NOT matching :: Validation NOT successful!!");

	}

	public static boolean validateWordInDropDown(String s) {

		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		for (WebElement ele : options) {
			if (!ele.getText().trim().contains(s) && !ele.getText().trim().equals("Select"))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws InterruptedException {
		navigateToUrl("https://rahulshettyacademy.com/AutomationPractice");
		// driver.findElement(By.xpath("//button[text()='Open Window']")).click();
		// changeWindow();
		// testSuggestions("India");
		// driver.findElement(By.xpath("//a[@id='opentab']")).click();
		// changeTab();
		// alertDismiss("Tanmoy");
		// alertConfirm("Tanmoy");
		// hideNSeek();
		// iframesValidation();
		// mouseHover();
		// getTableData();
		String s ="Option";
		System.out.println("DropDown Contains word "+s+" :: " +validateWordInDropDown(s) );
		//System.out.println(s.contains("Opt"));
		driver.quit();

	}
}
