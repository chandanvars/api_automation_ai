package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class DemoQATests extends BaseTest {

    @Test
    public void testTextBoxFunctionality() {
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.enterFullName("John Doe");
        textBoxPage.enterEmail("john.doe@example.com");
        textBoxPage.enterCurrentAddress("123 Main St");
        textBoxPage.enterPermanentAddress("456 Elm St");
        textBoxPage.clickSubmit();
        textBoxPage.verifySubmittedData("John Doe", "john.doe@example.com", "123 Main St", "456 Elm St");
    }

    @Test
    public void testButtonClickFunctionality() {
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.doubleClickButton();
        buttonsPage.verifyDoubleClickMessage();
    }

    // Add more tests for other functionalities
}