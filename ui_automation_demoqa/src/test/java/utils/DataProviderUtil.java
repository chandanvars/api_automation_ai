package utils;

import models.TestDataModel;
import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider(name = "textBoxDataProvider")
    public Object[][] textBoxDataProvider() {
        TestDataModel data = new TestDataModel();
        data.setFullName("John Doe");
        data.setEmail("john.doe@example.com");
        data.setCurrentAddress("123 Main St");
        data.setPermanentAddress("456 Elm St");

        return new Object[][]{{data}};
    }
}