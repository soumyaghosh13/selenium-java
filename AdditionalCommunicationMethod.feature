@tag

Feature: Creation Of Additional Communication Methods

  @CreateAdditionalCommunicationMethods
  Scenario Outline: Create Of Additional Communication Methods
    Given User is in HRAcuity demo
#    And user clicks on "<optionName>" and "<subMenuOption>"
    And user selects on "<optionName>" and "<subMenuOption>"
    And user clicks on plus icon
    And user create additional communication methods
    And user selects on "<optionName>" and "<subMenuOption>"
    And user search additional communication methods
    And user verify additional communication methods
    And user clicks on export to excel
    Examples:
      | optionName        | subMenuOption                  |
      | ER and INV Fields | Additional Communication Methods (INV only) |