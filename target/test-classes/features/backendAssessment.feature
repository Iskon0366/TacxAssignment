@integration @wipApi
Feature:Tacx API Collection Tests

  @smoke
  Scenario: GET all employees
    When User sends GET request to end point "employees" and gets the json payload
    Then status code should be 200
    And status code text should be "OK"
    And "status" data should have "success" value
    And verify "data" has 24 items in payload
    And verify response header has "Content-Type" and verify its value "application/json"
    And get 1 st element data and save

  Scenario: GET single employee
    When User sends GET request to end point "employee" with id and gets the json payload
    Then status code should be 200
    And status code text should be "OK"
    And "status" data should have "success" value
    And employee data should match with the previous data values
    And "message" data should have "Successfully! Record has been fetched." value
    And verify response header has "Content-Type" and verify its value "application/json"

  Scenario: POST Create A New Employee
    When User sends POST request to end point create with body and gets the json payload
      | name   | Jamal |
      | salary | 55000 |
      | age    | 31    |
    #200 must me 201
    Then status code should be 200
    #status code must be Created
    And status code text should be "OK"
    And verify response header has "Content-Type" and verify its value "application/json"
    And "status" data should have "success" value
    And body content should match with the given values
    #Take ID for next scenario
    And "message" data should have "Successfully! Record has been added." value


  Scenario: PUT Update An Employee
    Given User gets the Id from previous created value and create a change
    When When User sends PUT request to end point "update" with a new change and gets the json payload
    #200 must me 201
    Then status code should be 200
    #status code must be Created
    And status code text should be "OK"
    And verify response header has "Content-Type" and verify its value "application/json"
    And "status" data should have "success" value
    #compare with sent
    And verify the updated value passed
    And "message" data should have "Successfully! Record has been updated." value

    #negative scenario with changing ID
  Scenario: DELETE Delete An Employee
    #pass the ID taken before
    When When User sends DELETE request to end point "delete" with ID taken before and gets the json payload
    Then status code should be 200
    And status code text should be "OK"
    And verify response header has "Content-Type" and verify its value "application/json"
    And "status" data should have "success" value
    #compare with taken ID
    And "data" data should have taken ID value
    And "message" data should have "Successfully! Record has been deleted" value



