Feature: Set Query Header And Post a new user
  Background:
    Given Set up Base Site and Headers for request

  Scenario: Post a new User Data
    When Set body JSON data to insert new user
    And Go to the webservice to insert: users
    Then Check Insert Status code is 200
    And Tear down the request