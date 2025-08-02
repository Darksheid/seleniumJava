package stepDefinition;

import java.io.IOException;

import org.junit.Assert; //cucumber junit dependency
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given; //io.cucumber-java dependency
import cucumber.api.java.en.Then; //io.cucumber-java dependency
import tests.googlePage;
import utilities.DriverManager1;
import utilities.excelFunctions;
import utilities.launchBrowser;

public class steps {
	private WebDriver driver;
	private launchBrowser launchBrowser;
	private googlePage gp;
	private excelFunctions excelFunctions;
	private String TestName;

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
		driver = launchBrowser.chromeDriver();
		gp = new googlePage(driver);
		excelFunctions = new excelFunctions();
		String url = excelFunctions.get_cell_value_from_driver_excel(tcName, get_url_from_excel);
		url = "https://www.python.org/downloads/";
		Assert.assertTrue(gp.navigateGooglePage(url));
	}

	@Then("user tests download")
	public void test_download() throws IOException, InterruptedException {
		// driver = launchBrowser.chromeDriver();
		driver = DriverManager1.createWebDriver("chrome");
		gp = new googlePage(driver);
		String url = "https://www.python.org/downloads/windows/";
		Assert.assertTrue(gp.download(url));
	}

	@Then("User searches {string} in the Google home page")
	public void user_searches_in_the_Google_home_page(String get_keyword_from_excel) {
		String keyword = excelFunctions.get_cell_value_from_driver_excel(TestName, get_keyword_from_excel);
		Assert.assertTrue(gp.searchText(keyword));
	}

	@Then("Verify the results")
	public void verify_the_results() {
		Assert.assertTrue(gp.validateSearch());
	}

	@Then("user closes the application")
	public void close_application() {
		System.out.println("Closing all applications");
		driver.quit();
		Assert.assertTrue(true);
	}

}
