Feature: Add new address

  Background:
    Given logged in customer is on address page

  @ignore
  Scenario: As logged in customer I'm able to add new address
    When he opens new address page and adds new address with proper data
    Then new address is created
    And new created address is deleted

  @ignore
  Scenario: User can't add new address
    When he tries to add new address with empty fields
    Then new address is not created
