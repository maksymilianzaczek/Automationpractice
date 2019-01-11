Feature: Edit order on product details page

  Background:
    Given logged in customer is on product details page

  Scenario: User is able to change quantity of items on product details page
    When user change quantity on product details page
    And user add to cart item on product details page
    Then summary checkout page has a given number of items in product details page

#  Scenario: User is able to change size of items to S size on product details page
#    When user change size to S size on product details page
#    And user add to cart item on product details page
#    Then summary checkout page has item in given size
#
#  Scenario: User is able to change size of items to M size on product details page
#    When user change size to M size on product details page
#    And user add to cart item on product details page
#    Then summary checkout page has item in given size
#
#  Scenario: User is able to change size of items to L size on product details page
#    When user change size to L size on product details page
#    And user add to cart item on product details page
#    Then summary checkout page has item in given size
#
#  Scenario: User is able to change color of items to blue on product details page
#    When user change color to blue on product details page
#    And user add to cart item on product details page
#    Then summary checkout page has item in given color