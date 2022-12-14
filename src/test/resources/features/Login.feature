@Login
Feature: Login

  Scenario Outline: Login with correct <credentials> and password
    Given the user is on the login page
    When the user enters a valid "<credentials>" and password
    And clicks the login button
    Then the user should be successfully login
    Examples:
      | credentials  |
      | phone number |
      | email        |

  Scenario Outline: Login with valid "<valid field>" and invalid "<invalid field>"
    Given the user is on the login page
    When the user enters an valid "<valid field>" and invalid "<invalid field>"
    And clicks the login button
    Then an error message should be displayed
    Examples:
      | valid field  | invalid field |
      | email        | password      |
      | phone number | password      |
      | password     | email         |
      | password     | phone number  |
