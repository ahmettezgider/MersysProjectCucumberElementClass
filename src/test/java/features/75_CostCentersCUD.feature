@Regression
Feature: Budgets, Setup, Cost Centers operations

  Scenario: Cost Centers add, update and delete operations 1

    Given user on home page
    And   user logged in to basqar
    And   user navigate to cost centers page

    When  user create a cost center as follows
      | name    | name123 |
      | code    | code123 |
      | type    | Service |
      | orderNo | 100     |
      | key     | key123  |
      | value   | 100     |
      | expense | 2       |

    Then  cost center should be created

    When  user update the cost center name as "name123" as follows
      | name    | name124 |
      | code    | code124 |
      | type    | 2       |
      | orderNo | 99      |
      | key     | key124  |
      | value   | 99      |
      | expense | 3       |

    Then  cost center should be updated

    When  user delete the cost center named as "name124"
    Then  cost center should be deleted