package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider(name = "validTextBoxData")
    public static Object[][] validTextBoxData() {
        return new Object[][]{
                {"John Doe", "john.doe@example.com", "123 Main St", "456 Secondary St"},
                {"Jane Smith", "jane.smith@example.com", "789 Tertiary St", "1011 Quaternary St"}
        };
    }

    @DataProvider(name = "invalidTextBoxData")
    public static Object[][] invalidTextBoxData() {
        return new Object[][]{
                {"", "invalid-email", "", ""},
                {"123", "no-at-symbol", "", ""},
                {"Alice", "alice@.com", "Address", "Another Address"},
                {"Bob", "bob@domain", "Addr1", ""}
        };
    }

    @DataProvider(name = "sliderValues")
    public static Object[][] sliderValues() {
        return new Object[][]{
                {0}, {50}, {100}
        };
    }

    @DataProvider(name = "validButtonClickData")
    public static Object[][] validButtonClickData() {
        return new Object[][]{
                {"submitButton"},
                {"cancelButton"},
                {"resetButton"}
        };
    }

    @DataProvider(name = "invalidButtonClickData")
    public static Object[][] invalidButtonClickData() {
        return new Object[][]{
                {""},
                {"nonExistentButton"},
                {null}
        };
    }

    @DataProvider(name = "validAlertData")
    public static Object[][] validAlertData() {
        return new Object[][]{
                {"Are you sure?", "OK"},
                {"Confirm delete?", "Yes"},
                {"Please accept terms.", "Accept"}
        };
    }

    @DataProvider(name = "invalidAlertData")
    public static Object[][] invalidAlertData() {
        return new Object[][]{
                {"", ""},
                {"Unexpected error", "Dismiss"},
                {null, null}
        };
    }

}