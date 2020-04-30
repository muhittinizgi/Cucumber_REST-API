Feature: Set Query Header And Test REST API schema
  Background:
    Given Set up Base Site and Headers for request

  Scenario Outline: Test User JSON schema
    When Go to the webservice to test schema users/<user>
    Then Check schema Status
    And Tear down the request
    Examples:
      | user   |
      | 855  |