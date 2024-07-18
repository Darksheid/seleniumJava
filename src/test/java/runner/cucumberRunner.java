package runner;

import cucumber.api.CucumberOptions; //present in cucumber core jar
import cucumber.api.junit.Cucumber;  //cucumber junit dependency
import cucumber.api.testng.AbstractTestNGCucumberTests;  //cucumber testng dependency

import org.junit.runner.RunWith;   //cucumber junit dependency


@RunWith(Cucumber.class) //@Runwith cucumber unit dependency
@CucumberOptions(features = { "src/test/java/features/user_story.feature" }, glue = "stepDefinition", tags = "@testRun")

public class cucumberRunner extends AbstractTestNGCucumberTests {

}
