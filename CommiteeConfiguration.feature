Feature: Create a committee

@CommitteeConfiguration

Scenario Outline: Adding a new committee from admin
  Given User is in HRAcuity demo
  Then User click on Administration and hover over the "<ParentMenu>" than select the "<ChildMenu>"
  And user create a committee
  And user edit a committee
  And user delete a committee
#  And User Logout

  Examples:
  | ParentMenu | ChildMenu |
  | Feature Configuration | Committee Configuration |