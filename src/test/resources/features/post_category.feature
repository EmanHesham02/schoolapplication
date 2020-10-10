Feature: Add new category
  Scenario: (01) add new category (Happy Path)
    Given that the last category is "12"
    When Admin User post new category with the following value :
      | CategoryName |
      | Algorithm    |
