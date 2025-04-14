package utils;

import io.restassured.response.Response;

public class ApiUtils {
    public static void validateResponse(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }
}
