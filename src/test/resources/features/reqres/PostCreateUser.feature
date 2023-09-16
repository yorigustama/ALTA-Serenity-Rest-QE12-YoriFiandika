
Feature: ALTA QE BATCH 12
@Latihan
  Scenario: Post create a new user with valid json
    Given Create new user with valid json "User.json"
    When Send request post create new user
    Then Status code should be 201 Created
    And Respon body name was "Yori" and job was "QE"
   And Validate post create user JSON schema "PostCreateUser.json"
  @Tugas
  Scenario: Post create a new user without name field invalid json
    Given Create new user with valid json "UserWithOutName.json"
    When Send request post create new user
    Then Status code should be 201 Created