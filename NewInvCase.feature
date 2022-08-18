@Re-testing
Feature: Create an INV Case
@PositiveINVCase
Scenario: Positive create an INV case
Given User is in HRAcuity demo  
When User mouseover New Case Tab and select Conduct Investigation
And Create case Name
And Select Notification Method from the list
And Add Quick -Add Complainanat
And Click on the Save button
And Select Complainants to Add INV Case Involved Paty
And Select INV case Complainant
And Fill Complainant additional Contact Information
And Click on INV case Add Involved Party Save Another and select Subject
And Select Employee ID as Sort by option
And Type Subjects Employee ID and select Subject
And Click on INV case Add Involved Party Save Another and select Subject
And Select Witness from the Role Dropdown
And Click on External
And Select Board Member from the Relationship Dropdown
And Fill Board Members First name
And Fill Board Members Last name
And Fill Board Members Title
And Fill Board Members Email
And Fill Board Members Phone Number
And Fill Board Members Additional Information
And Click on INV case Add Involved Party Save Another and select Subject
And Select Witness from the Role Dropdown
And Click on External
And Select Contractor/Consultant from the Relationship Dropdown
And Fill Contractor/Consultant First name
And Fill Contractor/Consultant Last name
And Fill Contractor/Consultant Title
And Fill Contractor/Consultant Email
And Fill Contractor/Consultant Phone Number
And Fill Contractor/Consultant Additional Information
And Click on INV case Add Involved Party Save Another and select Subject
And Click on INV Involved party Cancel button
And Add Issue button
And Add INV case to be resolved
And Add INV case Issue Category
And INV case Issue Details
And Add unknowns for the Issue
And Click on Add Unknown
And Add another unknowns for the Issue
And Click on Save And Add Another
And Add second INV case to be resolved
And Add second INV case Issue Category
And INV case second Issue Details
And Add unknowns for the second Issue
And Click on Add Issue / Allegation Raised by Complainant Save button
And Click on the First Involved Party Gear and select Plan/Conduct New Intake Interview
And Type First Involved Party Interview Location
And Select First Involved Party Interview Date
And Type First Involved Party Others Present
And Select Use Interview Guide Template
And Select Blank Template from the Dropdown
And Click on Go to INterview
And Checked First interviews Opening Protocol
And Add First interviews Opening Protocols Notes
And Add First interviews First Interview Topic
And Add First interviews First Interview Topic Quesction
And Add First interviews First Interview Topic responses
And Click on Add Topic to INV Interview
And Add First interviews Second Interview Topic
And Checked First interviews Closing Protocol
And Add First interviews Opening Closing Notes
And Add First interview closing Notes
And Click on This interview is Completed
And Click on Save Button
And Click on Return To Investigation
And Clicks on Add team Member
And Select Legal  Advisor from the Role dropdown
And Select the Legal  Advisor
And Check the This case is attorney-client privileged checkbox
And Add Additional Contact Information for Legal  Advisor
And Click on Add Team Member Save And Add Another button
And Select Team Investigator from the Role dropdown
And Select the Team Investigator
And Add Additional Contact Information for Team Investigator
And Click on Add Team Member Save button
And Click on Add Intrim Action button
And Select First Involved Party
And Select Change reporting relationship as the intrim Action
And Add Change reporting relationship Interim Action Specifics
And Click on Save And Add Another button on Add Any Interim Actions to be Taken popup
And Select Second Involved Party
And Select Other as the intrim Action
And Add Other Interim Action Specifics
And Click on Save button on Add Any Interim Actions to be Taken popup
And Click on Continue Button INV case
And Click on Add Resources button for INV Additional Resouces
And Select Information Technology from Resouce
And Add Information Technology Specifics
And Click Save And Add Another button for Add Resources popup
And Select Other from Resouce
And Add Other Specifics
And Click Save button for Add Resources popup
And Click on Continue Button 
And Click on Case Information Continue Button
And Add Details in Findings 
And Add Conclusions
And Select Issue Disposition
And User logout
Then User Close Browser 
