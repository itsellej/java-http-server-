Feature: Simple POST request

  @simple-post
  Scenario: Posting echos the body
    Given I make a POST with a body to "/echo_body"
    Then my response should have statusCode code 200
    And my response body should equal the body of my request
