package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By elementsCard = By.xpath("//div[@class='card-body']/h5[text()='Elements']/ancestor::div[@class='card mt-4 top-card']");
    private By alertsFrameWindowsCard = By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']/ancestor::div[@class='card mt-4 top-card']");
    private By widgetsCard = By.xpath("//div[@class='card-body']/h5[text()='Widgets']/ancestor::div[@class='card mt-4 top-card']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElementsCard() {
        driver.findElement(elementsCard).click();
    }

    public void clickAlertsFrameWindowsCard() {
        driver.findElement(alertsFrameWindowsCard).click();
    }

    public void clickWidgetsCard() {
        driver.findElement(widgetsCard).click();
    }
}
