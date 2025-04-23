package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider(name = "testData")
    public static Object[][] getData() {
        return new Object[][]{
                {"Test Data 1"},
                {"Test Data 2"}
        };
    }
}