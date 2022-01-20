Feature: Users routines
  Some basic user routines - list, create, update, delete

  Scenario Outline: Send request for getting users

    When Get Users "<URL>" Request
    Then Response code is: "<status>"
    Examples:
      | URL           | status  |
      | users?page=2  | 200     |
      |               | 404     |
      | ?r            | 404     |

  Scenario Outline: Send request for register user

    Given Send request with attributes "<email>" and "<password>"
    Then Response code is: "<status>"
    Examples:
      | email               | password  | status  |
      | eve.holt@reqres.in  | pistol    | 200     |
      | eve.holt@reqres.in  |           | 400     |
      |                     | pistol    | 400     |
      |                     |           | 400     |