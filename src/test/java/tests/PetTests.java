package tests;

import base.BaseTest;
import helpers.EndpointHelper;
import models.Pet;
import models.ResponseModel;
import models.UploadResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;
import utils.TestDataGenerator;

import io.restassured.response.Response;

public class PetTests extends BaseTest {

    @Test
    public void testAddNewPet() {
        Pet pet = TestDataGenerator.generatePet(1, "Dog", "available");
        Response response = ApiUtils.post(EndpointHelper.ADD_PET, pet);
        Assert.assertEquals(response.getStatusCode(), 200);

        Pet responsePet = response.as(Pet.class);
        Assert.assertEquals(responsePet.getName(), pet.getName());
    }

    @Test
    public void testGetPetById() {
        Response response = ApiUtils.get(EndpointHelper.GET_PET_BY_ID.replace("{petId}", "1"));
        Assert.assertEquals(response.getStatusCode(), 200);

        Pet pet = response.as(Pet.class);
        Assert.assertEquals(pet.getId(), 1);
    }

    @Test
    public void testFindPetsByStatus() {
        Response response = ApiUtils.get(EndpointHelper.FIND_PETS_BY_STATUS + "?status=available");
        Assert.assertEquals(response.getStatusCode(), 200);

        Pet[] pets = response.as(Pet[].class);
        for (Pet pet : pets) {
            Assert.assertEquals(pet.getStatus(), "available");
        }
    }

    @Test
    public void testUpdatePet() {
        Pet pet = TestDataGenerator.generatePet(1, "Dog", "sold");
        Response response = ApiUtils.put(EndpointHelper.UPDATE_PET, pet);
        Assert.assertEquals(response.getStatusCode(), 200);

        Pet responsePet = response.as(Pet.class);
        Assert.assertEquals(responsePet.getStatus(), "sold");
    }

    @Test
    public void testDeletePet() {
        Response response = ApiUtils.delete(EndpointHelper.DELETE_PET.replace("{petId}", "1"));
        Assert.assertEquals(response.getStatusCode(), 200);

        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertEquals(responseModel.getMessage(), "Pet deleted");
    }

    @Test
    public void testUploadPetImage() {
        Response response = ApiUtils.uploadFile(EndpointHelper.UPLOAD_PET_IMAGE.replace("{petId}", "1"), "src/test/resources/pet.jpg");
        Assert.assertEquals(response.getStatusCode(), 200);

        UploadResponse uploadResponse = response.as(UploadResponse.class);
        Assert.assertEquals(uploadResponse.getMessage(), "File uploaded");
    }

    @Test
    public void testGetNonExistingPet() {
        Response response = ApiUtils.get(EndpointHelper.GET_PET_BY_ID.replace("{petId}", "999999"));
        Assert.assertEquals(response.getStatusCode(), 404);

        ResponseModel responseModel = response.as(ResponseModel.class);
        Assert.assertEquals(responseModel.getMessage(), "Pet not found");
    }
}
