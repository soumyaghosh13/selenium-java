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

public class AdminIssueDispositionsPage {
    WebDriver driver = Driver.getDriver();

    public AdminIssueDispositionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    static int randomInt = random.nextInt(999999999);
    static String issueDispositionName = "Auto-Issue-Disposition-" + randomInt;
    String issueDispositionNameEdit = "Auto-Edited-Issue-Disposition-" + randomInt;

    @FindBy(xpath = "//i[@class='fa fa-plus tooltip']")
    WebElement addButton;
    @FindBy(xpath = "//input[@class='required jq-issueDispositions-name']")
    WebElement issueDispositionTextArea;
    @FindBy(xpath = "//textarea[@name='Description']")
    WebElement issueDispositionDescriptionTextArea;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement saveButton;
    @FindBy(xpath = "//a[normalize-space()='Issue Dispositions (INV only)']")
    WebElement issueDispositions;
    @FindBy(xpath = "//input[@id='search-Name']")
    WebElement searchTextArea;
    @FindBy(xpath = "//input[@id='search-result']")
    WebElement searchButton;
    @FindBy(xpath = "//td[@class='admingrid-col anchor-iseditlink jq-iseditlink']")
    WebElement searchResult;
    @FindBy(xpath = "//div[@class='main']//div[@class='c-form']//input[2]")
    WebElement deActivateRadioButton;
    @FindBy(xpath = "//i[@class='fa fa-trash tooltip']")
    WebElement deleteButtonForCaseLog;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deleteConfirm;
    @FindBy(xpath = "//form[@id='issueDispositionsList']//div[@class='c-form-error-messages lblErrorMsg']")
    WebElement errorMessage;
    @FindBy(xpath = "//a[@class='c-btn-default jq-reset']")
    WebElement resetButton;


    public void clickOnCaseLogCategories() {
        Actions actions = new Actions(driver);
        actions.click(issueDispositions).build().perform();
    }

    public void addIssueDispositions() {
        BrowserUtilities.waitForElementToBeClickable(addButton);
        addButton.click();
        BrowserUtilities.waitForElementToBeClickable(issueDispositionTextArea);
        issueDispositionTextArea.sendKeys(issueDispositionName);
        BrowserUtilities.waitForElementToBeClickable(issueDispositionTextArea);
        issueDispositionDescriptionTextArea.sendKeys("This is generated during Automation");
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        saveButton.click();
    }

    public void resetSearchIssueDispositions() {
        BrowserUtilities.waitForElementToBeClickable(searchTextArea);
        searchTextArea.clear();
        searchTextArea.sendKeys("Invalid Automation Input");
        BrowserUtilities.waitForElementToBeClickable(searchButton);
        searchButton.click();
        BrowserUtilities.waitForElementToBeVisible(errorMessage);
        Assert.assertTrue(errorMessage.isDisplayed());
        BrowserUtilities.waitForElementToBeClickable(resetButton);
        resetButton.click();


    }

    public void searchIssueDispositions() {
        BrowserUtilities.waitForElementToBeClickable(searchTextArea);
        searchTextArea.sendKeys(issueDispositionName);
        BrowserUtilities.waitForElementToBeClickable(searchButton);
        searchButton.click();
        BrowserUtilities.waitForElementToBeClickable(searchResult);
        Assert.assertTrue(searchResult.isDisplayed());
        Assert.assertEquals(issueDispositionName, searchResult.getText());
    }

    public void editIssueDispositions() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(searchResult);
        searchResult.click();
        BrowserUtilities.waitForElementToBeClickable(issueDispositionTextArea);
        issueDispositionTextArea.click();
        Thread.sleep(1000);
        issueDispositionTextArea.clear();
        issueDispositionTextArea.sendKeys(issueDispositionNameEdit);

// Enable this secrion for deactivate case log
//        BrowserUtilities.waitForElementToBeClickable(deActivateRadioButton);
//        deActivateRadioButton.click();

        BrowserUtilities.waitForElementToBeClickable(saveButton);
        saveButton.click();


    }

    public void deleteIssueDispositions() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(deleteButtonForCaseLog);
        deleteButtonForCaseLog.click();
        BrowserUtilities.waitForElementToBeClickable(deleteConfirm);
        deleteConfirm.click();
    }

    public void editSearchIssueDispositions() {
        BrowserUtilities.waitForElementToBeClickable(searchTextArea);
        searchTextArea.sendKeys(issueDispositionNameEdit);
        BrowserUtilities.waitForElementToBeClickable(searchButton);
        searchButton.click();
        BrowserUtilities.waitForElementToBeClickable(searchResult);
        Assert.assertTrue(searchResult.isDisplayed());
        Assert.assertEquals(issueDispositionNameEdit, searchResult.getText());
        searchResult.click();
    }
}
