Feature: Navigate to Google page
  This feature will help in automating Google Page navigation

  
  Background:
	Given print running background steps
	Then check print of background steps
	
	@testRun
  Scenario Outline: Open Google homepage
    Given User navigate to "url" for "<Test>"
    Then User searches "keyword" in the Google home page
    Then Verify the results
    Then user closes the application
    
    

    Examples: 
      | Test |
      | TC01 |
      | TC02 |
      | TC03 |
