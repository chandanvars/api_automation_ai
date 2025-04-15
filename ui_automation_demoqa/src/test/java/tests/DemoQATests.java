package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DataProviderUtil;

public class DemoQATests extends BaseTest {

    @Test(dataProvider = "textBoxDataProvider", dataProviderClass = DataProviderUtil.class)
    public void testTextBox(String fullName, String email, String currentAddress, String permanentAddress) {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsCard();
        homePage.clickOnTextBoxElement();
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.enterFullName(fullName);
        textBoxPage.enterEmail(email);
        textBoxPage.enterCurrentAddress(currentAddress);
        textBoxPage.enterPermanentAddress(permanentAddress);
        textBoxPage.clickSubmit();

        Assert.assertTrue(textBoxPage.isOutputSectionDisplayed(), "Output section is not displayed");
    }

    @Test
    public void testButtonClick() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsCard();
        homePage.clickOnButtonsElement();
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.doubleClickButton();

        Assert.assertEquals(buttonsPage.getDoubleClickMessage(), "You have done a double click", "Double click message is incorrect");
    }

    @Test
    public void testCheckBox() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsCard();
        homePage.clickOnCheckBoxElement();
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.expandAll();
        checkBoxPage.selectHomeCheckBox();

        Assert.assertTrue(checkBoxPage.isResultDisplayed(), "Result section is not displayed");
    }

    @Test
    public void testRadioButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsCard();
        homePage.clickOnRadioButtonElement();
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.selectYesRadioButton();

        Assert.assertEquals(radioButtonPage.getSuccessMessage(), "Yes", "Radio button selection message is incorrect");
    }

    @Test
    public void testAlert() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsCard();
        homePage.clickOnAlertsFrameWindowsCard();
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.clickAlertButton();

        String alertText = alertsPage.getAlertText();
        alertsPage.acceptAlert();

        Assert.assertEquals(alertText, "This is a test alert", "Alert text is incorrect");
    }

    @Test
    public void testWebTable() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsCard();
        homePage.clickOnWebTablesElement();
        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.clickAddButton();
        webTablePage.enterFirstName("John");
        webTablePage.enterLastName("Doe");
        webTablePage.enterEmail("john.doe@example.com");
        webTablePage.enterAge("30");
        webTablePage.enterSalary("1000");
        webTablePage.enterDepartment("IT");
        webTablePage.clickSubmitButton();

        Assert.assertTrue(webTablePage.isTableRowDisplayed(), "New table row is not displayed");
    }

    @Test
    public void testDynamicProperties() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnElementsCard();
        homePage.clickOnDynamicPropertiesElement();
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage(driver);
        Thread.sleep(5000); // Wait for 5 seconds for the button to become clickable

        Assert.assertTrue(dynamicPropertiesPage.isEnableAfterButtonClickable(), "Button is not clickable after 5 seconds");
    }
}