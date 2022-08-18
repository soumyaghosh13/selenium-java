@SmokeTesting 
Feature: Search All Open case in HRAcuity Application 

@PositiveLoginoo
Scenario: Positive Pending Lrgal Review case Search 
	Given User is in HRAcuity demo  
	When  User Clicks on case tab 
	And Click on case Status 
	And Select Pending Legal Review Cases
	And Select INV from Case Type dropdown
	And Click on Advanced Search
	And Fill Pending Legal review Case Name
	And Fill Pending Legal review Case Involved Party First Name
	And Fill Pending Legal review Case Involved Party Last Name
	And fill Pending Legal review Case Involved party Employee ID
	And Fill Investigation Findings and Analysis/Conclusions to the text search
	And Select Customer service call Notification Method
	And Select the Cost center 456
	And  click on Search button 
	And Click on the Pending Legal Review case link
	And Click on Ok for the Pending Legal review case message
	And Verify the case is on Pending Legal review status
	And CaseAdmin logout from application 
	Then Browser close
	
	
	
	
	
	
	
	
	
	@NegativeLogin 
Scenario: Negetive Pending Lrgal Review case Search 
	Given User is in HRAcuity demo  
	When  User Clicks on case tab 
	And Click on case Status
	And Select Pending Legal Review Cases
	And Select INV from Case Type dropdown
	And Click on Advanced Search
	And Fill Pending Legal review Case Name
	And Fill Pending Legal review Case Involved Party First Name
	And Fill Pending Legal review Case Involved Party Last Name
	And fill Pending Legal review Case Involved party Employee ID
	And Select Customer service call Notification Method
	And Select the Cost center 456
	And fill Baker as case owner Last name
	And  click on Search button 
	And Case search Error message Dispaly
	And user logout from application 
	Then Browser close