Feature: Set Query Header And Get Users List
  Background:
    Given Set up Base Site and Headers for request

  Scenario Outline: Retrieving Users List by page parameter
    When Set Parameter page = <page> for request
    Then Go to the webservice and basepath users
    And Print all the logs on Console
    Then Check Status code is 200
    And Tear down the request
    Examples:
      | page   |
      | 1   |
      | 2   |
      | 3   |

  Scenario Outline: Retrieving Single User
    When Go to the webservice and basepath users/<user>
    And Print all the logs on Console
    Then Check Status code is 200
    And Tear down the request
    Examples:
      | user   |
      | 690   |
      | 691   |

  Scenario Outline: Search Users
    When Set Parameters <firstname> and <lastname> to search for request
    Then Go to the webservice and basepath users
    And Print all the logs on Console
    Then Check Status code is 200
    And Tear down the request
    Examples:
      | firstname   | lastname  |
      | Thelma      | Jast      |
      | Anne        | Groovy    |