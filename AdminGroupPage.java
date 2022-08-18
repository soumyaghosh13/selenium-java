package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import com.HRA.helper.ExcelReader;
import com.HRA.helper.ExcelWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

import static com.HRA.pageObjects.ManagERNotificationPage.random;

public class AdminGroupPage {
    WebDriver driver = Driver.getDriver();

    public AdminGroupPage(WebDriver driver) {
        //super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'/group')]")
    WebElement adminGroup;
    @FindBy(xpath = "//a[normalize-space()='Create New']")
    WebElement createNewButton;
    @FindBy(xpath = "//input[@id='GroupName']")
    WebElement groupNameTextArea;
    @FindBy(xpath = "//input[@id='ClientGroupId']")
    WebElement clientGroupIdTextArea;
    @FindBy(xpath = "//textarea[@id='Description']")
    WebElement notesTextArea;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsavegrouplocation jq-btnvalidate']")
    WebElement saveButton;
    @FindBy(xpath = "//select[@id='ParentGroupId']")
    WebElement selectGroupParent;
    @FindBy(xpath = "//input[@id='search-GroupName']")
    WebElement searchGroupTextArea;
    @FindBy(xpath = "//input[@id='btn-search-admingrid']")
    WebElement searchGroupButton;
    @FindBy(xpath = "//a[@class='icon icon--blue grid-delete']")
    WebElement deleteButton;
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deleteConfirmation;
    @FindBy(xpath = "//div[@class='c-form-error-messages lblErrorMsg']")
    WebElement errorMessage;
    @FindBy(xpath = "//a[@class='admingrid-col anchor-link gridlink-groupname']")
    WebElement editGroupLink;
    @FindBy(xpath = "//a[@class='linkExport jq-excelexport-admin']")
    WebElement exportToExelLink;

    public void clickOnGroups() {
        Actions actions = new Actions(driver);
        actions.click(adminGroup).build().perform();
    }

    int randomInt = random.nextInt(99999999);
    static String actual_groupName;
    String groupName = "Auto-Group-" + randomInt;

    public void createGroup() throws InterruptedException, IOException {

        BrowserUtilities.waitForElementToBeClickable(createNewButton);
        createNewButton.click();
        BrowserUtilities.waitForElementToBeClickable(groupNameTextArea);
        groupNameTextArea.sendKeys(groupName);
        BrowserUtilities.waitForElementToBeClickable(clientGroupIdTextArea);
        clientGroupIdTextArea.sendKeys(groupName);
        BrowserUtilities.waitForElementToBeClickable(selectGroupParent);
        Select parentGroup = new Select(selectGroupParent);
        parentGroup.selectByIndex(0);
        BrowserUtilities.waitForElementToBeClickable(notesTextArea);
        notesTextArea.sendKeys(groupName + " - This is a group created during automation");
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        saveButton.click();
        actual_groupName = groupName;
    }

    public void searchGroup() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(searchGroupTextArea);
        searchGroupTextArea.sendKeys(groupName);
        BrowserUtilities.waitForElementToBeClickable(searchGroupButton);
        Thread.sleep(5000);
        searchGroupButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'" + groupName + "')]")).isDisplayed());
    }

    public void deleteGroup() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(deleteButton);
        deleteButton.click();
        BrowserUtilities.waitForElementToBeClickable(deleteConfirmation);
        deleteConfirmation.click();
        BrowserUtilities.waitForElementToBeVisible(errorMessage);
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    public void editGroup() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(editGroupLink);
        editGroupLink.click();
        BrowserUtilities.waitForElementToBeVisible(notesTextArea);
        notesTextArea.clear();
        notesTextArea.sendKeys("This group was edited during Automation - " + groupName);
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        saveButton.click();
    }

    public void exportToExel() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(exportToExelLink);
        Assert.assertTrue(exportToExelLink.isDisplayed());
        exportToExelLink.click();
    }
}
