package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WidgetsPage {
    private WebDriver driver;
    private By datePickerInput = By.id("datePickerMonthYearInput");
    private By slider = By.className("range-slider");
    private By toolTipButton = By.id("toolTipButton");
    private By toolTipText = By.className("tooltip-inner");
    private By progressBar = By.cssSelector(".progress-bar");
    private By startStopButton = By.id("startStopButton");

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDate(String date) {
        driver.findElement(datePickerInput).clear();
        driver.findElement(datePickerInput).sendKeys(date);
    }

    public void setSliderValue(String value) {
        driver.findElement(slider).sendKeys(value);
    }

    public void hoverToolTipButton() {
        // Use Actions in test to hover
    }

    public String getToolTipText() {
        return driver.findElement(toolTipText).getText();
    }

    public void clickStartStopProgressBar() {
        driver.findElement(startStopButton).click();
    }

    public String getProgressBarValue() {
        return driver.findElement(progressBar).getAttribute("aria-valuenow");
    }
}
