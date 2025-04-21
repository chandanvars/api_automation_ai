package utils;

import java.util.Random;

public class TestDataGenerator {
    private static Random random = new Random();

    public static long generateRandomId() {
        return random.nextLong();
    }

    public static String generateRandomName() {
        return "Pet" + random.nextInt(1000);
    }
}