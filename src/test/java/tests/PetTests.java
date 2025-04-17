package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;
import utils.TestDataGenerator;
import helpers.EndpointHelper;

public class PetTests extends BaseTest {

    @Test
    public void testAddPet() {
        Pet pet = TestDataGenerator.generatePet();
        Response response = ApiUtils.post(EndpointHelper.ADD_PET, pet);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.as(Pet.class);
        Assert.assertEquals(responsePet.getName(), pet.getName());
    }

    @Test
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet();
        pet.setName("UpdatedName");
        Response response = ApiUtils.put(EndpointHelper.UPDATE_PET, pet);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.as(Pet.class);
        Assert.assertEquals(responsePet.getName(), "UpdatedName");
    }

    @Test
    public void testFindPetById() {
        long petId = 1; // Example ID
        Response response = ApiUtils.get(EndpointHelper.FIND_PET_BY_ID.replace("{petId}", String.valueOf(petId)));
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testFindPetsByStatus() {
        String status = "available";
        Response response = ApiUtils.get(EndpointHelper.FIND_PETS_BY_STATUS + "?status=" + status);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testDeletePet() {
        long petId = 1; // Example ID
        Response response = ApiUtils.delete(EndpointHelper.DELETE_PET.replace("{petId}", String.valueOf(petId)));
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}