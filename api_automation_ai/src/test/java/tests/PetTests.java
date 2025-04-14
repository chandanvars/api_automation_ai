package tests;

import base.BaseTest;
import helpers.EndpointHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;
import utils.TestDataGenerator;

import static io.restassured.RestAssured.given;

public class PetTests extends BaseTest {

    @Test(priority = 1)
    public void testAddPet() {
        Pet pet = TestDataGenerator.generatePet();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post(EndpointHelper.ADD_PET);

        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responseBody = response.getBody().as(Pet.class);
        Assert.assertEquals(responseBody.getName(), pet.getName());
    }

    @Test(priority = 2)
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet();
        pet.setName("UpdatedName");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(pet)
                .put(EndpointHelper.UPDATE_PET);

        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responseBody = response.getBody().as(Pet.class);
        Assert.assertEquals(responseBody.getName(), "UpdatedName");
    }

    @Test(priority = 3)
    public void testFindPetById() {
        long petId = 1;  // This should be replaced with a valid ID

        Response response = given()
                .pathParam("petId", petId)
                .get(EndpointHelper.FIND_PET_BY_ID);

        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responseBody = response.getBody().as(Pet.class);
        Assert.assertEquals(responseBody.getId(), petId);
    }

    @Test(priority = 4)
    public void testFindPetsByStatus() {
        String status = "available";

        Response response = given()
                .queryParam("status", status)
                .get(EndpointHelper.FIND_PETS_BY_STATUS);

        Assert.assertEquals(response.getStatusCode(), 200);
        Pet[] pets = response.getBody().as(Pet[].class);
        for (Pet pet : pets) {
            Assert.assertEquals(pet.getStatus(), status);
        }
    }

    @Test(priority = 5)
    public void testDeletePet() {
        long petId = 1;  // This should be replaced with a valid ID

        Response response = given()
                .pathParam("petId", petId)
                .delete(EndpointHelper.DELETE_PET);

        Assert.assertEquals(response.getStatusCode(), 200);
        ResponseModel responseBody = response.getBody().as(ResponseModel.class);
        Assert.assertEquals(responseBody.getCode(), 200);
    }

    @Test(priority = 6)
    public void testAddPetInvalid() {
        Pet pet = new Pet(); // Invalid pet object

        Response response = given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post(EndpointHelper.ADD_PET);

        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test(priority = 7)
    public void testFindPetByIdInvalid() {
        long petId = -1;  // Invalid ID

        Response response = given()
                .pathParam("petId", petId)
                .get(EndpointHelper.FIND_PET_BY_ID);

        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test(priority = 8)
    public void testDeletePetInvalid() {
        long petId = -1;  // Invalid ID

        Response response = given()
                .pathParam("petId", petId)
                .delete(EndpointHelper.DELETE_PET);

        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
