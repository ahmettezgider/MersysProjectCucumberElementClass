package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import utilities.NotificationResults;
import utilities.ParentClass;

import static utilities.BasqarElement.$;
import static utilities.Buttons.Save;

public class PositionsSteps extends ParentClass {

    @And("^user navigate to positions page$")
    public void userNavigateToPositionsPage() {
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.Positions);
    }

    @When("^user create a position name as \"([^\"]*)\" and short name as \"([^\"]*)\"$")
    public void userCreateAPositionNameAsAndShortNameAs(String name, String shortName) {
        $(PageButtonAdd).click();
        $(DialogFormNameInput).sendKeys(name);
        $(DialogFormShortNameInput).sendKeys(shortName);
        clickToDialogButton(Save);
    }

    @Then("^position should be created$")
    public void positionShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user update the position named \"([^\"]*)\" to name as \"([^\"]*)\" and code as \"([^\"]*)\"$")
    public void userUpdateThePositionNamedToNameAsAndCodeAs(String oldName, String name, String code)  {
        editTheTableData(oldName);
        if (name.length()>0){
            $(DialogFormNameInput).clear().sendKeys(name);
        }
        if (code.length()>0) {
            $(DialogFormShortNameInput).clear().sendKeys(code);
        }
        clickToDialogButton(Save);
    }

    @Then("^position should be updated$")
    public void positionShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @When("^user edit the position named \"([^\"]*)\"$")
    public void userEditThePositionNamed(String name)  {
        editTheTableData(name);
    }

    @When("^user delete the position named as \"([^\"]*)\"$")
    public void userDeleteThePositionNamedAs(String name)  {
        deleteTheTableData(name);
    }

    @Then("^position should be deleted$")
    public void positionShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }
}
