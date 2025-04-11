package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {
    public static Response post(String endpoint, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .post(endpoint);
    }

    public static Response put(String endpoint, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .put(endpoint);
    }

    public static Response get(String endpoint) {
        return given()
                .get(endpoint);
    }

    public static Response delete(String endpoint) {
        return given()
                .delete(endpoint);
    }

    public static Response postWithFormParams(String endpoint, String key, String value) {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .formParam(key, value)
                .post(endpoint);
    }

    public static Response uploadFile(String endpoint, String filePath) {
        return given()
                .multiPart("file", filePath)
                .post(endpoint);
    }
}