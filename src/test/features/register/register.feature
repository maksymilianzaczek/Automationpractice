Feature: Register user

  Scenario: Register user correctly
    Given User is on home page
    When he types new correct e-mail
    And correctly types other fields on next page
    Then new user is registered

  Scenario: User tries to register by typing incorrect e-mail
    Given User is on home page
    When he types incorect e-mail
    Then he can't register

  Scenario: User ries to register by typing incorrect informations
    Given User is on home page
    When he types new correct e-mail
    And incorrectly types other fields on next page
    Then he can't register