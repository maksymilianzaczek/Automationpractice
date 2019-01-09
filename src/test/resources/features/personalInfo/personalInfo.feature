Feature: Personal Info

  Scenario: User is able to change data
    Given logged in user is on personal info page
    When he fills up every field correctly
    Then changes are saved

    Scenario: User