Feature: Create New Articles

  Scenario Outline: Create Article
    Given I logged into Tiki
    When I click on menu category Articles
    Then Following menu options should be visible for Articles:
      | Articles Home |
      | List Articles |
      | New Articles  |
      | Admin Topics  |
      | Admin Types   |
    And I click on the New Articles
    Then I type in a title input field:
      | title_input  |
      | <title_text> |
    And I type in a Heading input field:
      | heading_input  |
      | <heading_text> |
    And I type in a Body input field:
      | body_input  |
      | <body_text> |
    Then I click on button save
    And I should see new Article for "<title_text>"
    Then I logout from Tiki

    Examples: 
      | title_input         | heading_input   | body_input                |
      | Favorite Recipe     | Tiramisu        | Tiramisu Recipe           |
      | Todays News         | World           | Easter Sunday Celebrating |
      | This Day In History | History Stories | Oldest Human Footprints   |

  Scenario Outline: Search Article
    Given I logged into Tiki
    When I click on menu category Articles
    Then Following menu options should be visible for Articles:
      | Articles Home |
      | List Articles |
      | New Articles  |
      | Admin Topics  |
      | Admin Types   |
    And I click on the List Articles
    Then I type in search input field:
      | search_input  |
      | <search_text> |
    And I should see in table of Article list only articles that contains "<search_text>"
    Then I logout from Tiki

    Examples: 
      | search_input        |
      | Favorite Recipe     |
      | Todays News         |
      | This Day In History |
