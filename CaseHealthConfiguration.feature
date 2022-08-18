@CaseHealthConfiguration
Feature: Testing case health Feature on qa-demo

@Inactivecasehealthverification
Scenario: Creating an Inactive case health and verifying validation message
Given User is in HRAcuity demo
And User click Administration and move to case health
And user click on ercasehealth tab
And user make the case health inactve and verify message
And user click on inv case health tab
And user make the INV case case health inactve and verify message
#And User Logout
Then User close browser

@ERcasehealthselectverification
 Scenario: Selcting all checkboxes in ERcasehealth tab  and Verifing the field in ER case
 Given User is in HRAcuity demo
 And User click Administration and move to case health
And user click on ercasehealth tab
And user select all options from ER case
And user Go to an ER case and   check case health
#And User Logout
Then User close browser

@INVcasehealthselectverification
 Scenario: Selcting all checkboxes in INVcasehealth tab  and Verifing the field in INV case
 Given User is in HRAcuity demo
 And User click Administration and move to case health
And user click on inv case health tab
And user select all options from INV case
And user Go to an INV case and   check INV case health
#And User Logout
Then User close browser

@ERcasehealthdeselectverification
Scenario: DeSelcting Health checkboxes in ERcasehealth tab  and Verifing the field in ER case
 Given User is in HRAcuity demo
 And User click Administration and move to case health
And user click on ercasehealth tab
And User Deselect ER checkboxes
And User navigate to an ER case and Verify the ER case health fields
#And User Logout
Then User close browser

@INVcasehealthdeselectverification
Scenario: Deselect Health checkboxes in INVcasehealth tab  and Verifing the field in INV case
 Given User is in HRAcuity demo
 And User click Administration and move to case health
And user click on inv case health tab
And User Deselect INV checkboxes
And User navigate to an INV case and Verify the INV case health fields
#And User Logout
Then User close browser
#