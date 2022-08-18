Feature: To create a Admin Issue Dispositions


  @AdminIssueDispositions
  Scenario: Add a Issue Dispositions
    #Given User is in HRAcuity Chenoa
    Given User is in HRAcuity demo
    Then User Mouse Hover on Admin Tab
    And User click on ErAndEnvField
    And User click on Issue Dispositions INV only
    And User Add a Issue Dispositions
    ####
    Then User Mouse Hover on Admin Tab
    And User click on ErAndEnvField
    And User click on Issue Dispositions INV only
    And User reset the search for Issue Dispositions
    And User search for Issue Dispositions
    And User export search result to excel
    And User Edit Issue Dispositions
    ####
    Then User Mouse Hover on Admin Tab
    And User click on ErAndEnvField
    And User click on Issue Dispositions INV only
    And User search edited Issue Dispositions
    And User delete Issue Dispositions
    ####
    And User Logout
    Then User close browser