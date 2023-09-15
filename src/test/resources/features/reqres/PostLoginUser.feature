@Tugas
Feature: ALTA QE BATCH 12

  Scenario: Post login a user with valid json
    Given Login a new user with valid json "LoginUser.json"
    When Send request login user
    Then Status code should be 200 OK

  Scenario: Post login a user with invalid json
    Given Login a new user without password invalid json "LoginUserInvalidPassword.json"
    When Send request login user
    Then Status code should be 400 bad request

  Scenario: Post login a user with invalid json
    Given Login a new user without email invalid json "LoginUserInvalidEmail.json"
    When Send request login user
    Then Status code should be 400 bad request




