package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchWindowsPage {
    private WebDriver driver;

    private By newTabButton = By.id("tabButton");
    private By newWindowButton = By.id("windowButton");
    private By newWindowMessageButton = By.id("messageWindowButton");

    /**
     * Constructor to initialize the WebDriver instance.
     *
     * @param driver WebDriver instance to interact with the browser.
     */
    public SwitchWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks the button that opens a new browser tab.
     */
    public void clickNewTabButton() {
        driver.findElement(newTabButton).click();
    }

    /**
     * Clicks the button that opens a new browser window.
     */
    public void clickNewWindowButton() {
        driver.findElement(newWindowButton).click();
    }

    /**
     * Clicks the button that opens a new message window.
     */
    public void clickNewWindowMessageButton() {
        driver.findElement(newWindowMessageButton).click();
    }

    /**
     * Retrieves all the window handles currently available.
     *
     * @return A set of window handle strings.
     */
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    /**
     * Switches the driver's context to the specified window.
     *
     * @param windowHandle The handle of the window to switch to.
     */
    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    /**
     * Gets the handle of the current window.
     *
     * @return The current window handle as a String.
     */
    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }
}