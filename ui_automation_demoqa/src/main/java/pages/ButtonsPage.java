package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage {
    private WebDriver driver;
    private Actions actions;

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickButton;

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMessage;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void doubleClickButton() {
        actions.doubleClick(doubleClickButton).perform();
    }

    public String getDoubleClickMessage() {
        return doubleClickMessage.getText();
    }
}