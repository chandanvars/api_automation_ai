package tests;

import base.BaseTest;
import helpers.EndpointHelper;
import io.restassured.response.Response;
import models.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PetTests extends BaseTest {

    @Test
    public void testAddPet() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Doggie");
        pet.setStatus("available");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .post(EndpointHelper.ADD_PET)
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("name"), "Doggie");
    }

    @Test
    public void testGetPetById() {
        int petId = 1;

        Response response = given()
                .pathParam("petId", petId)
                .when()
                .get(EndpointHelper.GET_PET_BY_ID)
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getInt("id"), petId);
    }

    @Test
    public void testFindPetsByStatus() {
        String status = "available";

        Response response = given()
                .queryParam("status", status)
                .when()
                .get(EndpointHelper.FIND_PETS_BY_STATUS)
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertTrue(response.jsonPath().getList("status").contains(status));
    }

    @Test
    public void testUpdatePet() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Doggie");
        pet.setStatus("sold");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .put(EndpointHelper.UPDATE_PET)
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("status"), "sold");
    }

    @Test
    public void testDeletePet() {
        int petId = 1;

        Response response = given()
                .pathParam("petId", petId)
                .when()
                .delete(EndpointHelper.DELETE_PET)
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getInt("code"), 200);
    }
}
