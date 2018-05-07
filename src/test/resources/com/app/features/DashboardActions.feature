Feature: Note on Dashboard

  Background: 
    Given I logged into suiteCRM

@aaaa
  Scenario: Post a note on Dashboard
    When I post "Hello Everyone"
    Then Post should be displayed
    Then I logout from application
@aaaa
  Scenario: Post another note on Dashboard
    When I post "Hello Everyone"
    Then Post should be displayed
    Then I logout from application
