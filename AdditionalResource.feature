@tag
Feature: Creation Of Additional Resource

  @CreateAdditionalResource
  Scenario Outline: Create Of Additional Resource
    Given User is in HRAcuity demo
#    And user clicks on "<optionName>" and "<subMenuOption>"
    And user selects on "<optionName>" and "<subMenuOption>"
    And user clicks on plus icon
    And user create additional resource
    And user selects on "<optionName>" and "<subMenuOption>"
    And user search additional resource
    And user verify additional resource
    And user clicks on export to excel

    Examples:
      | optionName        | subMenuOption                  |
      | ER and INV Fields | Additional Resource (INV only) |