@Regression
Feature: Setup, Parameters, Bank Accounts process

  Scenario: Bank Accounts add, update and delete operations

    Given user on home page
    And   user logged in to basqar
    And   user navigate to bank accounts page

    When  user create a bank account as follows
      | name            | account001             |
      | iban            | DE34567890123456789012 |
      | currency        | USD                    |
      | integrationCode | code01                 |

    Then  bank account should be created

    When  user update the bank account named as "account001" as follows
      | name            | account002             |
      | iban            | TR34567890123456789012 |
      | currency        | 2                      |
      | integrationCode | Tr01                   |

    Then  bank account should be updated

    When  user delete the bank account named as "account002"
    Then  bank account should be deleted
