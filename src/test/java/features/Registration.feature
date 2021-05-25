Feature: Registration Feature
  Enter valid details for account

  Scenario: Register as a authenticated user
    Given user is on Register Page
    When user navigates to Registration Page
    And user enters firstName and lastName
    And user select the country
    And user enter state, Email address , Password and Repeat password
    And user clicks on Create an account
    Then New account is created and user verify account Page

  Scenario: Login as a authenticated user
    Given user is on Login page
    When user enters Login ID  and Pasword
    And user click on sign in button
    Then Account is Logged in


  Scenario: Add Product to the cart
    Given user is on Home Page
    When user navigates to required product
    And user Click on the required product
    And user click on add to cart
    And user navigate to shoppping cart and Checkout
    And user clicks on Procced to checkout
    Then Order summary page opens up


