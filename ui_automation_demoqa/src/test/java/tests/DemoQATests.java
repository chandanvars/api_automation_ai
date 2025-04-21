package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;
import utils.DataProviderUtil;

public class DemoQATests extends BaseTest {

    @Test(dataProvider = "textBoxData", dataProviderClass = DataProviderUtil.class)
    public void testTextBoxFunctionality(TestDataModel testData) {
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.enterFullName(testData.getFullName());
        textBoxPage.enterEmail(testData.getEmail());
        textBoxPage.enterCurrentAddress(testData.getCurrentAddress());
        textBoxPage.enterPermanentAddress(testData.getPermanentAddress());
        textBoxPage.clickSubmit();

        // Add assertions to verify the entered data
        Assert.assertTrue(true); // Placeholder for actual assertions
    }

    // Add more test methods for other functionalities
}