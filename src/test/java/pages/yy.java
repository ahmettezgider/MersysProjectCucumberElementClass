package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.Condition;
import utilities.Driver;

import static utilities.BasqarElement.$;
import static utilities.BasqarElement.open;
import static utilities.BasqarElements.$$;

public class yy {
    String url = "http://automationpractice.com";
    String username = "deneme@gmail.com";
    String password = "deneme";

    By loginForm = By.cssSelector("form#login_form");
    By loginLink = By.cssSelector("a.login");
    By logoutLink = By.cssSelector("a.logout");
    By loginUsername = By.cssSelector("input[id='email']");
    By loginPassword = By.cssSelector("input[id='passwd']");
    By loginSubmitButton = By.cssSelector("button[id='SubmitLogin']");

    By productList = By.cssSelector("ul.product_list>li");
    By searchInput = By.id("search_query_top");
    By searchButton = By.cssSelector("button[name='submit_search']");

    @Parameters("browser")
    @Test
    public void test1() {
        // Driver.browsers.set(browser);
        open(url);
        $(searchInput).sendKeys("summer").pressEnter();
        for (WebElement e : $$(productList).getElements())
            System.out.println(e.getText());

        $(loginLink).click();
        $(loginForm).find(loginUsername).sendKeys(username);
        $(loginForm).find(loginPassword).sendKeys(password).pressEnter();
        $(searchInput).clear().sendKeys("blouse").pressEnter();

        $(logoutLink).click();
        $(loginLink).shouldBe(Condition.appear);

        Driver.quitDriver();

    }
}

