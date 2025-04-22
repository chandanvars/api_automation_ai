package utils;

import com.github.javafaker.Faker;
import models.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDataGenerator {
    private static final Faker faker = new Faker();

    public static Pet generatePet() {
        Pet pet = new Pet();
        pet.setId(faker.number().randomNumber());
        pet.setName(faker.animal().name());
        pet.setStatus(generateStatus());
        pet.setCategory(generateCategory());
        pet.setPhotoUrls(generatePhotoUrls());
        pet.setTags(generateTags());
        return pet;
    }

    public static Pet createRandomPet() {
        Pet pet = new Pet();
        pet.setId(faker.number().randomNumber());
        pet.setName(faker.animal().name());
        pet.setStatus(generateStatus());
        pet.setCategory(generateCategory());
        pet.setPhotoUrls(generatePhotoUrls());
        pet.setTags(generateTags());
        return pet;
    }

    private static String generateStatus() {
        // Pet status can be "available", "pending", or "sold"
        List<String> statuses = List.of("available", "pending", "sold");
        return statuses.get(faker.number().numberBetween(0, statuses.size()));
    }

    private static Pet.Category generateCategory() {
        Pet.Category category = new Pet.Category();
        category.setId(faker.number().randomNumber());
        category.setName(faker.animal().name());
        return category;
    }

    private static List<String> generatePhotoUrls() {
        int count = faker.number().numberBetween(1, 4);
        List<String> photoUrls = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            photoUrls.add(faker.internet().url());
        }
        return photoUrls;
    }

    private static List<Pet.Tag> generateTags() {
        int count = faker.number().numberBetween(1, 4);
        List<Pet.Tag> tags = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Pet.Tag tag = new Pet.Tag();
            tag.setId(faker.number().randomNumber());
            tag.setName(faker.lorem().word());
            tags.add(tag);
        }
        return tags;
    }
}