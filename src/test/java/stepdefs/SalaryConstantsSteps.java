package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import utilities.NotificationResults;
import utilities.ParentClass;

import java.util.Map;

import static utilities.BasqarElement.$;
import static utilities.Buttons.Save;

public class SalaryConstantsSteps extends ParentClass {

    private void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.SalaryConstants);
    }

    @And("^user navigate to salary constants page$")
    public void userNavigateToSalaryConstantsPage() {
        getPage();
    }

    @When("^user create a salary constant as follows$")
    public void userCreateASalaryConstantAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String validFormDate = map.get("validFormDate");
        String key = map.get("key");
        int value = Integer.parseInt(map.get("value"));
        $(PageButtonAdd).click();
        $(DialogFormName2Input).sendKeys(name);
        $(DialogFormValidFormInput).click();
        setCalenderDate(validFormDate);
        $(DialogFormKeyInput).sendKeys(key);
        $(DialogFormValueIntInput).sendKeys(value+"");
        clickToDialogButton(Save);
    }

    @Then("^salary constant should be created$")
    public void salaryConstantShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user update the salary constant name as \"([^\"]*)\" as follows$")
    public void userUpdateTheSalaryConstantNameAsAsFollows(String oldName, DataTable dataTable)  {
        getPage();
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String validFormDate = map.get("validFormDate");
        String key = map.get("key");
        int value = Integer.parseInt(map.get("value"));
        searchInTextField(PageFormNameInput2, oldName);

        editTheTableData(oldName);
        if (name.length()>0)
            $(DialogFormName2Input).clear().sendKeys(name);

        if (validFormDate.length()>0) {
            $(DialogFormValidFormInput).clear();
            setCalenderDate(validFormDate);
        }
        if (key.length()>0)
            $(DialogFormKeyInput).clear().sendKeys(key);

        $(DialogFormValueIntInput).sendKeys(value+"");
        clickToDialogButton(Save);
    }

    @Then("^salary constant should be updated$")
    public void salaryConstantShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @When("^user delete the constant type named as \"([^\"]*)\"$")
    public void userDeleteTheConstantTypeNamedAs(String name) {
        getPage();
        searchInTextField(PageFormNameInput2, name);
        deleteTheTableData(name);
    }

    @Then("^salary constant should be deleted$")
    public void salaryConstantShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }
}
