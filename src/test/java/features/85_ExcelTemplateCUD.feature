@Regression
Feature: Reports, Setup, Excel Templetes operations

  Background: login to basqar and navigate to excel templetes

    Given user on home page
    And   user logged in to basqar
    And   user navigate to excel templetes page


  Scenario: Excel Templetes add, update and delete operations

    When  user create a excel templete name as "templete1" and period as 1
    Then  excel templete should be created

    When  user update the excel templete named "templete1" to name as "templete11" and period as 1
    Then  excel templete should be updated

    When  user delete the excel templete named as "templete11"
    Then  excel templete should be deleted


  Scenario: Excel Templetes add, update and delete operations with rows and columns

    When  user create a excel templete name as "templete2" and period as 1 and row and column size as follows
      | 2 | 2 |
    Then  excel templete should be created

    When  user update the excel templete named "templete2" to name as "templete22" and period as 1
    Then  excel templete should be updated

    When  user delete the excel templete named as "templete22"
    Then  excel templete should be deleted
