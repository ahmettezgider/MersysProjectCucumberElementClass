Feature: In this feature Country processes are proceeds


  Background: : city

    Given user on home page
    And   user logged in to basqar
    And   user navigate to cities page

  Scenario Outline:
    When  user create a city to the country "<countryName>" which name is "<cityName>"
    Then  city should be created

    When  user delete the city named as "<cityName>"
    Then  city should be deleted

    Examples:
      | countryName | cityName    |
      | Turkey      | Kayseri     |
      | Greece      | Theseloniki |
