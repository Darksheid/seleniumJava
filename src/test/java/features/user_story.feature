Feature: Navigate to Google page
  This feature will help in automating Google Page navigation

  Background: 
    Given print running background steps
    Then check print of background steps

  @test_run
  Scenario Outline: Open Google homepage
    Given User navigate to "url" for "<Test>"
    Then validate that login page is displayed
    Then user enters "username"
    Then user enters "password"
    Then clicks on "login" button
    Then validate that user is navigated to dashbaord screen
    Then user closes the application

    Examples: 
      | Test |
      | TC05 |
