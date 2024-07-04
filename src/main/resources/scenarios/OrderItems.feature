@OrderItems
Feature: Sign-in and Sign-out on Swag Labs website

  Background: 
    Given User is on the Swag Labs login page
    When User enters valid username and password
    And User clicks on the login button

  @OrderTwoItems
  Scenario: Order items two items to the card 
  Then User selects any two items and clicks on Cart button 
  Then User Checkout and enters address details 
  Then User Continue to Overview and finish Order
  
