package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response getResponse(String endpoint, String method, Object body) {
        return switch (method) {
            case "POST" -> given().body(body).when().post(endpoint);
            case "GET" -> given().when().get(endpoint);
            case "PUT" -> given().body(body).when().put(endpoint);
            case "DELETE" -> given().when().delete(endpoint);
            default -> throw new IllegalStateException("Unexpected value: " + method);
        };
    }
}