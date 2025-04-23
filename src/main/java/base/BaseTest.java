package base;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger = LogManager.getLogger(BaseTest.class);

    /**
     * Sets up the WebDriver before each test method.
     * Initializes browser driver, configures timeouts, window size, and explicit wait.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        initializeWebDriver();
    }

    /**
     * Tears down the WebDriver after each test method.
     * Takes a screenshot if the test failed.
     *
     * @param result The ITestResult containing test method result info.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        handleTestResult(result);
        closeWebDriver();
    }

    /**
     * Initializes the WebDriver based on the provided browser configuration.
     */
    private void initializeWebDriver() {
        try {
            String browser = ConfigReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (ConfigReader.getBooleanProperty("headless")) {
                        chromeOptions.addArguments("--headless=new");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (ConfigReader.getBooleanProperty("headless")) {
                        firefoxOptions.addArguments("-headless");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            // Maximize browser window
            driver.manage().window().maximize();

            // Set implicit wait timeout
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getIntProperty("implicitWait")));

            // Set page load timeout
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getIntProperty("pageLoadTimeout")));

            // Initialize explicit wait
            wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getIntProperty("explicitWait")));

            logger.info("WebDriver initialized for browser: " + browser);
        } catch (Exception e) {
            logger.error("Error occurred during WebDriver setup: ", e);
            throw e;
        }
    }

    /**
     * Handles the result of a test method and captures a screenshot if the test failed.
     *
     * @param result The ITestResult containing test method result info.
     */
    private void handleTestResult(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                captureScreenshot(result.getMethod().getMethodName());
            }
        } catch (Exception e) {
            logger.error("Error occurred while handling test result: ", e);
        }
    }

    /**
     * Closes the WebDriver instance if it exists.
     */
    private void closeWebDriver() {
        if (driver != null) {
            try {
                driver.quit();
                logger.info("WebDriver closed.");
            } catch (Exception e) {
                logger.error("Error occurred while closing WebDriver: ", e);
            }
        }
    }

    /**
     * Captures a screenshot of the current browser window.
     *
     * @param methodName The name of the test method for which screenshot is taken.
     */
    private void captureScreenshot(String methodName) {
        if (!(driver instanceof TakesScreenshot)) {
            logger.warn("Driver does not support taking screenshots");
            return;
        }

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);

            String screenshotsDir = "screenshots";
            Path screenshotsPath = Paths.get(screenshotsDir);
            if (!Files.exists(screenshotsPath)) {
                Files.createDirectories(screenshotsPath);
            }

            String screenshotName = methodName + "_" + System.currentTimeMillis() + ".png";
            Path destination = screenshotsPath.resolve(screenshotName);
            Files.copy(srcFile.toPath(), destination);

            logger.info("Screenshot saved: " + destination.toAbsolutePath());
        } catch (IOException e) {
            logger.error("Failed to save screenshot: ", e);
        }
    }
}