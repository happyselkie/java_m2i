Feature: User Account

  as a customer i want to acces an account to order

  Scenario: Creation of User account
    Given Customer "Cortana" who wants to get an account to command
    When Customer register email : "cortana@master.com", username : "cortana" and password : "Halo123"
    Then Customer receive an confirmation email
    And Check if customer "cortana" already exist and raise an error if it does

  Scenario: Connexion of User account
    Given Customer "Cortana" who wants to get an account to command
    When Customer inputs username : "cortana" and password : "Halo123"
    Then Customer "cortana" is redirect to homepage if success
    And Customer "cortana" gets an error if not register
    And Customer "cortana" gets an error if wrong password

