package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import io.restassured.response.Response;
import base.BaseTest;
import models.Pet;
import utils.TestDataGenerator;
import utils.ApiUtils;

public class PetTests extends BaseTest {

    @Test
    public void testAddPet() {
        Pet pet = TestDataGenerator.generatePet();
        Response response = ApiUtils.addPet(pet);
        assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.getBody().as(Pet.class);
        assertEquals(responsePet.getName(), pet.getName());
    }

    @Test
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet();
        ApiUtils.addPet(pet);
        pet.setStatus("sold");
        Response response = ApiUtils.updatePet(pet);
        assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.getBody().as(Pet.class);
        assertEquals(responsePet.getStatus(), pet.getStatus());
    }

    @Test
    public void testGetPetById() {
        Pet pet = TestDataGenerator.generatePet();
        ApiUtils.addPet(pet);
        Response response = ApiUtils.getPetById(pet.getId());
        assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.getBody().as(Pet.class);
        assertEquals(responsePet.getId(), pet.getId());
    }

    @Test
    public void testFindPetsByStatus() {
        Pet pet = TestDataGenerator.generatePet();
        ApiUtils.addPet(pet);
        Response response = ApiUtils.findPetsByStatus("available");
        assertEquals(response.getStatusCode(), 200);
        Pet[] pets = response.getBody().as(Pet[].class);
        assertTrue(pets.length > 0);
    }

    @Test
    public void testDeletePet() {
        Pet pet = TestDataGenerator.generatePet();
        ApiUtils.addPet(pet);
        Response response = ApiUtils.deletePet(pet.getId());
        assertEquals(response.getStatusCode(), 200);
        Response getResponse = ApiUtils.getPetById(pet.getId());
        assertEquals(getResponse.getStatusCode(), 404);
    }
}