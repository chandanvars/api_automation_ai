package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage {
    private WebDriver driver;
    private By fullNameInput = By.id("userName");
    private By emailInput = By.id("userEmail");
    private By currentAddressInput = By.id("currentAddress");
    private By permanentAddressInput = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By outputName = By.id("name");
    private By outputEmail = By.id("email");
    private By outputCurrentAddress = By.xpath("//p[@id='currentAddress']");
    private By outputPermanentAddress = By.xpath("//p[@id='permanentAddress']");
    private By emailError = By.cssSelector("input[id='userEmail'].field-error");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFullName(String name) {
        driver.findElement(fullNameInput).clear();
        driver.findElement(fullNameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterCurrentAddress(String address) {
        driver.findElement(currentAddressInput).clear();
        driver.findElement(currentAddressInput).sendKeys(address);
    }

    public void enterPermanentAddress(String address) {
        driver.findElement(permanentAddressInput).clear();
        driver.findElement(permanentAddressInput).sendKeys(address);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getOutputName() {
        return driver.findElement(outputName).getText();
    }

    public String getOutputEmail() {
        return driver.findElement(outputEmail).getText();
    }

    public String getOutputCurrentAddress() {
        return driver.findElement(outputCurrentAddress).getText();
    }

    public String getOutputPermanentAddress() {
        return driver.findElement(outputPermanentAddress).getText();
    }

    public boolean isEmailErrorDisplayed() {
        return driver.findElements(emailError).size() > 0;
    }
}
