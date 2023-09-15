Feature: ALTA QE BATCH 12

  @Tugas
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list
    Then Status code should be 200 OK
    And Respon body page should be <page>
#    And Respon id page body page should be "<idPage>"
    And Validate get list user JSON schema "ListUserSchema.json"
    Examples:
      | page | idPage |
      | 2    | 7      |
      | 1    | 1      |
 @Tugas
  Scenario Outline: Get list user with invalid parameter page
    Given Get list user with invalid parameter page <page>
    When Send request get list
    Then Status code should be 404 not found
    Examples:
      | page     |
      | 10000000 |
      | 20000000 |


