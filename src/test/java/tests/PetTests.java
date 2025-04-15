package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;
import utils.TestDataGenerator;

public class PetTests extends BaseTest {

    @Test
    public void testAddPet() {
        Pet pet = TestDataGenerator.generatePet();
        Response response = ApiUtils.addPet(pet);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet createdPet = response.as(Pet.class);
        Assert.assertEquals(createdPet.getName(), pet.getName());
    }

    @Test
    public void testGetPetById() {
        Pet pet = TestDataGenerator.generatePet();
        ApiUtils.addPet(pet);
        Response response = ApiUtils.getPetById(pet.getId());
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet fetchedPet = response.as(Pet.class);
        Assert.assertEquals(fetchedPet.getId(), pet.getId());
    }

    @Test
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet();
        ApiUtils.addPet(pet);
        pet.setName("UpdatedName");
        Response response = ApiUtils.updatePet(pet);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet updatedPet = response.as(Pet.class);
        Assert.assertEquals(updatedPet.getName(), "UpdatedName");
    }

    @Test
    public void testDeletePet() {
        Pet pet = TestDataGenerator.generatePet();
        ApiUtils.addPet(pet);
        Response response = ApiUtils.deletePet(pet.getId());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testFindPetsByStatus() {
        Response response = ApiUtils.findPetsByStatus("available");
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet[] pets = response.as(Pet[].class);
        Assert.assertTrue(pets.length > 0);
    }
}