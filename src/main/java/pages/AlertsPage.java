package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By alertButton = By.id("alertButton");
    private By timerAlertButton = By.id("timerAlertButton");
    private By confirmButton = By.id("confirmButton");
    private By promptButton = By.id("promtButton");
    private By confirmResult = By.id("confirmResult");
    private By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAlertButton() {
        driver.findElement(alertButton).click();
    }

    public void clickTimerAlertButton() {
        driver.findElement(timerAlertButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void clickPromptButton() {
        driver.findElement(promptButton).click();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void sendTextToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getConfirmResult() {
        return driver.findElement(confirmResult).getText();
    }

    public String getPromptResult() {
        return driver.findElement(promptResult).getText();
    }
}
