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

public class CostCentersSteps extends ParentClass {

    @And("^user navigate to cost centers page$")
    public void userNavigateToCostCentersPage() {
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.CostCenters);
    }

    @When("^user create a cost center as follows$")
    public void userCreateACostCenterAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String code = map.get("code");
        String type = map.get("type");
        int orderNo = Integer.parseInt(map.get("orderNo"));
        String key = map.get("key");
        String value = map.get("value");
        int expense = Integer.parseInt(map.get("expense"));

        $(PageButtonAdd).click();
        $(DialogFormNameInput).sendKeys(name);
        $(DialogFormCodeInput).sendKeys(code);
        if (isInteger(type))
            $(DialogFormTypeSelect).selectOptionWithIndex(getIntVal(type));
        else
            $(DialogFormTypeSelect).selectOptionWithText(type);

        $(DialogFormOrderInput).sendKeys(orderNo+"");
        selectOptionMulti(DialogFormExpenseAccoutMultiSelect, expense);
        $(TabPageConstants).click();
        $(DialogFormKeyInput).sendKeys(key);
        $(DialogFormValueTextInput).sendKeys(value);
        $(DialogButtonAddWithText).click();
        clickToDialogButton(Save);

    }

    @Then("^cost center should be created$")
    public void costCenterShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user update the cost center name as \"([^\"]*)\" as follows$")
    public void userUpdateTheCostCenterNameAsAsFollows(String oldName, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String code = map.get("code");
        String type = map.get("type");
        int orderNo = Integer.parseInt(map.get("orderNo"));
        String key = map.get("key");
        String value = map.get("value");
        String expense = map.get("expense");

        editTheTableData(oldName);
        if (name.length() > 0)
            $(DialogFormNameInput).clear().sendKeys(name);

        if (code.length() > 0)
            $(DialogFormCodeInput).sendKeys(code);

        if (isInteger(type))
            $(DialogFormTypeSelect).selectOptionWithIndex(getIntVal(type));
        else
            $(DialogFormTypeSelect).selectOptionWithText(type);

        if (orderNo > 0)
            $(DialogFormOrderInput).sendKeys(orderNo+"");

        if (expense.length()>0) {
            deleteMultiSelectOptions(MultiSelectOptionDelete);
            selectOptionMulti(DialogFormExpenseAccoutMultiSelect, expense);
        }
        $(TabPageConstants).click();
        if (key.length() > 0) $(DialogFormKeyInput).sendKeys(key);
        if (value.length() > 0) $(DialogFormValueTextInput).sendKeys(value);

        clickToDialogButton(Save);

    }

    @Then("^cost center should be updated$")
    public void costCenterShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @When("^user delete the cost center named as \"([^\"]*)\"$")
    public void userDeleteTheCostCenterNamedAs(String name) {
        deleteTheTableData(name);
    }

    @Then("^cost center should be deleted$")
    public void costCenterShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }
}
