Feature: Create contacts using beans

 
  Scenario: Create contact
    Given I logged into suiteCRM
    When I save a new contact:
      | firstName | lastName | department | officePhone | cellPhone | email         |
      | Julia     | Brandon  | IT         |     3232323 | 342123421 | juliaB@gm.com |
    Then I should see contact information for "Julia Brandon"

  @new_contact
  Scenario Outline: Create way more contact
    Given I logged into suiteCRM
    When I save a new contact:
      | firstName   | lastName   | department   | officePhone | cellPhone | email   |
      | <firstname> | <lastname> | <department> | <office>    | <cell>    | <email> |
   # Then I should see contact information for "<firstname> <lastname>"

    Examples: 
      | firstname | lastname | department | office | cell    | email         |
      | Jenny     | Moore    | ER         |  99999 | 1010101 | jennyM@gm.com |
      | David     | Smith    | IT         |  88888 | 2020202 | davidS@gm.com |
