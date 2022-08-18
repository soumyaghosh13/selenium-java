package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ManagEREmployeeIssuePage extends BrowserUtilities {
    static WebDriver driver = Driver.getDriver();
   
    public ManagEREmployeeIssuePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static ManagERWorkflowTempPage MWTP = new ManagERWorkflowTempPage(driver);
    
    @FindBy(xpath = "(//*[@class='history-filter-table-cell col-4']/div)[1]")
    public WebElement allActionsDropdown;

    @FindBy(xpath = "//*[@autocompleteid='jq-autocomplete-actionlist']/li")
    public List<WebElement> getAllActionsDropdownElements;

    @FindBy(xpath = "//span[@datacolumn='ActionName']")
    public List<WebElement> actionNameInTheTable;

    //below is for NoTemplateWorkflow
    @FindBy(xpath = "(//div[@class='sidebar jq-wf-list jq-vertical-workflowlist'])[1]")
    public WebElement workflowSidebar;

    @FindBy(xpath = "//span[@datacolumn='Value']")
    public List<WebElement> dataValueColumn;

    @FindBy(xpath = "(//h2[@datacolumn='FullName'])[1]")
    public WebElement employeeName;

    @FindBy(xpath = "(//*[@class='c-modal__heading'])[5]")
    public WebElement issueAndEmployeeNameHeader;

    @FindBy(xpath = "//a[.='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "(//span[@datacolumn='ConcernTypeName'])[2]")
    public WebElement issueNameInOpenCase;

    @FindBy(xpath = "//a[@datacolumn='CasePartyName']")
    public WebElement employeeNameInOpenCase;

    @FindBy(xpath = "(//span[@datacolumn='CaseNumber'])[1]")
    public WebElement caseNumberInDetailPage;

    @FindBy(xpath = "(//span[@class='d-block'])[1]/strong")
    public WebElement dateNearToConcernType;

    @FindBy(xpath = "(//span[@class='d-block'])[1]")
    public WebElement concernTypeInTimeLine;

    @FindBy(xpath = "(//textarea[@class='required jq-focus-target'])[1]")
    public WebElement detailsTextInputArea;

    @FindBy(xpath = "(//a[.='Next'])[2]")
    public WebElement nextButtonForDetails;

    @FindBy(xpath = "(//span[@class='d-block'])[2]")
    public WebElement detailsInTimeLine;

    @FindBy(xpath = "(//div[@uploadmodaltype='policies']/div/a)[1]")
    public WebElement attachDocumentLibrary;

    @FindBy(xpath = "//span[@class='label jq-clientsearch-searchable']/..")
    public List<WebElement> documentsInLibrary;//0 index is empty

    @FindBy(xpath = "//a[.='Attach Document(s)']")
    public WebElement attachDocumentsButton;

    @FindBy(xpath = "(//a[.='Next'])[3]")
    public WebElement nextButtonForAttachMaterials;

    @FindBy(xpath = "//a[@datacolumn='Filename']")
    public List<WebElement> selectedFileNames;

    @FindBy(xpath = "//input[@name='WorkflowActionId']")
    public List<WebElement> workflowActionsList;

    @FindBy(xpath = "(//a[.='Next'])[4]")
    public WebElement nextButtonForSelectAction;

    @FindBy(xpath = "(//span[@class='d-block'])[3]")
    public WebElement actionInTimeLine;

    @FindBy(xpath = "(//label[@class='custom-checkbox'])[1]")
    public WebElement discussLabel;

    @FindBy(xpath = "(//a[.='Close Case'])")
    public WebElement closeCaseButton;

    @FindBy(xpath = "(//span[contains(.,'closed')])")
    public List<WebElement> closedTextInTimeLine;

    @FindBy(xpath = "//span[@datacolumn='Details']")
    public WebElement closedIssuesTimeLineFirstRow;

    @FindBy(xpath = "//span[@datacolumn='CaseNumber']")
    public List<WebElement> caseNumbersInIssueHistroy;

    @FindBy(xpath = "//span[@datacolumn='Details']")
    public List<WebElement> detailsInIssueHistory;

    @FindBy(xpath = "//span[@datacolumn='InitiationDate']")
    public List<WebElement> dateInIssueHistory;

    @FindBy(xpath = "//span[@datacolumn='CaseNumber']/ancestor::li/div[3]//span[@datacolumn]")
    public List<WebElement> concernNameInIssueHistor;

    @FindBy(xpath = "//span[@class='fa fa-print']")
    public List<WebElement> printIconInIssueHistory;

    @FindBy(xpath = "//span[@class='fa fa-eye']")
    public List<WebElement> eyeIconsInIssueHistory;

    @FindBy(xpath = "(//span[@class='checkmark'])/../input")
    public List<WebElement> checkmarkForRelatedIssue;

    @FindBy(xpath = "(//span[@class='checkmark'])/..")
    public List<WebElement> checkmarkForRelatedIssueForAll;

    @FindBy(xpath = "(//span[@class='checkmark'])/../..")
    public List<WebElement> checkmarkForRelatedIssueForSelect;

    @FindBy(xpath = "(//span[@class='checkmark'])/../../../div[4]")
    public List<WebElement> checkmarkRelatedIssuName;

    @FindBy(xpath = "(//a[.='Prepare Letter'])[1]")
    public WebElement prepareLetterButton;

    @FindBy(xpath = "(//a[.='Edit Letter'])[1]")
    public WebElement editLetterButton;

    @FindBy(xpath = "(//a[.='Finish Editing'])[1]")
    public WebElement finishEditingButton;

    @FindBy(xpath = "(//span[@class='d-block'])[4]/../div/div")
    public List<WebElement> relatedIssueListInTimeLine;

    @FindBy(xpath = "(//a[.='Skip this step'])[2]")
    public WebElement skipThisStepButtonForReview;

    @FindBy(xpath = "(//a[.='Send for Review (Optional)'])[2]")
    public WebElement sendForReviewForButton;

    @FindBy(xpath = "//*[normalize-space(text())='No review requested']")
    public WebElement noReviewerRequestedInTimeLine;

    @FindBy(xpath = "(//a[.='Send and Close Issue'])[2]")
    public WebElement sendAndCloseIssueButton;

    @FindBy(xpath = "(//div[.='Success'])")
    public WebElement successTextOnPopUp;

    @FindBy(xpath = "//a[@class='btn btn-primary save jq-modal-ok']")
    public WebElement closePopUpButton;

    @FindBy(xpath = "(//input[@name='AllegationIDs'])/..")
    public List<WebElement> typesOfIssuesInTimeline;

    @FindBy(xpath = "(//a[.='Next'])[1]")
    public WebElement nextButtonForTypesOfIssues;

    @FindBy(xpath = "(//span[@class='d-block'])[1]")
    public WebElement typesOfIssuesInTimelineAfterNext;

    @FindBy(xpath = "(//a[contains(.,'Send for Review')])[2]")
    public WebElement sendForReviewerButton;

    @FindBy(xpath = "//*[@class='fa fa-times close-help-popup jq-helptext-close']")
    public WebElement closeTips;

    @FindBy(xpath = "(//*[contains(text(),'reviewed')])[1]")
    public WebElement reviewedInTimeline;

    @FindBy(xpath = "(//*[contains(text(),'approved')])[1]")
    public WebElement approvedInTimeline;

    @FindBy(xpath = "(//*[contains(text(),'Waiting for Response')])[1]")
    public WebElement waitingForReviewInTimeline;

    @FindBy(xpath = "(//span[contains(.,'closed')])[2]")
    public WebElement closedTextForReviewerInTimeline;

    @FindBy(xpath = "(//a[.='Send for Approval'])[1]")
    public WebElement sendForApprovalButton;

    @FindBy(xpath = "(//span[@datacolumn='ApprovalSentOn'])[1]/..")
    public WebElement sendForApprovalText;

    @FindBy(xpath = "(//div[@class='title jq-mgr-caseflow-panel-title hide'])[6]/../.")
    public WebElement approvedInTimeLine;

    @FindBy(xpath = "(//select[@class='jq-caseflow-hr-users required jq-ddl-autocomplete'])[1]")
    public WebElement dropdownForSendForApproval;

    @FindBy(xpath = "(//li[@class='ui-menu-item'])")
    public List<WebElement> dropdownOptionsForSendForApproval;

    @FindBy(xpath = "(//div[@id='jq-dropdownautocomplete-12']/select[@name='ApproverId'])[1]")
    public WebElement sendForApprovalIndividualDropdown;

    @FindBy(xpath = "(//select[@class='jq-caseflow-hr-users required jq-ddl-autocomplete'])[1]/..")
    public WebElement dropdownContainer;

    @FindBy(xpath = "(//input[@class='jq-search-input-dropdownautocomplete ui-autocomplete-input'])[1]")
    public WebElement dropdownContainerInput;

    @FindBy(xpath = "//div[@class='employees jq-emp-data jq-employeeCardData']/div")
    public List<WebElement> employeeCards;

    @FindBy(xpath = "(//i[@class='fa fa-times close-help-popup jq-helptext-close'])")
    public WebElement closeHelpPopUp;

    @FindBy(xpath = "//a[@class='clean jq-notification']")
    public WebElement notificationBell;

    @FindBy(xpath = "((//div[@class='sidebar'])[1]/div/ul/li/a)[1]")
    public WebElement notificationsTab;


    @FindBy(xpath = "(//tr[@data-testid='actionrows']/td)[2]")
    public static  WebElement expectedActionlimit;
    
    @FindBy(xpath = "(//tr[@data-testid='actionrows']/td)[3]")
    public static WebElement expectedActionperiod;
    
    @FindBy(xpath = "//div[@jq-caseflow-panel-type='Actions']//div[@class='jq-mgr-bind-timeline-text']")
    public static WebElement actionTimeline;
    
    @FindBy(xpath = "(//div[@jq-caseflow-panel-type='Actions']//span)[2]")
    public static WebElement actionLimitEndmessage;
    
    @FindBy(xpath = "//div[@id='resource']//div[@data-testid='resource-title']")
    public static WebElement helpfulResourceTitle;
    
    @FindBy(xpath = "//div[@id='resource']//div[@data-testid='resource-html']")
    public static WebElement helpfulResourceMessageTip;

    public static void verifyactionLimitandTimePeriod() throws Exception
    {
    	String limitValue = MWTP.getAllManagERExcelData("LimitValue");
    	String timePeriodvalue = MWTP.getAllManagERExcelData("TimePeriodValue");
    	Thread.sleep(5000);
    	waitForClickablility(actionTimeline,20).click();
    	String actionLimit = expectedActionlimit.getText();
    	String expectedActionLimit = actionLimit.substring(actionLimit.indexOf("/") + 1).trim();
    	System.out.println(expectedActionLimit);
    	String expectedActionPeriod = expectedActionperiod.getText();
    	System.out.println(expectedActionPeriod);
    	Assert.assertEquals(limitValue, expectedActionLimit);
    	Assert.assertEquals(timePeriodvalue, expectedActionPeriod);
    	Assert.assertTrue(actionLimitEndmessage.getText().trim().contains("history, you may want to take stronger corrective action"));
    }
    
}
