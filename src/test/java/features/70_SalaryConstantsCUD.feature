@Regression
Feature: Human Resourses, Setup, Salary Constants operations


  Scenario: Salary Constants add, update and delete

    Given user on home page
    And   user logged in to basqar
    And   user navigate to salary constants page

    When  user create a salary constant as follows
      | name          | name123    |
      | validFormDate | 2019-01-10 |
      | key           | name123key |
      | value         | 100        |

    Then  salary constant should be created

    When  user update the salary constant name as "name123" as follows
      | name          | name124    |
      | validFormDate | 2020-05-10 |
      | key           | name124key |
      | value         | 200        |

    Then  salary constant should be updated

    When  user delete the constant type named as "name124"
    Then  salary constant should be deleted