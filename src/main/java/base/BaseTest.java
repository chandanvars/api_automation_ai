package base;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WebDriverFactory;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;

    @BeforeMethod
    public void setUp() {
        config = new ConfigReader();
        driver = WebDriverFactory.createInstance(config.getBrowser());
        driver.manage().window().maximize();
        driver.get(config.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
