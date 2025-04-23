package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model for the Text Box page.
 * Provides methods to interact with the form fields and retrieve output.
 */
public class TextBoxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for input fields and buttons
    private By fullNameInput = By.id("userName");
    private By emailInput = By.id("userEmail");
    private By currentAddressInput = By.id("currentAddress");
    private By permanentAddressInput = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By outputName = By.id("name");
    private By outputEmail = By.id("email");
    private By outputCurrentAddress = By.xpath("//p[@id='currentAddress']");
    private By outputPermanentAddress = By.xpath("//p[@id='permanentAddress']");

    /**
     * Constructor to initialize WebDriver and WebDriverWait.
     * 
     * @param driver WebDriver instance
     * @param wait   WebDriverWait instance
     */
    public TextBoxPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * Enters the full name into the full name input field.
     * Clears the field before sending keys to avoid input errors.
     * 
     * @param fullName the full name to enter
     */
    public void enterFullName(String fullName) {
        wait.until(ExpectedConditions.elementToBeClickable(fullNameInput));
        driver.findElement(fullNameInput).clear();
        driver.findElement(fullNameInput).sendKeys(fullName);
    }

    /**
     * Enters the email into the email input field.
     * Clears the field before sending keys.
     * 
     * @param email the email to enter
     */
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    /**
     * Enters the current address into the current address input field.
     * Clears the field before sending keys.
     * 
     * @param currentAddress the current address to enter
     */
    public void enterCurrentAddress(String currentAddress) {
        wait.until(ExpectedConditions.elementToBeClickable(currentAddressInput));
        driver.findElement(currentAddressInput).clear();
        driver.findElement(currentAddressInput).sendKeys(currentAddress);
    }

    /**
     * Enters the permanent address into the permanent address input field.
     * Clears the field before sending keys.
     * 
     * @param permanentAddress the permanent address to enter
     */
    public void enterPermanentAddress(String permanentAddress) {
        wait.until(ExpectedConditions.elementToBeClickable(permanentAddressInput));
        driver.findElement(permanentAddressInput).clear();
        driver.findElement(permanentAddressInput).sendKeys(permanentAddress);
    }

    /**
     * Clicks the submit button to submit the form.
     * Waits until the button is clickable before clicking.
     */
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();
    }

    /**
     * Retrieves the output text for the full name after form submission.
     * Waits until the output element is visible.
     * 
     * @return the output full name text
     */
    public String getOutputName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(outputName));
        return driver.findElement(outputName).getText();
    }

    /**
     * Retrieves the output text for the email after form submission.
     * Waits until the output element is visible.
     * 
     * @return the output email text
     */
    public String getOutputEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(outputEmail));
        return driver.findElement(outputEmail).getText();
    }

    /**
     * Retrieves the output text for the current address after form submission.
     * Waits until the output element is visible.
     * 
     * @return the output current address text
     */
    public String getOutputCurrentAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(outputCurrentAddress));
        return driver.findElement(outputCurrentAddress).getText();
    }

    /**
     * Retrieves the output text for the permanent address after form submission.
     * Waits until the output element is visible.
     * 
     * @return the output permanent address text
     */
    public String getOutputPermanentAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(outputPermanentAddress));
        return driver.findElement(outputPermanentAddress).getText();
    }

    /**
     * Checks if the submit button is enabled.
     * 
     * @return true if enabled, false otherwise
     */
    public boolean isSubmitButtonEnabled() {
        wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
        return driver.findElement(submitButton).isEnabled();
    }
}