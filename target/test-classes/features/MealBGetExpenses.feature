Feature: MealB API -expenses endpoint

  @getExpenses
  Scenario: Get all expenses with valid token
    Given I generate token with "walmart" account
    When I submit a GET request to expense endpoint
    Then I validate status code is 200
    Then I validate success field is "true"
