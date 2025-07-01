Feature: Command Ordering

  as a customer i want to make a command for someone

  Scenario: Creation of an empty command
    Given Customer "Michel" who want to command for someone
    When a command is make for someone
    Then there is no product in the Command
    And the command comes from Customer "Michel"

    Scenario: Creation of command with two products
      Given Customer "Michel" who want to command for someone
      When a command is make for someone
      Then there is two products in the Command
      And the command comes from Customer "Michel"