package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Locator for Elements card on the home page
    private By elementsCard = By.xpath("//div[@class='card-body']/h5[text()='Elements']/ancestor::div[@class='card mt-4 top-card']");
    // Locator for Forms card on the home page
    private By formsCard = By.xpath("//div[@class='card-body']/h5[text()='Forms']/ancestor::div[@class='card mt-4 top-card']");
    // Locator for Alerts, Frame & Windows card on the home page
    private By alertsFrameWindowsCard = By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']/ancestor::div[@class='card mt-4 top-card']");
    // Locator for Widgets card on the home page
    private By widgetsCard = By.xpath("//div[@class='card-body']/h5[text()='Widgets']/ancestor::div[@class='card mt-4 top-card']");
    // Locator for Interactions card on the home page
    private By interactionsCard = By.xpath("//div[@class='card-body']/h5[text()='Interactions']/ancestor::div[@class='card mt-4 top-card']");
    // Locator for Book Store Application card on the home page
    private By bookStoreAppCard = By.xpath("//div[@class='card-body']/h5[text()='Book Store Application']/ancestor::div[@class='card mt-4 top-card']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on the Elements card to navigate to Elements section.
     */
    public void clickElementsCard() {
        driver.findElement(elementsCard).click();
    }

    /**
     * Clicks on the Forms card to navigate to Forms section.
     */
    public void clickFormsCard() {
        driver.findElement(formsCard).click();
    }

    /**
     * Clicks on the Alerts, Frame & Windows card to navigate to Alerts section.
     */
    public void clickAlertsFrameWindowsCard() {
        driver.findElement(alertsFrameWindowsCard).click();
    }

    /**
     * Clicks on the Widgets card to navigate to Widgets section.
     */
    public void clickWidgetsCard() {
        driver.findElement(widgetsCard).click();
    }

    /**
     * Clicks on the Interactions card to navigate to Interactions section.
     */
    public void clickInteractionsCard() {
        driver.findElement(interactionsCard).click();
    }

    /**
     * Clicks on the Book Store Application card to navigate to Book Store section.
     */
    public void clickBookStoreAppCard() {
        driver.findElement(bookStoreAppCard).click();
    }
}