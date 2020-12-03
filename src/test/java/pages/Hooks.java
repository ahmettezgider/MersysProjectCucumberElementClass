package pages;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.ParentClass;


public class Hooks extends ParentClass {

    @Before
    public void before(Scenario scenario) {
    }

    @After
    public void after(Scenario scenario) {

        if (scenario.getStatus().equalsIgnoreCase("failed")) {
            String scenarioName = scenario.getName();
            takeScreenshot(scenarioName);
        }

    }
}
