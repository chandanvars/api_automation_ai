Feature: Pet API Tests

  Scenario: Add a new pet
    Given a new pet with name "Doggie" and status "available"
    When the client adds the pet
    Then the pet is added successfully

  Scenario: Update an existing pet
    Given an existing pet with id 1
    When the client updates the pet's name to "DoggieUpdated"
    Then the pet is updated successfully

  Scenario: Find a pet by ID
    Given a pet with id 1 exists
    When the client retrieves the pet by id
    Then the pet details are returned

  Scenario: Find pets by status
    Given pets with status "available" exist
    When the client retrieves pets by status "available"
    Then the list of available pets is returned

  Scenario: Delete a pet
    Given a pet with id 1 exists
    When the client deletes the pet
    Then the pet is deleted successfully

  Scenario: Negative test - Find a pet by invalid ID
    Given a pet with id 9999 does not exist
    When the client retrieves the pet by id
    Then a not found error is returned
