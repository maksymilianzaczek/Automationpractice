Feature: Checkout

  Scenario: User is able to change quantity of items after added into cart
    Given logged customer is on home page and user select first item from homepage and added it into cart
    When  user change quantity used plus and minus button after added to carth
    Then checkout page has three items

  Scenario: user not mark checkbox terms of services
    Given logged customer is on home page
    When user select first item from homepage and added it into cart
    And he confirms every step up to the tab shipping and he do not click agree checkbox in shipping label and click proceed to checkout
    Then new alert is appear

  Scenario: user not mark checkbox terms of services and after the alert appear mark it
    Given logged customer is on home page
    When user select first item from homepage and added it into cart
    And he confirms every step up to the tab shipping and he do not click agree checkbox in shipping label and click proceed to checkout
    And new alert is appear and user close it and click agree checkbox and continue
    Then user is in payment label

  Scenario: user add comment about order
    Given logged customer is on home page
    When user select first item from homepage and added it into cart
    And user confirms every step up to the tab address and type a comment
    And user confirms every step from tab address to confirms order
    Then is comment about address in last one orders