Feature: Add billing and delivery addresses

  Background:
    Given logged customer is on home page and user select first item from homepage and added it into cart

  Scenario: User is able to add address and select it as delivery address
    When  user input new address
    And   user choices new address as delivery address
    Then the new address is selected as delivery address
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

