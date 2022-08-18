
Feature: To create a new group and perform actions on it


  @adminGroupCreation
  Scenario: Add a new Group
    #Given User is in HRAcuity Chenoa
    Given User is in HRAcuity demo
    Then User Mouse Hover on Admin Tab
    And user click on Groups and Locations from Admin
    And click on Groups to go on Groups Screen
    And enter Group name and keep parent as self
    And user search for newly created group
    And user edited the group
    And user search for newly created group
    And user use export to exel
    And user deleted newly created group
    And User Logout
    #Then User close browser