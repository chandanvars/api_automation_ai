package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Pet;

public class ApiUtils {

    public static Response postRequest(String endpoint, Object body) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(endpoint);
    }

    public static Response getRequest(String endpoint) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(endpoint);
    }

    public static Pet createTestPet() {
        return TestDataGenerator.generatePet();
    }
}
