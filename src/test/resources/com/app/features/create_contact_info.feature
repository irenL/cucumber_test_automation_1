Feature: Creating contacts

	@con
	Scenario: Create contact using CREATE page
		
		Given I logged into suiteCRM
		And I open the create contact page
		And I enter the first name "Meryl" and the last name "Streep"
		And I enter the phone number "405-005-5050"
		And I enter the departments "actress"
		When I click on the save button
		Then I should see contact information for "Meryl Streep"
		
		
	@smoke
	Scenario: Create contact using CREATE page
		
		Given I logged into suiteCRM
		And I open the create contact page
		And I enter the first name "Gordon" and the last name "Sumner"
		And I enter the phone number "400-000-7777"
		And I enter the departments "Singer"
		When I click on the save button
		Then I should see contact information for "Gordon Sumner"
		
		@con
	Scenario Outline: Create multiple contact
		
		Given I logged into suiteCRM
		And I open the create contact page
		And I enter the first name "<firstname>" and the last name "<lastname>"
		And I enter the phone number "<phonenumber>"
		And I enter the departments "<department>"
		When I click on the save button
		Then I should see contact information for "<firstname> <lastname>"
		
		Examples:
			| firstname | lastname | phonenumber    | department |
			| Kermit    | Goff     | 1-732-3727     | ing        |
      | Dennis    | Hoffman  | 1-602-5630     | ting       |
      | Quon      | Frank    | 1-191-8707     | sdf        |
      | Mason     | Mendez   | 1-710-5803     | sd         |
      | Herrod    | Berry    | 1-966-9204     | ing        |
      | Inez      | Slater   | 1-442-3808     | df         |
      | Todd      | Lyons    | 1-537-7100     | df         |
      | Brendan   | Meyer    | 1-1280-7814    | df         |
			
		
		
		
		
		
		