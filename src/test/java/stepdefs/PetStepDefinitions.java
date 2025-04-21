package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.Pet;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PetStepDefinitions {
    private Pet pet;
    private Response response;

    @Given("a new pet with name {string} and status {string}")
    public void a_new_pet_with_name_and_status(String name, String status) {
        pet = new Pet();
        pet.setName(name);
        pet.setStatus(status);
    }

    @When("the client adds the pet")
    public void the_client_adds_the_pet() {
        response = given().body(pet).post(EndpointHelper.PET);
    }

    @Then("the pet is added successfully")
    public void the_pet_is_added_successfully() {
        assertEquals(200, response.getStatusCode());
    }

    @Given("an existing pet with id {int}")
    public void an_existing_pet_with_id(int id) {
        pet = new Pet();
        pet.setId(id);
    }

    @When("the client updates the pet's name to {string}")
    public void the_client_updates_the_pet_s_name_to(String name) {
        pet.setName(name);
        response = given().body(pet).put(EndpointHelper.PET);
    }

    @Then("the pet is updated successfully")
    public void the_pet_is_updated_successfully() {
        assertEquals(200, response.getStatusCode());
    }

    @When("the client retrieves the pet by id")
    public void the_client_retrieves_the_pet_by_id() {
        response = given().get(EndpointHelper.PET_BY_ID, pet.getId());
    }

    @Then("the pet details are returned")
    public void the_pet_details_are_returned() {
        assertEquals(200, response.getStatusCode());
    }

    @Given("pets with status {string} exist")
    public void pets_with_status_exist(String status) {
        pet = new Pet();
        pet.setStatus(status);
    }

    @When("the client retrieves pets by status {string}")
    public void the_client_retrieves_pets_by_status(String status) {
        response = given().queryParam("status", status).get(EndpointHelper.PET_FIND_BY_STATUS);
    }

    @Then("the list of available pets is returned")
    public void the_list_of_available_pets_is_returned() {
        assertEquals(200, response.getStatusCode());
    }

    @When("the client deletes the pet")
    public void the_client_deletes_the_pet() {
        response = given().delete(EndpointHelper.PET_BY_ID, pet.getId());
    }

    @Then("the pet is deleted successfully")
    public void the_pet_is_deleted_successfully() {
        assertEquals(200, response.getStatusCode());
    }

    @Given("a pet with id {int} does not exist")
    public void a_pet_with_id_does_not_exist(int id) {
        pet = new Pet();
        pet.setId(id);
    }

    @Then("a not found error is returned")
    public void a_not_found_error_is_returned() {
        assertEquals(404, response.getStatusCode());
    }
}
