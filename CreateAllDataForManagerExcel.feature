@CreateExcelData
Feature: Create all data for end to end tests

  @CreateAllDataInExcelManagER
  Scenario Outline: Create all data for end to end tests managER
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

#    create action
    And user selects on "<optionName7>" and "<subMenuOption7>"
    And click on Add Actions Icon
    And fill Action name in the field And Save it
    And Update the action with changes And Update it
    #And again click on Add Actions Icon
    #And add New Action and click on Save and Another option

#   create letter template
    And user selects on "<optionName9>" and "<subMenuOption9>"
    Then User click on add icon
    #Then user add and upload log
    Then user drag and drop salutation icon
    Then user drag and drop richtext icon
    Then user drag and drop history icon
    Then user drag and drop selection icon
    Then user drag and drop acknowledgement icon
    Then user drag and drop acknowledgement icon for second manager
    Then User will enter footer
    Then user will search letter template

#    write all created data to excel sheet

    Then write all managER data in excel


    Examples:
      | optionName            | subMenuOption                | optionName1          | subMenuOption1 | optionName2          | subMenuOption2 | optionName3           | subMenuOption3           | optionName4       | subMenuOption4             | optionName5       | subMenuOption5               | optionName6       | subMenuOption6               | optionName7           | subMenuOption7  | optionName8       | subMenuOption8                    | optionName9           | subMenuOption9           |
      | managER Configuration | Step 6: Notification Methods | Groups and Locations | Groups         | Groups and Locations | Locations      | managER Configuration | Step 1: Issue Categories | ER and INV Fields | Interim Actions (INV only) | ER and INV Fields | Policy Guidelines (INV only) | ER and INV Fields | Involved Party Relationships | managER Configuration | Step 2: Actions | ER and INV Fields | Document and Materials (INV only) | managER Configuration | Step 4: Letter Templates |


