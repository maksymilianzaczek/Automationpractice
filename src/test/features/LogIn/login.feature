# new feature
# Tags: optional

Feature: Login

  Scenario: User with correct credentials can properly login
    Given customer is on home page
    When he logs in using correct credentials
    Then he is logged in

  Scenario: User with wrong credentials can't login
    Given customer is on home page
    When he logs in using wrong credentials
    Then he is not logged in

  Scenario: User can log out
    Given logged in customer is on home page
    When he logs out
    Then he is logged out