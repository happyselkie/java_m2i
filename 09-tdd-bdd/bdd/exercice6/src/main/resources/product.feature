Feature: Products List

  as a customer i want to browse a product List

  Scenario: Use the search bar
    Given Customer who wants to browse the product list
    When Customer puts "Needler" the search bar
    Then Customer receive a list of products corresponding to "Needler"

  Scenario: Use the categories
    Given Customer who wants to browse the product list
    When Customer choose "Covenant" category
    Then Customer receive a list of products corresponding to the "Covenant" category
