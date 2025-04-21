Feature: Pet API Tests

  Scenario: Add a new pet
    Given a new pet with name "Doggie" and status "available"
    When I add the pet to the store
    Then the pet is added successfully

  Scenario: Update an existing pet
    Given an existing pet with ID 1
    When I update the pet's name to "DoggieUpdated"
    Then the pet is updated successfully

  Scenario: Find a pet by ID
    Given a pet ID 1
    When I retrieve the pet by ID
    Then the pet details are returned

  Scenario: Find pets by status
    Given a status "available"
    When I retrieve pets by status
    Then the list of pets is returned

  Scenario: Delete a pet
    Given a pet ID 1
    When I delete the pet
    Then the pet is deleted successfully