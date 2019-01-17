Feature: Checkout

  Background:
    Given user add first item into cart

  Scenario: User is able to change quantity of items in summary checkout page
    When user change quantity on summary checkout page
    And user confirms every step from summary checkout page up to payment checkout page
    Then summary checkout page has a given number of items in summary checkout page
#
#  Scenario: user not mark checkbox terms of services in shipping checkout page
#    When user click proceed to checkout in summary address and shipping tab
#    Then alert is displayed in shipping checkout page
#
#  Scenario: user not mark checkbox terms of services and after the alert appear mark it
#    When user click proceed to checkout in summary address and shipping tab
#    And user exit alert click agree checkbox and click proceed to checkout
#    Then user is in payment checkout tab
#
#  Scenario: user add comment about order in address checkout page
#    When user click proceed to checkout in summary tab
#    And user type a comment entrance from the yard in address checkout page
#    And user confirms every step from address checkout page up to back to orders button in payment checkout page
#    Then comment about address is displayed in last one orders
