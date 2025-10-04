package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/java/features/user_story.feature", glue = "stepDefinition", tags = "@test_run", plugin = {
		"json:target/result/cucumber.json" }, // generate result in target/result folder
		monochrome = true)

public class cucumberRunner {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void runScenario1(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
		// the 'featureWrapper' parameter solely exists to display the feature file in a
		// test report
		testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
		if (testNGCucumberRunner == null) {
			return new Object[0][0];
		}
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		if (testNGCucumberRunner == null) {
			return;
		}
		testNGCucumberRunner.finish();
	}

}
