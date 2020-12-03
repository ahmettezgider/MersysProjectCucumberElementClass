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

public class SalaryModifiersSteps extends ParentClass {

    private void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.SalaryModifiers);
    }

    @And("^user navigate to salary modifiers page$")
    public void userNavigateToSalaryModifiersPage() {
        getPage();
    }

    @When("^user create a salary modifier as follows$")
    public void userCreateASalaryModifierAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String description = map.get("description");
        String variable = map.get("variable");
        String modifierType = map.get("modifierType");
        String integrationCode = map.get("integrationCode");
        String valueType = map.get("valueType");
        String priority = map.get("priority");
        String amount = map.get("amount");
        String formula = map.get("formula");
        String name = map.get("name");
        String formulaVariable = map.get("formulaVariable");
        String modifierVariableType = map.get("modifierVariableType");

        $(PageButtonAdd).click();
        $(PageFormDescriptionInput).sendKeys(description);
        $(PageFormVariableInput).sendKeys(variable);
        selectOption(PageFormModifierTypeSelect, Integer.parseInt(modifierType));
        $(PageFormIntegrationCodeInput).sendKeys(integrationCode);
        selectOption(PageFormValueTypeSelect, Integer.parseInt(valueType));
        $(PageFormPriorityIntInput).sendKeys(priority+"");
        if ($(PageFormValueTypeSelect).getText().equalsIgnoreCase("formula")){
            $(PageFormFormulaInput).sendKeys(formula);
        }else {
            $(PageFormAmountIntInput).sendKeys(amount);
        }
        $(PageButtonAdd).click();

        $(DialogFormName2Input).sendKeys(name);
        $(DialogFormFormulaVariableInput).sendKeys(formulaVariable);
        selectOption(DialogFormModifierVariableTypeSelect, Integer.parseInt(modifierVariableType));
        $(DialogButtonApplyWithText).click();

        $(PageButtonSaveWithText).click();
        getPage();
    }

    @Then("^salary modifier should be created$")
    public void salaryModifierShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user update the salary modifier named as \"([^\"]*)\" as follows$")
    public void userUpdateTheSalaryModifierNamedAsAsFollows(String oldDesc, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String description = map.get("description");
        String variable = map.get("variable");
        String modifierType = map.get("modifierType");
        String integrationCode = map.get("integrationCode");
        String valueType = map.get("valueType");
        String priority = map.get("priority");
        String amount = map.get("amount");
        String formula = map.get("formula");
        String name = map.get("name");
        String formulaVariable = map.get("formulaVariable");
        String modifierVariableType = map.get("modifierVariableType");

        getPage();
        editTheTableData(oldDesc);
        $(PageFormDescriptionInput).sendKeys(description);
        $(PageFormVariableInput).sendKeys(variable);
        selectOption(PageFormModifierTypeSelect, Integer.parseInt(modifierType));
        $(PageFormIntegrationCodeInput).sendKeys(integrationCode);
        selectOption(PageFormValueTypeSelect, Integer.parseInt(valueType));
        $(PageFormPriorityIntInput).sendKeys(priority+"");
        if ($(PageFormValueTypeSelect).getText().equalsIgnoreCase("formula")){
            $(PageFormFormulaInput).sendKeys(formula);
        }else {
            $(PageFormAmountIntInput).sendKeys(amount);
        }
        $(PageButtonAdd).click();

        $(DialogFormName2Input).sendKeys(name);
        $(DialogFormFormulaVariableInput).sendKeys(formulaVariable);
        selectOption(DialogFormModifierVariableTypeSelect, Integer.parseInt(modifierVariableType));
        $(DialogButtonApplyWithText).click();

        $(PageButtonSaveWithText).click();
    }

    @Then("^salary modifier should be updated$")
    public void salaryModifierShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @When("^user delete the salary modifier named as \"([^\"]*)\"$")
    public void userDeleteTheSalaryModifierNamedAs(String description) {
        getPage();
        deleteTheTableData(description);
    }

    @Then("^salary modifier should be deleted$")
    public void salaryModifierShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }

}
