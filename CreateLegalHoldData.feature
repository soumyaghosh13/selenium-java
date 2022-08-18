@CreateExcelData
Feature: Create legal hold data for end to end tests

  @CreateLegalHoldDataInExcel
  Scenario Outline: Create legal hold data for end to end tests
   #Given User is in HRAcuity Chenoa
    Given User is in HRAcuity demo

#    create group
    And user clicks on "<optionName1>" and "<subMenuOption1>"
    And enter Group name and keep parent as self
    And user search for newly created group

#     create location
    And user clicks on "<optionName2>" and "<subMenuOption2>"
    And Click on Add Icon of Location
    And enter Location name and keep parent as self
    And enter the Client LocationId
    And click on save Location button

    #    create action
    And user selects on "<optionName7>" and "<subMenuOption7>"
    And click on Add Actions Icon
    And fill Action name in the field And Save it
    And Update the action with changes And Update it
    And again click on Add Actions Icon
    And add New Action and click on Save and Another option

    And write all legal hold data in excel sheet

    Examples:
      | optionName1          | subMenuOption1 | optionName2          | subMenuOption2 | optionName7       | subMenuOption7 |
      | Groups and Locations | Groups         | Groups and Locations | Locations      | ER and INV Fields | Actions        |