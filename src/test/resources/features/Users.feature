Feature: Get Users
  We need to get some users

  Scenario Template: : Send request for getting users

    Given Get Users "<URL>" Request
    Then Response code is: "<status>"
    Examples:
      | URL           | status  |
      | users?page=2  | 200     |
      |               | 404     |
      | ?r            | 404     |