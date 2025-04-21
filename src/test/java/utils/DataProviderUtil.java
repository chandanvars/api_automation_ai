package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider(name = "textBoxData")
    public static Object[][] textBoxData() {
        return new Object[][] {
            {"John Doe", "john.doe@example.com", "123 Main St", "456 Elm St"},
            {"Jane Smith", "jane.smith@example.com", "789 Maple Ave", "101 Oak St"}
        };
    }

    @DataProvider(name = "invalidEmailData")
    public static Object[][] invalidEmailData() {
        return new Object[][] {
            {"John Doe", "john.doe@.com", "123 Main St", "456 Elm St"},
            {"Jane Smith", "jane.smith@com", "789 Maple Ave", "101 Oak St"}
        };
    }
}
