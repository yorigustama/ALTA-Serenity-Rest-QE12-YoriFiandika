Feature: ALTA QE BATCH 12
  @Tugas

  Scenario Outline: Put update user with valid json and user id
    Given Update user with valid json "<jsonFile>" and user id <id>
    When Send request put update user
    Then Status code should be 200 OK
    Examples:
      | id | jsonFile         |
      | 1  | UpdateUser.json  |
      | 2  | UpdateUser2.json |
      | 3  | UpdateUser3.json |

    Scenario: Put update without name field invalid json and valid user id
      Given Update user with invalid json "UpdateUserWithOutName.json" and user id 100000
      When Send request put update user
      Then Status code should be 200 OK

