package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DataProviderUtil;

public class DemoQATests extends BaseTest {

    @Test(dataProvider = "textBoxDataProvider", dataProviderClass = DataProviderUtil.class)
    public void testTextBoxFunctionality(TestDataModel data) {
        HomePage homePage = new HomePage(driver);
        homePage.clickElementsSection();

        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.enterFullName(data.getFullName());
        textBoxPage.enterEmail(data.getEmail());
        textBoxPage.enterCurrentAddress(data.getCurrentAddress());
        textBoxPage.enterPermanentAddress(data.getPermanentAddress());
        textBoxPage.clickSubmit();

        String outputText = textBoxPage.getOutputText();
        Assert.assertTrue(outputText.contains(data.getFullName()));
        Assert.assertTrue(outputText.contains(data.getEmail()));
        Assert.assertTrue(outputText.contains(data.getCurrentAddress()));
        Assert.assertTrue(outputText.contains(data.getPermanentAddress()));
    }

    @Test
    public void testButtonClickFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.clickElementsSection();

        // Implement button click test
    }

    @Test
    public void testCheckboxSelection() {
        HomePage homePage = new HomePage(driver);
        homePage.clickElementsSection();

        // Implement checkbox selection test
    }

    @Test
    public void testRadioButtonFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.clickElementsSection();

        // Implement radio button test
    }

    @Test
    public void testAlertsFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.clickElementsSection();

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.clickAlertButton();

        // Handle alert
        driver.switchTo().alert().accept();
    }

    @Test
    public void testWebTableFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.clickElementsSection();

        // Implement web table test
    }

    @Test
    public void testDynamicPropertiesFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.clickElementsSection();

        // Implement dynamic properties test
    }
}