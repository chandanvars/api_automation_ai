package utils;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WebDriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);

    public static WebDriver createDriver() {
        String browser = ConfigReader.getProperty("browser").toLowerCase();
        WebDriver driver;
        switch (browser) {
            case "chrome":
                driver = setupChromeDriver();
                break;
            case "firefox":
                driver = setupFirefoxDriver();
                break;
            default:
                logger.warn("Unsupported browser '{}', falling back to Chrome.", browser);
                driver = setupChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        int implicitWaitSeconds = ConfigReader.getIntProperty("implicitWait", 10);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        return driver;
    }

    private static WebDriver setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (ConfigReader.getBooleanProperty("headless")) {
            chromeOptions.addArguments("--headless=new");
        }
        logger.info("Setting up ChromeDriver with options: {}", chromeOptions.toString());
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver setupFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (ConfigReader.getBooleanProperty("headless")) {
            firefoxOptions.addArguments("-headless");
        }
        logger.info("Setting up FirefoxDriver with options: {}", firefoxOptions.toString());
        return new FirefoxDriver(firefoxOptions);
    }
}