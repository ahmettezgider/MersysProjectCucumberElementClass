@Regression
Feature: Human Resourses, Setup, Position Salaries operations


  Scenario: Position Salary add, update and delete

    Given user on home page
    And   user logged in to basqar
    And   user navigate to position salary page

    When  user create a person to position salary name as "posSal1"
    Then  person in position salary should be created

    When  user navigate to position salary page
    And   user add position salary to the name "posSal1" as follows
      | experience | 3-5        |
      | fromDate   | 2019-05-05 |
      | salary     | 10000      |
      | currency   | USD        |
    Then position salary should be created

    When  user navigate to position salary page
    And   user update position salary to the name "posSal1" as follows
      | experience | 3-5        |
      | fromDate   | 2020-10-05 |
      | salary     | 12000      |
      | currency   | USD        |
    Then position salary should be updated


    When  user navigate to position salary page
    And   user delete position salary belogs to person named "posSal1" with the text "3-5"
    Then  position salary should be deleted

    When  user navigate to position salary page
    And   user delete the person in position salary named as "posSal1"
    Then  person in position salary should be deleted

