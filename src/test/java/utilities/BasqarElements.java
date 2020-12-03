package utilities;

import org.openqa.selenium.*;

import java.util.ArrayList;
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

    public BasqarElements filterByText(String text){
        List<WebElement> e = new ArrayList<>();
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().contains(text.toLowerCase()))
                e.add(element);
        }
        elements = e;
        return this;
    }

    public BasqarElement filterWithText(String text){
        List<WebElement> e = new ArrayList<>();
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().equalsIgnoreCase(text))
                e.add(element);
        }
        return $(e.get(0));
    }


}
