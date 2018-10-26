Feature: Add new address

  Background:
    Given logged in customer is on address page

  Scenario: As logged in customer I'm able to add new address
    When he adds new address correctly
    Then new address is created

   # user can't add new address incorrectly, so he gets error message
  Scenario: User can't add new address incorrectly
    When he adds new address incorrectly
    Then new adress is not created
