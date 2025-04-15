package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {
    private WebDriver driver;

    @FindBy(css = ".rct-collapse.rct-collapse-btn")
    private WebElement expandAllButton;

    @FindBy(css = ".rct-icon.rct-icon-uncheck")
    private WebElement homeCheckBox;

    @FindBy(css = "#result")
    private WebElement result; 

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void expandAll() {
        expandAllButton.click();
    }

    public void selectHomeCheckBox() {
        homeCheckBox.click();
    }

    public boolean isResultDisplayed() {
        return result.isDisplayed();
    }
}