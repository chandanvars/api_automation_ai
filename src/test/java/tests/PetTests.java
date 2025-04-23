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
    public void testGetPetById() {
        Pet pet = TestDataGenerator.generatePet();
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post(EndpointHelper.ADD_PET);

        Response response = RestAssured.given()
                .pathParam("petId", pet.getId())
                .get(EndpointHelper.GET_PET_BY_ID);

        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.as(Pet.class);
        Assert.assertEquals(responsePet.getId(), pet.getId());
    }

    @Test
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet();
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post(EndpointHelper.ADD_PET);

        pet.setName("UpdatedName");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .put(EndpointHelper.UPDATE_PET);

        Assert.assertEquals(response.getStatusCode(), 200);
        Pet responsePet = response.as(Pet.class);
        Assert.assertEquals(responsePet.getName(), "UpdatedName");
    }

    @Test
    public void testDeletePet() {
        Pet pet = TestDataGenerator.generatePet();
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post(EndpointHelper.ADD_PET);

        Response response = RestAssured.given()
                .pathParam("petId", pet.getId())
                .delete(EndpointHelper.DELETE_PET);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testFindPetsByStatus() {
        Pet pet = TestDataGenerator.generatePet();
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post(EndpointHelper.ADD_PET);

        Response response = RestAssured.given()
                .queryParam("status", pet.getStatus())
                .get(EndpointHelper.FIND_PETS_BY_STATUS);

        Assert.assertEquals(response.getStatusCode(), 200);
        Pet[] pets = response.as(Pet[].class);
        Assert.assertTrue(pets.length > 0);
    }
}