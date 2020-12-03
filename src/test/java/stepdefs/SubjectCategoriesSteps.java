package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageModels.NavBarObjects;
import utilities.NotificationResults;
import utilities.ParentClass;

import static utilities.BasqarElement.$;
import static utilities.Buttons.Save;

public class SubjectCategoriesSteps extends ParentClass {


    @And("^user navigate to subject categories page$")
    public void userNavigateToSubjectCategoriesPage() {
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.SubjectCategories);
    }

    @When("^user create a subject category name as \"([^\"]*)\" and code as \"([^\"]*)\"$")
    public void userCreateASubjetCategoryAsAndCodeAs(String subjectCategory, String code) {
        $(PageButtonAdd).click();
        $(DialogFormNameInput).sendKeys(subjectCategory);
        $(DialogFormCodeInput).sendKeys(code);
        clickToDialogButton(Save);
    }

    @Then("^subject category should be created$")
    public void subjetCategoryShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user delete the subject category name as \"([^\"]*)\"$")
    public void userDeleteTheSubjectCategoryNameAs(String name) {
        deleteTheTableData(name);
    }

    @Then("^subject category should be deleted$")
    public void subjectCategoryShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }

    @When("^user update the subject category named \"([^\"]*)\" to name as \"([^\"]*)\" and code as \"([^\"]*)\"$")
    public void userUpdateTheSubjectCategoryNamedToNameAsAndCodeAs(String oldName, String name, String code) {
        editTheTableData(oldName);
        if (name.length()>0)
            $(DialogFormNameInput).sendKeys(name);

        if (code.length()>0)
            $(DialogFormCodeInput).sendKeys(code);

        clickToDialogButton(Save);
    }

    @Then("^subject category should be updated$")
    public void subjectCategoryShouldBeUpdated() {
        notificationShouldbe(NotificationResults.updated);
    }

    @Then("^subject category should not be deleted$")
    public void subjectCategoryShouldNotBeDeleted() {
        notificationShouldbe(NotificationResults.Error);
    }
}
