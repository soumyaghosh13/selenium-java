@PerformanceTesting 
Feature: To check to add data for multiple users



  @tag2
  Scenario Outline: Title of your scenario outline
    Given User is in HRAcuity demo1
    When User Logged in with <Username> and password <Password>
    And click on login button and agree to login 
    Then User mouseover New Case Tab and select Document Issue/Event
    And Enter ER case Name
    And Select ER case Notification Method
    And Add ER case Quick-Add Involved Party
    And Add ER case Group
    And Add ER case Location
    And Click on ER case Save button

    Examples: 
      | Username  | Password | 
      | jasleen@mindrops.com  | Admin@12345 | 
      | chelsa@mindrops.com  | Drops$4321 |
      
