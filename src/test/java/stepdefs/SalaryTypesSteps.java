package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import utilities.NotificationResults;
import utilities.ParentClass;

import static utilities.BasqarElement.$;
import static utilities.Buttons.Save;

public class SalaryTypesSteps extends ParentClass {

    @And("^user navigate to salary types page$")
    public void userNavigateToSalaryTapesPage() {
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.SalaryTypes);
    }

    @When("^user create a salary type name as \"([^\"]*)\" and user type as \"([^\"]*)\"$")
    public void userCreateASalaryTypeNameAsAndUserTypeAs(String name, String userType)  {
        $(PageButtonAdd).click();
        $(DialogFormNameInput).sendKeys(name);
        if (isInteger(userType))
            selectOptionMulti(DialogFormUserTypeMultiSelect, getIntVal(userType));
        else
            selectOptionMulti(DialogFormUserTypeMultiSelect, userType);
        clickToDialogButton(Save);
    }

    @Then("^salary type should be created$")
    public void salaryTypeShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user update the salary type named \"([^\"]*)\" to name as \"([^\"]*)\" and user type as \"([^\"]*)\"$")
    public void userUpdateTheSalaryTypeNamedToNameAsAndUserTypeAs(String oldName,
                                                                  String name,
                                                                  String userType)  {
        editTheTableData(oldName);
        if (name.length()>0)
            $(DialogFormNameInput).clear().sendKeys(name);

        if (userType.length()>0) {
            deleteMultiSelectOptions(MultiSelectOptionDelete);
            if (isInteger(userType))
                selectOptionMulti(DialogFormUserTypeMultiSelect, getIntVal(userType));
            else
                selectOptionMulti(DialogFormUserTypeMultiSelect, userType);
        }
        clickToDialogButton(Save);
    }

    @Then("^salary type should be updated$")
    public void salaryTypeShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @When("^user edit the salary type named \"([^\"]*)\"$")
    public void userEditTheSalaryTypeNamed(String name) {
        editTheTableData(name);
    }

    @When("^user delete the salary type named as \"([^\"]*)\"$")
    public void userDeleteTheSalaryTypeNamedAs(String name) {
        deleteTheTableData(name);
    }

    @Then("^salary type should be deleted$")
    public void salaryTypeShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }
}
