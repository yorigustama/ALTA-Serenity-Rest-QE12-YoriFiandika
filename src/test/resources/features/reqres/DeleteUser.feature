Feature: ALTA QE BATCH 12
  @Tugas
  Scenario Outline: Delete a user with valid user id
  Given Delete a user with valid user id <id>
  When Send request delete user
  Then Status code should be 204 No Content
  Examples:
    | id |
    | 2  |
    | 4  |