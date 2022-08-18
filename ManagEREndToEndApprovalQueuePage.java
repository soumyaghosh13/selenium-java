package com.HRA.pageObjects;


import com.HRA.helper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.HRA.helper.BrowserUtilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

import static com.HRA.pageObjects.ManagERCasePage.Actual_caseNumber;

public class ManagEREndToEndApprovalQueuePage {
    WebDriver driver = Driver.getDriver();

    public ManagEREndToEndApprovalQueuePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    int randomInt = random.nextInt(9999999);

    @FindBy(xpath = "(//input[@name='ApprovalType'])[2]")
    WebElement radioButtonApporavalQueue;
    @FindBy(xpath = "//*[@id='jq-dropdownautocomplete-12']/div[1]")
    WebElement queueDropDown;
    @FindBy(xpath = "(//a[@class='btn btn-primary jq-mgr-caseflow-btn-next jq-btnvalidate'][normalize-space()='Send for Approval'])[1]")
    WebElement sendForApproval;
    @FindBy(xpath = "//li[@class='c-my-queue']//a[@class='case-tab-class']")
    WebElement myQueueTab;
    @FindBy(xpath = "(//div[@id='jq-divqueuetickets']//span[@class='kebab'])[1]")
    WebElement kebabIcon;
    @FindBy(xpath = "(//a[@class='jq-self-assign-queue-case jq-goto-case'][normalize-space()='Assign to me and Go to Case'])[1]")
    WebElement assignToMeGoToCase;
    @FindBy(xpath = "//a[@class='anchor-link linkGreen']")
    WebElement reviewLetter;
    @FindBy(xpath = "//a[@class='btn btn-primary jq-btn-letter-action hdn']")
    WebElement sendApproval;
    @FindBy(xpath = "//span[normalize-space()='HRApprovalQue']")
    WebElement hrApprovalQue;
    @FindBy(xpath = "//a[@class='btn btn-primary save jq-modal-ok']")
    WebElement successPopup;
    @FindBy(xpath = "//*[@id='jq-mgr-caseflow-placeholder']/div[10]/div[1]")
    WebElement letterDelivery;
    @FindBy(xpath = "(//a[@class='btn btn-primary jq-modal-ok'][normalize-space()='OK'])[1]")
    WebElement okPopup;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public void selectApprovalQueue() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(radioButtonApporavalQueue);
        radioButtonApporavalQueue.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", letterDelivery);
        Thread.sleep(2000);
        BrowserUtilities.waitForElementToBeClickable(queueDropDown);
        queueDropDown.click();
        wait.until(ExpectedConditions.elementToBeClickable(hrApprovalQue)).click();
        BrowserUtilities.waitForElementToBeClickable(sendForApproval);
        sendForApproval.click();
        wait.until(ExpectedConditions.elementToBeClickable(successPopup)).click();
    }

    public void assignCase() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(myQueueTab);
        myQueueTab.click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//td[normalize-space()='" + Actual_caseNumber + "']")).isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(kebabIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(assignToMeGoToCase)).click();
        wait.until(ExpectedConditions.elementToBeClickable(reviewLetter)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sendApproval)).click();
        wait.until(ExpectedConditions.elementToBeClickable(okPopup)).click();

    }
}