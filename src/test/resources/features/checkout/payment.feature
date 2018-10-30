Feature: Select payment option

  Scenario: User selects pay by bank wire option
    Given logged in customer is on payment page
    When he confirms paying by bank wire option
    Then payment is made

  Scenario: User selects pay by check option
    Given logged in customer is on payment page
    When he confirms paying by check
    Then payment is made
