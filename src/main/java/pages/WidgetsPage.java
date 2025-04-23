package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    /**
     * Moves the slider to the specified value.
     * Assumes slider range is from 0 to 100.
     *
     * @param value target value to move the slider to
     */
    public void moveSliderTo(int value) {
        // Wait for slider to be visible and enabled
        WebElement sliderElement = wait.until(ExpectedConditions.elementToBeClickable(slider));
        int width = sliderElement.getSize().width;

        // Calculate x offset relative to slider center
        int xOffset = (int) (width * (value / 100.0)) - width / 2;

        // Perform click and drag to move the slider
        actions.clickAndHold(sliderElement)
                .moveByOffset(xOffset, 0)
                .release()
                .perform();
    }

    /**
     * Hovers over the tooltip button to reveal the tooltip.
     */
    public void hoverTooltipButton() {
        // Wait until tooltip button is visible
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipButton));
        actions.moveToElement(button).perform();
    }

    /**
     * Retrieves the text from the tooltip.
     *
     * @return tooltip text string
     */
    public String getTooltipText() {
        // Wait until tooltip text is visible
        WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipText));
        return tooltip.getText();
    }
}