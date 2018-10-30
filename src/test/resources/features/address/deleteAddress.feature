Feature: delete address

  Scenario: User is able to remove address
    Given logged in user is on address page with created address
    When he removes address
    Then address is removed