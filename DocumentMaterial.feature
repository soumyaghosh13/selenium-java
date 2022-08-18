@tag
Feature: Creation Of Document Material

  @CreateDocumentMaterial
  Scenario Outline: Create a Document Material
    Given User is in HRAcuity demo 
    And user clicks on "<optionName>" and "<subMenuOption>"
    Then User click on notification add icon
    Then User fill details for document material and save it
    Then User will click on search icon and search document material
    Then User will delete notification    

    Examples: 
     |optionName|subMenuOption|
     |ER and INV Fields|Document and Materials (INV only)|

   