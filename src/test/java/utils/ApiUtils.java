package utils;

import io.restassured.RestAssured;

public class ApiUtils {
    public static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }
}