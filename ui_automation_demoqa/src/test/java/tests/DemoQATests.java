package tests;

import base.BaseTest;
import models.TestDataModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;
import pages.TextBoxPage;
import utils.DataProviderUtil;

public class DemoQATests extends BaseTest {

    @Test(description = "Verify interaction with the text box", dataProvider = "textBoxDataProvider", dataProviderClass = DataProviderUtil.class)
    public void testTextBoxFunctionality(TestDataModel data) {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsCard();

        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.enterFullName(data.getFullName());
        textBoxPage.enterEmail(data.getEmail());
        textBoxPage.enterCurrentAddress(data.getCurrentAddress());
        textBoxPage.enterPermanentAddress(data.getPermanentAddress());
        textBoxPage.clickSubmit();

        Assert.assertTrue(textBoxPage.getOutputText().contains(data.getFullName()));
        Assert.assertTrue(textBoxPage.getOutputText().contains(data.getEmail()));
        Assert.assertTrue(textBoxPage.getOutputText().contains(data.getCurrentAddress()));
        Assert.assertTrue(textBoxPage.getOutputText().contains(data.getPermanentAddress()));
    }

    @Test(description = "Automate JavaScript alerts for accept and dismiss actions")
    public void testAlertsFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsCard();

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.clickAlertButton();

        driver.switchTo().alert().accept();
        // Add assertions as needed
    }
}