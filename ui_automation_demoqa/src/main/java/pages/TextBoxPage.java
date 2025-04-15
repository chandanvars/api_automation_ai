package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
    private WebDriver driver;

    @FindBy(id = "userName")
    private WebElement fullNameField;

    @FindBy(id = "userEmail")
    private WebElement emailField;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "output")
    private WebElement outputSection;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFullName(String fullName) {
        fullNameField.sendKeys(fullName);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterCurrentAddress(String currentAddress) {
        currentAddressField.sendKeys(currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress) {
        permanentAddressField.sendKeys(permanentAddress);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public boolean isOutputSectionDisplayed() {
        return outputSection.isDisplayed();
    }
}