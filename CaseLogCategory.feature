Feature: To create a case log category and search


  @adminCaseLogCategory
  Scenario: Add a case case log category
    #Given User is in HRAcuity Chenoa
    Given User is in HRAcuity demo
    Then User Mouse Hover on Admin Tab
    And User click on ErAndEnvField
    And User click on case log Categories
    And User add Case Log Categories
    #####
    Then User Mouse Hover on Admin Tab
    And User click on ErAndEnvField
    And User click on case log Categories
    And User reset the search for case log
    ####
    And User search Case Log Categories
    And User export search result to excel
    And User edit Case Log Categories
    ####
    Then User Mouse Hover on Admin Tab
    And User click on ErAndEnvField
    And User click on case log Categories
    And User search edited Case Log Categories
    And User delete Case Log Categories
    ####
    And User Logout
    Then User close browser
