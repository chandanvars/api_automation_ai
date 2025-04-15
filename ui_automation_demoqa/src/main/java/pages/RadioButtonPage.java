package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {
    private WebDriver driver;

    @FindBy(xpath = "//label[@for='yesRadio']")
    private WebElement yesRadioButton;

    @FindBy(className = "text-success")
    private WebElement successMessage;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectYesRadioButton() {
        yesRadioButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}