Feature: Verify Login Functionality

  #TC001 & TC007
  @login
  Scenario: The existence of the correct login form
    Given User navigates to Main Page
    When User click login button, Login Page should be opened
    And User enter username
    And User enter password
    And User click login button
    Then User should login Home page successfully

  #TC002
  @login
  Scenario: Error message when password field is empty
    Given User navigates to Main Page
    When User click login button, Login Page should be opened
    And User enter username
    And User click login button
    Then User cannot login Home Page because of empty fields

  #TC003
  @login
  Scenario: Error message when username field is empty
    Given User navigates to Main Page
    When User click login button, Login Page should be opened
    And User enter password
    And User click login button
    Then User cannot login Home Page because of empty fields

  #TC004
  @login
  Scenario: Error message when all fields is empty
    Given User navigates to Main Page
    When User click login button, Login Page should be opened
    And User click login button
    Then User cannot login Home Page because of empty fields

  #TC005
  @login
  Scenario: The existence of the correct login form
    Given User navigates to Main Page
    When User click login button, Login Page should be opened
    And User enter username
    And User enter invalid password
    And User click login button
    Then User cannot login Home Page because of wrong credentials

  #TC006
  @login
  Scenario: The existence of the correct login form
    Given User navigates to Main Page
    When User click login button, Login Page should be opened
    And User enter invalid username
    And User enter password
    And User click login button
    Then User cannot login Home Page because of wrong credentials

  #TC008
  @login
  Scenario: The existence of the correct login form
    Given User navigates to Main Page
    When User click login button, Login Page should be opened
    And User click login in with Google button
    And Gmail login page should be open
    And User enter gmail username
    Then User click first next button
    And User enter gmail password
    And User click second next button
    Then Gmail login page should be open
