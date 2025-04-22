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

    public void clickAlertButton() {
        driver.findElement(alertButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void clickPromptButton() {
        driver.findElement(promptButton).click();
    }

    public Alert switchToAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public String getConfirmResultText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmResult));
        return driver.findElement(confirmResult).getText();
    }

    public String getPromptResultText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(promptResult));
        return driver.findElement(promptResult).getText();
    }
}
