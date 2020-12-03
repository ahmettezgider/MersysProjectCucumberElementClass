@LoginControl
Feature: Login

  Scenario: deneme

    Given user on home page

  Scenario Outline: controls the unautorized users
    When  the users in the excel file "userPass.xls" in the order "<userRow>" try to login
    Then  login should not be successfull

    Examples:
      | userRow |
      | 1       |
      | 2       |
      | 5       |
      | 8       |
      | 10      |
      | 13      |
      | 15      |
