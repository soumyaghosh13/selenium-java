package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CommiteeConifurationPage {
    WebDriver driver = Driver.getDriver();

    public CommiteeConifurationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Create New']")
    WebElement addCommiteeButton;
    @FindBy(xpath = "//input[@placeholder='Committee Name']")
    WebElement commiteeNameField;
    @FindBy(xpath = "//div[@class='c-form__fieldSet']//input[@id='Person']")
    WebElement memberNameField;
    @FindBy(xpath = "//div[@class='dm-info-box']//div[@class='c-form']//div[@class='c-form__field']//input[1]")
    WebElement activeStatusRadioButton;
    @FindBy(xpath = "//div[@class='dm-info-box']//input[@value='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']//li[2]")
    WebElement dropDownResult;
    @FindBy(xpath = "//select[@id='MinimumApprovalNeeded']")
    WebElement approvalNumber;
    @FindBy(xpath = "(//span[@class='hraicon hraicon-gear'])[1]")
    WebElement firstGearIcon;
    @FindBy(xpath = "(//a[@class='jq-manage-committee-modal-open'][normalize-space()='Edit'])[1]")
    WebElement editButton;
    @FindBy(xpath = "(//a[@class='jq-remove-committee-modal-open'][normalize-space()='Delete'])[1]")
    WebElement deleteButton;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-delete-committee']")
    WebElement deleteConfirmButton;
    @FindBy(xpath = "//div[contains(text(),'Showing 1 to 10')]")
    WebElement totalNumberOfCommittee;

    public static Random random = new Random();
    public static int randomNumber = random.nextInt(999999999);
    public static String commiteeName = "0Auto-Committee-" + randomNumber;
    public static String commiteeNameEdit = "0Auto-Committee-Edited-" + randomNumber;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    public int getTotalNumberOfCommittee() throws InterruptedException {
        BrowserUtilities.waitForElementToBeVisible(totalNumberOfCommittee);
        String str = totalNumberOfCommittee.getText();
        String numberOnly = str.substring(str.length() - 3);
        int totalNumber = Integer.parseInt(numberOnly);
        return totalNumber;
    }

    public void createCommitee() throws InterruptedException {
        int totalBeforeAdd = getTotalNumberOfCommittee();
        BrowserUtilities.waitForElementToBeClickable(addCommiteeButton);
        addCommiteeButton.click();
        BrowserUtilities.waitForElementToBeClickable(commiteeNameField);
        commiteeNameField.sendKeys(commiteeName);
        BrowserUtilities.waitForElementToBeClickable(memberNameField);
        memberNameField.sendKeys("kapinder vats");
        BrowserUtilities.waitForElementToBeClickable(dropDownResult);
        dropDownResult.click();
        BrowserUtilities.waitForElementToBeClickable(approvalNumber);
        BrowserUtilities.waitForElementToBeClickable(activeStatusRadioButton);
        activeStatusRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        Assert.assertTrue(saveButton.isEnabled());
        saveButton.click();
        int totalAfterAdd = getTotalNumberOfCommittee();
        Assert.assertTrue(totalAfterAdd > totalBeforeAdd);
    }

    public void editCommittee() throws InterruptedException {
        int totalBeforeEdit = getTotalNumberOfCommittee();
        BrowserUtilities.waitForElementToBeClickable(firstGearIcon);
        firstGearIcon.click();
        BrowserUtilities.waitForElementToBeClickable(editButton);
        editButton.click();
        BrowserUtilities.waitForElementToBeClickable(commiteeNameField);
        Thread.sleep(1000);
        commiteeNameField.sendKeys("lorelipsam");
        commiteeNameField.clear();
        commiteeNameField.sendKeys(commiteeNameEdit);
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        saveButton.click();
        int totalAfterEdit = getTotalNumberOfCommittee();
        Assert.assertTrue(totalAfterEdit == totalBeforeEdit);
        System.out.println("Committee Name Edited Successfully to: " + commiteeNameEdit);
    }

    public void deleteCommittee() throws InterruptedException {
        int totalBeforeDelete = getTotalNumberOfCommittee();
        BrowserUtilities.waitForElementToBeClickable(firstGearIcon);
        firstGearIcon.click();
        BrowserUtilities.waitForElementToBeClickable(deleteButton);
        deleteButton.click();
        BrowserUtilities.waitForElementToBeClickable(deleteConfirmButton);
        deleteConfirmButton.click();
        int totalAfterDelete = getTotalNumberOfCommittee();
        Assert.assertTrue(totalAfterDelete < totalBeforeDelete);
        System.out.println("Committee Deleted Successfully");
    }

    public void verifyCommitteeAdded() {
        Assert.assertTrue(driver.findElement(By.xpath("//td[normalize-space()='" + commiteeName + "']")).isDisplayed());
        System.out.println("Committee Added Verified");
    }

    public void verifyCommittee() {
        List<WebElement> dynamicElement = driver.findElements(By.xpath("//td[normalize-space()='" + commiteeNameEdit + "']"));
        if (dynamicElement.size() != 0) {
            //If list size is non-zero, element is present
            System.out.println("Committee Edited Verified");
        } else {
            //Else if size is 0, then element is not present
            System.out.println("Committee Deleted Verified");
        }
    }

}


