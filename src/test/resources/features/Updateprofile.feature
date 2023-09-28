
Feature: Change the profile data using API request and check if the data was updated using Selenium

    Background:
        Given I have navigated to Rami Levi
        When  I login with user 'aaaaa@gmail.com' and password 'muradelevation123'


    Scenario Outline: update profile data
        Given I have navigated to profile dashboard
        When  I am updating the profile data "<first_name>" ,"<last_name>","<phone>","<additional_phone>","<sex_id>","<birth_date>"
        Then On the profile dashboard
        Examples:
