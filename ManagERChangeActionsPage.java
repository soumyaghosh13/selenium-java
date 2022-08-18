package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ManagERChangeActionsPage {
    WebDriver driver = Driver.getDriver();
    
    public ManagERChangeActionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.=\"Continue\"]")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@value='4554']")
    public WebElement fmla;

    @FindBy(xpath = "//input[@value='17273']")
    public WebElement inappropriateBehavior;

    @FindBy(xpath = "//input[@value='14933']")
    public WebElement newissuemanager1;

    @FindBy(xpath = "//input[@value='11020']")
    public WebElement test1;

    @FindBy(xpath = "//a[@class='btn btn-primary jq-mgr-caseflow-btn-next ml-1rem jq-btnvalidate']")
    public WebElement next;

    //@FindBy(xpath = "//*[@id=\"jq-mgr-caseflow-placeholder\"]/div[3]/div[3]/div[2]/a")
    @FindBy(xpath = "(//*[@class='btn btn-primary jq-mgr-caseflow-btn-next m-right-0_5rem'])[1]")
    public WebElement nextForAttach;

    @FindBy(xpath = "//input[@name='WorkflowActionId']")
    public List<WebElement> workflowActionsList;

    @FindBy(xpath = "//div[@class='task jq-mgr-caseflow-panel jq-validatepanel jq-form jq-mgr-caseflow-panel-accessible wf-color1']//div[@class='title jq-mgr-caseflow-panel-title'][normalize-space()='Select Action']")
    public WebElement selectAction;

    @FindBy(xpath = "//div[@class='task jq-mgr-caseflow-panel jq-validatepanel jq-form jq-mgr-caseflow-panel-accessible wf-color1']//div[@class='title jq-mgr-caseflow-panel-timeline-title']")
    public WebElement backToSelectAction;


    @FindBy(xpath = "//input[@value='12189']")
    public WebElement actionForDirect;

    @FindBy(xpath = "//input[@value='12192']")
    public WebElement actionWithNoApproval;

    @FindBy(xpath = "//input[@value='12193']")
    public WebElement actionWithNoTemplate;

    @FindBy(xpath = "//input[@value='12190']")
    public WebElement actionForSecond;

    @FindBy(xpath = "//input[@value='12191']")
    public WebElement actionForHR;

    @FindBy(xpath = "//input[@value='8080']")
    public WebElement managerAction;

    @FindBy(xpath = "//a[@class='btn btn-primary jq-mgr-caseflow-btn-next ml-1rem jq-btnvalidate jq-btn-action-change']")
    public WebElement nextForAction;


    @FindBy(xpath = "//a[normalize-space()='Change Action']")
    public WebElement changeAction;


    @FindBy(xpath = "//span[contains(text(),'selected the following action: Action')]")
    public WebElement logForActionDirect;

    @FindBy(xpath = "//span[contains(text(),'changed the action to: Action with No')]")
    public WebElement logForActionNoApproval;

    @FindBy(xpath = "//span[contains(text(),'changed the action to: Action with no template')]")
    public WebElement logForActionNoTemplate;

    @FindBy(xpath = "//span[contains(text(),'changed the action to: Action for Second')]")
    public WebElement logForActionForSecond;

    @FindBy(xpath = "//span[contains(text(),'changed the action to: Action for HR')]")
    public WebElement logForActionForHR;

    @FindBy(xpath = "//span[contains(text(),'changed the action to: Manager Action')]")
    public WebElement logForManagerAction;


    @FindBy(xpath = "//a[@class='btn btn-primary jq-mgr-caseflow-btn-next jq-mgr-caseflow-panel-btn-skippable ml-1rem jq-btnvalidate jq-isclosebtn']")
    public WebElement closeCase;

    @FindBy(xpath = "(//div[@class=\"title jq-mgr-caseflow-panel-title jq-review-need hide\"])/../.")
    public WebElement reviewedInTimeline;

    @FindBy(xpath = "//div[@class='task jq-mgr-caseflow-panel-closed jq-validatepanel jq-form jq-mgr-caseflow-panel-accessible wf-color1']//span[@class='d-block']")
    public WebElement logForCloseCase;


    public void clickOnContinue() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(continueButton);
        continueButton.click();
    }

    public void checkAllIssueType() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(fmla);
        fmla.click();
        BrowserUtilities.waitForElementToBeClickable(inappropriateBehavior);
        inappropriateBehavior.click();
        BrowserUtilities.waitForElementToBeClickable(newissuemanager1);
        newissuemanager1.click();
        BrowserUtilities.waitForElementToBeClickable(test1);
        test1.click();
        BrowserUtilities.waitForElementToBeClickable(next);
        next.click();
    }

    public void attachNoDocument() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(nextForAttach);
        Thread.sleep(5000);
        nextForAttach.click();
    }

    public void directAction() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(actionForDirect);
        actionForDirect.click();
        BrowserUtilities.waitForElementToBeClickable(nextForAction);
        nextForAction.click();
        BrowserUtilities.waitForElementToBeVisible(logForActionDirect);
        Assert.assertTrue(logForActionDirect.isDisplayed());
    }

    public void backToSelectAction() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(backToSelectAction);
        backToSelectAction.click();
    }

    public void changeToNoApproval() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(actionWithNoApproval);
        actionWithNoApproval.click();
        BrowserUtilities.waitForElementToBeClickable(nextForAction);
        nextForAction.click();
        BrowserUtilities.waitForElementToBeClickable(changeAction);
        changeAction.click();
        BrowserUtilities.waitForElementToBeVisible(logForActionNoApproval);
        Assert.assertTrue(logForActionNoApproval.isDisplayed());
    }

    public void changeToActionForHR() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(actionForHR);
        actionForHR.click();
        BrowserUtilities.waitForElementToBeClickable(nextForAction);
        nextForAction.click();
        BrowserUtilities.waitForElementToBeClickable(changeAction);
        changeAction.click();
        BrowserUtilities.waitForElementToBeVisible(logForActionForHR);
        Assert.assertTrue(logForActionForHR.isDisplayed());
        System.out.println("Action Selected For HR");
    }

    public void changeToManagerAction() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(managerAction);
        managerAction.click();
        BrowserUtilities.waitForElementToBeClickable(nextForAction);
        nextForAction.click();
        BrowserUtilities.waitForElementToBeClickable(changeAction);
        changeAction.click();
        BrowserUtilities.waitForElementToBeVisible(logForManagerAction);
        Assert.assertTrue(logForManagerAction.isDisplayed());
        System.out.println("Action Selected For Manager");
    }

    public void changeToManagerSecond() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(actionForSecond);
        actionForSecond.click();
        BrowserUtilities.waitForElementToBeClickable(nextForAction);
        nextForAction.click();
        BrowserUtilities.waitForElementToBeClickable(changeAction);
        changeAction.click();
        BrowserUtilities.waitForElementToBeVisible(logForActionForSecond);
        Assert.assertTrue(logForActionForSecond.isDisplayed());
        System.out.println("Action Selected For Manager Second");
    }

    public void changeToActionWithNotemplate() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(actionWithNoTemplate);
        actionWithNoTemplate.click();
        BrowserUtilities.waitForElementToBeClickable(nextForAction);
        nextForAction.click();
        BrowserUtilities.waitForElementToBeClickable(changeAction);
        changeAction.click();
        BrowserUtilities.waitForElementToBeVisible(logForActionNoTemplate);
        Assert.assertTrue(logForActionNoTemplate.isDisplayed());
        System.out.println("Action Selected For Manager");
    }

    public void closeChangeActionCase() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(closeCase);
        closeCase.click();
    }

    public void showWaitingForResponse() throws InterruptedException {
        BrowserUtilities.highlightElement(reviewedInTimeline);
    }

    public void verifyCaseIsClosed() throws InterruptedException {
        BrowserUtilities.waitForElementToBeVisible(logForCloseCase);
        Assert.assertTrue(logForCloseCase.isDisplayed());
    }

}

