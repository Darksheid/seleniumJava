package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinition.BaseClass;

public class LoginPage extends BaseClass {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions ac;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		this.ac = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[text()='Login']")
	private WebElement hrm_login_hdr;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement input_username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement input_password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btn_submit;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement hdrDashboard;

	public boolean navigateUrl(String url) throws InterruptedException {
		boolean res = false;
		try {
			System.out.println("Launching Login page");
			driver.get(url);
			wait.until(ExpectedConditions.visibilityOf(hrm_login_hdr));
			scenario.log("User sucessfully navigated to Login page");
			takeScreenshot();
			res = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	public void takeScreenshot() {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "screenshot");
	}

	public boolean validateLoginPage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(hrm_login_hdr));
			System.out.println("HRM Login page is opened successfully!!!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean enterValue(String inputTxt) {
		try {
			if (inputTxt.toLowerCase().contains("username")) {
				System.out.println("User tyring to send username");
				ac.moveToElement(input_username).sendKeys(inputTxt, Keys.TAB).build().perform();
			} else {
				System.out.println("User tyring to send password");
				wait.until(ExpectedConditions.elementToBeClickable(input_password));
				ac.moveToElement(input_password).sendKeys(inputTxt, Keys.TAB).build().perform();
			}
			System.out.println(inputTxt + " is entered successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickButton(String buttonName) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btn_submit));
			btn_submit.click();
			System.out.println("btn_submit is clicked sucessfully!!!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validateDashboardLogin() {
		try {
			wait.until(ExpectedConditions.visibilityOf(hdrDashboard));
			System.out.println("Dashboard screen is navigated sucessfully!!!");
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
