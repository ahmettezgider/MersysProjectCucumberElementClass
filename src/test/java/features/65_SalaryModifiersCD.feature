@Regression
Feature: Human Resourses, Setup, Salary Modifiers operations


  Scenario: Salary Modifiers add, update and delete

    Given user on home page
    And   user logged in to basqar
    And   user navigate to salary modifiers page

    When  user create a salary modifier as follows
      | description          | description        |
      | variable             | variable           |
      | modifierType         | 1                  |
      | integrationCode      | integrationCode    |
      | valueType            | 1                  |
      | priority             | 101                |
      | amount               | 10                 |
      | formula              | BASE_SALARY * 0.15 |
      | name                 | name               |
      | formulaVariable      | variable1          |
      | modifierVariableType | 0                  |

    Then  salary modifier should be created

    When  user delete the salary modifier named as "description"
    Then  salary modifier should be deleted