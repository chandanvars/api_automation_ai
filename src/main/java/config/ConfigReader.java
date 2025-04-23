package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader is responsible for loading configuration properties from the config.properties file.
 * It provides methods to retrieve property values with appropriate exception handling.
 */
public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        // Load properties from config.properties file during class initialization
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    /**
     * Retrieves the property value as a String for the given key.
     * 
     * @param key the property key
     * @return the property value or null if not found
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Retrieves the property value as an int for the given key.
     * Throws RuntimeException if the value is not a valid integer.
     * 
     * @param key the property key
     * @return the integer property value
     */
    public static int getIntProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found.");
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Property '" + key + "' is not a valid integer.", e);
        }
    }

    /**
     * Retrieves the property value as a boolean for the given key.
     * 
     * @param key the property key
     * @return the boolean property value
     */
    public static boolean getBooleanProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found.");
        }
        return Boolean.parseBoolean(value);
    }

    /**
     * Retrieves the base URL from the properties file.
     * 
     * @return the base URL as a String
     */
    public static String getBaseUrl() {
        String baseUrl = properties.getProperty("base.url");
        if (baseUrl == null || baseUrl.trim().isEmpty()) {
            throw new RuntimeException("Base URL (property 'base.url') is not configured.");
        }
        return baseUrl;
    }

    /**
     * Retrieves the browser type from the properties file.
     * 
     * @return the browser type as a String
     */
    public static String getBrowserType() {
        String browser = properties.getProperty("browser.type");
        if (browser == null || browser.trim().isEmpty()) {
            throw new RuntimeException("Browser type (property 'browser.type') is not configured.");
        }
        return browser;
    }
}