package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;
import pages.AlertsPage;
import utils.DataProviderUtil;

public class DemoQATests extends BaseTest {

    @Test(dataProvider = "textBoxData", dataProviderClass = DataProviderUtil.class)
    public void testTextBoxFunctionality(String fullName, String email, String currentAddress, String permanentAddress) {
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.enterFullName(fullName);
        textBoxPage.enterEmail(email);
        textBoxPage.enterCurrentAddress(currentAddress);
        textBoxPage.enterPermanentAddress(permanentAddress);
        textBoxPage.clickSubmit();

        String confirmationText = textBoxPage.getConfirmationText();
        Assert.assertTrue(confirmationText.contains(fullName), "Full Name not found in confirmation");
        Assert.assertTrue(confirmationText.contains(email), "Email not found in confirmation");
        Assert.assertTrue(confirmationText.contains(currentAddress), "Current Address not found in confirmation");
        Assert.assertTrue(confirmationText.contains(permanentAddress), "Permanent Address not found in confirmation");
    }

    @Test
    public void testAlertFunctionality() {
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.triggerAlert();

        String alertText = alertsPage.getAlertText();
        Assert.assertEquals(alertText, "You clicked a button", "Alert text does not match");

        alertsPage.acceptAlert();
    }
}
