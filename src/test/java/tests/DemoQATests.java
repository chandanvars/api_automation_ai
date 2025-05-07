package tests;

import base.BaseTest;
import models.TestDataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DataProviderUtil;

public class DemoQATests extends BaseTest {
    // Story: SCRUM-23 - UI Automation for DemoQA

    @Test(description = "[SCRUM-23] Validate TextBox with valid and invalid data", dataProvider = "textBoxData", dataProviderClass = DataProviderUtil.class)
    public void testTextBox(TestDataModel data) {
        HomePage home = new HomePage(driver);
        home.goToElements();
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        TextBoxPage textBox = new TextBoxPage(driver);
        textBox.enterFullName(data.getUsername());
        textBox.enterEmail(data.getEmail());
        textBox.enterCurrentAddress(data.getAddress());
        textBox.enterPermanentAddress(data.getAddress());
        textBox.clickSubmit();
        if (data.getEmail().contains("@")) {
            Assert.assertTrue(textBox.getOutputName().contains(data.getUsername()), "Name output mismatch");
            Assert.assertTrue(textBox.getOutputEmail().contains(data.getEmail()), "Email output mismatch");
        } else {
            Assert.assertTrue(textBox.isEmailErrorDisplayed(), "Email error not displayed for invalid email");
        }
    }

    @Test(description = "[SCRUM-23] Validate Alerts handling")
    public void testAlerts() {
        HomePage home = new HomePage(driver);
        home.goToAlerts();
        driver.findElement(By.xpath("//span[text()='Alerts']")).click();
        AlertsPage alerts = new AlertsPage(driver);
        alerts.clickAlertButton();
        alerts.acceptAlert();
        alerts.clickConfirmButton();
        alerts.dismissAlert();
        Assert.assertTrue(alerts.getConfirmResult().contains("Cancel"), "Confirm result mismatch");
        alerts.clickPromptButton();
        alerts.sendTextToAlert("DemoQA");
        Assert.assertTrue(alerts.getPromptResult().contains("DemoQA"), "Prompt result mismatch");
    }

    @Test(description = "[SCRUM-23] Validate switching between windows and tabs")
    public void testSwitchWindows() {
        HomePage home = new HomePage(driver);
        home.goToAlerts();
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();
        SwitchWindowsPage switchPage = new SwitchWindowsPage(driver);
        String originalHandle = switchPage.getCurrentWindowHandle();
        switchPage.clickNewTab();
        switchPage.switchToNewWindow(originalHandle);
        Assert.assertTrue(driver.getCurrentUrl().contains("demoqa.com"), "New tab did not open correctly");
        driver.close();
        driver.switchTo().window(originalHandle);
    }

    @Test(description = "[SCRUM-23] Validate Widgets - Date Picker, Slider, Tooltip, Progress Bar")
    public void testWidgets() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.goToWidgets();
        driver.findElement(By.xpath("//span[text()='Date Picker']")).click();
        WidgetsPage widgets = new WidgetsPage(driver);
        widgets.setDate("12/12/2024");
        Assert.assertEquals(driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value"), "12/12/2024");
        driver.findElement(By.xpath("//span[text()='Slider']")).click();
        widgets.setSliderValue("50");
        Assert.assertEquals(driver.findElement(By.className("range-slider")).getAttribute("value"), "50");
        driver.findElement(By.xpath("//span[text()='Tool Tips']")).click();
        WebElement toolTipBtn = driver.findElement(By.id("toolTipButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(toolTipBtn).perform();
        Thread.sleep(1000); // Wait for tooltip
        Assert.assertTrue(widgets.getToolTipText().length() > 0, "Tooltip not displayed");
        driver.findElement(By.xpath("//span[text()='Progress Bar']")).click();
        widgets.clickStartStopProgressBar();
        Thread.sleep(2000);
        widgets.clickStartStopProgressBar();
        int progress = Integer.parseInt(widgets.getProgressBarValue());
        Assert.assertTrue(progress > 0, "Progress bar did not start");
    }

    @Test(description = "[SCRUM-23] Validate responsiveness and cross-browser compatibility")
    public void testResponsiveness() {
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 667)); // iPhone X
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isBannerDisplayed(), "Banner not visible on mobile size");
        driver.manage().window().maximize();
    }
}
