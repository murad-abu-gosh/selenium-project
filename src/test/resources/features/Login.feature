

Feature: Rami levi feature

  @LoginTest
  Scenario: Login
    Given I have navigated to Rami Levi
    When  I login with user 'aaaaa@gmail.com' and password 'muradelevation123'
    Then On Rami Levi Home page - 'Murad'

