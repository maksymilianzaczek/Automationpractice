Feature: edition of customer information

  Scenario: As customer I want to edit my personal information
    Given logged in customer is on customer information page
    When he edit his personal information
    Then personal information are changed