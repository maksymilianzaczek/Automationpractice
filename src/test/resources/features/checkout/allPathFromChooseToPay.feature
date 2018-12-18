Feature: All path from choose to pay

  Scenario: User is able to make an order from the cart and pay by bank wire
    Given logged customer is on home page
    When user select first item from homepage and added it into cart
#    You don't want to test adding to cart. So given should be
#     logged in customer is on cart box/page with added item
    And he confirms every step to make order and pay by bank wire
    And he confirms order
    Then order is created

  Scenario: User is able to make an order from the cart and pay by check
    Given logged customer is on home page
    When user select first item from homepage and added it into cart
#    same here
    And he confirms every step to make order and pay by check
    And he confirms order
    Then order is created
