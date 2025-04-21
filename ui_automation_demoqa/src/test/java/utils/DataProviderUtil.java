package utils;

import org.testng.annotations.DataProvider;
import models.TestDataModel;

public class DataProviderUtil {
    @DataProvider(name = "textBoxData")
    public Object[][] textBoxDataProvider() {
        return new Object[][] {
            {new TestDataModel("John Doe", "john.doe@example.com", "123 Main St", "456 Elm St")},
            {new TestDataModel("Jane Smith", "jane.smith@example.com", "789 Oak St", "101 Pine St")}
        };
    }
}