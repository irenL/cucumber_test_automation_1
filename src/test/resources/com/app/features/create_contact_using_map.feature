Feature: Creating contacts

 
  Scenario: Create contact using a map
    Given I logged into suiteCRM
    When I create a new contact:
      | first_name | John    |
      | last_name  | Smith   |
      | cell_phone | 9756382 |
    Then I should see contact informatio for 	"John Smith"
    And the following contact should be created:
      | first_name | John    |
      | last_name  | Smith   |
      | cell_phone | 9756382 |

 
  Scenario Outline: Create contact using a map
    Given I logged into suiteCRM
    When I create a new contact:
      | first_name   | <first_name>   |
      | last_name    | <l_name>       |
      | cell_phone   | <cell_phone>   |
      | office_phone | <office_phone> |
    Then I should see contact informatio for 	"<first_name> <l_name>"

    Examples: 
      | first_name | l_name  | cell_phone   | office_phone |
      | Cindy      | Roberts |  90909090909 |   2532535253 |
      | Melanie    | Smith   | 888888888888 | 344334343343 |
