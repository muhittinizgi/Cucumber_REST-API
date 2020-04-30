Feature: Set Query Header And Update a Users Info
  Background:
    Given Set up Base Site and Headers for request

  Scenario Outline: Update Spesified User Data
    When Set body JSON user data
    When Go to the webservice to update users/<user>
    Then Check Update Status code is 200
    And Tear down the request
    Examples:
      | user    |
      | 715     |