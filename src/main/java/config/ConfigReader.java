package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties");
            }
            properties.load(input);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to load configuration", ex);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }
}