package utils;

import models.Pet;

import java.util.Random;

public class TestDataGenerator {
    public static Pet generatePet() {
        Random random = new Random();
        long id = random.nextInt(1000);
        String name = "Pet" + id;
        String status = "available";

        return new Pet(id, name, status);
    }
}
