package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pageModels.NavBarObjects;
import utilities.NotificationResults;
import utilities.ParentClass;

import java.util.Map;

import static utilities.BasqarElement.$;

public class BudgetAccountsSteps extends ParentClass {

    private void getPage(){
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.BudgetAccounts);
    }

    @And("^user navigate to budget accounts page$")
    public void userNavigateToBudgetAccountsPage() {
        getPage();
    }

    @When("^user create a budget account as follows$")
    public void userCreateABudgetAccountAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String code = map.get("code");
        String category = map.get("category");
        String type = map.get("type");
        String parentAccountCode = map.get("parentAccountCode");
        String closingAccountCode = map.get("closingAccountCode");
        String balanceType = map.get("balanceType");
        String integrationCodes = map.get("integrationCodes");
        String currency = map.get("currency");

        $(PageButtonAdd).click();

        $(DialogFormCodeInput).sendKeys(code);
        $(DialogFormNameInput).sendKeys(name);

        selectOption(PageFormCategorySelect, Integer.parseInt(category));
        selectOption(PageFormTypeSelect, type);
        switch (type.toLowerCase()){
            case "detail":
                $(PageFormParentClosingAccountCode).sendKeys(closingAccountCode);
                selectOption(3);
            case "auxiliary":
                $(PageFormParentAccountCode).sendKeys(parentAccountCode);
                selectOption(0);
        }
        $(PageFormBalanceTypeSelect).selectOptionWithText(balanceType);
        selectOption(PageFormCurrencySelect, currency);

        $(PageButtonSaveWithText).click();
    }

    @Then("^budget account should be created$")
    public void budgetAccountShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user delete the budget account named as \"([^\"]*)\"$")
    public void userDeleteTheBudgetAccountNamedAs(String name) {
        getPage();
        deleteTheTableData(name);
    }

    @Then("^budget account should be deleted$")
    public void budgetAccountShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }

    @And("^user delete the budget account named as \"([^\"]*)\" under category (\\d+)$")
    public void userDeleteTheBudgetAccountNamedAsUnderCategory(String name, int category) {
        getPage();
        $(PageFormCategorySelectInBudgetAccount).selectOptionWithIndex(category);
        searchInTextField(PageFormNameInputInBudgetAccount, name);
        deleteTheTableData(name);
    }

}
