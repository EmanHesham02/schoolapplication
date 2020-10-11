Feature: Add new category

  Scenario: (01) add new category (Happy Path)
    Given that the last category is "2"
    When Admin User post new category with the following value :
      | CategoryName |
      | math2        |
    Then the category are added with id "3"
