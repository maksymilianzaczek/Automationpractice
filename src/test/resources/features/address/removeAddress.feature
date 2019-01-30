Feature: remove exists address

  Background:
    Given logged in customer is on address page

  @ignore
  Scenario: User remove exists address correctly
    When he remove exists address
    Then address is removed

