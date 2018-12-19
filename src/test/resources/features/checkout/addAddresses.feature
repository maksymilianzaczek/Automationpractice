Feature: Add billing and delivery addresses

  Background:
#   To much ands. Cant it be logged in customer is on cart box with added item/product
    Given logged customer is on home page and user select first item from homepage and added it into cart

  Scenario: User is able to add address and select it as delivery address
    When  user input new address
    And   user choices new address as delivery address
    Then the new address is selected as delivery address
#    if asserts from then step will fail, and step will not execute. So probably every other scenario from this file will fail
    And new created address is deleted after test

  Scenario: User is able to add address and select it as billing address
    When  user input new address
    And   user choices new address as billing address
    Then the new address is selected as billing address
    And new created address is deleted after test

  Scenario: User is able to add address and select it as delivery and billing address
    When  user input new address
    And   user choices new address as delivery and billing address
    Then the new address is selected as delivery and billing address
    And new created address is deleted after test