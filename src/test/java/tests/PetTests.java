package tests;

import base.BaseTest;
import helpers.EndpointHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Pet;
import org.testng.annotations.Test;
import utils.TestDataGenerator;
import utils.ApiUtils;

public class PetTests extends BaseTest {

    @Test
    public void testAddPet() {
        Pet pet = TestDataGenerator.generatePet();
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(pet)
                .post(EndpointHelper.ADD_PET);
        ApiUtils.validateResponse(response, 200);
    }

    @Test
    public void testGetPetById() {
        long petId = 12345; // Replace with valid petId
        Response response = RestAssured.given()
                .pathParam("petId", petId)
                .get(EndpointHelper.GET_PET_BY_ID);
        ApiUtils.validateResponse(response, 200);
    }

    @Test
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet();
        pet.setId(12345); // Replace with valid petId
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(pet)
                .put(EndpointHelper.UPDATE_PET);
        ApiUtils.validateResponse(response, 200);
    }

    @Test
    public void testDeletePet() {
        long petId = 12345; // Replace with valid petId
        Response response = RestAssured.given()
                .pathParam("petId", petId)
                .delete(EndpointHelper.DELETE_PET);
        ApiUtils.validateResponse(response, 200);
    }

    @Test
    public void testFindPetByStatus() {
        Response response = RestAssured.given()
                .queryParam("status", "available")
                .get(EndpointHelper.FIND_PET_BY_STATUS);
        ApiUtils.validateResponse(response, 200);
    }
}
