package stepDefinition;

import io.cucumber.java.Scenario;

public class BaseClass {

	protected static Scenario scenario;

	public static void initBeforeMethods(Scenario scenario) {
		BaseClass.scenario = scenario;
	}

}
