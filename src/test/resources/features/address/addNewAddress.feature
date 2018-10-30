Feature: Add new address

  Background:
    Given logged in customer is on address page

  Scenario: As logged in customer I'm able to add new address
    When he adds new address with proper data
    Then new address is created


  Scenario: User can't add new address incorrectly
    When he tries to add new address with empty fields
    Then new address is not created
