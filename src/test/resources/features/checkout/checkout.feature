Feature: Checkout

  Scenario: User is able to make an order from the cart
    Given logged customer is on home page
    When user select first item from homepage and added it into cart
    And he confirms every step to make order
    And he confirms order
    Then order is created

  Scenario: User is able to change quantity of items before added into cart.
    Given logged customer is on home page
    When user select first item from homepage change quantity used plus and minus button
    Then checkout page has two items

  Scenario: User is able to change size of items before added into cart.
    Given logged customer is on home page
    When user select first item from homepage and change size
    Then checkout page has item in L size

  Scenario: User is able to change color of items before added into cart.
    Given logged customer is on home page
    When user select first item from homepage and change color
    Then checkout page has item in different color