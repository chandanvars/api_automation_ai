package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import config.ConfigReader;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }
}
