Feature: Checkout

#  Scenario: User is able to make an order from the cart
#    Given logged customer is on home page
#    When user select first item from homepage and added it into cart
#    And he confirms every step to make order
#    And he confirms order
#    Then order is created
#
#  Scenario: User is able to change quantity of items before added into cart
#    Given logged customer is on home page
#    When user select first item from homepage change quantity used plus and minus button before added to cart
#    Then checkout page has two items
#
#  Scenario: User is able to change size of items before added into cart
#    Given logged customer is on home page
#    When user select first item from homepage and change size
#    Then checkout page has item in L size
#
#  Scenario: User is able to change color of items before added into cart
#    Given logged customer is on home page
#    When user select first item from homepage and change color
#    Then checkout page has item in different color

#  Scenario: User is able to share information about item with friends in twitter
#    Given logged customer is on home page
#    When user select first item from homepage and chose twitter
#    Then new page in twitter domain is open

#  Scenario: User is able to change quantity of items after added into cart
#    Given logged customer is on home page and user select first item from homepage and added it into cart
#    When  user change quantity used plus and minus button after added to cart
#    Then checkout page has three items

  Scenario: User is able to add address and select it as delivery address
    Given logged customer is on home page and user select first item from homepage and added it into cart
    When  user input new address
    And   user choices new address as delivery address
    Then the new address is selected as delivery address

#  Scenario: User is able to add address and select it as billing address
#    Given logged customer is on home page and user select first item from homepage and added it into cart
#    When  user input new address
#    And   user choices new address as billing address
#    Then the new address is selected as billing address
#
#  Scenario: User is able to add address and select it as delivery and billing address
#    Given logged customer is on home page and user select first item from homepage and added it into cart
#    When  user input new address
#    And   user choices new address as delivery and billing address
#    Then the new address is selected as delivery and billing address



