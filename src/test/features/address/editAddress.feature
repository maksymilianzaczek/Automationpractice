Feature: edit current adress

  Background:
    Given logged in customer is on address page

  Scenario: User changes current address correctly
    When he changes current address correctly
    Then address is updated

  Scenario: User changes current address incorrectly
    When he changes current address incorrectly
    Then address is not updated