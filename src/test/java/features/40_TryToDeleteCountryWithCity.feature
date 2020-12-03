@Regression
Feature: In this feature Country and City Combined processes are proceeds

  Background: user logon Basqar
    Given user on home page
    And   user logged in to basqar

  Scenario: country create

    Given  user navigate to countries page
    When   user create a country name as "My Country Name" and code as "My Country Code"
    Then   country should be created

  Scenario: city create
    Given user navigate to cities page
    When  user create a city to the country "My Country Name" which name is "My City Name"
    Then  city should be created

  Scenario: try to delete country that has a city
    Given user navigate to countries page
    When  user delete the country named as "My Country Name"
    Then  country should not be deleted


  Scenario: delete the city than country
    Given user navigate to cities page
    When  user delete the city named as "My City Name"
    And   user navigate to countries page
    And   user delete the country named as "My Country Name"

    Then  country should be deleted

