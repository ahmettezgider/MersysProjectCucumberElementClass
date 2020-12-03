@Regression
Feature: In this feature Country processes are proceeds

  Background: Login and navigate to basqar
    Given user on home page
    And   user logged in to basqar

  Scenario: create country
    Given user navigate to countries page
    When  user create a country name as "countryName" and code as "countryCode"
    Then  country should be created

  Scenario: update country
    Given user on the same page
    When  user update the country named "countryName" to name as "countryNewName" and code as "newCode"
    Then  country should be updated

  Scenario: delete country
    Given user on the same page
    When  user delete the country named as "countryNewName"
    Then  country should be deleted