@Tugas
Feature: ALTA QE BATCH 12

  Scenario Outline: Put update user with valid json and user id
    Given Update user with valid json "<jsonFile>" and user id <id>
    When Send request put update user
    Then Status code should be 200 OK
    And Respon body name was "<name>" and job was "<job>"
    And Validate put update user JSON schema "PutUpdateUser.json"
    Examples:
      | id | jsonFile         | name  | job |
      | 1  | UpdateUser.json  | Yori  | QE2 |
      | 2  | UpdateUser2.json | Yori2 | QE2 |
      | 3  | UpdateUser3.json | Yori3 | QE3 |

  Scenario: Put update without name field invalid json and valid user id
      Given Update user with invalid json "UpdateUserWithOutName.json" and user id 100000
      When Send request put update user
      Then Status code should be 200 OK

