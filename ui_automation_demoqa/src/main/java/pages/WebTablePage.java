package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {
    private WebDriver driver;

    @FindBy(id = "addNewRecordButton")
    private WebElement addButton;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "userEmail")
    private WebElement emailField;

    @FindBy(id = "age")
    private WebElement ageField;

    @FindBy(id = "salary")
    private WebElement salaryField;

    @FindBy(id = "department")
    private WebElement departmentField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(css = ".rt-tr-group")
    private WebElement tableRow;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterAge(String age) {
        ageField.sendKeys(age);
    }

    public void enterSalary(String salary) {
        salaryField.sendKeys(salary);
    }

    public void enterDepartment(String department) {
        departmentField.sendKeys(department);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isTableRowDisplayed() {
        return tableRow.isDisplayed();
    }
}