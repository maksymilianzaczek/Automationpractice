Feature: Edit order on product details page

  Background:
    Given logged in customer is on product details page

  Scenario: User is able to change quantity of items on product details page
    When user change quantity on product details page
    And user add to cart item on product details page
    Then summary checkout page has a given number of items in product details page

  Scenario Outline: User is able to change size of items on product details page
    When user change size to <size> size on product details page
    And user add to cart item on product details page
    Then summary checkout page has item in given size
    Examples:
      | size |
      |    S |
      |    M |
      |    L |

  Scenario Outline: User is able to change color of items on product details page
    When user change color to <color> on product details page
    And user add to cart item on product details page
    Then summary checkout page has item in given color
    Examples:
      | color  |
      | blue   |