
Feature: Creating Tasks
 
  @con
  Scenario: Create a task 
    Given I logged into suiteCRM  
    When I click on create task
    And Set subject as "Automate Scenarios"
    And Set status as "Not Started"
		And Start date is todays date
		And Due date is 5 dates after today date
 		And Set "Medium" priority
 		And Set description as "Automate test cases using Cucumber and Selenium"
 		Then Save the task
 		Then Task details page should be displayed 
 		And Data should match with create task data
 		Then I logout from application
