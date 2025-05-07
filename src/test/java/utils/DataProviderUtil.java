package utils;

import org.testng.annotations.DataProvider;
import models.TestDataModel;

public class DataProviderUtil {
    @DataProvider(name = "textBoxData")
    public static Object[][] textBoxData() {
        return new Object[][] {
            { new TestDataModel("John Doe", "john@example.com", "123 Main St", "password123") },
            { new TestDataModel("", "invalidemail", "", "") },
            { new TestDataModel("Jane Smith", "jane.smith@example.com", "456 Elm St", "pass456") }
        };
    }
}
