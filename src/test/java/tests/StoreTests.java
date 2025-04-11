package tests;

import base.BaseTest;
import helpers.EndpointHelper;
import models.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;
import utils.TestDataGenerator;

import static io.restassured.RestAssured.given;

public class StoreTests extends BaseTest {

    @Test
    public void testPlaceOrder() {
        Order order = TestDataGenerator.generateOrder();

        Order responseOrder = given()
            .contentType("application/json")
            .body(order)
            .when()
            .post(EndpointHelper.PLACE_ORDER)
            .then()
            .statusCode(200)
            .extract().as(Order.class);

        Assert.assertEquals(responseOrder.getPetId(), order.getPetId());
    }

    @Test
    public void testGetOrderById() {
        int orderId = 1; // Example order ID

        Order responseOrder = given()
            .pathParam("orderId", orderId)
            .when()
            .get(EndpointHelper.GET_ORDER_BY_ID)
            .then()
            .statusCode(200)
            .extract().as(Order.class);

        Assert.assertEquals(responseOrder.getId(), orderId);
    }

    @Test
    public void testDeleteOrder() {
        int orderId = 1; // Example order ID

        given()
            .pathParam("orderId", orderId)
            .when()
            .delete(EndpointHelper.DELETE_ORDER)
            .then()
            .statusCode(200);

        given()
            .pathParam("orderId", orderId)
            .when()
            .get(EndpointHelper.GET_ORDER_BY_ID)
            .then()
            .statusCode(404);
    }

    @Test
    public void testGetInventory() {
        given()
            .when()
            .get(EndpointHelper.GET_INVENTORY)
            .then()
            .statusCode(200);
    }
}
