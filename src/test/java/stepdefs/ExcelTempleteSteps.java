package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import utilities.NotificationResults;
import utilities.ParentClass;

import java.util.List;

import static utilities.BasqarElement.$;
import static utilities.Buttons.Close;
import static utilities.Buttons.Save;

public class ExcelTempleteSteps extends ParentClass {

    @And("^user navigate to excel templetes page$")
    public void userNavigateToExcelTempletesPage() {
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.ExcelTemplate);
    }

    @When("^user create a excel templete name as \"([^\"]*)\" and period as (\\d+)$")
    public void userCreateAExcelTempleteNameAsAndPeriodAs(String name, int period)  {
        $(PageButtonAdd).click();
        $(DialogFormNameInput).sendKeys(name);
        $(DialogFormPeriodCountInput).sendKeys(period+"");
        clickToDialogButton(Save);
        clickToDialogButton(Close);
    }

    @Then("^excel templete should be created$")
    public void excelTempleteShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user create a excel templete name as \"([^\"]*)\" and period as (\\d+) and row and column size as follows$")
    public void userCreateAExcelTempleteNameAsAndPeriodAsAndRowAndColumnSizeAsFollows(String name,
                                                                                      int period,
                                                                                      DataTable dataTable) {
       List<List<String>> lists = dataTable.asLists(String.class);
        $(PageButtonAdd).click();
        $(DialogFormNameInput).sendKeys(name);
        $(DialogFormPeriodCountInput).sendKeys(period+"");
        clickToDialogButton(Save);
        $(TabPageVersions).click();
        for (List<String> list : lists) {
            $(DialogFormRowSizeCountInput).sendKeys(list.get(0)+"");
            $(DialogFormColumnSizeCountInput).sendKeys(list.get(1)+"");
            $(DialogButtonAddVersion).click();
        }
        clickToDialogButton(Save);
        clickToDialogButton(Close);
    }

    @When("^user update the excel templete named \"([^\"]*)\" to name as \"([^\"]*)\" and period as (\\d+)$")
    public void userUpdateTheExcelTempleteNamedToNameAsAndPeriodAs(String oldName,
                                                                   String name,
                                                                   int period) {
        editTheTableData(oldName);
        if (name.length() > 0){
            $(DialogFormNameInput).clear().sendKeys(name);
        }
        if (period > 0) {
            $(DialogFormPeriodCountInput).clear().sendKeys(period+"");
        }
        clickToDialogButton(Save);
        $(TabPageVersions).click();
    }

    @Then("^excel templete should be updated$")
    public void excelTempleteShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @When("^user edit the excel templete named \"([^\"]*)\"$")
    public void userEditTheExcelTempleteNamed(String name) {
        editTheTableData(name);
        clickToDialogButton(Save);
        clickToDialogButton(Close);
    }

    @When("^user delete the excel templete named as \"([^\"]*)\"$")
    public void userDeleteTheExcelTempleteNamedAs(String name) {
        deleteTheTableData(name);
    }

    @Then("^excel templete should be deleted$")
    public void excelTempleteShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }
}
