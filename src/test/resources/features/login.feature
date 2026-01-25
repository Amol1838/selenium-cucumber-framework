Feature: Login Functionality

# Login feature for SauceDemo application

Scenario: Valid login test
  Given User is on SauceDemo login page
  When User enters valid credentials
  Then User should land on products page
  
  
Scenario Outline: Login with multiple users
  Given User is on SauceDemo login page
  When User logs in with username "<username>" and password "<password>"
  Then Login should be "<expectedResult>"

  Examples:
    | username | password | expectedResult |
    | standard_user    | secret_sauce    | success          |
    | locked_out_user    | secret_sauce    | failure          |