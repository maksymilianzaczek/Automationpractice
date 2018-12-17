Feature: Checkout

  Scenario: User is able to make an order from the cart and pay by bank wire
    Given logged customer is on home page
    When user select first item from homepage and added it into cart
    And he confirms every step to make order and pay by bank wire
    And he confirms order
    Then order is created

  Scenario: User is able to make an order from the cart and pay by check
    Given logged customer is on home page
    When user select first item from homepage and added it into cart
    And he confirms every step to make order and pay by check
    And he confirms order
    Then order is created
