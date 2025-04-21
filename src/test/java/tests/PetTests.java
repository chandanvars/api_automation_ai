package tests;

import base.BaseTest;
import helpers.EndpointHelper;
import models.Pet;
import org.testng.annotations.Test;
import utils.ApiUtils;
import utils.TestDataGenerator;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PetTests extends BaseTest {

    @Test
    public void testAddPet() {
        Pet pet = TestDataGenerator.generatePet();
        Response response = ApiUtils.postRequest(EndpointHelper.ADD_PET, pet);
        assertEquals(response.getStatusCode(), 200);
        assertNotNull(response.jsonPath().get("id"));
    }

    @Test
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet();
        pet.setName("UpdatedName");
        Response response = ApiUtils.putRequest(EndpointHelper.UPDATE_PET, pet);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().get("name"), "UpdatedName");
    }

    @Test
    public void testGetPetById() {
        long petId = 12345; // Example pet ID
        Response response = ApiUtils.getRequest(EndpointHelper.GET_PET_BY_ID.replace("{petId}", String.valueOf(petId)));
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().get("id"), petId);
    }

    @Test
    public void testFindPetsByStatus() {
        String status = "available";
        Response response = ApiUtils.getRequest(EndpointHelper.FIND_PETS_BY_STATUS + "?status=" + status);
        assertEquals(response.getStatusCode(), 200);
        assertNotNull(response.jsonPath().getList("id"));
    }

    @Test
    public void testDeletePet() {
        long petId = 12345; // Example pet ID
        Response response = ApiUtils.deleteRequest(EndpointHelper.DELETE_PET.replace("{petId}", String.valueOf(petId)));
        assertEquals(response.getStatusCode(), 200);
    }
}