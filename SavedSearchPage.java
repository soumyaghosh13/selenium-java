package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.HRA.pageObjects.ManagERNotificationPage.random;

public class SavedSearchPage {

    WebDriver driver = Driver.getDriver();

    public SavedSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    int randomInt = random.nextInt(999999999);
    public static String actual_searchName;
    public static String expected_searchName;
    public static String expected_searchResult;


    @FindBy(xpath = "//a[text()=\"All Cases\"]")
    private WebElement allCases;

    @FindBy(xpath = "//a[text()=\"Save Search\"]")
    private WebElement saveSearch;

    @FindBy(xpath = "//input[@id=\"txtSearchName\"]")
    private WebElement searchName;

    @FindBy(xpath = "//input[@id=\"jq-btnsavesearch\"]")
    private WebElement saveButton;

    @FindBy(xpath = "//a[text()=\"Saved Searches\"]")
    private WebElement savedSearchTab;

    @FindBy(xpath = "//a[@class=\"c-btn-default jq-save-search-box-toggle\"]")
    private WebElement cancelButton;

    @FindBy(xpath = "//a[@class=\"js-edit-saved-search-link\"]")
    private WebElement editButton;

    @FindBy(xpath = "//input[@class=\"c-form__input jq-txtsavedsearch\"]")
    private WebElement editSearchName;

    @FindBy(xpath = "//input[@class=\"c-btn c-btn--small jq-savedsearch-btnupdate\"]")
    private WebElement editSaveButton;

    @FindBy(xpath = "//a[text()=\"Execute\"]")
    private WebElement executeButton;

    @FindBy(xpath = "//a[@class=\"c-btn-default jq-savedsearch-btndelete\"]")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@id=\"jq-btnconfirmalert\"]")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//span[@class=\"c-cases__savedSearchName\"]")
    private WebElement expectedSearchName;

    @FindBy(xpath = "//span[@class=\"jq-save-search-name\"]")
    private WebElement expectedSearchResult;

    public void clickOnAllCases() {
        allCases.click();
    }

    public void clickOnSaveSearch() {
        saveSearch.click();
    }

    public String enterSearchName() {
        searchName.sendKeys("Auto-Search" + randomInt);
        actual_searchName = searchName.getAttribute("value");
        return actual_searchName;
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void clickOnSavedSearchTab() {
        savedSearchTab.click();
        expected_searchName = expectedSearchName.getText();
        Assert.assertEquals(actual_searchName, expected_searchName);
    }

    public void clickOnEditButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
    }

    public void editSearchName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(editSearchName));
        editSearchName.clear();
        editSearchName.sendKeys("December " + randomInt);

    }

    public void clickOnEditSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(editSaveButton));
        editSaveButton.click();
    }

    public void clickOnExecuteButton() throws InterruptedException {
        executeButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(expectedSearchResult));
        expected_searchResult = expectedSearchResult.getText();
        Assert.assertEquals(actual_searchName, expected_searchResult.substring(expected_searchResult.indexOf("(") + 1, expected_searchResult.indexOf(")")).trim());
        savedSearchTab.click();
        Thread.sleep(3000);
        System.out.println("saved search executed successfully");
    }

    public void clickOnDeleteButton() {
        deleteButton.click();
        confirmDeleteButton.click();
    }
}
