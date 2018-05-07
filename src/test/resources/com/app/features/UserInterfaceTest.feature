Feature: User Interface for SuiteCRM

Scenario: CRM Name and Modules
	Given I logged into suiteCRM 
	Then CRM Name shouls be SuiteCRM 
	And Modules should be displayed  
	Then I logout from application

	