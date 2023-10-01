Feature: Cart feature for adding items and clearing cart
  Background:
    Given I have navigated to Rami Levi
    And I empty the cart
#    When  I login with user 'aaaaa@gmail.com' and password 'muradelevation123'

    @cartTest
    Scenario: Add multiple items to cart
      When I type 'bamba' in search bar
      And I click on show all results button
      And I click on plus button 1 times for item index 0
      And I click on plus button 2 times for item index 1
      And I click on plus button 3 times for item index 2
      Then I have 3 items in cart

  @cartTest
  Scenario: Empty cart after adding items
#      Given I have bamba in cart
      When I type 'bamba' in search bar
      And I click on show all results button
      And I click on plus button 1 times for item index 0
      And I empty the cart
      Then Cart is empty