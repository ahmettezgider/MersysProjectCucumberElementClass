package pageModels;

public enum NavBarObjects {

    /**
     * Navigation menu links chain. First value is Header of the required page
     * enum has 2 variables, header: String and links: String varargs
     */

    Dashboard ("Dashboard", "Dashboard"),
    Countries ("Countries", "Setup", "Parameters", "Countries"),
    Cities ("Cities", "Setup", "Parameters", "Cities"),
    BankAccounts ("Bank Accounts", "Setup", "Parameters","Bank Accounts"),
    SubjectCategories ("Subject Categories", "Education", "Setup", "Subject Categories"),
    Subjects ("Subjects", "Education", "Setup", "Subjects"),
    PositionSalary ("Position Salary", "Human Resources", "Setup", "Position Salary"),
    Positions ("Positions", "Human Resources", "Setup", "Positions"),
    ExcelTemplate ("Budget Excel Template", "Reports", "Setup", "Excel Template"),
    SalaryTypes ("Salary Types", "Human Resources", "Setup", "Salary Types"),
    SalaryModifiers ("Salary Modifiers", "Human Resources", "Setup", "Salary Modifiers"),
    SalaryConstants ("Salary Constants", "Human Resources", "Setup", "Salary Constants"),
    BudgetAccounts ("Budget Accounts", "Budget", "Budget Accounts"),
    CostCenters ("Cost Centers", "Budget", "Setup", "Cost Centers")
    ;

    private String header;
    private String[] links;

    NavBarObjects(String header, String...links) {
        this.header = header;
        this.links = links;
    }

    public String getHeader(){
        return header;
    }
    public String[] getLinks(){
        return links;
    }

}
