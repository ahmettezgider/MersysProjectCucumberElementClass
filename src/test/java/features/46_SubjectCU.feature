@Regression
Feature: Eduation, Setup, Subject Category operations


  Scenario: Subject Category add, update and delete with data table

    Given user on home page
    And   user logged in to basqar
    And   user navigate to subjects page

    When  user create a subject as follows
      | name     | subj1  |
      | code     | sCode1 |
      | category | 2      |
      | style    | 5      |

    Then  subject should be created

    When  user delete the subject name as "subj1"
    Then  subject should be deleted

