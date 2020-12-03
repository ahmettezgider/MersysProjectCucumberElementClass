@Regression
Feature: In this feature City processes are proceeds

  Scenario: city

    Given user on home page
    And   user logged in to basqar
    And   user navigate to cities page

    When  user create a city to the country "Turkey" which name is "TurkeycityName"
    Then  city should be created

    When  user delete the city named as "TurkeycityName"
    Then  city should be deleted

    When  user create a city which name is "OptionCity" to the country with option 10
    Then  city should be created

    When  user delete the city named as "OptionCity"
    Then  city should be deleted

    And   user logout from basqar
