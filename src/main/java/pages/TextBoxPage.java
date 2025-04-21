package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    private WebDriver driver;

    private By fullNameField = By.id("userName");
    private By emailField = By.id("userEmail");
    private By currentAddressField = By.id("currentAddress");
    private By permanentAddressField = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By confirmationSection = By.id("output");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFullName(String fullName) {
        driver.findElement(fullNameField).sendKeys(fullName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterCurrentAddress(String address) {
        driver.findElement(currentAddressField).sendKeys(address);
    }

    public void enterPermanentAddress(String address) {
        driver.findElement(permanentAddressField).sendKeys(address);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getConfirmationText() {
        return driver.findElement(confirmationSection).getText();
    }
}
