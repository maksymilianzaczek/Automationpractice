Feature: Checkout

  Scenario: User is able to make an order from the cart
    Given logged in customer is on chekout page
    When he confirms every step to make order
    And he confirms order
    Then order is created

