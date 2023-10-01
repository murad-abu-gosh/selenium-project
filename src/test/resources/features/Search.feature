Feature: Search feature of the page

  Background:
    Given I have navigated to Rami Levi

    @searchTest
  Scenario: Search for product
    When I type 'bamba' in search bar
    And I click on show all results button
    Then I am on advanced search page for 'bamba'

