package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By alertButton = By.id("alertButton");
    private By confirmButton = By.id("confirmButton");
    private By promptButton = By.id("promtButton");
    private By confirmResult = By.id("confirmResult");
    private By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * Clicks the alert button to trigger a simple alert.
     */
    public void clickAlertButton() {
        wait.until(ExpectedConditions.elementToBeClickable(alertButton));
        driver.findElement(alertButton).click();
    }

    /**
     * Clicks the confirm button to trigger a confirmation alert.
     */
    public void clickConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        driver.findElement(confirmButton).click();
    }

    /**
     * Clicks the prompt button to trigger a prompt alert.
     */
    public void clickPromptButton() {
        wait.until(ExpectedConditions.elementToBeClickable(promptButton));
        driver.findElement(promptButton).click();
    }

    /**
     * Switches the driver's context to the currently displayed alert.
     * Waits until the alert is present before switching.
     * 
     * @return Alert object representing the alert.
     */
    public Alert switchToAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    /**
     * Retrieves the text displayed as a result of interacting with a confirmation alert.
     * Waits until the result element is visible before getting the text.
     * 
     * @return String text of the confirmation result.
     */
    public String getConfirmResultText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmResult));
        return driver.findElement(confirmResult).getText();
    }

    /**
     * Retrieves the text displayed as a result of interacting with a prompt alert.
     * Waits until the result element is visible before getting the text.
     * 
     * @return String text of the prompt result.
     */
    public String getPromptResultText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(promptResult));
        return driver.findElement(promptResult).getText();
    }
}