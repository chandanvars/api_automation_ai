package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider(name = "validTextBoxData")
    public static Object[][] validTextBoxData() {
        return new Object[][]{
                {"John Doe", "john.doe@example.com", "123 Main St", "456 Secondary St"}
        };
    }

    @DataProvider(name = "invalidTextBoxData")
    public static Object[][] invalidTextBoxData() {
        return new Object[][]{
                {"", "invalid-email", "", ""},
                {"123", "no-at-symbol", "", ""}
        };
    }

    @DataProvider(name = "sliderValues")
    public static Object[][] sliderValues() {
        return new Object[][]{
                {0}, {50}, {100}
        };
    }

}
