Feature: Need to test GetController
  Scenario: Whenever a student enrolls to a school
    Given A student enrolls
    When The data is collected
    Then Data is added in the database

  Scenario: Whenever a student leaves school
    Given A student leaves
    When The student data is removed
    Then Checked if data is removed