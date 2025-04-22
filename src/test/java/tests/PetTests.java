package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import helpers.EndpointHelper;
import models.Pet;

public class PetTests {
    @Test
    public void addPet() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Dog");
        pet.setStatus("available");

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(pet)
                .post(EndpointHelper.ADD_PET);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    // Additional test methods for other endpoints
}