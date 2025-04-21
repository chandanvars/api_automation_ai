package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage {
    private WebDriver driver;

    @FindBy(id = "toolTipButton")
    private WebElement toolTipButton;

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverOverToolTipButton() {
        // Implement hover action using Actions class
    }
}