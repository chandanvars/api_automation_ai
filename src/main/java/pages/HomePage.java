package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By elementsSection = By.xpath("//h5[text()='Elements']/ancestor::div[contains(@class,'card')]"),
            formsSection = By.xpath("//h5[text()='Forms']/ancestor::div[contains(@class,'card')]"),
            alertsSection = By.xpath("//h5[text()='Alerts, Frame & Windows']/ancestor::div[contains(@class,'card')]"),
            widgetsSection = By.xpath("//h5[text()='Widgets']/ancestor::div[contains(@class,'card')]"),
            interactionsSection = By.xpath("//h5[text()='Interactions']/ancestor::div[contains(@class,'card')]"),
            bookStoreSection = By.xpath("//h5[text()='Book Store Application']/ancestor::div[contains(@class,'card')]"),
            banner = By.id("app"),
            mainHeader = By.className("main-header");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToElements() {
        driver.findElement(elementsSection).click();
    }
    public void goToForms() {
        driver.findElement(formsSection).click();
    }
    public void goToAlerts() {
        driver.findElement(alertsSection).click();
    }
    public void goToWidgets() {
        driver.findElement(widgetsSection).click();
    }
    public void goToInteractions() {
        driver.findElement(interactionsSection).click();
    }
    public void goToBookStore() {
        driver.findElement(bookStoreSection).click();
    }
    public boolean isBannerDisplayed() {
        return driver.findElement(banner).isDisplayed();
    }
    public String getMainHeader() {
        return driver.findElement(mainHeader).getText();
    }
}
