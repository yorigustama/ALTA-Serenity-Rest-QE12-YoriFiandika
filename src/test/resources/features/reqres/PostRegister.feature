
Feature: ALTA QE BATCH 12
  @Tugas
  Scenario: Post create register a new user with valid json
    Given Create register new user with valid json "Register.json"
    When Send request post register create new user
    Then Status code should be 200 OK
    And Validate post create JSON schema "PostRegisterSchema.json"
  @Tugas
  Scenario: Post create register a new user with invalid json
    Given Create register new user with invalid json "RegisterInvalid.json"
    When Send request post register create new user
    Then Status code should be 400 bad request
    And Validate post create JSON schema "PostRegisterInvalidSchema.json"