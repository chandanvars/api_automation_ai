package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.Pet;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class PetStepDefinitions {
    private Pet pet;
    private Response response;

    @Given("a new pet with name {string} and status {string}")
    public void a_new_pet_with_name_and_status(String name, String status) {
        pet = new Pet();
        pet.setName(name);
        pet.setStatus(status);
    }

    @When("I add the pet to the store")
    public void i_add_the_pet_to_the_store() {
        response = given()
                .contentType("application/json")
                .body(pet)
                .post("/pet");
    }

    @Then("the pet is added successfully")
    public void the_pet_is_added_successfully() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    // Implement other step definitions similarly
}
