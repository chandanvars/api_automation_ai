package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    public static Response getPetById(int petId) {
        return RestAssured.given()
                .pathParam("petId", petId)
                .get("/pet/{petId}");
    }
}