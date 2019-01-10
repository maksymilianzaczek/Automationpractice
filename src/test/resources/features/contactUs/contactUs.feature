Feature: Contact Us

  Background:
Given logged in customer is on home page

  Scenario: User is able to send a message correctly
    When user opens contact us page
    And he fills fields correctly
    Then message is send

    Scenario: User doesn't send the message
      When user opens contact us page
      And he doesn't fill every field
      Then message is not send