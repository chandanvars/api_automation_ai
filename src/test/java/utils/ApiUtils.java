package utils;

import io.restassured.response.Response;
import models.Pet;

import static io.restassured.RestAssured.given;

public class ApiUtils {
    public static Response addPet(Pet pet) {
        return given()
                .contentType("application/json")
                .body(pet)
                .post(helpers.EndpointHelper.PET);
    }

    public static Response getPetById(long petId) {
        return given()
                .pathParam("petId", petId)
                .get(helpers.EndpointHelper.PET_BY_ID);
    }

    public static Response updatePet(Pet pet) {
        return given()
                .contentType("application/json")
                .body(pet)
                .put(helpers.EndpointHelper.PET);
    }

    public static Response deletePet(long petId) {
        return given()
                .pathParam("petId", petId)
                .delete(helpers.EndpointHelper.PET_BY_ID);
    }

    public static Response findPetsByStatus(String status) {
        return given()
                .queryParam("status", status)
                .get(helpers.EndpointHelper.PET_FIND_BY_STATUS);
    }
}