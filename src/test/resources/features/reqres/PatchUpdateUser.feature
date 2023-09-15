Feature: ALTA QE BATCH 12
  @Tugas

  Scenario: Pacth update user with valid json and user id
    Given Update user patch with valid json "UpdateUser.json" and user id 7
    When Send request patch update user
    Then Status code should be 200 OK