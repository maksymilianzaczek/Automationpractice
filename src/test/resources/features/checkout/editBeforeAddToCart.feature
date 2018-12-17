Feature: Edit order before added into cart

  Background:
    Given logged customer is on home page

  Scenario: User is able to change quantity of items before added into cart
    When user select first item from homepage change quantity used plus and minus button before added to cart
    Then checkout page has two items

  Scenario: User is able to change size of items before added into cart
    When user select first item from homepage and change size
    Then checkout page has item in L size

  Scenario: User is able to change color of items before added into cart
    When user select first item from homepage and change color
    Then checkout page has item in different color











