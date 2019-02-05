Feature: Wishlists feature

  Scenario: Customer is able to create his own wishlist
    Given logged in customer is on wishlist page
    When he creates new wishlist
    Then wishlist is created

  Scenario: Customer is able to delete wishlist
    Given logged in customer is on wishlist page
    When he deletes existing wishlist
    Then wishlist is deleted

  Scenario: Customer is able to add product to wishlist
    Given logged in customer is on home page
    When he adds product to wishlist
    Then product is added to the list