@AdminCase
Feature: To create a case expense and search


  @adminCaseExpense
  Scenario: Add a case expense
    #Given User is in HRAcuity Chenoa
    Given User is in HRAcuity demo
    Then User Mouse Hover on Admin Tab
    And User click on ErAndEnvField
    And User click on Expense Categories
    And User add Expense Categories
    #####
    Then User Mouse Hover on Admin Tab
    And User click on ErAndEnvField
    And User click on Expense Categories
    And User reset the search
    ####
    And User search Expense Categories
    And User export search result to excel
    And User edit Expense Categories
    And User delete Expense Categories
    ####
    And User Logout
    Then User close browser
