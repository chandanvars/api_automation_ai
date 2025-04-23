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

    @DataProvider(name = "validDropdownData")
    public static Object[][] validDropdownData() {
        return new Object[][]{
                {"Option1"},
                {"Option2"},
                {"Option3"}
        };
    }

    @DataProvider(name = "invalidDropdownData")
    public static Object[][] invalidDropdownData() {
        return new Object[][]{
                {""},
                {"InvalidOption"},
                {null}
        };
    }

    @DataProvider(name = "validFormSubmissionData")
    public static Object[][] validFormSubmissionData() {
        return new Object[][]{
                {"John Doe", "john.doe@example.com", "123 Main St", "Male", true},
                {"Jane Smith", "jane.smith@example.com", "789 Tertiary St", "Female", false}
        };
    }

    @DataProvider(name = "invalidFormSubmissionData")
    public static Object[][] invalidFormSubmissionData() {
        return new Object[][]{
                {"", "invalid-email", "", "", false},
                {"123", "no-at-symbol", "", "InvalidGender", true},
                {null, null, null, null, null}
        };
    }

    @DataProvider(name = "validCheckboxData")
    public static Object[][] validCheckboxData() {
        return new Object[][]{
                {"checkbox1", true},
                {"checkbox2", false},
                {"checkbox3", true}
        };
    }

    @DataProvider(name = "invalidCheckboxData")
    public static Object[][] invalidCheckboxData() {
        return new Object[][]{
                {"", false},
                {"nonExistentCheckbox", true},
                {null, null}
        };
    }

    @DataProvider(name = "validRadioButtonData")
    public static Object[][] validRadioButtonData() {
        return new Object[][]{
                {"radio1", true},
                {"radio2", false}
        };
    }

    @DataProvider(name = "invalidRadioButtonData")
    public static Object[][] invalidRadioButtonData() {
        return new Object[][]{
                {"", false},
                {"nonExistentRadioButton", true},
                {null, null}
        };
    }
}