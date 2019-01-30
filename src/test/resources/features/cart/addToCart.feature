Feature: Add To Cart

  @ignore
  Scenario: As logged in user I'm able to add product to cart
    Given logged in user is on product detail page
    When he adds product to cart
    Then product is added to cart

