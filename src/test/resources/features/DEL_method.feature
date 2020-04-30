Feature: Set Query Header And Delete a Users Info
  Background:
    Given Set up Base Site and Headers for request

  Scenario Outline: Delete Single User
    When Go to the webservice to delete users/<user>
    Then Check Delete Status code is 200
    And Tear down the request
    Examples:
      | user   |
      | 711   |
      | 712   |