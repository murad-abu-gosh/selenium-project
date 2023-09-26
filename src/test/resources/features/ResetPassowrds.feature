# new feature
# Tags: optional

Feature: Rami levi feature
  Background:
    Given I have navigated to Rami Levi
    When  I login with user 'aaaaa@gmail.com' and password 'muradelevation1234'

#  12345678
  #muradelevation123
  Scenario: Reset password
    Given On Rami Levi home page - I click on 'Murad' profile
    And On login popup - I click on  dashboard page
    When On dashboard page - click on reset password
    And On reset password popup - I change 'muradelevation1234' to 'muradelevation123'
    And On dashboard page - I do logout
    Then I login with user 'aaaaa@gmail.com' and password 'muradelevation123'
    Then On Rami Levi Home page - 'Murad'