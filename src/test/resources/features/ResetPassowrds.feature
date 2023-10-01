Feature: Rami levi feature
  Background:
    Given I have navigated to Rami Levi
    When  I login with user 'khaledidkidk@gmail.com' and password 'Zxasqw12--IDK'

  @ResetPasswordTest
  Scenario: Reset password
    Given On Rami Levi home page - I click on 'אדקידק' profile
    And On login popup - I click on  dashboard page
    When On dashboard page - click on reset password
    And On reset password popup - I change 'Zxasqw12--IDK' to 'Zxasqw12--IDK2'
    And On dashboard page - I do logout
    Then I login with user 'khaledidkidk@gmail.com' and password 'Zxasqw12--IDK2'
    Then On Rami Levi Home page - 'אדקידק'