@Regression
Feature: Human Resourses, Setup, Salary Types operations


  Scenario: Salary Types add, update and delete

    Given user on home page
    And   user logged in to basqar
    And   user navigate to salary types page

    When  user create a salary type name as "salaryType1" and user type as "Teacher"
    Then  salary type should be created

    When  user update the salary type named "salaryType1" to name as "salaryType2" and user type as "Student"
    Then  salary type should be updated

    When  user edit the salary type named "salaryType2"
    And   click to dialog "save" button
    Then  salary type should be updated

    When  user navigate to salary types page
    And   user delete the salary type named as "salaryType2"
    Then  salary type should be deleted