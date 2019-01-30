Feature: Register user

  Background:
    Given User is on login page

  @ignore
  Scenario: Register user correctly
    When he submits form with unique e-mail
    And on second registration page he submits fields with correct data
    Then new user is registered

  @ignore
  Scenario: User tries to register by typing incorrect e-mail
    When he submits form with incorrect e-mail
    Then error message is displayed on login page

  @ignore
  Scenario: User tries to register by typing incorrect data
    When he submits form with unique e-mail
    And incorrectly submits form on second registration page
    Then error message is displayed on home page
