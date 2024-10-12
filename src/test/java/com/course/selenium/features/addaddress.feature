Feature: User Address
  As a user,
  I want to define an address.

  Background:
    Given the user is on the HomePage

  Scenario Outline: Add a new user address
    Given the user is on the login page
    When the user types an email and password into login input field
    And the user clicks on Sign In button
    Given the user is on My Account page
    When the user clicks on Addresses button
    Given the user is on My Addresses page
    When the user clicks on Create New Address button
    And the user fills the address form with "<alias>", "<address>", "<city>", "<zipCode>", "<phone>"
    And the user click the Save button
    Then the user should be on My Addresses page and the My Addresses Page should display confirmation message "Address successfully added!"
    And My addresses page should include the New Address

    Examples:
      | alias  | address      | city   | zipCode | phone     |
      | Głowny | Kasztanowa 6 | Krakow | 30-011  | 666777888 |

  Scenario: Remove previously added address
    Given the user is on My Addresses page
    Then the user click the Delete created address button
    And My addresses page should not contains the removed address