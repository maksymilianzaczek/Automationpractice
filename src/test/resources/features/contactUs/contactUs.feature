Feature: Contact Us

  Scenario: User is able to send a message correctly
    Given user is on contact us page
    When he fills fields correctly
    Then message is send

    Scenario: User doesn't send the message
      Given user is on contact us page
      When he doesn't fill every field
      Then message is not send