package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.NotificationResults;
import utilities.ParentClass;

import java.util.List;

public class LoginSteps extends ParentClass {

    @Given("^user on home page$")
    public void userOnHomePage() {
        getHomePage();
        prepareLogin();
    }

    @And("^user logged in to basqar$")
    public void userLoggedInToBasqar() {
        login();
    }


    @When("^the users in the excel file \"([^\"]*)\" in the order \"([^\"]*)\" try to login$")
    public void theUsersInTheExcelFileInTheOrderTryToLogin(String excelFile, String rowNumber) {
        int row = Integer.parseInt(rowNumber);
        List<String> list = getExcelData(excelFile, "Sheet1", row);
        login(list.get(0), list.get(1));
    }

    @Then("^login should not be successfull$")
    public void loginShouldNotBeSuccessfull() {
        notificationShouldbe(NotificationResults.Error);
    }

    @Then("^user on the same page$")
    public void userOnTheSamePage() {
    }

}
