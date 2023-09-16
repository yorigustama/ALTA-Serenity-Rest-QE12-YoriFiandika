Feature: ALTA QE BATCH 12
  @Tugas

  Scenario: Pacth update user with valid json and user id
    Given Update user patch with valid json "UpdateUser.json" and user id 7
    When Send request patch update user
    Then Status code should be 200 OK
    And Validate patch update user JSON schema "PatchUpdateUserSchema.json"
  @Tugas
  Scenario: Pacth update user with invalid json and user id
    Given Update user patch without job field invalid json "UpdateUserInvalidJob.json" and user id 7
    When Send request patch update user
    Then Status code should be 200 OK
    And Validate patch update user JSON schema "PatchUpdateUserWithoutJobSchema.json"
  @Tugas
  Scenario: Pacth update user with invalid json and user id
    Given Update user patch without name field invalid json "UpdateUserInvalidName.json" and user id 7
    When Send request patch update user
    Then Status code should be 200 OK
    And Validate patch update user JSON schema "PatchUpdateUserWithoutNameSchema.json"