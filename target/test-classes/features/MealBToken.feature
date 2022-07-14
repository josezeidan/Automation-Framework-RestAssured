@token
Feature: Token API

  @token_tc1
  Scenario: GET token with valid credentials
    Given I create a request payload with username "walmart" and password "Mart12345"
    When I submit a POST request to token api
    Then I validate status code is 200
    And I validate success field is "true"

  @token_tc2
    Scenario Outline: GET token with valid credentials
      Given I create a request payload with username <username> and password <password>
      When I submit a POST request to token api
      Then I validate status code is 400
      And I validate success field is "false"
      And I validate error message is <message>

      Examples:
        | username  | password | message                                         |
        | ""        | "12345"  | "The UserNameOrEmailAddress field is required." |
        | "Company" | ""       | "The Password field is required."               |
