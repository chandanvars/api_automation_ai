package utils;

import io.restassured.response.Response;

public class ApiUtils {
    public static void printResponse(Response response) {
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }
}