package tests;

import base.BaseTest;
import helpers.EndpointHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Pet;
import org.testng.annotations.Test;
import utils.ApiUtils;
import static org.testng.Assert.assertEquals;

public class PetTests extends BaseTest {

    @Test
    public void testAddNewPet() {
        Pet pet = ApiUtils.createTestPet();

        Response response = ApiUtils.postRequest(EndpointHelper.getPetEndpoint(), pet);
        assertEquals(response.getStatusCode(), 200);

        Pet responsePet = response.as(Pet.class);
        assertEquals(pet.getName(), responsePet.getName());
    }

    @Test
    public void testFindPetById() {
        Pet pet = ApiUtils.createTestPet();
        ApiUtils.postRequest(EndpointHelper.getPetEndpoint(), pet);

        Response response = ApiUtils.getRequest(EndpointHelper.getPetByIdEndpoint(pet.getId()));
        assertEquals(response.getStatusCode(), 200);

        Pet responsePet = response.as(Pet.class);
        assertEquals(pet.getId(), responsePet.getId());
    }

    // Add other test methods for update, delete, find by status, etc.
}
