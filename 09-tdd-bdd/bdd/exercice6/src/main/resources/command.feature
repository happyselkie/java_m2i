Feature: Command Order

  as a customer i want to make a command

  Scenario: Add products in command
    Given Customer wants to make a command
    When Customer has command
    And Customer choose the product "Needler"
    Then The product is added in command
    And An error is raised if the command to is not found

  Scenario: Remove products in command
    Given Customer wants to make a command
    When Customer has command
    And Customer choose the product "Needler"
    Then The product is removed from command
    And An error is raised if the command from is not found
    And An error is raised if the product is not found

  Scenario: Valid the command
    Given Customer wants to make a command
    When Customer has command
    Then Customer receive validation mail


