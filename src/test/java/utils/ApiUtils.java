package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiUtils {
    public static Response post(String endpoint, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response put(String endpoint, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(endpoint);
    }

    public static Response get(String endpoint) {
        return given()
                .when()
                .get(endpoint);
    }

    public static Response delete(String endpoint) {
        return given()
                .when()
                .delete(endpoint);
    }

    public static Response postWithFormParams(String endpoint, String key, String value) {
        return given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam(key, value)
                .when()
                .post(endpoint);
    }

    public static Response uploadFile(String endpoint, String filePath) {
        return given()
                .multiPart("file", filePath)
                .when()
                .post(endpoint);
    }
}