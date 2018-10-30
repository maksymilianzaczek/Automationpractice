Feature: Register user

  Scenario: Register user correctly
    Given User is on home page
    When he types unique e-mail
    And on second registeration page he submits fields with correct data
    Then new user is registered

  Scenario: User tries to register by typing incorrect e-mail
    Given User is on home page
    When he submits form with incorrect e-mail
    Then error message is displayed

  Scenario: User ries to register by typing incorrect data
    Given User is on home page
    When he types new correct e-mail
    And incorrectly submits form on second registration page
    Then error message is displayed