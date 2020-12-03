package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import utilities.Buttons;
import utilities.NotificationResults;
import utilities.ParentClass;

import java.util.Map;

import static utilities.BasqarElement.$;
import static utilities.Buttons.Save;

public class PositionSalarySteps extends ParentClass {


    @And("^user navigate to position salary page$")
    public void userNavigateToPositionSalary() {
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.PositionSalary);
    }

    @When("^user create a person to position salary name as \"([^\"]*)\"$")
    public void userCreateAPositionSalaryNameAs(String name) {
        $(PageButtonAdd).click();
        $(DialogFormNameInputInPosSal).sendKeys(name);
        clickToDialogButton(Save);
    }

    @Then("^person in position salary should be created$")
    public void personInPositionSalaryShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user update the person in position salary named \"([^\"]*)\" to name as \"([^\"]*)\"$")
    public void userUpdateThePositionSalaryNamedToNameAs(String oldName, String name) {
        editTheTableData(oldName);
        if (name.length()>0) {
            $(DialogFormNameInputInPosSal).clear().sendKeys(name);
        }
        clickToDialogButton(Save);
    }

    @Then("^person in position salary should be updated$")
    public void personInPositionSalaryShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @When("^user delete the person in position salary named as \"([^\"]*)\"$")
    public void userDeleteThePositionSalaryNamedAs(String name)  {
        deleteTheTableData(name);
    }

    @Then("^person in position salary should be deleted$")
    public void personInPositionSalaryShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }

    @When("^user edit the person in position salary named \"([^\"]*)\"$")
    public void userEditThePositionSalaryNamed(String name)  {
        editTheTableData(name);
    }

    @When("^user add position salary to the name \"([^\"]*)\" as follows$")
    public void userAddPositionSalaryToTheNameAsFollows(String name, DataTable dataTable)  {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String experience = map.get("experience");
        String from = map.get("fromDate");
        String salary = map.get("salary");
        String currency = map.get("currency");

        clickToAddPositionSalary(name);

        $(PageButtonAdd).click();
        $(DialogFormName2Input).sendKeys(experience);
        $(DialogFormFromDate).click();
        setCalenderDate(from);
        $(DialogFormSalary).sendKeys(salary+"");
        if (isInteger(currency))
            $(PageFormCurrencySelect).selectOptionWithIndex(getIntVal(currency));
        else
            $(PageFormCurrencySelect).selectOptionWithText(currency);
        $(DialogButtonAddWithText).click();
        $(DialogContainerButtonSave).click();
    }

    @Then("^position salary should be created$")
    public void positionSalaryShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user update position salary to the name \"([^\"]*)\" as follows$")
    public void userUpdatePositionSalaryToTheNameAsFollows(String name, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String experience = map.get("experience");
        String from = map.get("fromDate");
        String salary = map.get("salary");
        String currency = map.get("currency");
        clickToAddPositionSalary(name);
        editTheTableData(experience);
        $(TableButtonEditUnique).click();
        $(DialogFormName2Input).clear();
        $(DialogFormFromDate).click();
        setCalenderDate(from);
        $(DialogFormSalary).clear().sendKeys(salary+"");
        selectOption(PageFormCurrencySelect, currency);
        $(DialogContainerButtonSave).click();
    }

    @Then("^position salary should be updated$")
    public void positionSalaryShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @When("^user delete position salary belogs to person named \"([^\"]*)\" with the text \"([^\"]*)\"$")
    public void userDeletePositionSalaryBelogsToPersonNamedWithTheText(String name, String text) {
        clickToAddPositionSalary(name);
        deleteTheTableData(text);
    }

    @Then("^position salary should be deleted$")
    public void positionSalaryShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }

    public void clickToAddPositionSalary(String name){
        clickToButtonInTable(PageFormButtonAddPositionSalary, name);
    }

    @And("^click to dialog \"([^\"]*)\" button$")
    public void userClickToDialogButton(String buttonString)  {
        Buttons button = getButtonFromText(buttonString);
        clickToDialogButton(button);
    }

}
