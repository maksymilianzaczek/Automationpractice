Feature: edit current address

  Background:
    Given logged in customer is on address page

  @ignore
  Scenario: User changes current address correctly
    When he changes current address correctly
    Then address is updated

  @ignore
  Scenario: User changes current address incorrectly
    When he tries to change new address he leaves empty fields
    Then address is not updated