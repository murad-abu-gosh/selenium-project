
Feature: Add new shipping address using API request and check if the address was added using Selenium

    Background:
        Given I have navigated to Rami Levi
        When  I login with user 'aaaaa@gmail.com' and password 'muradelevation123'


    Scenario: Add new shipping address
        Given I have navigated to Addresses managment
        When  I am now adding a new shipping address
        Then On Shipping address managment