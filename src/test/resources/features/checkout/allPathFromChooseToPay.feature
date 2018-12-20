Feature: All path from choose to pay

  Background:
    Given user add first item into cart
    When user confirms order
    Then order is created

  Scenario: User is able to make an order from the cart and pay by bank wire
    When user confirms every step to make order and pay by bank wire
    And user confirms order
    Then order is created

  Scenario: User is able to make an order from the cart and pay by check
    When user confirms every step to make order and pay by check
    And user confirms order
    Then order is created
