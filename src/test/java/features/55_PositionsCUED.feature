@Regression
Feature: Human Resourses, Setup, Positions operations


  Scenario: Positions add, update and delete

    Given user on home page
    And   user logged in to basqar
    And   user navigate to positions page

    When  user create a position name as "position1" and short name as "pos1"
    Then  position should be created

    When  user update the position named "position1" to name as "position2" and code as "pos2"
    Then  position should be updated

    When  user navigate to positions page
    And   user edit the position named "position2"
    And   click to dialog "save" button
    Then  position should be updated

    When  user navigate to positions page
    And   user delete the position named as "position2"
    Then  position should be deleted