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
        Pet responsePet = response.as(Pet.class);
        Assert.assertEquals(responsePet.getName(), pet.getName());
    }

    @Test
    public void testFindPetById() {
        long petId = 1; // Example ID
        Response response = RestAssured.given()
                .pathParam("petId", petId)
                .get(EndpointHelper.FIND_PET_BY_ID);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet pet = response.as(Pet.class);
        Assert.assertEquals(pet.getId(), petId);
    }

    @Test
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet();
        pet.setId(1); // Example ID
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .put(EndpointHelper.UPDATE_PET);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.as(Pet.class);
        Assert.assertEquals(responsePet.getName(), pet.getName());
    }

    @Test
    public void testDeletePet() {
        long petId = 1; // Example ID
        Response response = RestAssured.given()
                .pathParam("petId", petId)
                .delete(EndpointHelper.DELETE_PET);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testFindPetsByStatus() {
        String status = "available"; // Example status
        Response response = RestAssured.given()
                .queryParam("status", status)
                .get(EndpointHelper.FIND_PETS_BY_STATUS);
        Assert.assertEquals(response.getStatusCode(), 200);
        Pet[] pets = response.as(Pet[].class);
        for (Pet pet : pets) {
            Assert.assertEquals(pet.getStatus(), status);
        }
    }
}