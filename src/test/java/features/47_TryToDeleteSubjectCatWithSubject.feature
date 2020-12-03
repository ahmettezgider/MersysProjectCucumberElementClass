@Regression
Feature: Try to delete subject category with subject


  Scenario: Try to delete subject category with subject

    Given user on home page
    And   user logged in to basqar

    When  user navigate to subject categories page
    And   user create a subject category name as "sCat1" and code as "sCode1"
    Then  subject category should be created

    When user navigate to subjects page
    And  user create a subject as follows
      | name     | subj1  |
      | code     | sCode1 |
      | category | sCat1  |
      | style    | 5      |

    Then  subject should be created

    When  user navigate to subject categories page
    And   user delete the subject category name as "sCat1"
    Then  subject category should not be deleted


  Scenario: Delete in order

    Given user navigate to subjects page
    When  user delete the subject name as "subj1"
    And   subject should be deleted

    When  user navigate to subject categories page
    And   user delete the subject category name as "sCat1"
    Then  subject category should be deleted

