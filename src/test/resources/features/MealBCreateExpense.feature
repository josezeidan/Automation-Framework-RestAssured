Feature: MealB API -expenses endpoint

  @createExp
  Scenario: Create Expense API with valid token
    Given I generate token with "walmart" account
    When I submit a POST request to create expense endpoint
    Then I validate status code is 200
    Then I validate expected expense name with actual expense name from API
    Then I validate success field is "true"
