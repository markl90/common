Feature: Performing a search

#  Background:

  @test
  Scenario: Successful search with primary search bar
    Given the user is on the "bt shop landing" page
    When the user enters a new search term into the mains search bar
#      | Search Term |
#      | phone       |
    And the user performs a search
    Then the expected products page is returned