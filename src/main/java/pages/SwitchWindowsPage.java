package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchWindowsPage {
    private WebDriver driver;

    private By newTabButton = By.id("tabButton");
    private By newWindowButton = By.id("windowButton");
    private By newWindowMessageButton = By.id("messageWindowButton");

    public SwitchWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewTabButton() {
        driver.findElement(newTabButton).click();
    }

    public void clickNewWindowButton() {
        driver.findElement(newWindowButton).click();
    }

    public void clickNewWindowMessageButton() {
        driver.findElement(newWindowMessageButton).click();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }
}
