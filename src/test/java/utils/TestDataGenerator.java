package utils;

import com.github.javafaker.Faker;
import models.Pet;
import models.User;

import java.util.UUID;

public class TestDataGenerator {
    private static final Faker faker = new Faker();

    public static Pet generatePet() {
        Pet pet = new Pet();
        pet.setId(faker.number().randomNumber());
        pet.setName(faker.name().firstName());
        pet.setStatus("available");
        return pet;
    }

    public static User generateUser() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(faker.name().username());
        user.setEmail(faker.internet().emailAddress());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().phoneNumber());
        user.setUserStatus(1); // Assuming 1 is the default status
        return user;
    }
}