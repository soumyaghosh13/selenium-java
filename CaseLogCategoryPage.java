package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.HRA.pageObjects.ManagERNotificationPage.random;

public class CaseLogCategoryPage {
    WebDriver driver = Driver.getDriver();

    public CaseLogCategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    int randomInt = random.nextInt(999999999);
    String caseLogName = "Auto-Case-Log-Category-" + randomInt;
    String caseLogNameEdit = "Auto-Edited-Case-Log-Category-" + randomInt;

    @FindBy(xpath = "//a[normalize-space()='ER and INV Fields']")
    WebElement erAndInvFields;
    @FindBy(xpath = "//a[@class='jq-prevent-refresh-analytics-filter'][normalize-space()='Case Log Categories']")
    WebElement caseLofCategories;
    @FindBy(xpath = "//i[@class='fa fa-plus tooltip']")
    WebElement addButton;
    @FindBy(xpath = "//input[@class='required jq-caselog-name']")
    WebElement caseLogNameTextArea;
    @FindBy(xpath = "//textarea[@name='Description']")
    WebElement caseLogDescriptionTextArea;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement saveButton;
    @FindBy(xpath = "//input[@id='search-Name']")
    WebElement searchTextArea;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-caselog-btn-search']")
    WebElement searchButtonForCaseLog;
    @FindBy(xpath = "//td[@class='admingrid-col anchor-iseditlink jq-iseditlink']")
    WebElement searchResult;
    @FindBy(xpath = "//div[@class='main']//div[@class='c-form']//input[2]")
    WebElement deActivateRadioButton;
    @FindBy(xpath = "//i[@class='fa fa-trash tooltip']")
    WebElement deleteButtonForCaseLog;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deleteConfirm;
    @FindBy(xpath = "//label[@class='c-form-error-messages lblErrorMsg']")
    WebElement errorMessage;
    @FindBy(xpath = "//a[@class='c-btn-default jq-reset-btn']")
    WebElement resetButton;
    @FindBy(xpath = "//a[@class='linkExport jq-excelexport-admin']")
    WebElement exportToExel;


    public void clickOnErAndEnvField() {
        Actions act = new Actions(driver);
        act.click(erAndInvFields).build().perform();
    }

    public void clickOnCaseLogCategories() {
        Actions act = new Actions(driver);
        act.click(caseLofCategories).build().perform();
    }

    public void addNewCaseLogCategory() {
        BrowserUtilities.waitForElementToBeClickable(addButton);
        addButton.click();
        BrowserUtilities.waitForElementToBeClickable(caseLogNameTextArea);
        caseLogNameTextArea.sendKeys(caseLogName);
        BrowserUtilities.waitForElementToBeClickable(caseLogDescriptionTextArea);
        caseLogDescriptionTextArea.sendKeys("This is generated during Automation");
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        saveButton.click();
    }

    public void searchCaseLogCategory() {
        BrowserUtilities.waitForElementToBeClickable(searchTextArea);
        searchTextArea.sendKeys(caseLogName);
        BrowserUtilities.waitForElementToBeClickable(searchButtonForCaseLog);
        searchButtonForCaseLog.click();
        BrowserUtilities.waitForElementToBeClickable(searchResult);
        Assert.assertTrue(searchResult.isDisplayed());
        Assert.assertEquals(caseLogName, searchResult.getText());
    }

    public void editCaseLogCategory() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(searchResult);
        searchResult.click();
        BrowserUtilities.waitForElementToBeClickable(caseLogNameTextArea);
        caseLogNameTextArea.click();
        Thread.sleep(1000);
        caseLogNameTextArea.clear();
        caseLogNameTextArea.sendKeys(caseLogNameEdit);
// Enable this secrion for deactivate case log
//        BrowserUtilities.waitForElementToBeClickable(deActivateRadioButton);
//        deActivateRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        saveButton.click();
    }

    public void deleteCaseLogCategory() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(deleteButtonForCaseLog);
        deleteButtonForCaseLog.click();
        BrowserUtilities.waitForElementToBeClickable(deleteConfirm);
        deleteConfirm.click();
    }

    public void resetSearchCaseLogCategory() {
        BrowserUtilities.waitForElementToBeClickable(searchTextArea);
        searchTextArea.sendKeys("Invalid Automation Input");
        BrowserUtilities.waitForElementToBeClickable(searchButtonForCaseLog);
        searchButtonForCaseLog.click();
        BrowserUtilities.waitForElementToBeVisible(errorMessage);
        Assert.assertTrue(errorMessage.isDisplayed());
        BrowserUtilities.waitForElementToBeClickable(resetButton);
        resetButton.click();


    }

    public void searchEditedCaseLogCategory() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(searchTextArea);
        searchTextArea.clear();
        Thread.sleep(2000);
        searchTextArea.sendKeys(caseLogNameEdit);
        BrowserUtilities.waitForElementToBeClickable(searchButtonForCaseLog);
        searchButtonForCaseLog.click();
        BrowserUtilities.waitForElementToBeClickable(searchResult);
        Assert.assertTrue(searchResult.isDisplayed());
        Assert.assertEquals(caseLogNameEdit, searchResult.getText());
        searchResult.click();
    }
}
