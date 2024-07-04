@Login
Feature: Sign-in and Sign-out on Swag Labs website

  Background: 
    Given User is on the Swag Labs login page
    When User enters valid username and password
    And User clicks on the login button

  @SignIn
  Scenario: User logs in with valid credentials
    Then User should be logged in successfully

  @SignOut
  Scenario: User logs out from the Swag Labs website
    Then User clicks on the menu icon
    And User selects the logout option
    Then User should be logged out successfully
