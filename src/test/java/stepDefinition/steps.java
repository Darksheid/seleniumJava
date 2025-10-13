package stepDefinition;

import org.junit.Assert; //cucumber junit dependency
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tests.LoginPage;
import utilities.excelFunctions;

public class steps extends BaseClass {
	private WebDriver driver;
	private LoginPage gp;
	private excelFunctions excelFunctions;
	private String TestName;

	@Before
	public void beforeMethod(Scenario scenario) throws Throwable {
		System.out.println("Execution started>>>>>>");
		initBeforeMethods(scenario);

	}

	// @After
	// public void tearDown(Scenario scenario) {
	// if (scenario.isFailed()) {
	// System.out.println("Scenario failed: " + scenario.getName());
	// byte[] screenshot = ((TakesScreenshot)
	// driver).getScreenshotAs(OutputType.BYTES);
	// scenario.attach(screenshot, "img/png", "failedScreenshot");
	// } else {
	// System.out.println("Scenario passed: " + scenario.getName());
	// }
	// }

	@Given("print running background steps")
	public void print_back_run() {
		System.out.println("Running background steps");
	}

	@Then("check print of background steps")
	public void check_print_of_background_steps() {
		System.out.println("Then check print of background steps");
	}

	@Given("User navigate to {string} for {string}")
	public void user_navigate_to_url(String get_url_from_excel, String tcName) throws InterruptedException {
		TestName = tcName;
		System.out.println("TC name>>>" + tcName);
		driver = utilities.launchBrowser.chromeDriver();
		gp = new LoginPage(driver);
		excelFunctions = new excelFunctions();
		String url = excelFunctions.get_cell_value_from_driver_excel(tcName, get_url_from_excel);
		Assert.assertTrue(gp.navigateUrl(url));
	}

	@Then("user closes the application")
	public void close_application() {
		System.out.println("Closing all applications");
		driver.quit();
		Assert.assertTrue(true);
	}

	@Then("validate that login page is displayed")
	public void validate_login_page() {
		Assert.assertTrue(gp.validateLoginPage());
	}

	@Then("user enters {string}")
	public void user_enters_value(String key) {
		key = excelFunctions.get_cell_value_from_driver_excel(TestName, key);
		System.out.println("key >> " + key);
		Assert.assertTrue(gp.enterValue(key));
	}

	@Then("clicks on {string} button")
	public void user_clicks_onlogin_btn(String buttonName) {
		Assert.assertTrue(gp.clickButton(buttonName));

	}

	@Then("validate that user is navigated to dashbaord screen")
	public void validate_dashborad_login() {
		Assert.assertTrue(gp.validateDashboardLogin());

	}
}
