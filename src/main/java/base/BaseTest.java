package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        // Load base URI from config
        RestAssured.baseURI = ConfigReader.getBaseURI();
    }
}