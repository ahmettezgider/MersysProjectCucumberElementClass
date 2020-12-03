@Navigation
Feature: Navigation functionality in different window status


  Scenario: Navigation on menu in different window styles

    Given user on home page
    And   user logged in to basqar

  Scenario Outline: navigate on menu with different browser size
    When the browser size is "<browserSize>"

    Then user should navigate to the following links on menu
      | Countries         |
      | SalaryConstants   |
      | SubjectCategories |
      | Dashboard         |
      | Subjects          |
      | ExcelTemplate     |
      | Dashboard         |
      | SalaryTypes       |
      | Dashboard         |
      | CostCenters       |

    Examples:
      | browserSize |
      | max         |
      | big         |
      | half        |