package utils;

import io.restassured.response.Response;

public class ApiUtils {

    public static void validateStatusCode(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    public static void validateResponseTime(Response response, long maxResponseTime) {
        response.then().time(lessThan(maxResponseTime));
    }

    public static void validateResponseBody(Response response, String expectedValue, String jsonPath) {
        response.then().body(jsonPath, equalTo(expectedValue));
    }
}
