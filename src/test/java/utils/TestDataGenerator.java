package utils;

import com.github.javafaker.Faker;
import models.Pet;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static Pet generatePet() {
        Pet pet = new Pet();
        pet.setId(faker.number().randomNumber());
        pet.setName(faker.animal().name());
        pet.setStatus("available");
        return pet;
    }
}