package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    // Main cards
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsCard;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsCard;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsCard;

    @FindBy(xpath = "//h5[text()='Widgets']")
    private WebElement widgetsCard;

    @FindBy(xpath = "//h5[text()='Interactions']")
    private WebElement interactionsCard;

    @FindBy(xpath = "//h5[text()='Book Store Application']")
    private WebElement bookStoreApplicationCard;

    // Sub-elements for "Elements"
    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textBoxElement;

    @FindBy(xpath = "//span[text()='Check Box']")
    private WebElement checkBoxElement;

    @FindBy(xpath = "//span[text()='Radio Button']")
    private WebElement radioButtonElement;

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTablesElement;

    @FindBy(xpath = "//span[text()='Buttons']")
    private WebElement buttonsElement;

    @FindBy(xpath = "//span[text()='Links']")
    private WebElement linksElement;

    @FindBy(xpath = "//span[text()='Broken Links - Images']")
    private WebElement brokenLinksElement;

    @FindBy(xpath = "//span[text()='Upload and Download']")
    private WebElement uploadDownloadElement;

    @FindBy(xpath = "//span[text()='Dynamic Properties']")
    private WebElement dynamicPropertiesElement;

    // Sub-elements for "Forms"
    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceFormElement;

    // Sub-elements for "Alerts, Frame & Windows"
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsElement;

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsElement;

    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesElement;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFramesElement;

    @FindBy(xpath = "//span[text()='Modal Dialogs']")
    private WebElement modalDialogsElement;

    // Sub-elements for "Widgets"
    @FindBy(xpath = "//span[text()='Accordian']")
    private WebElement accordianElement;

    @FindBy(xpath = "//span[text()='Auto Complete']")
    private WebElement autoCompleteElement;

    @FindBy(xpath = "//span[text()='Date Picker']")
    private WebElement datePickerElement;

    @FindBy(xpath = "//span[text()='Slider']")
    private WebElement sliderElement;

    @FindBy(xpath = "//span[text()='Progress Bar']")
    private WebElement progressBarElement;

    @FindBy(xpath = "//span[text()='Tabs']")
    private WebElement tabsElement;

    @FindBy(xpath = "//span[text()='Tool Tips']")
    private WebElement toolTipsElement;

    @FindBy(xpath = "//span[text()='Menu']")
    private WebElement menuElement;

    @FindBy(xpath = "//span[text()='Select Menu']")
    private WebElement selectMenuElement;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods for main cards
    public void clickOnElementsCard() {
        elementsCard.click();
    }

    public void clickOnFormsCard() {
        formsCard.click();
    }

    public void clickOnAlertsFrameWindowsCard() {
        alertsFrameWindowsCard.click();
    }

    public void clickOnWidgetsCard() {
        widgetsCard.click();
    }

    public void clickOnInteractionsCard() {
        interactionsCard.click();
    }

    public void clickOnBookStoreApplicationCard() {
        bookStoreApplicationCard.click();
    }

    // Methods for "Elements" sub-elements
    public void clickOnTextBoxElement() {
        textBoxElement.click();
    }

    public void clickOnCheckBoxElement() {
        checkBoxElement.click();
    }

    public void clickOnRadioButtonElement() {
        radioButtonElement.click();
    }

    public void clickOnWebTablesElement() {
        webTablesElement.click();
    }

    public void clickOnButtonsElement() {
        buttonsElement.click();
    }

    public void clickOnLinksElement() {
        linksElement.click();
    }

    public void clickOnBrokenLinksElement() {
        brokenLinksElement.click();
    }

    public void clickOnUploadDownloadElement() {
        uploadDownloadElement.click();
    }

    public void clickOnDynamicPropertiesElement() {
        dynamicPropertiesElement.click();
    }

    // Methods for "Forms" sub-elements
    public void clickOnPracticeFormElement() {
        practiceFormElement.click();
    }

    // Methods for "Alerts, Frame & Windows" sub-elements
    public void clickOnBrowserWindowsElement() {
        browserWindowsElement.click();
    }

    public void clickOnAlertsElement() {
        alertsElement.click();
    }

    public void clickOnFramesElement() {
        framesElement.click();
    }

    public void clickOnNestedFramesElement() {
        nestedFramesElement.click();
    }

    public void clickOnModalDialogsElement() {
        modalDialogsElement.click();
    }

    // Methods for "Widgets" sub-elements
    public void clickOnAccordianElement() {
        accordianElement.click();
    }

    public void clickOnAutoCompleteElement() {
        autoCompleteElement.click();
    }

    public void clickOnDatePickerElement() {
        datePickerElement.click();
    }

    public void clickOnSliderElement() {
        sliderElement.click();
    }

    public void clickOnProgressBarElement() {
        progressBarElement.click();
    }

    public void clickOnTabsElement() {
        tabsElement.click();
    }

    public void clickOnToolTipsElement() {
        toolTipsElement.click();
    }

    public void clickOnMenuElement() {
        menuElement.click();
    }

    public void clickOnSelectMenuElement() {
        selectMenuElement.click();
    }
}