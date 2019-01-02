Feature: Share information about item

  Background:
    Given logged in customer is on product details page

  Scenario: User is able to share information about item with friends using twitter
    When user chose twitter
    Then new page in twitter domain is open

  Scenario: User is able to share information about item with friends using facebook
    When user chose facebook
    Then new page in facebook domain is open

  Scenario: User is able to share information about item with friends using google plus
    When user chose google plus
    Then new page in google plus domain is open

  Scenario: User is able to share information about item with friends using pinterest
    When user chose pinterest
    Then new page in pinterest domain is open
