Feature: User shopping
  As a user,
  I want to go through whole shopping process.

    Background:
    Given the user is on the HomePage

  Scenario: Shopping process
    Given the user is on the login page
    When the user types an email and password into login input field
    And the user clicks on Sign In button
    Given the user is on My Account page
    When the user types item name into search bar
    And the user search for this item
    And the user clicks on searched item
    And the user is on the product page and the Product Page should display confirmation message "SAVE 20%"
    Then the user select M size
    And the user add required number of product to the cart
    And the user clicks on proceed to checkout
    Then the user is in shopping cart page
    And the user confirm address by clicking on continue button
    And the user confirm shipping method and clicking continue button
    And the user selects pay by check method, confirms terms of service and clicks on place order button

