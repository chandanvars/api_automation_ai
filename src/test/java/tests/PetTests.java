package tests;

import base.BaseTest;
import helpers.EndpointHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Pet;
import org.testng.annotations.Test;
import utils.ApiUtils;
import utils.TestDataGenerator;

import static io.restassured.RestAssured.given;

public class PetTests extends BaseTest {

    @Test
    public void testAddPet() {
        Pet pet = TestDataGenerator.generatePet();

        Response response = given()
                .contentType("application/json")
                .body(pet)
                .when()
                .post(EndpointHelper.ADD_PET);

        ApiUtils.validateStatusCode(response, 200);
        ApiUtils.validateResponseBody(response, pet.getName(), "name");
    }

    @Test
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet();
        pet.setName("UpdatedName");

        Response response = given()
                .contentType("application/json")
                .body(pet)
                .when()
                .put(EndpointHelper.UPDATE_PET);

        ApiUtils.validateStatusCode(response, 200);
        ApiUtils.validateResponseBody(response, "UpdatedName", "name");
    }

    @Test
    public void testFindPetById() {
        long petId = 1;

        Response response = given()
                .pathParam("petId", petId)
                .when()
                .get(EndpointHelper.FIND_PET_BY_ID);

        ApiUtils.validateStatusCode(response, 200);
    }

    @Test
    public void testFindPetsByStatus() {
        Response response = given()
                .queryParam("status", "available")
                .when()
                .get(EndpointHelper.FIND_PETS_BY_STATUS);

        ApiUtils.validateStatusCode(response, 200);
    }

    @Test
    public void testDeletePet() {
        long petId = 1;

        Response response = given()
                .pathParam("petId", petId)
                .when()
                .delete(EndpointHelper.DELETE_PET);

        ApiUtils.validateStatusCode(response, 200);
    }
}
