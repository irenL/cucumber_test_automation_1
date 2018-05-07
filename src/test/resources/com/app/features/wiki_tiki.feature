Feature: Create a wiki pages

  Scenario Outline: Create page
    Given I logged into Tiki
    When I click on menu category Wiki
    Then Following menu options should be visible for Wiki:
      | Wiki Home          |
      | Last Changes       |
      | List Pages         |
      | Create a Wiki Page |
      | Structures         |
    And I click on the Create a Wiki Page
    Then I typed  in the input field:
      | name_page   |
      | <name_page> |
    And I click on Create Page
    Then I type to Input field "<text_page>" text:
      | text_page   |
      | <text_page> |
    And I click on save button
    Then I should see new page for "<name_page>"
    Then I logout from Tiki

    Examples: 
      | name_page       | text_page            |
      | DefecTeam Page1 | Welcome To Our Page1 |
      | DefecTeam Page2 | Welcome To Our Page2 |
      | DefecTeam Page3 | Welcome To Our Page3 |

  Scenario Outline: Delete New Created Page
    Given I logged into Tiki
    When I click on menu category Wiki
    Then Following menu options should be visible for Wiki:
      | Wiki Home          |
      | Last Changes       |
      | List Pages         |
      | Create a Wiki Page |
      | Structures         |
    And I click on the List Pages
    Then I should see table of list pages
    And I find new created page "<name_page>" from list pages
      | name_page   |
      | <name_page> |
    Then I delete "<name_page>"
    And I check if it was deleted from table of list pages
    Then I logout from Tiki
