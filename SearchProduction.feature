Feature: Search Cases
  
  @AllOpenCaseSearch/ProfileSearch/NegativeProfileSearch 
  Scenario: Search for all open cases on Production
  #Given User is in HRAcuity Chenoa
  Given User is in HRAcuity demo
  When User Clicks on Case Tab on production
  And Select All Open Cases from Case Status
  And Click on Search 
  And open the case
  And verify case status in In Progress
  And click on Profile
  And Enter Name for Search
  And click on search button
  And click on Profile
  And Enter Invalid Name for Search
  And click on search button
  And User Logout
  Then User close browser
  
  @AllCloseCaseSearchProduction 
  Scenario: Search for all Close Cases On Production
  #Given User is in HRAcuity Chenoa
  Given User is in HRAcuity demo
  When User Clicks on Case Tab on production
  And Select All Close Cases from Case Status
  And Click on Search 
  And open the closed case after search
  And verify case status
  And User Logout
  Then User close browser
  
  
  @DisabledCaseSearchProductionPositive
  Scenario: Positive Disabled Case Search on Production
  #Given User is in HRAcuity Chenoa
  Given User is in HRAcuity demo
  When user click on case tab 
  And Select Disabled Case from the dropdown
  And Select EI cases from the case type dropdown
  And click on advanced search
  And click on search button on production
  And click on disabled case
  And verify disabled display 
  And User Logout
  Then User close browser
  
  @DisabledCaseSearchProductionNegative
  Scenario: Negative Disabled Case Search On Production
  #Given User is in HRAcuity Chenoa
  Given User is in HRAcuity demo
  When user click on case tab 
  And Select Disabled Case from the dropdown
  And Select EI cases from the case type dropdown
  And click on advanced search
  And fill case owner last name Khan
  And click on search button on production
  And Case search error message displays
  And User Logout
  Then User close browser
  
  
  
 #@AllCasesSearch
  #Scenario: Search for all cases on Production
  #Given User is in HRAcuity Chenoa
  #When User Clicks on Case Tab on production
  #And Select All Cases from Case Status
  #And Click on Search 
  #And open the case
  #And verify case status in In Progress
  #And User Logout
  #Then User close browser
  
  
   