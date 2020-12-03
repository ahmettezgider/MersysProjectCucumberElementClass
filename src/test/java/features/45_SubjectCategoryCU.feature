@Regression
Feature: Eduation, Setup, Subject Category operations


  Scenario: Subject Category add, update and delete

    Given user on home page
    And   user logged in to basqar
    And   user navigate to subject categories page

    When  user create a subject category name as "sCat1" and code as "sCode1"
    Then  subject category should be created

    When  user update the subject category named "sCat1" to name as "sCat2" and code as "sCode2"
    Then  subject category should be updated

    When  user delete the subject category name as "sCat2"
    Then  subject category should be deleted

