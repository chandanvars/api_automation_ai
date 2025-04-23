package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TextBoxPage;
import utils.DataProviderUtil;

public class DemoQATests extends BaseTest {

    @Test(dataProvider = "textBoxDataProvider", dataProviderClass = DataProviderUtil.class)
    public void testTextBoxFunctionality(TestDataModel testData) {
        driver.get("https://demoqa.com/");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToElementsSection();

        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.fillTextBox(testData);
        textBoxPage.verifyTextBoxSubmission(testData);
    }
}