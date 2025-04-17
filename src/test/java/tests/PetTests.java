package tests;

import base.BaseTest;
import helpers.EndpointHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGenerator;

public class PetTests extends BaseTest {

    @Test
    public void testAddPet() {
        Pet pet = TestDataGenerator.generatePet();
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post(EndpointHelper.ADD_PET);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.getBody().as(Pet.class);
        Assert.assertEquals(responsePet.getName(), pet.getName());
    }

    @Test
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet();
        pet.setName("UpdatedName");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .put(EndpointHelper.UPDATE_PET);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.getBody().as(Pet.class);
        Assert.assertEquals(responsePet.getName(), "UpdatedName");
    }

    @Test
    public void testGetPetById() {
        long petId = 12345; // Example pet ID
        Response response = RestAssured.given()
                .pathParam("petId", petId)
                .get(EndpointHelper.GET_PET_BY_ID);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.getBody().as(Pet.class);
        Assert.assertEquals(responsePet.getId(), petId);
    }

    @Test
    public void testFindPetsByStatus() {
        String status = "available";
        Response response = RestAssured.given()
                .queryParam("status", status)
                .get(EndpointHelper.FIND_PETS_BY_STATUS);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet[] pets = response.getBody().as(Pet[].class);
        for (Pet pet : pets) {
            Assert.assertEquals(pet.getStatus(), status);
        }
    }

    @Test
    public void testDeletePet() {
        long petId = 12345; // Example pet ID
        Response response = RestAssured.given()
                .pathParam("petId", petId)
                .delete(EndpointHelper.DELETE_PET);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}