@Regression
Feature: Human Resourses, Setup, Position Salaries operations


  Scenario: Position Salary add, update and delete

    Given user on home page
    And   user logged in to basqar
    And   user navigate to position salary page

    When  user create a person to position salary name as "posSal1"
    Then  person in position salary should be created

    When  user update the person in position salary named "posSal1" to name as "posSal2"
    Then  person in position salary should be updated

    When  user edit the person in position salary named "posSal2"
    And   click to dialog "save" button
    Then  person in position salary should be updated

    When  user navigate to position salary page
    And   user delete the person in position salary named as "posSal2"
    Then  person in position salary should be deleted