package utils;

import models.Pet;
import java.util.Random;

public class TestDataGenerator {
    private static Random random = new Random();

    public static Pet generateRandomPet() {
        Pet pet = new Pet();
        pet.setId(random.nextInt(1000));
        pet.setName("Pet" + pet.getId());
        pet.setStatus("available");
        return pet;
    }
}