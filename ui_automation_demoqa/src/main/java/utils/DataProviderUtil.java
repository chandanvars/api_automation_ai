package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider(name = "textBoxDataProvider")
    public Object[][] textBoxDataProvider() {
        return new Object[][] {
            {"John Doe", "john.doe@example.com", "123 Main St", "456 Elm St"},
            {"Jane Doe", "jane.doe@example.com", "789 Maple St", "012 Oak St"}
        };
    }
}