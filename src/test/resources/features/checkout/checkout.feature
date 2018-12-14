Feature: Checkout

  Scenario: User is able to make an order from the cart and pay by bank wire
    Given logged customer is on home page
    When user select first item from homepage and added it into cart
    And he confirms every step to make order and pay by bank wire
    And he confirms order
    Then order is created

  Scenario: User is able to make an order from the cart and pay bu check
    Given logged customer is on home page
    When user select first item from homepage and added it into cart
    And he confirms every step to make order and pay by check
    And he confirms order
    Then order is created

  Scenario: User is able to change quantity of items before added into cart
    Given logged customer is on home page
    When user select first item from homepage change quantity used plus and minus button before added to cart
    Then checkout page has two items

  Scenario: User is able to change size of items before added into cart
    Given logged customer is on home page
    When user select first item from homepage and change size
    Then checkout page has item in L size

  Scenario: User is able to change color of items before added into cart
    Given logged customer is on home page
    When user select first item from homepage and change color
    Then checkout page has item in different color

  Scenario: User is able to change quantity of items after added into cart
    Given logged customer is on home page and user select first item from homepage and added it into cart
    When  user change quantity used plus and minus button after added to cart
    Then checkout page has three items

  Scenario: User is able to add address and select it as delivery address
    Given logged customer is on home page and user select first item from homepage and added it into cart
    When  user input new address
    And   user choices new address as delivery address
    Then the new address is selected as delivery address
    And new created address is deleted after test

  Scenario: User is able to add address and select it as billing address
    Given logged customer is on home page and user select first item from homepage and added it into cart
    When  user input new address
    And   user choices new address as billing address
    Then the new address is selected as billing address
    And new created address is deleted after test

  Scenario: User is able to add address and select it as delivery and billing address
    Given logged customer is on home page and user select first item from homepage and added it into cart
    When  user input new address
    And   user choices new address as delivery and billing address
    Then the new address is selected as delivery and billing address
    And new created address is deleted after test

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

  Scenario: User is able to share information about item with friends using twitter
    Given logged customer is on home page
    When user select first item from homepage and chose twitter
    Then new page in twitter domain is open

  Scenario: User is able to share information about item with friends using facebook
    Given logged customer is on home page
    When user select first item from homepage and chose facebook
    Then new page in facebook domain is open

  Scenario: User is able to share information about item with friends using google plus
    Given logged customer is on home page
    When user select first item from homepage and chose google plus
    Then new page in google plus domain is open

#  Scenario: User is able to share information about item with friends using pinterest
#    Given logged customer is on home page
#    When user select first item from homepage and chose pinterest
#    Then new page in pinterest domain is open










