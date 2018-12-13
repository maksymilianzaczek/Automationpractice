Feature: Newsletter

  Scenario: User is able to add email to newsletter
    Given logged in customer is on home page
    When he types correct email
    Then his email is added to newsletter


    Scenario: User fills email incorrectly, therefore can't add it to newsletter
      Given logged in customer is on home page
      When he types incorrect email
      Then his email is not added to newsletter