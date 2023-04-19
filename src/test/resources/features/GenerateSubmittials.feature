@Smoke @Sample
Feature: Submittals generation

  Scenario: Verify submittal generation process
    Given User opens Hilti website for country US
    When User navigates to Firestop submittal generator page
    And User starts submittal generation process
    And User selects Firestop systems: 3
    And User creates submittal
    And User deselects Firestop products: 1
    And User selects submittals options: NO_COVER, NO_NUMBERS
    And User finalizes submittal generation process
    Then User can download the generated document
