package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import helpers.EndpointHelper;
import models.Pet;

public class PetTests {

    @Test
    public void addNewPet() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Doggie");
        pet.setStatus("available");

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(pet)
                .post(EndpointHelper.ADD_PET);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void updatePet() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Doggie");
        pet.setStatus("sold");

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(pet)
                .put(EndpointHelper.UPDATE_PET);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void findPetById() {
        Response response = RestAssured.given()
                .pathParam("petId", 1)
                .get(EndpointHelper.FIND_PET_BY_ID);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void findPetsByStatus() {
        Response response = RestAssured.given()
                .queryParam("status", "available")
                .get(EndpointHelper.FIND_PETS_BY_STATUS);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void deletePet() {
        Response response = RestAssured.given()
                .pathParam("petId", 1)
                .delete(EndpointHelper.DELETE_PET);

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}