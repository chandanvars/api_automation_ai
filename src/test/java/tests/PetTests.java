package tests;

import base.BaseTest;
import models.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;

public class PetTests extends BaseTest {

    @Test
    public void testAddNewPet() {
        Pet pet = new Pet(); // Assuming Pet model is properly defined
        // Set pet details

        var response = ApiUtils.getResponse("/pet", "POST", pet);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}