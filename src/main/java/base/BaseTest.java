package base;

import config.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }
}
