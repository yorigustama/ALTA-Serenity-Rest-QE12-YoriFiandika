@Tugas
Feature: ALTA QE BATCH 12

  Scenario: Get single user with valid id user
    Given Get single user with valid parameter id 2
    When Send request get single user
    Then Status code should be 200 OK
    And Respon single user body page should id 2


  Scenario: Get single user with invalid id user
    Given Get single user with invalid parameter id 10000
    When Send request get single user
    Then Status code should be 404 not found
