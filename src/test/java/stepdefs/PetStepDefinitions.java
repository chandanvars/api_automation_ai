package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Pet;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PetStepDefinitions {
    private Response response;
    private Pet pet = new Pet();

    @Given("a new pet with name {string} and status {string}")
    public void a_new_pet_with_name_and_status(String name, String status) {
        pet.setName(name);
        pet.setStatus(status);
    }

    @When("I add the pet to the store")
    public void i_add_the_pet_to_the_store() {
        response = given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(EndpointHelper.PET);
    }

    @Then("the pet is created successfully")
    public void the_pet_is_created_successfully() {
        assertEquals(200, response.statusCode());
    }

    @Given("an existing pet with ID {long}")
    public void an_existing_pet_with_ID(long id) {
        pet.setId(id);
    }

    @When("I update the pet name to {string} and status to {string}")
    public void i_update_the_pet_name_to_and_status_to(String name, String status) {
        pet.setName(name);
        pet.setStatus(status);
        response = given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(EndpointHelper.PET);
    }

    @Then("the pet is updated successfully")
    public void the_pet_is_updated_successfully() {
        assertEquals(200, response.statusCode());
    }

    @When("I retrieve the pet by ID")
    public void i_retrieve_the_pet_by_ID() {
        response = given()
                .pathParam("petId", pet.getId())
                .when()
                .get(EndpointHelper.PET_BY_ID);
    }

    @Then("the pet details are returned successfully")
    public void the_pet_details_are_returned_successfully() {
        assertEquals(200, response.statusCode());
    }

    @When("I retrieve pets by status {string}")
    public void i_retrieve_pets_by_status(String status) {
        response = given()
                .queryParam("status", status)
                .when()
                .get(EndpointHelper.PET_BY_STATUS);
    }

    @Then("the pets are returned successfully")
    public void the_pets_are_returned_successfully() {
        assertEquals(200, response.statusCode());
    }

    @When("I delete the pet")
    public void i_delete_the_pet() {
        response = given()
                .pathParam("petId", pet.getId())
                .when()
                .delete(EndpointHelper.PET_BY_ID);
    }

    @Then("the pet is deleted successfully")
    public void the_pet_is_deleted_successfully() {
        assertEquals(200, response.statusCode());
    }
}