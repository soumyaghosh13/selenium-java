@SmokeTesting
Feature: Search Profile 
@positiveProfile
Scenario Outline: Positive-Search Valid Profile 
	#Given User is in HRAcuity demo 
	Given User is in HRAcuity demo
	And user clicks on "<optionName1>" and "<subMenuOption1>"
	#When User mouseover Administration Tab and select Profile 
	And click on Profile
	And Write Existing ProfileName"<ProfileName>" 
	And Click on Search Button 
	Then User should be able to see the user name with his/her details 
	Then Close Browser 
	
	Examples: 
		|ProfileName |
		|Jasleen Kaur|
		
		@negetiveProfile 
		Scenario Outline: Negative-Search Valid Profile 
			Given User is in HRAcuity demo 
			When User mouseover Administration Tab and select Profile 
			And Write nonexisting ProfileName"<ProfileName>" 
			And click on search Button 
			Then No Record found Message Will displayed 
			Then close browser 
			
			Examples: 
				|ProfileName |
				|Iron Man|