@CreateExcelData @ProductionTestingReg
Feature: Create all data for end to end tests

  @CreateAllDataInExcel
  Scenario Outline: Create all data for end to end tests
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

        #    create issue category
    And user selects on "<optionName3>" and "<subMenuOption3>"
    And user click on Add Icon
    And fill all the details and save it
    And now update the issue category with Tags
    And Add child to created issue category and save it

      #    create notification method
    And user selects on "<optionName>" and "<subMenuOption>"
    Then User click on notification add icon
    Then User fill details for notification method
    Then User will click on search icon and search notification method

      #    create interim action
    And user selects on "<optionName4>" and "<subMenuOption4>"
    When user click on + Icon
    When user enter inputs in Action Name
    When user enter input in Notes
    When user click on save option

      # create policy guidelines
    And user selects on "<optionName5>" and "<subMenuOption5>"
    Then User click on notification add icon
    Then User fill details for policy guidelines and save it
    Then User will click on search icon and search policy guidelines

    #    create involve party relationship
    And user selects on "<optionName6>" and "<subMenuOption6>"
    And User will click on add icon and add INV relationship
    And User will update INV relationship
    Then User will search created INV relationship

#    create action
    And user selects on "<optionName7>" and "<subMenuOption7>"
    And click on Add Actions Icon
    And fill Action name in the field And Save it
    And Update the action with changes And Update it
    And again click on Add Actions Icon
    And add New Action and click on Save and Another option

#    create document material
    And user selects on "<optionName8>" and "<subMenuOption8>"
    Then User click on notification add icon
    Then User fill details for document material and save it
    Then User will click on search icon and search document material

#    create tag
    Then User Mouse Hover on Admin Tab
    And click on ER and INV Fields
    And user click on Tag Management from Admin
    And click create Tag Icon
    And Enter Tag Name
    And then search the tag
    And then map the created tag with some Issue Category

    #Create Issue Disposition
    And user clicks on "<optionName9>" and "<subMenuOption9>"
    And User Add a Issue Dispositions

    And write all core data in excel sheet

    Examples:
      | optionName        | subMenuOption        | optionName1          | subMenuOption1 | optionName2          | subMenuOption2 | optionName3       | subMenuOption3   | optionName4       | subMenuOption4             | optionName5       | subMenuOption5               | optionName6       | subMenuOption6               | optionName7       | subMenuOption7 | optionName8       | subMenuOption8                    | optionName9       | subMenuOption9                |
      | ER and INV Fields | Notification Methods | Groups and Locations | Groups         | Groups and Locations | Locations      | ER and INV Fields | Issue Categories | ER and INV Fields | Interim Actions (INV only) | ER and INV Fields | Policy Guidelines (INV only) | ER and INV Fields | Involved Party Relationships | ER and INV Fields | Actions        | ER and INV Fields | Document and Materials (INV only) | ER and INV Fields | Issue Dispositions (INV only) |


