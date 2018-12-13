Feature: Contact Us

  Scenario: User is able to send a message correctly
    Given User is on contact us page
    When he fills fields correctly
    Then Message is send

    Scenario: User doesn't send the message
      Given User is on contact us page
      When he doesn't fill every field
      Then Message is not send