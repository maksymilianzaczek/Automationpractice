Feature: Checkout

  Scenario: User is able to make an order from the cart
    Given logged in customer is on order page
    When he confirms every step
    And he proceeds to checkout
    Then order is created

