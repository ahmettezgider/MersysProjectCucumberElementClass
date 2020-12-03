package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import utilities.Condition;
import utilities.NotificationResults;
import utilities.ParentClass;

import java.util.Map;

import static utilities.BasqarElement.$;
import static utilities.Buttons.Save;

public class BankAccountsSteps extends ParentClass {

    @And("^user navigate to bank accounts page$")
    public void userNavigateToBankAccountsPage() {
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.BankAccounts);
    }

    @When("^user create a bank account as follows$")
    public void userCreateABankAccountAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String iban = map.get("iban");
        String currency = map.get("currency");
        String integrationCode = map.get("integrationCode");
        $(PageButtonAdd).click();
        $(DialogFormNameInput).sendKeys(name);
        $(DialogFormIban).sendKeys(iban);
        if (isInteger(currency))
            $(PageFormCurrencySelect).selectOptionWithIndex(getIntVal(currency));
        else
            $(PageFormCurrencySelect).selectOptionWithText(currency);

        $(DialogFormIntegrationCode).sendKeys(integrationCode);
        clickToDialogButton(Save);

    }

    @Then("^bank account should be created$")
    public void bankAccountShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user update the bank account named as \"([^\"]*)\" as follows$")
    public void userUpdateTheBankAccountAsFollows(String oldName, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String name = map.get("name");
        String iban = map.get("iban");
        String currency = map.get("currency");
        String integrationCode = map.get("integrationCode");
        editTheTableData(oldName);
        if (name.length()>0)
            $(DialogFormNameInput).clear().sendKeys(name);

        if (iban.length()==22)
            $(DialogFormIban).clear().sendKeys(iban);

        if (isInteger(currency))
            $(PageFormCurrencySelect).selectOptionWithIndex(getIntVal(currency));
        else
            $(PageFormCurrencySelect).selectOptionWithText(currency);

        if (integrationCode.length()>0)
            $(DialogFormIntegrationCode).clear().sendKeys(integrationCode);

        clickToDialogButton(Save);
    }

    @Then("^bank account should be updated$")
    public void bankAccountShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @When("^user delete the bank account named as \"([^\"]*)\"$")
    public void userDeleteTheBankAccountNamedAs(String name)  {
        deleteTheTableData(name);
    }

    @Then("^bank account should be deleted$")
    public void bankAccountShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }
}
