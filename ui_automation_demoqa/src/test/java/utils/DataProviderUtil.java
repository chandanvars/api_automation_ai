package utils;

import org.testng.annotations.DataProvider;
import models.TestDataModel;

public class DataProviderUtil {

    @DataProvider(name = "textBoxDataProvider")
    public Object[][] textBoxDataProvider() {
        return new Object[][] {
            { new TestDataModel("John Doe", "john.doe@example.com", "123 Main St", "456 Elm St") },
            { new TestDataModel("", "invalid-email", "", "") } // Negative test case
        };
    }
}