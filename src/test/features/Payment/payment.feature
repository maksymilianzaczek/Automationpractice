Feature: Select payment option

  Scenario: User selects pay by bank wire option
    Given logged in customer is on payment page
    When he choose pay by bank wire option and confirms
    Then Payment is made

  Scenario: User selects pay by check option
    Given logged in customer is on payment page
    When he choose pay by check option and confirms
    Then Payment is made
