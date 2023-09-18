Feature: ALTA QE BATCH 12
  @Tugas

  Scenario Outline: Pacth update user with valid json and user id
    Given Update user patch with valid json "UpdateUser.json" and user id 7
    When Send request patch update user
    Then Status code should be 200 OK
    And Respon body patch name was "<name>" and job was "<job>"
    And Validate patch update user JSON schema "PatchUpdateUserSchema.json"
    Examples:
      | name | job |
      | morpheus | zion resident |

  @Tugas
  Scenario Outline: Pacth update user with invalid json and user id
    Given Update user patch without job field invalid json "UpdateUserName.json" and user id 7
    When Send request patch update user
    Then Status code should be 200 OK
    And Respon body patch update without job was "<name>"
    And Validate patch update user JSON schema "PatchUpdateUserWithoutNameSchema.json"
    Examples:
      | name          |  |
      | morpheus |  |

  @Tugas
  Scenario Outline: Pacth update user with invalid json and user id
    Given Update user patch without name field invalid json "UpdateUserJob.json" and user id 7
    When Send request patch update user
    Then Status code should be 200 OK
    And Respon body patch update without name was "<job>"
    And Validate patch update user JSON schema "PatchUpdateUserWithoutJobSchema.json"
    Examples:
      |  | job           |
      |  | zion resident |