@book
Feature: User should be able to book up a declined payment on

  Scenario: Book for a ticket

    Given I enter valid credentials to login into Ryanair
    And I make a booking from "MADRID" to "IBIZA" on "2020-09-20" for "1" adults and "0" child
    And I enter passengers title "mr" name "musab" and  surname "guzelel"
    And I select an available seat number for selection number "7"
    When I pay for booking with card details "5555 5555 5555 5555" "January/21" and "265"
    Then I should get payment declined message


