@ProductionTesting
Feature: Create a case on Manager Portal 

  @PositiveCreateAndSave
  Scenario: Create positive case for manager portal 
    Given User is in HRAcuity Manager Chenoa
    When user mouse hover on New Case tab in manager portal
    And Enter Employee Name 
    And Select Issue documenting from the dropdown
    And Select Action from the action dropdown
    And choose the letter template 
    And add some fields in the letter template choosen
    And Select the reviewer from the dropdown 
    And click on Add Document 
    And Select document from library in manager portal
    And click on document save button
    And click on Save button
    And click on Reminders in Manager Portal
    And Set Reminder Date and add note 
    And click on Send reminder to others checkbox
    And Enter Person name in manager portal
    And Enter some message 
    And click on save reminder button
    And User Logout from manager portal
    Then User close browser
    
    
    @PositiveCreateAndSaveAndExit
    Scenario: Create and save and exit the case
     Given User is in HRAcuity Manager Chenoa
    When user mouse hover on New Case tab in manager portal
    And Enter Employee Name 
    And Select Issue documenting from the dropdown
    And Select Action from the action dropdown
    And choose the letter template 
    And add some fields in the letter template choosen
    And Select the reviewer from the dropdown 
    And click on Add Document 
    And Select document from library in manager portal
    And click on document save button
    And click on Save and exit button
    And click on Reminders in Manager Portal
    And Set Reminder Date and add note 
    And click on Send reminder to others checkbox
    And Enter Person name in manager portal
    And Enter some message 
    And click on save reminder button
    And User Logout from manager portal
    Then User close browser
    
    
    @PositiveCreateAndSubmitForReview
    Scenario: Create and submit for review
     Given User is in HRAcuity Manager Chenoa
    When user mouse hover on New Case tab in manager portal
    And Enter Employee Name 
    And Select Issue documenting from the dropdown
    And Select Action from the action dropdown
    And choose the letter template 
    And add some fields in the letter template choosen
    And Select the reviewer from the dropdown
    And click on Add Document 
    And Select document from library in manager portal
    And click on document save button
    And click on save and submit for review button
    And click on Reminders in Manager Portal
    And Set Reminder Date and add note 
    And click on Send reminder to others checkbox
    And Enter Person name in manager portal
    And Enter some message 
    And click on save reminder button
   And User Logout from manager portal
    Then User close browser
    
  