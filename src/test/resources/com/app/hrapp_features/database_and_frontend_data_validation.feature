Feature: Hr Application Database and UI data verification

  Background: 
    Given I am on DeptEmpPage

  @HRAppDB
  Scenario: Department data UI and Database verification
    When I search for department id 10
    Then I query database with sql "Select department_name,manager_id,location_id from departments where department_id=10"
    Then UI data and Database data must match

  @HRAppDB
  Scenario Outline: Firstname and lastname search by email-UI vs DB verification
    When I search for email "<email>" to see firstname and lastname
    And I query database with sql "SELECT first_name,last_name FROM employees WHERE email='<email>'"
    Then UI data and Database data must match

    Examples: 
      | email   |
      | JWHALEN |
      | HBAER   |
      | JRUSSEL |

  @HRAppDB
  Scenario Outline: Verify Number of Employees for department_UI vs DB verification
    When I search for department id <departmentId> and get number of employees
    And I query database with sql "SELECT COUNT(*) AS EMPLOYEES_COUNT FROM employees WHERE department_id=<departmentId>"
    Then UI data and Database data must match

    Examples: 
      | departmentId |
      |           10 |
      |           30 |
      |           50 |
