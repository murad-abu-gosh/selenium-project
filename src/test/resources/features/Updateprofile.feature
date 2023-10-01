Feature: Change the profile data using API request and check if the data was updated using Selenium

    Background:
        Given I have navigated to Rami Levi
        When  I login with user 'aaaaa@gmail.com' and password 'muradelevation123'

    @ResetUpdateProfile
    Scenario Outline: update profile data
        Given I have navigated to profile dashboard
        When  I am updating the profile data "<first_name>" ,"<last_name>","<phone>","<additional_phone>","<sex_id>","<birth_date>"
        Then On the profile dashboard page check the entered data if available "<first_name>" ,"<last_name>","<phone>","<additional_phone>","<sex_id>","<birth_date>"

        Examples:
        |first_name|last_name|phone|additional_phone|sex_id|birth_date|
        |   Alpha  |Elevation x|020-2002021|  055-1122334  | 3 | 2000-04-28|
        |   Murad  |Elevation|020-2002024|null| 1|null|



