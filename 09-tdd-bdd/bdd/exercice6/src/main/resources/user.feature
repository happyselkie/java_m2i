Feature: Command Ordering

  as a customer i want to make a command for someone

  Scenario: Creation of User account
    Given Customer "Cortana" who wants to get an account to command
    When Customer register email : "cortana@master.com", username : "cortana" and password : "Halo123"
    Then Customer receive an confirmation email
    And Check if customer already exist and raise an error if it does

  Scenario: Connexion of User account
    Given Customer "Cortana" who wants to get an account to command
    When Customer register email : "cortana@master.com", username : "cortana" and password : "Halo123"
    Then Customer receive an confirmation email
    And Check if customer already exist and raise an error if it does