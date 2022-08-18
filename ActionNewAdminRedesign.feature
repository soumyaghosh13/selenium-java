Feature: To validate Action Redesign Screen in Administration
 
@CreationOfActionWithDifferentWaysAndDeleteIt 
Scenario: validate Action Redesign Screen in Administration
 #Given User is in HRAcuity Chenoa
 Given User is in HRAcuity demo
Then User Mouse Hover on Admin Tab 
 And click on ER and INV Fields
 And click on Actios from Admin
 And click on Add Actions Icon
 And fill Action name in the field And Save it 
 And Update the action with changes And Update it
 And again click on Add Actions Icon
 And add New Action and click on Save and Another option
 #And click on New Case for ER Case Creation
 #And Enter ER case name 
 #And Add notification Method and Notification Date 
 #And Add INV case Group
 #And Add ER Case Location
 #And click on Save Button
 #And click on Add Involved Party ER
 #And click on Add Involved Party ER Save Button
 #And click on ER Add Issues
 #And Select ER Issue Category and click on save button
 #And Click on Actions and add created Action
Then User Mouse Hover on Admin Tab 
 And click on ER and INV Fields
 And click on Actios from Admin
 And Enter Action Name and click on search button 
 And Click on Delete Icon and validate the message
 And User Logout
 Then User close browser