package utilities;

import org.openqa.selenium.*;

import java.util.List;

import static utilities.BasqarElement.$;


public class BasqarElements {

    public static BasqarElements $$(By by){ return new BasqarElements(by); }

    private WebDriver driver;
    private List<WebElement> elements;
    private By by;

    private BasqarElements(){
        this.driver = Driver.getDriver();
    }

    private BasqarElements(By by){
        this();
        this.by = by;
        elements = driver.findElements(by);
    }

    public List<WebElement> getElements(){
        return elements;
    }

    public int size(){
        return elements.size();
    }


}
