package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By fullNameInput = By.id("userName");
    private By emailInput = By.id("userEmail");
    private By currentAddressInput = By.id("currentAddress");
    private By permanentAddressInput = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By outputName = By.id("name");
    private By outputEmail = By.id("email");

    public TextBoxPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterFullName(String fullName) {
        driver.findElement(fullNameInput).clear();
        driver.findElement(fullNameInput).sendKeys(fullName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterCurrentAddress(String currentAddress) {
        driver.findElement(currentAddressInput).clear();
        driver.findElement(currentAddressInput).sendKeys(currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress) {
        driver.findElement(permanentAddressInput).clear();
        driver.findElement(permanentAddressInput).sendKeys(permanentAddress);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getOutputName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(outputName));
        return driver.findElement(outputName).getText();
    }

    public String getOutputEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(outputEmail));
        return driver.findElement(outputEmail).getText();
    }

    public boolean isSubmitButtonEnabled() {
        return driver.findElement(submitButton).isEnabled();
    }
}
