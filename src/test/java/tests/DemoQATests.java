package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import pages.TextBoxPage;
import pages.AlertsPage;
import pages.SwitchWindowsPage;
import pages.WidgetsPage;
import models.TestDataModel;
import utils.DataProviderUtil;

public class DemoQATests extends BaseTest {

    @Test(dataProvider = "textBoxDataProvider", dataProviderClass = DataProviderUtil.class)
    public void testTextBoxFunctionality(TestDataModel data) {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsSection();

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
    public void testAlertFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsSection();

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.clickAlertButton();

        driver.switchTo().alert().accept();
    }

    @Test
    public void testSwitchWindowsFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsSection();

        SwitchWindowsPage switchWindowsPage = new SwitchWindowsPage(driver);
        switchWindowsPage.clickNewWindowButton();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }

    @Test
    public void testWidgetsFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsSection();

        WidgetsPage widgetsPage = new WidgetsPage(driver);
        widgetsPage.hoverOverToolTipButton();

        // Add assertions for tooltip visibility
    }
}