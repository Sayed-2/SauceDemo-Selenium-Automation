Feature: SauceDemo checkout

  #1
  Scenario: User successfully completes a purchase
    Given the user is logged in with valid credentials.
    When the user adds Sauce Labs Backpack to the cart
    And the user proceeds to checkout
    And the user enters the following checkout information:
      | firstName | lastName | postalCode |
      | Steve     | Craig    | 75018      |
    And the user completes the order
    Then the order confirmation message should be displayed



#2
  Scenario: User cannot complete checkout without a first name
    Given the user is logged in with valid credentials.
    When the user adds Sauce Labs Backpack to the cart
    And the user proceeds to checkout
    And the user enters the following checkout information:
      | firstName | lastName | postalCode |
      |           | Craig    | 75018      |
    And the user clicks the continue button
    Then the checkout error message for missing first name should be displayed


    #3
  Scenario: User cannot complete checkout without a last name
    Given the user is logged in with valid credentials.
    When the user adds Sauce Labs Backpack to the cart
    And the user proceeds to checkout
    And the user enters the following checkout information:
      | firstName | lastName | postalCode |
      | Steve     |          | 75018      |
    And the user clicks the continue button
    Then the checkout error message for missing last name should be displayed


    #4
     Scenario: User cannot complete checkout without a postal code
        Given the user is logged in with valid credentials.
        When the user adds Sauce Labs Backpack to the cart
        And the user proceeds to checkout
        And the user enters the following checkout information:
          | firstName | lastName | postalCode |
          | Steve     | Craig    |            |
        And the user clicks the continue button
        Then the checkout error message for missing postal code should be displayed
