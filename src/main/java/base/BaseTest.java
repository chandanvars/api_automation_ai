package base;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import config.ConfigReader;
import utils.TestUtils;

public class BaseTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
        TestUtils.initialize();
    }
}