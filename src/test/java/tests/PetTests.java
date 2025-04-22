package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;

import io.restassured.response.Response;
import io.restassured.http.ContentType;

import base.BaseTest;
import models.Pet;
import utils.TestDataGenerator;
import utils.ApiUtils;

public class PetTests extends BaseTest {

    private Pet pet;

    @BeforeMethod
    public void setup() {
        pet = TestDataGenerator.generatePet();
        Reporter.log("Generated new Pet with ID: " + pet.getId(), true);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (pet != null && pet.getId() != 0) {
            // Attempt to clean up pet after test if exists
            Response response = ApiUtils.getPetById(pet.getId());
            if (response.getStatusCode() == 200) {
                ApiUtils.deletePet(pet.getId());
                Reporter.log("Deleted Pet with ID: " + pet.getId() + " after test: " + result.getMethod().getMethodName(), true);
            }
        }
    }

    @Test(description = "Positive test: Add a new pet successfully")
    public void testAddPet() {
        Reporter.log("Adding pet with ID: " + pet.getId(), true);
        Response response = ApiUtils.addPet(pet);
        assertEquals(response.getStatusCode(), 200, "Expected HTTP status code 200 on addPet");
        Pet responsePet = response.getBody().as(Pet.class);
        assertNotNull(responsePet, "Response Pet should not be null");
        assertEquals(responsePet.getName(), pet.getName(), "Pet name should match");
        assertEquals(responsePet.getId(), pet.getId(), "Pet ID should match");
        Reporter.log("Successfully added pet with ID: " + responsePet.getId(), true);
    }

    @Test(description = "Negative test: Add pet with missing required fields should fail")
    public void testAddPetMissingFields() {
        Pet invalidPet = new Pet(); // Empty pet with no fields set
        Reporter.log("Adding invalid pet with missing required fields", true);
        Response response = ApiUtils.addPet(invalidPet);
        assertTrue(response.getStatusCode() >= 400, "Expected client error status code for invalid pet");
        Reporter.log("Add pet failed as expected with status: " + response.getStatusCode(), true);
    }

    @Test(description = "Positive test: Update pet status successfully")
    public void testUpdatePet() {
        ApiUtils.addPet(pet);
        pet.setStatus("sold");
        Reporter.log("Updating pet with ID: " + pet.getId() + " to status: sold", true);
        Response response = ApiUtils.updatePet(pet);
        assertEquals(response.getStatusCode(), 200, "Expected HTTP status code 200 on updatePet");
        Pet responsePet = response.getBody().as(Pet.class);
        assertNotNull(responsePet, "Response Pet should not be null");
        assertEquals(responsePet.getStatus(), pet.getStatus(), "Pet status should be updated to sold");
        Reporter.log("Successfully updated pet status to sold", true);
    }

    @Test(description = "Negative test: Update pet which does not exist should fail")
    public void testUpdateNonExistentPet() {
        pet.setId(99999999); // Assuming this ID does not exist
        pet.setStatus("pending");
        Reporter.log("Attempting to update non-existent pet with ID: " + pet.getId(), true);
        Response response = ApiUtils.updatePet(pet);
        assertTrue(response.getStatusCode() >= 400, "Expected client error status code when updating non-existent pet");
        Reporter.log("Update failed as expected with status: " + response.getStatusCode(), true);
    }

    @Test(description = "Positive test: Get pet by valid ID")
    public void testGetPetById() {
        ApiUtils.addPet(pet);
        Reporter.log("Retrieving pet by ID: " + pet.getId(), true);
        Response response = ApiUtils.getPetById(pet.getId());
        assertEquals(response.getStatusCode(), 200, "Expected HTTP status code 200 on getPetById");
        Pet responsePet = response.getBody().as(Pet.class);
        assertNotNull(responsePet, "Response Pet should not be null");
        assertEquals(responsePet.getId(), pet.getId(), "Pet ID should match");
        Reporter.log("Successfully retrieved pet with ID: " + responsePet.getId(), true);
    }

    @Test(description = "Negative test: Get pet by invalid/non-existent ID")
    public void testGetPetByInvalidId() {
        int invalidId = 99999999; // Assuming this ID does not exist
        Reporter.log("Retrieving pet by invalid ID: " + invalidId, true);
        Response response = ApiUtils.getPetById(invalidId);
        assertEquals(response.getStatusCode(), 404, "Expected HTTP status code 404 for non-existent pet");
        Reporter.log("Get pet by invalid ID returned 404 as expected", true);
    }

    @Test(description = "Positive test: Find pets by status 'available'")
    public void testFindPetsByStatusAvailable() {
        ApiUtils.addPet(pet);
        Reporter.log("Finding pets by status 'available'", true);
        Response response = ApiUtils.findPetsByStatus("available");
        assertEquals(response.getStatusCode(), 200, "Expected HTTP status code 200 on findPetsByStatus");
        Pet[] pets = response.getBody().as(Pet[].class);
        assertTrue(pets.length > 0, "Expected at least one pet to be returned for status 'available'");
        boolean found = false;
        for (Pet p : pets) {
            if (p.getId() == pet.getId()) {
                found = true;
                break;
            }
        }
        assertTrue(found, "Added pet should be present in the list of 'available' pets");
        Reporter.log("Found pets with status 'available', including the added pet", true);
    }

    @Test(description = "Negative test: Find pets by invalid status should return empty or error")
    public void testFindPetsByInvalidStatus() {
        String invalidStatus = "notastatus";
        Reporter.log("Finding pets by invalid status: " + invalidStatus, true);
        Response response = ApiUtils.findPetsByStatus(invalidStatus);
        // The API might return 200 with empty list or 400 error, checking both scenarios
        if (response.getStatusCode() == 200) {
            Pet[] pets = response.getBody().as(Pet[].class);
            assertTrue(pets.length == 0, "Expected no pets for invalid status");
            Reporter.log("Received empty pet list for invalid status as expected", true);
        } else {
            assertTrue(response.getStatusCode() >= 400, "Expected error status code for invalid status");
            Reporter.log("Received error status code " + response.getStatusCode() + " for invalid status as expected", true);
        }
    }

    @Test(description = "Positive test: Delete pet successfully")
    public void testDeletePet() {
        ApiUtils.addPet(pet);
        Reporter.log("Deleting pet with ID: " + pet.getId(), true);
        Response response = ApiUtils.deletePet(pet.getId());
        assertEquals(response.getStatusCode(), 200, "Expected HTTP status code 200 on deletePet");
        Response getResponse = ApiUtils.getPetById(pet.getId());
        assertEquals(getResponse.getStatusCode(), 404, "Expected HTTP status code 404 after pet deletion");
        Reporter.log("Successfully deleted pet and confirmed non-existence", true);
        pet = null; // Mark pet as deleted to avoid tearDown delete attempt
    }

    @Test(description = "Negative test: Delete pet with invalid/non-existent ID")
    public void testDeletePetInvalidId() {
        int invalidId = 99999999; // Assuming this ID does not exist
        Reporter.log("Attempting to delete non-existent pet with ID: " + invalidId, true);
        Response response = ApiUtils.deletePet(invalidId);
        assertTrue(response.getStatusCode() >= 400, "Expected client error status code when deleting non-existent pet");
        Reporter.log("Delete failed as expected with status: " + response.getStatusCode(), true);
    }
}