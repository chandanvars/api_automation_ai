package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiUtils {
    public static Response postRequest(String endpoint, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }

    public static Response putRequest(String endpoint, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract().response();
    }

    public static Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract().response();
    }

    public static Response deleteRequest(String endpoint) {
        return given()
                .when()
                .delete(endpoint)
                .then()
                .extract().response();
    }
}