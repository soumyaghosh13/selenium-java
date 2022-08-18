Feature: Additional Issue Field


  @AddAdditionalIssueField
  Scenario Outline: Add an Additional Issue Field
    #Given User is in HRAcuity Chenoa
    Given User is in HRAcuity demo
    Then User click on Administration and hover over the "<option>" than select the "<subOption>"
    And user click on Add Icon
    And fill all the details and save it
    And now update the issue category with Tags
    And Add child to created issue category and save it
    And Click on Issue Category name Search bar and enter the name
    Then User click on Administration and hover over the "<Parent_Category>" than select the "<Sub_Category>"
    And User create an Additional Issue Field Template
    And User verify an Additional Issue Field Template
#    And User delete an Additional Issue Field Template
    Examples:
      | option            | subOption        | Parent_Category | Sub_Category           |
      | ER and INV Fields | Issue Categories | Templates       | Additional Issue Field |