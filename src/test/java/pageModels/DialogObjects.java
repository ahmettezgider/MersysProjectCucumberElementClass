package pageModels;

import org.openqa.selenium.By;

public interface DialogObjects {

    /**
     * this site contains the locators which are in the dialog style forms
     */

    By DialogForm = By.cssSelector("ms-dialog-content");
    By DialogFormNameInput = By.cssSelector("ms-text-field[formcontrolname='name']>input");
    By DialogFormName2Input = By.cssSelector("input[formcontrolname='name']");
    By DialogFormCodeInput = By.cssSelector("ms-text-field[formcontrolname='code']>input");
    By DialogFormNameInputInPosSal = By.cssSelector("ms-text-field[formcontrolname='title']>input");
    //By DialogFormCountryInput = By.cssSelector("ms-text-field[formcontrolname='country']>input");
    By DialogFormCountrySelect = By.cssSelector("mat-select[formcontrolname='id']");
    By DialogFormFirstNameInput = By.cssSelector("ms-text-field[formcontrolname='firstName']>input");
    By DialogFormMiddleNameInput = By.cssSelector("ms-text-field[formcontrolname='middleName']>input");
    By DialogFormLastNameInput = By.cssSelector("ms-text-field[formcontrolname='lastName']>input");
    By DialogFormShortNameInput = By.cssSelector("ms-text-field[formcontrolname='shortName']>input");
    By DialogFormCitySelect = By.cssSelector("mat-form-field[formgroupname='city'] mat-select");
    By DialogFormSubjectCategorySelect = By.cssSelector("mat-select[formcontrolname='id']");
    By DialogFormStyleSelect = By.cssSelector("mat-select[formcontrolname='value']");
    By DialogFormUserTypeMultiSelect = By.cssSelector("mat-chip-list input");
    By DialogFormExpenseAccoutMultiSelect = By.cssSelector("mat-chip-list input");
    By DialogFormValidFormInput = By.cssSelector("input[name='datePickerControl'] + input");
    By DialogFormKeyInput = By.cssSelector("ms-text-field[formcontrolname='key']>input");
    By DialogFormValueIntInput = By.cssSelector("ms-integer-field[formcontrolname='value']>input"); // in Salary
    By DialogFormPeriodCountInput = By.cssSelector("ms-integer-field[formcontrolname='periodCount']>input");
    By DialogFormRowSizeCountInput = By.cssSelector("ms-integer-field[formcontrolname='rowSize']>input");
    By DialogFormColumnSizeCountInput = By.cssSelector("ms-integer-field[formcontrolname='columnSize']>input");
    By DialogFormTypeSelect = By.cssSelector("mat-select[formcontrolname='type']");
    By DialogFormOrderInput = By.cssSelector("ms-text-field[formcontrolname='orderNo']>input");
    By DialogFormValueTextInput = By.cssSelector("ms-text-field[formcontrolname='value'] > input");  // in Cost Centers

    By DialogButtonAdd = By.cssSelector("ms-dialog-content ms-add-button button");
    By DialogButtonAddWithText = By.xpath("//ms-dialog-content//*[contains(text(),'Add')]");
    By DialogButtonApplyWithText = By.xpath("//*[contains(text(),'Apply')]");
    By DialogButtonDelete = By.cssSelector("ms-dialog-content ms-delete-button>button");
    By DialogButtonEdit = By.cssSelector("ms-dialog-content ms-edit-button>button");
    By DialogButtonAddVersion = By.xpath("//button[.//text()='Add Version']");

    By DialogFormFormulaVariableInput = By.cssSelector("input[data-placeholder='Formula Variable']");
    By DialogFormModifierVariableTypeSelect = By.cssSelector("mat-select[formcontrolname='type']");

    By DialogFormActiveCheckbox = By.cssSelector("ms-dialog-content mat-slide-toggle input");
    By MultiSelectOptionDelete = By.cssSelector("mat-chip mat-icon");
    By DialogueFormIntegrationCodeToAdd = By.cssSelector("div[formarrayname='integrationCodes'] button");
    By DialogueFormIntegrationCodeInputLast = By.cssSelector("//ms-dialog-content//mat-form-field//input");
    //By DialogueFormIntegrationCodeInputLast = By.cssSelector("(//ms-dialog-content//mat-form-field//input)[last()]");
    By DialogFormFromDate = By.cssSelector("input[data-placeholder='From']");

    By DialogFormSalary = By.cssSelector("ms-currency-field[formcontrolname='value']>input");
    By DialogFormIban = By.cssSelector("ms-masked-text-field[formcontrolname='iban']>input");
    By TableButtonEditUnique = By.cssSelector("mat-dialog-container ms-edit-button>button");
    By DialogFormIntegrationCode = By.cssSelector("ms-text-field[formcontrolname='integrationCode']>input");




}
