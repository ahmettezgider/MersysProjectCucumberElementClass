package pages;


import org.testng.annotations.Test;
import pageModels.NavBarObjects;
import utilities.Condition;
import utilities.ParentClass;


import static utilities.BasqarElement.*;

public class xx extends ParentClass {

    @Test
    public void test1() {

        String username = "daulet2030@gmail.com";
        String password = "TechnoStudy123@";
        String url = "https://test.basqar.techno.study/";


        open(url);
        $(LoginPageUserName).shouldBe(Condition.appear).clear().sendKeys(username);
        $(LoginPagePassword).clear().sendKeys(password);
        $(LoginPageSubmitButton).click();

        if ($(CookieDialogBox).isEnabled()) {
            $(CookieDialogButton).shouldBe(Condition.enabled).click();
        }

        clickOnMenuTo(NavBarObjects.Dashboard);
        clickOnMenuTo(NavBarObjects.Cities);

        $(PageButtonAdd).click();
        $(DialogFormCountrySelect).click();
        $(ListOfOptions).selectOptionWithText("Turkey");
        //selectOption(DialogFormCountrySelect, countryIndex);
        $(DialogFormNameInput).sendKeys("deneme");

        //Driver.quitDriver();

    }
}

