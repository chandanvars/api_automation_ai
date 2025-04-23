package tests;

import base.BaseTest;
import models.TestDataModel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DataProviderUtil;

import java.time.Duration;
import java.util.Set;

public class DemoQATests extends BaseTest {

    @Test(dataProvider = "validTextBoxData", dataProviderClass = DataProviderUtil.class, description = "Verify TextBox valid input submission")
    public void testTextBoxValidInput(String fullName, String email, String currentAddress, String permanentAddress) {
        driver.get(ConfigReader.getProperty("baseUrl") + "/text-box");
        TextBoxPage textBoxPage = new TextBoxPage(driver, wait);

        textBoxPage.enterFullName(fullName);
        textBoxPage.enterEmail(email);
        textBoxPage.enterCurrentAddress(currentAddress);
        textBoxPage.enterPermanentAddress(permanentAddress);

        Assert.assertTrue(textBoxPage.isSubmitButtonEnabled(), "Submit button should be enabled for valid inputs");

        textBoxPage.clickSubmit();

        String outputName = textBoxPage.getOutputName();
        String outputEmail = textBoxPage.getOutputEmail();

        Assert.assertTrue(outputName.contains(fullName), "Output name should contain the input full name");
        Assert.assertTrue(outputEmail.contains(email), "Output email should contain the input email");
    }

    @Test(dataProvider = "invalidTextBoxData", dataProviderClass = DataProviderUtil.class, description = "Verify TextBox invalid input validation")
    public void testTextBoxInvalidInput(String fullName, String email, String currentAddress, String permanentAddress) {
        driver.get(ConfigReader.getProperty("baseUrl") + "/text-box");
        TextBoxPage textBoxPage = new TextBoxPage(driver, wait);

        textBoxPage.enterFullName(fullName);
        textBoxPage.enterEmail(email);
        textBoxPage.enterCurrentAddress(currentAddress);
        textBoxPage.enterPermanentAddress(permanentAddress);

        boolean isEmailValid = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].checkValidity();", driver.findElement(By.id("userEmail")));
        Assert.assertFalse(isEmailValid, "Email field should be invalid for incorrect email format");
    }

    @Test(description = "Verify Buttons: double click, right click, and dynamic click")
    public void testButtons() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/buttons");
        ButtonsPage buttonsPage = new ButtonsPage(driver, wait);

        buttonsPage.doubleClickButton();
        String doubleClickMessage = buttonsPage.getDoubleClickMessage();
        Assert.assertEquals(doubleClickMessage, "You have done a double click", "Double click message should be correct");

        buttonsPage.rightClickButton();
        String rightClickMessage = buttonsPage.getRightClickMessage();
        Assert.assertEquals(rightClickMessage, "You have done a right click", "Right click message should be correct");

        buttonsPage.dynamicClickButton();
        String dynamicClickMessage = buttonsPage.getDynamicClickMessage();
        Assert.assertEquals(dynamicClickMessage, "You have done a dynamic click", "Dynamic click message should be correct");
    }

    @Test(description = "Verify JavaScript alerts: accept, dismiss, and prompt")
    public void testAlerts() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/alerts");
        AlertsPage alertsPage = new AlertsPage(driver, wait);

        alertsPage.clickAlertButton();
        Alert alert = alertsPage.switchToAlert();
        Assert.assertEquals(alert.getText(), "You clicked a button", "Alert text should be 'You clicked a button'");
        alert.accept();

        alertsPage.clickConfirmButton();
        alert = alertsPage.switchToAlert();
        Assert.assertEquals(alert.getText(), "Do you confirm action?", "Confirm alert text should be 'Do you confirm action?'");
        alert.accept();
        Assert.assertEquals(alertsPage.getConfirmResultText(), "You selected Ok", "Confirm result should be 'You selected Ok'");

        alertsPage.clickConfirmButton();
        alert = alertsPage.switchToAlert();
        alert.dismiss();
        Assert.assertEquals(alertsPage.getConfirmResultText(), "You selected Cancel", "Confirm result should be 'You selected Cancel'");

        alertsPage.clickPromptButton();
        alert = alertsPage.switchToAlert();
        String promptInput = "TestUser";
        alert.sendKeys(promptInput);
        alert.accept();
        Assert.assertTrue(alertsPage.getPromptResultText().contains(promptInput), "Prompt result should contain the entered text");

        alertsPage.clickPromptButton();
        alert = alertsPage.switchToAlert();
        alert.dismiss();
        Assert.assertEquals(alertsPage.getPromptResultText(), "You entered null", "Prompt result should indicate null after dismiss");
    }

    @Test(dataProvider = "sliderValues", dataProviderClass = DataProviderUtil.class, description = "Verify slider widget interaction")
    public void testSliderWidget(int value) {
        driver.get(ConfigReader.getProperty("baseUrl") + "/slider");
        WidgetsPage widgetsPage = new WidgetsPage(driver, wait);

        widgetsPage.moveSliderTo(value);

        String sliderValue = driver.findElement(By.id("sliderValue")).getAttribute("value");
        Assert.assertEquals(Integer.parseInt(sliderValue), value, "Slider value should match the set value");
    }

    @Test(description = "Verify tooltip visibility on hover")
    public void testTooltipVisibility() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/tool-tips");
        WidgetsPage widgetsPage = new WidgetsPage(driver, wait);

        widgetsPage.hoverTooltipButton();
        String tooltipText = widgetsPage.getTooltipText();

        Assert.assertEquals(tooltipText, "You hovered over the Button", "Tooltip text should be visible and correct");
    }

    @Test(description = "Verify window/tab switching")
    public void testWindowSwitching() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/browser-windows");
        SwitchWindowsPage switchWindowsPage = new SwitchWindowsPage(driver);

        String originalWindow = switchWindowsPage.getCurrentWindowHandle();

        switchWindowsPage.clickNewTabButton();
        Set<String> handles = switchWindowsPage.getWindowHandles();
        Assert.assertTrue(handles.size() > 1, "New tab should be opened");

        for (String handle : handles) {
            if (!handle.equals(originalWindow)) {
                switchWindowsPage.switchToWindow(handle);
                Assert.assertTrue(driver.getTitle().length() > 0 || driver.getCurrentUrl().length() > 0, "New tab/window should have content");
                driver.close();
                break;
            }
        }

        switchWindowsPage.switchToWindow(originalWindow);
    }

    @Test(description = "Simulate network delay and verify UI handles it gracefully")
    public void testNetworkDelayHandling() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/text-box");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Assert.fail("Thread was interrupted during simulated network delay");
        }

        TextBoxPage textBoxPage = new TextBoxPage(driver, wait);
        Assert.assertTrue(textBoxPage.isSubmitButtonEnabled(), "Submit button should be enabled after delay");
    }

    @Test(description = "Verify selectable list functionality")
    public void testSelectableList() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/selectable");
        SelectablePage selectablePage = new SelectablePage(driver, wait);

        selectablePage.selectListItem("Cras justo odio");
        Assert.assertTrue(selectablePage.isListItemSelected("Cras justo odio"), "List item should be selected");

        selectablePage.selectListItem("Dapibus ac facilisis in");
        Assert.assertTrue(selectablePage.isListItemSelected("Dapibus ac facilisis in"), "List item should be selected");
    }

    @Test(description = "Verify droppable functionality")
    public void testDroppable() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/droppable");
        DroppablePage droppablePage = new DroppablePage(driver, wait);

        droppablePage.dragAndDrop();
        Assert.assertTrue(droppablePage.isDropped(), "Element should be dropped successfully");
    }

    @Test(description = "Verify dynamic properties functionality")
    public void testDynamicProperties() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/dynamic-properties");
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage(driver, wait);

        Assert.assertTrue(dynamicPropertiesPage.isButtonEnabledAfterDelay(), "Button should be enabled after delay");
        Assert.assertTrue(dynamicPropertiesPage.isButtonColorChanged(), "Button color should change after delay");
    }
}