Feature: ALTA QE BATCH 12

  @Tugas
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list
    Then Status code should be 200 OK
    Examples:
      | page |
      | 1    |
      | 2    |

  Scenario Outline: Get list user with invalid parameter page
    Given Get list user with invalid parameter page <page>
    When Send request get list
    Then Status code should be 404 not found
    Examples:
      | page     |
      | 10000000 |
      | 20000000 |


