package utils;

import models.Pet;

public class TestDataGenerator {
    public static Pet createPet() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Dog");
        pet.setStatus("available");
        return pet;
    }
}