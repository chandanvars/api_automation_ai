package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropertiesPage {
    private WebDriver driver;

    @FindBy(id = "enableAfter")
    private WebElement enableAfterButton;

    @FindBy(id = "colorChange")
    private WebElement colorChangeButton;

    public DynamicPropertiesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isEnableAfterButtonClickable() {
        return enableAfterButton.isEnabled();
    }

    public String getColorChangeButtonColor() {
        return colorChangeButton.getCssValue("color");
    }
}