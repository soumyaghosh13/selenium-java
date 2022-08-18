@TestsWrittenByParamita
Feature: Schedule Analytic Report 

@ScheduleReportWithoutPassword
Scenario: Schedule the report 
	Given User is in HRAcuity demo  
	When  User clicks on Insight Analytics Center
	And Click on HrAcuity Report
	And Apply filter
	And Save the report
	And Schedule the report with the details
 And Select calendar dates
And schedule without password          
Then Admin logout and close the browser
	

@ScheduleReportWithPassword
Scenario: Schedule the report 
Given User is in HRAcuity demo  
	When  User clicks on Insight Analytics Center
	And Click on HrAcuity Report
	And Apply filter
	And Save the report
	And Schedule the report with the details
 And Select calendar dates
 And schedule with password
	Then Admin logout and close the browser





