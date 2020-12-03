package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.BrowserSize;
import pageModels.NavBarObjects;
import utilities.ParentClass;

import java.util.List;

public class NavigationSteps extends ParentClass {


    @When("^the browser size is \"([^\"]*)\"$")
    public void theBrowserSizeIs(String browserSize)  {
        BrowserSize size = BrowserSize.valueOf(browserSize);
        setBrowserSize(size);
    }

    @Then("^user should navigate to the following links on menu$")
    public void userNavigateToTheFollowingLinksOnMenu(DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        for (String linkText : list) {
            NavBarObjects link = NavBarObjects.valueOf(linkText);
            clickOnMenuTo(link);
        }
    }

    @And("^user logout from basqar$")
    public void userLogout() {
        logout();
    }

}

