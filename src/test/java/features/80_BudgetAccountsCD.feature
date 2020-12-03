@Regression
Feature: Budget, Budget Accounts operations


  Scenario: Budget, Budget Accounts add, update and delete operations

    Given user on home page
    And   user logged in to basqar
    And   user navigate to budget accounts page

    When  user create a budget account as follows
      | name               | name123 |
      | code               | 1234    |
      | category           | 4       |
      | type               | Detail  |
      | parentAccountCode  | 1       |
      | closingAccountCode | 10      |
      | balanceType        | Credit  |
      | integrationCodes   | 1       |
      | currency           | EUR     |

    Then  budget account should be created

    When  user navigate to budget accounts page
    And   user delete the budget account named as "name123" under category 4
    Then  budget account should be deleted