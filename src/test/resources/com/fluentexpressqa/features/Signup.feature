Feature: Verify Signup Functionality

  
  @signup
  Scenario: The existence of the correct sign up form
    Given User navigates to Main Page
    When User click signup button
    Then User should login Signup page successfully
