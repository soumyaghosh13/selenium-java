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

public class CaseExpensePage {
    WebDriver driver = Driver.getDriver();

    public CaseExpensePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    int randomInt = random.nextInt(999999999);
    String expenseName = "Auto-Expense-" + randomInt;
    String expenseNameEdit = "Auto-Edited-" + randomInt;

    @FindBy(xpath = "//a[normalize-space()='ER and INV Fields']")
    WebElement erAndInvFields;
    @FindBy(xpath = "//a[normalize-space()='Expense Categories']")
    WebElement expenseCategories;
    @FindBy(xpath = "//i[@class='fa fa-plus tooltip']")
    WebElement addButtonForExpense;
    @FindBy(xpath = "//input[@class='required jq-expense-name']")
    WebElement expenseNameTextArea;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-btnsave-admin']")
    WebElement saveExpenseButton;
    @FindBy(xpath = "//input[@id='search-ExpenseCategoryName']")
    WebElement searchExpenseNameTextArea;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-expense-btn-search']")
    WebElement searchButtonForExpense;
    @FindBy(xpath = "//td[@class='admingrid-col anchor-iseditlink jq-iseditlink']")
    WebElement searchResult;
    @FindBy(xpath = "//div[@class='main']//div[@class='c-form']//input[2]")
    WebElement deActivateRadioButton;
    @FindBy(xpath = "//i[@class='fa fa-trash tooltip']")
    WebElement deleteButtonForExpense;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deleteConfirm;
    @FindBy(xpath = "//label[@class='c-form-error-messages lblErrorMsg']")
    WebElement errorMessage;
    @FindBy(xpath = "//a[@class='c-btn-default jq-reset-btn']")
    WebElement resetButton;
    @FindBy(xpath = "//a[@class='linkExport jq-excelexport-admin']")
    WebElement exportToExel;


    public void clickOnErAndEnvField() {
        Actions actions = new Actions(driver);
        actions.click(erAndInvFields).build().perform();
    }

    public void clickOnExpenseCategories() {
        Actions actions = new Actions(driver);
        actions.click(expenseCategories).build().perform();
    }

    public void addNewExpenseCategory() {
        BrowserUtilities.waitForElementToBeClickable(addButtonForExpense);
        addButtonForExpense.click();
        BrowserUtilities.waitForElementToBeClickable(expenseNameTextArea);
        expenseNameTextArea.sendKeys(expenseName);
        BrowserUtilities.waitForElementToBeClickable(saveExpenseButton);
        saveExpenseButton.click();
    }

    public void searchExpenseCategory() {
        BrowserUtilities.waitForElementToBeClickable(searchExpenseNameTextArea);
        searchExpenseNameTextArea.sendKeys(expenseName);
        BrowserUtilities.waitForElementToBeClickable(searchButtonForExpense);
        searchButtonForExpense.click();
        BrowserUtilities.waitForElementToBeClickable(searchResult);
        Assert.assertTrue(searchResult.isDisplayed());
        Assert.assertEquals(expenseName, searchResult.getText());
    }

    public void editExpenseCategory() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(searchResult);
        searchResult.click();
        BrowserUtilities.waitForElementToBeClickable(expenseNameTextArea);
        expenseNameTextArea.click();
        Thread.sleep(1000);
        expenseNameTextArea.clear();
        expenseNameTextArea.sendKeys(expenseNameEdit);
        BrowserUtilities.waitForElementToBeClickable(deActivateRadioButton);
        deActivateRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(saveExpenseButton);
        saveExpenseButton.click();
    }

    public void deleteExpenseCategory() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(deleteButtonForExpense);
        deleteButtonForExpense.click();
        BrowserUtilities.waitForElementToBeClickable(deleteConfirm);
        deleteConfirm.click();
    }

    public void resetSearchExpenseCategory() {
        BrowserUtilities.waitForElementToBeClickable(searchExpenseNameTextArea);
        searchExpenseNameTextArea.sendKeys("I am BatMan");
        BrowserUtilities.waitForElementToBeClickable(searchButtonForExpense);
        searchButtonForExpense.click();
        BrowserUtilities.waitForElementToBeVisible(errorMessage);
        Assert.assertTrue(errorMessage.isDisplayed());
        BrowserUtilities.waitForElementToBeClickable(resetButton);
        resetButton.click();
    }

    public void exportToExcel() {
        BrowserUtilities.waitForElementToBeClickable(exportToExel);
        Assert.assertTrue(exportToExel.isDisplayed());
        exportToExel.click();
    }
}
