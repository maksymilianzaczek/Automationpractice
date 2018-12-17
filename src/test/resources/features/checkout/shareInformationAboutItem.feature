Feature: Share information about item

  Background:
    Given logged customer is on home page

  Scenario: User is able to share information about item with friends using twitter
    When user select first item from homepage and chose twitter
    Then new page in twitter domain is open

  Scenario: User is able to share information about item with friends using facebook
    When user select first item from homepage and chose facebook
    Then new page in facebook domain is open

  Scenario: User is able to share information about item with friends using google plus
    When user select first item from homepage and chose google plus
    Then new page in google plus domain is open

  Scenario: User is able to share information about item with friends using pinterest
    When user select first item from homepage and chose pinterest
    Then new page in pinterest domain is open











