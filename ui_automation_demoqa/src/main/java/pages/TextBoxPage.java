package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage {
    private WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFullName(String fullName) {
        driver.findElement(By.id("userName")).sendKeys(fullName);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    public void enterCurrentAddress(String address) {
        driver.findElement(By.id("currentAddress")).sendKeys(address);
    }

    public void enterPermanentAddress(String address) {
        driver.findElement(By.id("permanentAddress")).sendKeys(address);
    }

    public void clickSubmit() {
        driver.findElement(By.id("submit")).click();
    }

    // Add methods to interact with TextBoxPage elements
}