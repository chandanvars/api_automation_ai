package utils;

import models.Pet;

import java.util.Collections;

public class TestDataGenerator {
    public static Pet generatePet(long id, String name, String status) {
        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(name);
        pet.setStatus(status);
        pet.setCategory(new Pet.Category());
        pet.setPhotoUrls(Collections.singletonList("https://example.com/photo.jpg"));
        pet.setTags(Collections.singletonList(new Pet.Tag()));
        return pet;
    }

    public static Pet generatePet() {
        Pet pet = new Pet();
        pet.setId(System.currentTimeMillis());
        pet.setName("Dog");
        pet.setStatus("available");
        pet.setCategory(new Pet.Category());
        pet.setPhotoUrls(Collections.singletonList("https://example.com/photo.jpg"));
        pet.setTags(Collections.singletonList(new Pet.Tag()));
        return pet;
    }
}