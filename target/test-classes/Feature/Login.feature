Feature: Verify login function

Scenario: Successfull login

Given User is on login page
When User enters username and password
Then User clicks on login button
And user navigate to home page