package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchWindowsPage {
    private WebDriver driver;
    private By newTabButton = By.id("tabButton");
    private By newWindowButton = By.id("windowButton");
    private By newWindowMsgButton = By.id("messageWindowButton");

    public SwitchWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewTab() {
        driver.findElement(newTabButton).click();
    }

    public void clickNewWindow() {
        driver.findElement(newWindowButton).click();
    }

    public void clickNewWindowMsg() {
        driver.findElement(newWindowMsgButton).click();
    }

    public void switchToNewWindow(String originalHandle) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }
}
