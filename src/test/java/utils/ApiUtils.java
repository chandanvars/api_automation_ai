package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.equalTo;
import helpers.EndpointHelper;
import models.Pet;

public class ApiUtils {
    public static Response addPet(Pet pet) {
        return given()
                .contentType("application/json")
                .body(pet)
                .when()
                .post(EndpointHelper.ADD_PET);
    }

    public static Response updatePet(Pet pet) {
        return given()
                .contentType("application/json")
                .body(pet)
                .when()
                .put(EndpointHelper.UPDATE_PET);
    }

    public static Response getPetById(Long petId) {
        return given()
                .pathParam("petId", petId)
                .when()
                .get(EndpointHelper.GET_PET_BY_ID);
    }

    public static Response findPetsByStatus(String status) {
        return given()
                .queryParam("status", status)
                .when()
                .get(EndpointHelper.FIND_PETS_BY_STATUS);
    }

    public static Response deletePet(Long petId) {
        return given()
                .pathParam("petId", petId)
                .when()
                .delete(EndpointHelper.DELETE_PET);
    }

    public static void validateStatusCode(Response response, int expectedStatusCode) {
        assertThat("Status code validation failed", response.getStatusCode(), equalTo(expectedStatusCode));
    }

    public static void validateResponseTime(Response response, long maxResponseTimeMillis) {
        assertThat("Response time validation failed", response.getTime(), lessThan(maxResponseTimeMillis));
    }
}