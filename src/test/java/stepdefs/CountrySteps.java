package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import utilities.Condition;
import utilities.NotificationResults;
import utilities.ParentClass;

import static utilities.BasqarElement.$;
import static utilities.Buttons.Save;


public class CountrySteps extends ParentClass {

    @And("^user navigate to countries page$")
    public void userNavigateToCountriesPage() {
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.Countries);
    }

    @When("^user create a country name as \"([^\"]*)\" and code as \"([^\"]*)\"$")
    public void userCreateACountryNameAsAndCodeAs(String country, String code) {
        $(PageButtonAdd).click();
        $(DialogFormNameInput).shouldBe(Condition.enabled).sendKeys(country);
        $(DialogFormCodeInput).sendKeys(code);
        clickToDialogButton(Save);
    }

    @Then("^country should be created$")
    public void countryShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user edit the country named \"([^\"]*)\"$")
    public void userEditThe(String country) {
        editTheTableData(country);
    }

    @When("^user delete the country named as \"([^\"]*)\"$")
    public void userDeleteTheCountryNameAs(String country) {
        deleteTheTableData(country);
    }

    @Then("^country should be deleted$")
    public void countryShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }

    @When("^user update the country named \"([^\"]*)\" to name as \"([^\"]*)\" and code as \"([^\"]*)\"$")
    public void userUpdateCountryNewAsNameAndNewCode(String oldName, String name, String code)  {
        editTheTableData(oldName);
        if (name.length()>0){
            $(DialogFormNameInput).shouldBe(Condition.enabled).clear().sendKeys(name);
        }
        if (code.length()>0) {
            $(DialogFormCodeInput).clear().sendKeys(code);
        }
        clickToDialogButton(Save);
    }

    @Then("^country should be updated$")
    public void countryShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);

    }
}
