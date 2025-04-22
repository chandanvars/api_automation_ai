package utils;

import com.github.javafaker.Faker;
import models.Pet;

public class TestDataGenerator {
    private static final Faker faker = new Faker();

    public static Pet generatePet() {
        Pet pet = new Pet();
        pet.setId(faker.number().randomNumber());
        pet.setName(faker.animal().name());
        pet.setStatus("available");
        return pet;
    }

    public static Pet createRandomPet() {
        Pet pet = new Pet();
        pet.setId(faker.number().randomNumber());
        pet.setName(faker.animal().name());
        pet.setStatus("available");
        // Assuming Pet has type and age fields, add them if required
        // pet.setType(faker.animal().type());
        // pet.setAge(faker.number().numberBetween(1, 15));
        return pet;
    }
}