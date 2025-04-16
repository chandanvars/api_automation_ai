Feature: Pet API Tests

  Scenario: Create a new pet
    Given a new pet with name "Doggie" and status "available"
    When I add the pet to the store
    Then the pet is created successfully

  Scenario: Update an existing pet
    Given an existing pet with ID 1
    When I update the pet name to "Kitty" and status to "sold"
    Then the pet is updated successfully

  Scenario: Retrieve a pet by ID
    Given a pet with ID 1 exists
    When I retrieve the pet by ID
    Then the pet details are returned successfully

  Scenario: Retrieve pets by status
    Given pets with status "available" exist
    When I retrieve pets by status "available"
    Then the pets are returned successfully

  Scenario: Delete a pet
    Given a pet with ID 1 exists
    When I delete the pet
    Then the pet is deleted successfully