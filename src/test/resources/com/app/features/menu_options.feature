Feature: SugarCRM menu options

  @now
  Scenario: Verify Collaboration menu options
    Given I logged into suiteCRM
    When I hover over the Collaboration menu
    Then Following menu options should be visible for Collaboration:
      | Home      |
      | Emails    |
      | Documents |
      | Projects  |

 
  Scenario: Verify Support menu options
    Given I logged into suiteCRM
    When I hover over the Support menu
    Then Following menu options should be visible for Support:
      | Home      |
      | Emails    |
      | Documents |
      | Projects  |

 
  Scenario: Verify Sales menu options
    Given I logged into suiteCRM
    When I hover over the Sales menu
    Then Following menu options should be visible for Sales:
      | Home      |
      | Emails    |
      | Documents |
      | Projects  |


  Scenario: Verify All menu options
    Given I logged into suiteCRM
    When I hover over the All menu
    Then Following menu options should be visible for All:
      | Home      |
      | Emails    |
      | Documents |
      | Projects  |


  Scenario: Verify Marketing menu options
    Given I logged into suiteCRM
    When I hover over the Marketing menu
    Then Following menu options should be visible for Marketing:
      | Home      |
      | Emails    |
      | Documents |
      | Projects  |
      
      
