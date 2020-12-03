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


public class CitySteps extends ParentClass {

    @And("^user navigate to cities page$")
    public void userNavigateToCityPage() {
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.Cities);
    }

    @When("^user create a city to the country \"([^\"]*)\" which name is \"([^\"]*)\"$")
    public void userCreateACityToTheCountryWhichNameIs(String country, String city) {
        $(PageButtonAdd).click();
        $(DialogFormCountrySelect).selectOptionWithText(country);
        $(DialogFormNameInput).sendKeys(city);
        clickToDialogButton(Save);
    }

    @When("^user create a city which name is \"([^\"]*)\" to the country with option (\\d+)$")
    public void userCreateACityToTheCountryWithOptionWhichNameIs(String city, int countryOption) {
        $(PageButtonAdd).click();
        $(DialogFormCountrySelect).selectOptionWithIndex(countryOption);
        $(DialogFormNameInput).sendKeys(city);
        clickToDialogButton(Save);
    }

    @Then("^city should be created$")
    public void cityyShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user delete the city named as \"([^\"]*)\"$")
    public void userDeleteTheCityNamedAs(String name) {
        deleteTheTableData(name);
    }

    @Then("^city should be deleted$")
    public void cityShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }

    @Then("^city should be updated$")
    public void cityShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @Then("^country should not be deleted$")
    public void countryShouldNotBeDeleted() {
        notificationShouldbe(NotificationResults.Error);
    }


    public void update(String oldName, String newName){
        editTheTableData(oldName);
        if (newName.length()>0) {
            $(DialogFormNameInput).shouldBe(Condition.enabled).clear().sendKeys(newName);
        }
        clickToDialogButton(Save);
    }
}
