package utils;

import org.testng.annotations.DataProvider;
import models.TestDataModel;

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