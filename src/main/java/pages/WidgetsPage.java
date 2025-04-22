package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WidgetsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private By slider = By.cssSelector(".range-slider.range-slider--primary");
    private By tooltipButton = By.id("toolTipButton");
    private By tooltipText = By.cssSelector(".tooltip-inner");

    public WidgetsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.actions = new Actions(driver);
    }

    public void moveSliderTo(int value) {
        // Slider range is 0 to 100
        int width = driver.findElement(slider).getSize().width;
        int xOffset = (int) (width * (value / 100.0));
        actions.clickAndHold(driver.findElement(slider)).moveByOffset(xOffset - width / 2, 0).release().perform();
    }

    public void hoverTooltipButton() {
        actions.moveToElement(driver.findElement(tooltipButton)).perform();
    }

    public String getTooltipText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipText));
        return driver.findElement(tooltipText).getText();
    }
}
