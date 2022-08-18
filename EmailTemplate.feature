Feature: Create an Email Template Configuration


  @EmailTemplateConfiguration
  Scenario Outline: Add an Email Template Configuration
    #Given User is in HRAcuity Chenoa
    Given User is in HRAcuity demo
    Then User click on Administration and hover over the "<Parent_Category>" than select the "<Sub_Category>"
    And User create an Email Template Configuration
    Then User verify the template is created successfully
    Examples:
      | Parent_Category | Sub_Category |
      | Templates       | Email        |

  @EmailTemplateConfigurationWithUsage
  Scenario Outline: Add an Email Template Configuration
    #Given User is in HRAcuity Chenoa
    Given User is in HRAcuity demo
    Then User click on Administration and hover over the "<Parent_Category>" than select the "<Sub_Category>"
    And User create an Email Template Configuration
    Then User verify the template is created successfully
    When User mouse hover on New Case Tab and Click on Conduct Investigation
    And Enter INV case name
#    And Add notificatio Method and notification Date
    And select Dynamic Notofication for end to end
    And Add INV case Group
    And Add INV case location
    And click on INV save button
    Then User opens a case to use the new Email Template
    When user click on "Email" icon
    Then User enters "<TO>" and "<CC>" and other required fields and sends the the email
    Examples:
      | Parent_Category | Sub_Category | TO                    | CC                    |
      | Templates       | Email        | hracuity123@gmail.com | hracuity123@gmail.com |