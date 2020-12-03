
package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import pageModels.*;
import pageModels.HomePageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;


import static utilities.BasqarElement.open;
import static utilities.Buttons.Close;
import static utilities.Buttons.Yes;
import static utilities.BasqarElement.$;
import static utilities.BasqarElements.$$;


public class ParentClass implements HomePageObjects, PageObjects, DialogObjects {

    /**
     * gets the homepage
     */
    public void getHomePage(){

        String url = "https://test.basqar.techno.study/";

        if (!isBrowserOnHomePage(url))
            open(url);
    }

    /**
     * whether the browser on homepage or not
     * @param url as string
     * @return true if on homepage
     */
    private boolean isBrowserOnHomePage(String url){
        return (Driver.getDriver() != null && Driver.getDriver().getCurrentUrl().contains(url));
    }

    /**
     * this method checks if already logged in. If already logged in then login stage passed
     */
    public void prepareLogin(){
        if (!isLoggedIn()) {
            if (!$(LoginButton).isExist()) {
                $(UserButton).click();
            }
            if ($(CookieDialogBox).isDisplayed()) {
                $(CookieDialogButton).shouldBe(Condition.enabled).click();
            }
        }
    }

    /**
     * this method login to the site with unoque credientals
     */
    public void login(){
        String username = "daulet2030@gmail.com";
        String password = "TechnoStudy123@";
        login(username, password);
    }

    /**
     * this method login to the site with different credentials
     * @param username username
     * @param password  password
     */
    public void login(String username, String password){
        if (!isLoggedIn()) {
            $(LoginButton).click();
            $(LoginPageUserName).clear().sendKeys(username);
            $(LoginPagePassword).clear().sendKeys(password);
            $(LoginPageSubmitButton).click();
        }
    }

    /**
     * logout method
     */
    public void logout(){
        openMenu();
        if ($(UserMenuVisible).isExist()){
            $(UserMenuVisible).click();
        }else{
            clickOnMenuTo(NavBarObjects.Dashboard);
            openMenu();
            $(UserMenuHidden).click();
        }
        $(Logout).click();
        Driver.quitDriver();
    }

    /**
     * controls if already logged in
     * @return true if logged in already
     */
    public boolean isLoggedIn(){
        return $$(UserMessageBell).size()>0;
    }

    /**
     * sets the browser size
     * @param size as BrowserSize enum
     */
    public void setBrowserSize(BrowserSize size){
        Driver.setBrowserSizeTo(size);
    }


    /**
     * if the menu is hidden opens it
     */
    public static void openMenu(){
        if ($(NavMenu).isMenuHidden()) {
            $(NavMenuToggleButton).click();
            if (!$(ToggleSideBarFolded).isMenuHidden())
                $(ToggleSideBarFolded).click();
            else if (!$(NavbarToggleButton).isMenuHidden())
                $(NavbarToggleButton).click();

            $(NavMenu).shouldBe(Condition.enabled);
        }
    }


    /**
     * this method clicks to the links on left menu
     * @param page  takes varargs from PageModelNavBar enum
     */
    public static void clickOnMenuTo(NavBarObjects page){

        openMenu();

        String[] linkTexts = page.getLinks();

        String strXpath = "//fuse-nav-vertical-group/div/fuse-nav-vertical-collapsable";
        for (int i=0; i<linkTexts.length; i++) {
            if (linkTexts[i].equalsIgnoreCase("dashboard"))
                strXpath = "(//span[contains(text(),'" + linkTexts[i] + "')])[1]";
            else
                strXpath += "/a/span[contains(text(),'" + linkTexts[i] + "')]";

            By by = By.xpath(strXpath);
            $(by).scrollIntoView().shouldBe(Condition.visible).click();
            strXpath += "//ancestor::fuse-nav-vertical-collapsable/";
        }
        $(By.xpath("//toolbar//*[contains(text(),'" + page.getHeader() + "')]")).shouldBe(Condition.exists);
    }


    /**
     *
     * @param result
     * @return
     */
    public boolean notificationShouldbe(NotificationResults result){
        return $(PopupMessageContainer)
                .shouldBe(Condition.exists)
                .getText()
                .toLowerCase()
                .contains(result.toString().toLowerCase());
    }

    /**
     * search in text field in page
     * @param by field selector
     * @param textToSearch text to be searched
     */
    public void searchInTextField(By by, String textToSearch){
        $(by).click();
        $(by).clear().sendKeys(textToSearch);
        $(PageButtonSearchWithText).click();
    }

    /**
     *
     * @param textToBeSearched
     * @return
     */
    public WebElement getTableRowWithText(String textToBeSearched){
        By byTr = By.xpath("//*[contains(text(),'" + textToBeSearched + "')]//ancestor::tr");
        return $(byTr).getElement();
    }


    /**
     *
     * @param button
     */
    public void clickToDialogButton(Buttons button){
        switch (button){
            case Save:
                $(DialogContainerButtonSave).shouldBe(Condition.appear).click();
                break;
            case Yes:
                $(DialogContainerButtonYes).shouldBe(Condition.appear).click();
                break;
            case No:
                $(DialogContainerButtonNo).shouldBe(Condition.appear).click();
                break;
            case Close:
                $(DialogContainerButtonClose).shouldBe(Condition.appear).click();
                break;
            case Apply:
                $(DialogButtonApplyWithText).shouldBe(Condition.appear).click();
        }
    }


    /**
     *
     * @param by
     * @param textToBeSearched
     */
    protected void clickToButtonInTable(By by, String textToBeSearched){
        WebElement row = getTableRowWithText(textToBeSearched);
        WebElement button;
        if (!$(TableButtonDialogEditDeleteButton).isEnabled()) {
            row.findElement(TableButtonDialogEditDeleteButton).click();
            button = $(TableButtonDialogEditDeleteDialog).find(by).getElement();
        }else {
            button = row.findElement(by);
        }
        button.click();
    }


    /**
     *
     * @param textToBeSearched
     */
    public void deleteTheTableData(String textToBeSearched){
        clickToButtonInTable(TableButtonDelete, textToBeSearched);
        $(DialogContainer).shouldBe(Condition.enabled);
        clickToDialogButton(Yes);
    }


    /**
     *
     * @param textToBeSearched
     */
    public void editTheTableData(String textToBeSearched){
        clickToButtonInTable(TableButtonEdit, textToBeSearched);
        $(DialogContainer).shouldBe(Condition.enabled);
    }


    /**
     *
     * @param buttonText
     * @return
     */
    public Buttons getButtonFromText(String buttonText){
        if (buttonText.toLowerCase().contains("save"))
            return Buttons.Save;
        else if (buttonText.toLowerCase().contains("yes"))
            return Buttons.Yes;
        else if (buttonText.toLowerCase().contains("no"))
            return Buttons.No;
        else
            return Close;
    }


    /**
     *
     * @param textToBeSearched
     * @return
     */
    public boolean isDataExistOnTable(String textToBeSearched){
        return getTableRowWithText(textToBeSearched).isEnabled();
    }


    public boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (Exception ignored){
            return false;
        }

    }

    public int getIntVal(String strNum){
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return Integer.MIN_VALUE;
        }
    }


    //  calender methods //////
    /**
     *
     * @param dayStr
     * @return
     */
    public static String formatDay(String dayStr){
        if (dayStr.length()==1)
            return "0" + dayStr;
        else
            return dayStr;
    }


    /**
     *
     * @param dateField
     * @param date
     */
    public void sendKeysToCalander(By dateField, LocalDate date){
        String dataToUSFormat = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        $(dateField).sendKeys(dataToUSFormat);
        if ($(Calender).isExist()){
            $(OverlayContainer).click();
        }
    }


    /**
     *
     * @param isoDate
     * @return
     */
    public LocalDate stringToDate(String isoDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(isoDate, formatter);
    }


    /**
     *
     * @param dateStr
     * @return
     */
    public String[] getYearMonthDayAsArray(String dateStr){
        String[] yearMonthDay = dateStr.split("-");
        LocalDate date = stringToDate(dateStr);
        yearMonthDay[1] = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
        return yearMonthDay;
    }


    /**
     *
     * @param month
     * @param monthCalender
     * @return
     */
    public int compareMonths(String month, String monthCalender){
        LinkedList<String> months =
                new LinkedList<>(Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"));
        int indexOfMonth = months.indexOf(month);
        int indexOfMonthCalender = months.indexOf(monthCalender);
        if (indexOfMonth > indexOfMonthCalender) return 1;
        else if (indexOfMonth < indexOfMonthCalender) return -1;
        else return 0;
    }


    /**
     * calender method, compare required date and calender date,
     * month and date respectively according to calenders middle month year (JAN 2020)
     * @param monthYear required month and year
     * @param monthYearCalender calender month and year
     * @return [1,2,3,4] == [one year back, one month back, one month forward, one year forward]
     */
    public int compareMonthYear(String monthYear, String monthYearCalender){

        String month = monthYear.replaceAll("[^A-Z]+","");
        int year = Integer.parseInt(monthYear.replaceAll("[^0-9]+",""));
        String monthCalender = monthYearCalender.replaceAll("[^A-Z]+","");
        int yearCalender = Integer.parseInt(monthYearCalender.replaceAll("[^0-9]+",""));

        if (year < yearCalender) return 1;
        if (year > yearCalender) return 4;
        if (compareMonths(month, monthCalender)==-1) return 2;
        if (compareMonths(month, monthCalender)==1) return 3;
        return 0;
    }


    /**
     * calender method, to directly set date value to inoutbox
     * @param dateStr date in String type as ISO format 2020-01-01
     */
    public void setCalenderDate(String dateStr){
        String[] dateArray = getYearMonthDayAsArray(dateStr);
        String monthYear = dateArray[1] + " " + dateArray[0];
        String monthYearCalender;
        do{
            monthYearCalender = $(CalanderMonthYearText).getText().trim();
            switch (compareMonthYear(monthYear, monthYearCalender)){
                case 1: $(CalanderPreviousYear).click(); break;
                case 2: $(CalanderPreviousMonth).click(); break;
                case 3: $(CalanderNextMonth).click(); break;
                case 4: $(CalanderNextYear).click(); break;
            }
        }while (compareMonthYear(monthYear, monthYearCalender)!=0);

        String day = Integer.parseInt(dateArray[2]) + "";
        $(CalanderMonthTable).find(By.xpath("//*[text()=' " + day + " ']")).click();
    }

    /**
     *
     * @param by
     * @param optionText
     */
    public void selectOption(By by, String optionText){
        $(by).click();
        WebElement option = null;
        List<WebElement> list = $$(ListOfOptions).getElements();
        for (WebElement element : list) {
            if ($(element).containsText(optionText)){
                option = element;
                break;
            }
        }
        $(option).scrollIntoView().click();
    }


    /**
     * select option from dropdown by index
     * @param optionNumber to select
     */
    public void selectOption(By by, int optionNumber){
        $(by).click();
        List<WebElement> list = $$(ListOfOptions).getElements();
        if (optionNumber >= list.size())
            optionNumber = list.size()-1;
        else if (optionNumber < 0)
            optionNumber = 0;

        WebElement option = $$(ListOfOptions).getElements().get(optionNumber);
        $(option).scrollIntoView().click();
    }


    /**
     *
     * @param optionText
     */
    public void selectOption(String optionText){
        WebElement option = null;
        List<WebElement> list = $$(ListOfOptions).getElements();
        for (WebElement element : list) {
            if ($(element).containsText(optionText)){
                option = element;
                break;
            }
        }
        $(option).scrollIntoView().click();
    }


    /**
     *
     * @param optionNumber
     */
    public void selectOption(int optionNumber){
        List<WebElement> list = $$(ListOfOptions).getElements();
        if (optionNumber >= list.size())
            optionNumber = list.size()-1;
        else if (optionNumber < 0)
            optionNumber = 0;

        WebElement option = $$(ListOfOptions).getElements().get(optionNumber);
        $(option).scrollIntoView().click();
    }


    /**
     *
     * @param by
     */
    public void deleteMultiSelectOptions(By by){
        List<WebElement> list = $$(by).getElements();
        for (WebElement element : list) {
            element.click();
        }
    }


    /**
     *
     * @param by
     * @param optionTexts
     */
    public void selectOptionMulti(By by, String...optionTexts){
        WebElement option = null;
        List<WebElement> list;
        for (int i=0; i<optionTexts.length; i++) {
            $(by).click();
            list = $$(ListOfOptions).getElements();
            for (WebElement element : list) {
                if (element.getText().equalsIgnoreCase(optionTexts[i])){
                    option = element;
                    break;
                }
            }
            $(option).scrollIntoView().click();
        }
    }


    /**
     *
     * @param by
     * @param optionNumbers
     */
    public void selectOptionMulti(By by, int...optionNumbers){
        List<WebElement> list;
        for (int i=0; i<optionNumbers.length; i++) {
            $(by).click();
            list = $$(ListOfOptions).getElements();
            if (optionNumbers[i] >= list.size())
                optionNumbers[i] = list.size()-1;
            else if (optionNumbers[i] < 0)
                optionNumbers[i] = 0;
            WebElement option = $$(ListOfOptions).getElements().get(optionNumbers[i]);
            $(option).scrollIntoView().click();
        }
    }


    /**
     * takeScreenshot
     * @param fileName		fileName
     */
    public void takeScreenshot(String fileName){
        String directoryPath = "target/screenshots/";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        File file = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);

        String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss"));
        String filePath = directoryPath + fileName + "_" + Thread.currentThread().getName() + "_" + dt + ".png";
        try {
            FileUtils.copyFile(file, new File(filePath));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     *
     * @param excelName
     * @param sheetName
     * @return
     */
    public List<List<String>> getExcelData(String excelName, String sheetName){

        List<List<String>> mainLists = new ArrayList<>();

        String path="src/test/resources/" + excelName;

        FileInputStream inputStream = null;
        Workbook workbook= null;

        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet= workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();

        for(int i=1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            int cellCount = row.getPhysicalNumberOfCells();
            List<String> innerList = new ArrayList<>();
            for(int j=0 ;j< cellCount; j++) {
                Cell cell = row.getCell(j);
                innerList.add(cell.getStringCellValue());
            }
            mainLists.add(innerList);
        }
        return mainLists;
    }


    /**
     *
     * @param excelName
     * @param sheetName
     * @param returnRowNumber
     * @return
     */
    public List<String> getExcelData(String excelName, String sheetName, int returnRowNumber){

        List<String> list = new ArrayList<>();

        String path="src/test/resources/" + excelName;

        FileInputStream inputStream = null;
        Workbook workbook= null;

        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet= workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();

        Row row = sheet.getRow(returnRowNumber);
        for(int j=0 ; j<2; j++) {
            Cell cell = row.getCell(j);
            list.add(cell.getStringCellValue());
        }
        return list;
    }
}


