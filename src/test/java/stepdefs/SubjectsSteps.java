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

public class SubjectsSteps extends ParentClass {

    @And("^user navigate to subjects page$")
    public void userNavigateToSubjectsPage() {
        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.Subjects);
    }

    @When("^user create a subject as follows$")
    public void userCreateASubjectAsFollows(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);

        String name="", code="", category="";
        int style=0;

        for(Map.Entry entry : map.entrySet()){
            if (entry.getKey().toString().contains("name"))
                name = entry.getValue().toString();
            else if (entry.getKey().toString().contains("code"))
                code = entry.getValue().toString();
            else if (entry.getKey().toString().contains("category")) {
                category = entry.getValue().toString();
            } else if (entry.getKey().toString().contains("style"))
                try {
                    style = Integer.parseInt(entry.getValue().toString());
                }catch (Exception e){
                    style = 1;
                }
        }

        $(PageButtonAdd).click();
        $(DialogFormNameInput).sendKeys(name);
        $(DialogFormCodeInput).sendKeys(code);
        if (isInteger(category))
            $(DialogFormSubjectCategorySelect).selectOptionWithIndex(getIntVal(category));
        else
            $(DialogFormSubjectCategorySelect).selectOptionWithText(category);

        $(DialogFormStyleSelect).selectOptionWithIndex(style);
        clickToDialogButton(Save);

    }

    @Then("^subject should be created$")
    public void subjectShouldBeCreated() {
        notificationShouldbe(NotificationResults.created);
    }

    @When("^user delete the subject name as \"([^\"]*)\"$")
    public void userDeleteTheSubjectNameAs(String subject)  {
        deleteTheTableData(subject);
    }

    @Then("^subject should be deleted$")
    public void subjectShouldBeDeleted() {
        notificationShouldbe(NotificationResults.deleted);
    }

}
