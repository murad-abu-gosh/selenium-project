# new feature
# Tags: optional

Feature: Rami levi feature

  Scenario: Reset password
    Given I have navigated to Rami Levi
    And I login with user 'aaaaa@gmail.com' and password 'muradelevation123'
    And On Rami Levi home page - I click on 'Murad' profile
    And On login popup - I click on  dashboard page
    When On dashboard page - click on reset password
#    And On reset password popup - I change to new passowrd '12345678'
#    And On dashboard page - I do logout
#    Then I login with user 'aaaaa@gmail.com' and password '12345678'