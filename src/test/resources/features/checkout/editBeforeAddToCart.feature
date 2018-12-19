Feature: Edit order on product details page

  Background:
    Given logged in customer is on first product details page

  Scenario: User is able to change quantity of items on product details page
    When user change quantity on product details page
    And user add to cart item on product details page
    Then summary checkout page has two items

  Scenario: User is able to change size of items on product details page
    When user change size on product details page
    And user add to cart item on product details page
    Then summary checkout page has item in L size

  Scenario: User is able to change color of items on product details page
    When user change color on product details page
    And user add to cart item on product details page
    Then summary checkout page has item in different color