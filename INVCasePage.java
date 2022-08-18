package com.HRA.pageObjects;

import static com.HRA.helper.Driver.getDriver;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.HRA.helper.Driver;
import com.HRA.helper.ExcelReadCellData;
import com.HRA.helper.LoggerHelper;
import com.HRA.stepdefinitions.INVProductionStepDef;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.HRA.helper.BrowserUtilities;

public class INVCasePage extends BrowserUtilities {

    WebDriver driver = Driver.getDriver();

    public INVCasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    EndToEndINVToERConversionPage ETEINVTOER = new EndToEndINVToERConversionPage(driver);

    Random random = new Random();
    int randomInt = random.nextInt(9999999);
    String actual_workflowName;
    public static String concernName;
    public static String actual_employeeHistoryCount;
    public static String expected_employeeHistoryCount;
    public static String expected_InterviewLocation;
    public static String actual_EditInterviewLocation;
    public static String expected_EditInterviewLocation;
    public static String actual_CommuincationSpecifics;
    public static String expected_CommuincationSpecifics;
    public static String actual_FollowupInvolvedParty;
    public static String expected_FollowupInvolvedParty;
    public static String actual_CommunicationDocumentName;
    public static String expected_CommunicationDocumentName;
    public static String actual_RecordActionDocumentName;
    public static String expected_RecordActionDocumentName;
    public static String actual_InterviewNotesDocumentName;
    public static String expected_InterviewNotesDocumentName;
    public static String actual_IndividualUserName;
    public static String expected_IndividualUserName;


    public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);

    @FindBy(xpath = "(//span[@name='IssueSubCategoryName'])[1]")
    public WebElement selectSubCatDropdown;

    @FindBy(xpath = "//div[@id='recommendedactions-modal']//label[contains(text(),'Recommended Action')]/..//span[contains(text(),'Select')]")
    private WebElement SelectActionField;

    @FindBy(xpath = "//input[@id='Person']")
    public WebElement selectTextField;

    @FindBy(xpath = "//input[@id='btnSendToDecisionMaker']")
    public WebElement SendButton;

    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']/../a")
    public WebElement mailsentpopup;

    @FindBy(xpath = "//input[@id='rdDmManualAdd']")
    public WebElement manuallyAddDecisionMakerButton;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@class='c-form__input decision-email jq-otherDmManualFields']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='ConfirmEmail']")
    public WebElement confirmEmail;

    @FindBy(xpath = "//input[@name='PersonFullName']")
    public WebElement searchPersonNameField;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate']")
    public WebElement teamMemberSaveButton;

    @FindBy(xpath = "//input[@value='Add to Investigation Team']")
    public WebElement addToInvestigationTeamButton;

    @FindBy(xpath = "//div[@class='c-casesDetail__btnArea']/input[@value='Continue']")
    public static WebElement continueButton;

    @FindBy(xpath = "//div[@class='c-casesDetail__btnArea']//input[@class='c-btn c-btn--small disabled']")
    public WebElement disabledContinueButton;

    @FindBy(xpath = "//span[@class='c-form__input jq-tree-input selectedtext jq-searchinput jq-AutoPopulate'][normalize-space()='-- Select Group --']")
    WebElement groupSelectDropdown;

    @FindBy(xpath = "//span[@class='c-form__input jq-tree-input selectedtext jq-searchinput jq-AutoPopulate'][normalize-space()='-- Select Location --']")
    WebElement locationDropdown;

    @FindBy(xpath = "//strong[contains(text(),'+ Add Recommended Action')]")
    WebElement recommendedactionSelect;

    @FindBy(xpath = "//select[@id='recommendedactions-CasePartiesList']")
    WebElement recommendedactionSelectDropdown;

    @FindBy(xpath = "(//*[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate'])")
    WebElement recommendedActionSaveButton;

    @FindBy(xpath = "//form[@id='ER-Form']//input[@name='Save']")
    public WebElement iNVpopupSaveButton;

    @FindBy(xpath = "//select[@id='investigators-Roles']")
    WebElement selectInvestigator;

    @FindBy(xpath = "//*[@class='c-modal__header jq-addTeamMemberWarning-header']//h4[contains(text(),'Confirm')]")
    public WebElement InvestigatorConfirmPopup;

    @FindBy(xpath = "//h4[contains(text(),'More Information')]/../a")
    WebElement moreInformationPopup;

    @FindBy(xpath = "//div[@id='jq-determine-btnsavepanel']//input[@id='btnOpenDecisionMaker']")
    WebElement sendToDecisionMakerButton;

    @FindBy(xpath = "//input[starts-with(@class,'ml-0 default-populate-fields jq-case-decision-maker-type') and contains(@value,'1')]")
    WebElement sendToOneDecisionMakerButton;

    @FindBy(xpath = "//select[@id='ddlInvestigatorList']")
    WebElement selectOneDecisionMakerButton;

    @FindBy(xpath = "(//*[@id='btnOpenDecisionMaker'])[2]")
    WebElement additionalInformationReminder;

    @FindBy(xpath = "//a[@class='gridlink-historycount anchor-link']")
    WebElement employeeHistoryCount;

    @FindBy(xpath = "//a[@class='c-content__heading heading6 jq-accord-head']")
    WebElement employeeHistoryCountonHistoryPage;

    @FindBy(xpath = "//div[@id='involved-parties']//h4[contains(text(),'Involved Party')]/../a")
    WebElement closeEmployeeHistoryPopup;

    @FindBy(xpath = "//i[@class='fa fa-print']")
    WebElement downloadINVPartyReport;

    @FindBy(xpath = "//*[@class=' jqAutoSavedCheckbox']")
    WebElement openingProtocolCheckbox;

    @FindBy(xpath = "//textarea[@name='OpeningProtocolNotes']")
    WebElement openingProtocolNotes;

    @FindBy(xpath = "//a[contains(text(),'Interview Topics')]")
    WebElement interviewTopicLink;

    @FindBy(xpath = "//*[@class='jq-inter-issuename jq-changesinterviewtopic jq-changedNotDetected']")
    WebElement interviewTopicSubject;

    @FindBy(xpath = "//*[@class='c-issue__topicLink']")
    WebElement interviewTopicArrow;

    @FindBy(xpath = "//*[@id='bootstraphtmleditor10']")
    WebElement interviewTopicQuestion;

    @FindBy(xpath = "//*[@id='bootstraphtmleditor11']")
    WebElement interviewTopicResponse;

    @FindBy(xpath = "//*[@class='c-add-btn jq-add-anotherinterviewque']")
    WebElement addInterviewTopic;

    @FindBy(xpath = "//a[contains(text(),'Closing Protocol ')]")
    WebElement closingProtocolLink;

    @FindBy(xpath = "//a[contains(text(),'Closing Protocol ')]/./../../div[@id='closing-protocol']/div/div/input")
    WebElement closingProtocolCheckbox;

    @FindBy(xpath = "//textarea[@name='ClosingProtocolNotes']")
    WebElement closingProtocolNotes;

    @FindBy(xpath = "//input[@name='IsInterviewComplete']")
    WebElement interviewCompleteCheckbox;

    @FindBy(xpath = "//div[@class='o-grid__item c-casesDetail__infotext jq-interviewee-location']")
    WebElement expectedInterviewLocation;

    @FindBy(xpath = "//table[@id='interviews']//span[@class='kebab']")
    WebElement editInterviewGearIcon;

    @FindBy(xpath = "//*[@class='jq-setaccess gridgear-redirect']")
    WebElement editInterviewLink;

    @FindBy(xpath = "//*[@class='anchor-link jq-inv-interview-edit']")
    WebElement editInterviewInsideInterviewpage;

    @FindBy(xpath = "//input[@name='InterviewLocation']")
    WebElement addInterviewLocation;

    @FindBy(xpath = "//input[@type='button']")
    WebElement saveInterviewLocationButton;

    @FindBy(xpath = "//a[@class='save-button-custom anchor-link']")
    WebElement saveInterviewLink;

    @FindBy(xpath = "//a[@class='save-button-custom redirect-toinv anchor-link']")
    WebElement returnToInvestigationLink;

    @FindBy(xpath = "//table[@id='interviews']/tbody/tr/td[5]")
    WebElement editInterviewLocationOutsideInterviewpage;

    @FindBy(xpath = "//a[@class='linkGreen jq-addnewdetails jq-setaccess']/strong[contains(text(),'+ New Interview')]")
    WebElement newInterviewLink;

    @FindBy(xpath = "//input[@id='InterviewDate']")
    WebElement addInterviewDate;

    @FindBy(xpath = "(//table[@class='ui-datepicker-calendar']/tbody/tr/td/a)[13]")
    WebElement InterviewDatePicker;

    @FindBy(xpath = "//a[@class='js-tab-link jq-interviewnotes']")
    WebElement attachCompleteInterviewNotes;

    @FindBy(xpath = "//div[@id='interviews-modal']//div[contains(text(),'Choose File')]")
    WebElement chooseFileButtonInterview;

    //@FindBy(xpath = "//div[@id='divsavetwo']//input[@class='c-btn c-btn--small jq-btnvalidate']")
//    @FindBy(xpath = "(//div[@class='c-form__fieldBrowse']//div[contains(text(),'Choose File')])[2]")
    @FindBy(xpath = "(//div[@id='divcompletedinterview']//tbody//input)[1]")
    WebElement chooseFileButton;

    @FindBy(xpath = "//input[@id='jq-btnsaveinterviewtwo']")
    WebElement saveInterviewButton;

    @FindBy(xpath = "//a[@class='jq-setaccess gridgear-delete'][contains(text(),'Delete Interview')]")
    WebElement deleteInterviewLink;

    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    WebElement deleteButton;

    @FindBy(xpath = "//a[@class='linkGreen jq-addnewdetails']/strong[contains(text(),'+ Add Communication')]")
    WebElement addCommunicationLink;

    @FindBy(xpath = "//select[@id='communication-CasePartiesList']")
    WebElement selectInvolvedParty;

    @FindBy(xpath = "//select[@id='communication-CommunicationTemplates']")
    WebElement selectCommunicationType;

    @FindBy(xpath = "//input[@id='CaseCommunicationDate']")
    WebElement selectCommuincationDate;

    @FindBy(xpath = "(//table[@class='ui-datepicker-calendar']/tbody/tr/td/a)[13]")
    WebElement CommuincationDatePicker;

    @FindBy(xpath = "//textarea[@name='Specifics']")
    WebElement CommuincationSpecifics;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate']")
    WebElement saveCommunicationButton;

    @FindBy(xpath = "//a[@class='linkGreen jq-addnewdetails']/strong[contains(text(),'+ Schedule Follow Up')]")
    WebElement scheduleFollowupLink;

    @FindBy(xpath = "//select[@id='followups-CasePartiesList']")
    WebElement selectFollowupINVParty;

    @FindBy(xpath = "//select[@id='followups-AssignmentList']")
    WebElement selectAssignment;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate']")
    WebElement saveFollowupButton;

    @FindBy(xpath = "//table[@id='communication']//span[@class='kebab']")
    WebElement editCommunicationGearIcon;

    @FindBy(xpath = "//a[@class='jq-setaccess gridgear-edit'] [contains(text(),'Edit Communication')]")
    WebElement editCommunicationLink;

    @FindBy(xpath = "//td[@id='Specifics']")
    WebElement expectedCommunicationSpecifics;

    @FindBy(xpath = "//a[@class='jq-setaccess gridgear-delete'] [contains(text(),'Delete Communication')]")
    WebElement deleteCommunicationLink;

    @FindBy(xpath = "//table[@id='followups']//span[@class='kebab']")
    WebElement editFollowupGearIcon;

    @FindBy(xpath = "//a[@class='jq-setaccess gridgear-edit'] [contains(text(),'Edit Follow Up')]")
    WebElement editFollowupLink;

    @FindBy(xpath = "//a[@class='jq-setaccess gridgear-delete'] [contains(text(),'Delete Follow Up')]")
    WebElement deleteFollowupLink;

    @FindBy(xpath = "//select[@id='followups-CasePartiesList']/option[2]")
    WebElement FollowupINVParty;

    @FindBy(xpath = "//h6[contains(text(),'Follow Up')]/../..//td[3]")
    WebElement expectedFollowupINVParty;

    @FindBy(xpath = "//table[@id='finalactions']//span[@class='kebab']")
    WebElement FinalActionGearIcon;

    @FindBy(xpath = "//a[@class='jq-setaccess gridgear-addcommunication']")
    WebElement addCommunicationFinalActionLink;

    @FindBy(xpath = "//a[@class='jq-setaccess gridgear-schedulefollow-up']")
    WebElement scheduleFollowupFinalActionLink;

    @FindBy(xpath = "//table[@id='finalactions']//a[@class='jq-setaccess gridgear-edit']")
    WebElement recordActionTakenLink;

    @FindBy(xpath = "//input[@id='finalactiondate']")
    WebElement recordFinalActionDate;

    @FindBy(xpath = "//div[@id='finalactions-modal']//input[@id='chkRestricted']")
    WebElement documentRestrictedCheckbox;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate']")
    WebElement saveFinalActionButton;

    @FindBy(xpath = "//input[@id='EstimateDate']")
    WebElement scheduleFollowupDate;

    @FindBy(xpath = "//div[@id='communication-modal']//div[contains(text(),'Choose File')]")
    WebElement chooseFileButtonCommunication;

    @FindBy(xpath = "//div[@id='finalactions-modal']//div[contains(text(),'Choose File')]")
    WebElement chooseFileButtonFinalAction;

    @FindBy(xpath = "//div[@id='communication-modal']//table[@class='tblfiles']//td")
    WebElement actualCommunicationDocumentName;

    @FindBy(xpath = "//table[@id='communication']/tbody//td[@id='FileName']/a")
    WebElement expectedCommunicationDocumentName;

    @FindBy(xpath = "//div[@id='communication-modal']//table[@class='tblfiles']//td/span[@title='Delete']")
    WebElement actualCommunicationDocumentDeleteIcon;

    @FindBy(xpath = "//div[@id='finalactions-modal']//table[@class='tblfiles']//td/span[@title='Delete']")
    WebElement actualRecordActionDocumentDeleteIcon;

    @FindBy(xpath = "//div[@id='finalactions-modal']//table[@class='tblfiles']//td")
    WebElement actualRecordActionDocumentName;

    @FindBy(xpath = "//table[@id='finalactions']/tbody//td[@id='FileName']/a")
    WebElement expectedRecordActionDocumentName;

    @FindBy(xpath = "//div[@id='interviews-modal']//table[@class='tblfiles']//td/span[@title='Delete']")
    WebElement actualInterviewNotesDeleteIcon;

    @FindBy(xpath = "//div[@class='dm-btn']//input[@name='IsCommittee']")
    WebElement committeRadioButton;

    @FindBy(xpath = "//input[@id='isDecisionMakerApprovalOrderEnabled']")
    WebElement approvalOrderCheckbox;

    @FindBy(xpath = "//div[@class='c-form__field']//input[@name='IsCommittee']")
    WebElement individualRadioButton;

    @FindBy(xpath = "//div[@id='dmAutoCompleteIndividualBox']//input[@placeholder='Name']")
    WebElement enterIndiviualUserName;

    @FindBy(xpath = "//*[@class='custom-autocomplete-style ui-menu-item-wrapper']//tr//td")
    WebElement clickInividualUserName;

    @FindBy(xpath = "//*[@id='dmAutoCompleteResponseBox']//tr//td")
    WebElement actualIndividualUserName;

    @FindBy(xpath = "//div[@id='caseDetermineListBox']//table[@class='c-content__table']//td")
    WebElement expectedIndividualUserName;

    @FindBy(xpath = "//div[@id='caseDetermineListBox']//table[@class='c-content__table']//td//a")
    WebElement reviewApprovalGearIcon;

    @FindBy(xpath = "//form[@id='ER-Form']//span[@class='ddl-ac-text']")
    WebElement notificationSelectDropdown;

    @FindBy(xpath = "//*[@class='c-tab-dashboard c-dashboard__caseType']//a[@data-tab='leagal-review-requests']")
    static WebElement legalreviewtab;

    @FindBy(xpath = "//table[@class='c-table tdbreak']//tr[@class='c-table__evenRow']/td//a")
    static List<WebElement> legalreviewcase;

    @FindBy(xpath = "//table[@class='c-table tdbreak']//tr[@class='c-table__evenRow']/td/input")
    static List<WebElement> legalreviewcasecount;

    @FindBy(xpath = "//div[@id='modal-confirm-alert']//a[@id='jq-modalhref-target']")
    static WebElement attorneyclientprivilegepopup;

    @FindBy(xpath = "//*[@data-tab='determine']")
    static WebElement determinetab;

    @FindBy(xpath = "//div[@class='c-content__block jq-invcase-legalreview']//input")
    static WebElement legalreviewcompletecheckbox;

    @FindBy(xpath = "//input[@id='btnLegalAdvisorSave']")
    static WebElement legalcasesavebutton;

    @FindBy(xpath = "//div[@id='modal-confirm-alert']//a[@id='jq-modalhref-target']")
    static WebElement legalsuccesssentpopup;

    @FindBy(xpath = "//div[@id='custom-selection']/span[contains(text(),'Legal Review Complete')]")
    static WebElement casetstatuslegalreviewcomplete;

    @FindBy(xpath = "//h4[@class='c-casesDetail__infoHeading heading4 jq-master-casename']")
    static WebElement expectedlegalcaseName;

    @FindBy(xpath = "//div[@class='c-pagination jq-DashboardPaging']//div[@class='c-pagination__text']")
    static WebElement pageEndCountLegalReview;

    @FindBy(xpath = "//div[@class='grid-loader-small']")
    static WebElement pagegridLoader;

    @FindBy(xpath = "//div[@id='recommendedactions-modal']//label[contains(text(),'Recommended Action')]/..//input[@placeholder='Search']")
    static WebElement recommendedactionDropdownSearchBox;

    @FindBy(xpath = "//a[@class='linkGreen jq-btnvalidate jq-addanother jq-add-new-details jq-popup-link']//strong")
    public static WebElement addInvolvedPartyDropdown;

    @FindBy(xpath = "//a[contains(text(),'Subject') and starts-with(@class,'jq-addnewdetails jq-btnsaveanother-ddl')]")
    public static WebElement subjectInAddInvolvedPartyDropdown;

    @FindBy(xpath = "//div[@id='jq-dropdownautocomplete-5']")
    WebElement subjectDropdown;

    @FindBy(xpath = "//div[@id='jq-dropdownautocomplete-5']//input[@placeholder='Search']")
    WebElement subjectDropdownSearchBox;

    @FindBy(xpath = "(//span[contains(text(),'Paramita')])[8]")
    WebElement subjectDropdownSearchResault;

    @FindBy(xpath = "//div[@id='divInvolvedPartyDispList_01']/select")
    WebElement selectSubjectDropdown;

    @FindBy(xpath = "//div[@id='divInvolvedPartyDispList_01']/select")
    WebElement selectIssueDispositionDropdown;

    @FindBy(xpath = "//div[@id='divIssueDispList_1']/select")
    WebElement selectOverallIssueDispositionDropdown;

    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\WriteExcel.xlsx";

    public String getAllExcelData(String arg) throws Exception {
        ExcelReadCellData excelData = new ExcelReadCellData(filePath);
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("sheet");
        XSSFRow row = sheet.getRow(0);
        int colNum = row.getLastCellNum();
        int rowNum = sheet.getLastRowNum()+1;
        String cellData = excelData.getCellData("sheet",arg, rowNum);
        return cellData;
    }

    public void selectDynamicNotificationMethod() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        isSaveButtonDisabled();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ddl-ac-text'][normalize-space()= '" + ManagERNotificationPage.actual_notificationName + "']")));
        } catch (Exception e) {
            //notificationSelectDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + ManagERNotificationPage.actual_notificationName + "')]"))).click();
        }
        //Thread.sleep(3000);

    }

    public void selectDynamicGroup() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        isSaveButtonDisabled();
        groupSelectDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + AdminGroupPage.actual_groupName + "')]"))).click();
        Thread.sleep(3000);
    }

    public void selectDynamicLocation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Mandatory Check
        isSaveButtonDisabled();
        locationDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + LocationAdminRedesignPage.actual_parentLocationName + "')]"))).click();
        Thread.sleep(3000);
    }

    public void SelectIssueMethod() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        selectSubCatDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + IssueCategoryAdminPage.actual_categoryName + "'" + "])/../div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + IssueCategoryAdminPage.actual_childCategoryName + "'" + "])"))).click();
    }

    public void SelectActionsMethod() throws Exception {
        String actionName = ETEINVTOER.getAllExcelData("Action");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,750)");
        Thread.sleep(3000);
        recommendedactionSelect.click();
        TimeUnit.SECONDS.sleep(2);
        recommendedactionSelectDropdown.sendKeys(Keys.ARROW_DOWN);
        recommendedactionSelectDropdown.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        SelectActionField.click();
        recommendedactionDropdownSearchBox.click();
        Thread.sleep(2000);
        recommendedactionDropdownSearchBox.sendKeys(actionName);
        Thread.sleep(2000);
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[.=" + "'" + ActionNewAdminRedesignPage.actual_actionName + "'" + "])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[.=" + "'" + actionName + "'" + "])[1]"))).click();
        recommendedActionSaveButton.click();
        Thread.sleep(3000);
        try {
            WebElement closepopup = driver.findElement(By.xpath("//h4[contains(text(),'More Information')]"));
            wait.until(ExpectedConditions.visibilityOf(closepopup));
            if (closepopup.isDisplayed()) {
                driver.findElement(By.xpath("//h4[contains(text(),'More Information')]/../a")).click();
            }
        } catch (Exception e) {

        }
        Thread.sleep(3000);

    }

    public void sendtoOneDecisionMaker() throws Throwable {
        sendToDecisionMakerButton.click();
        try {
            additionalInformationReminder.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean sendToOneDecisionMaker;
        sendToOneDecisionMaker = sendToOneDecisionMakerButton.isSelected();
        if (sendToOneDecisionMaker) {
            System.out.println("Send to One Decision Maker is already Selected");
        } else {
            sendToOneDecisionMakerButton.click();
            System.out.println("Radio Button is now selected");
        }
        Select objSelect = new Select(selectOneDecisionMakerButton);
        objSelect.selectByVisibleText("Other");
        selectTextField.click();
        selectTextField.sendKeys("Deepak Chander");
        Thread.sleep(3000);
        selectTextField.sendKeys(Keys.ARROW_DOWN);
        selectTextField.sendKeys(Keys.ENTER);
        SendButton.click();
        mailsentpopup.click();
        sendToDecisionMakerButton.click();
        try {
            additionalInformationReminder.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sendToOneDecisionMaker) {
            System.out.println("Send to One Decision Maker is already Selected");
        } else {
            sendToOneDecisionMakerButton.click();
            System.out.println("Radio Button is now selected");
        }
        objSelect.selectByVisibleText("Other");
        manuallyAddDecisionMakerButton.click();
        Thread.sleep(2000);
        firstName.sendKeys("Deepak");
        lastName.sendKeys("Chander");
        email.sendKeys("deepak@mindrops.com");
        confirmEmail.sendKeys("deepak@mindrops.com");
        SendButton.click();
        mailsentpopup.click();
    }

    public void selectTeamInvestigator() {
        Select role = new Select(selectInvestigator);
        role.selectByVisibleText("Team Investigator");
    }

    public void addTeamInvestigatorName() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchPersonNameField.click();
        searchPersonNameField.sendKeys("Mohit");
        TimeUnit.SECONDS.sleep(2);
        searchPersonNameField.sendKeys(Keys.ARROW_DOWN);
        searchPersonNameField.sendKeys(Keys.ENTER);
        searchPersonNameField.sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//td[contains(text(),'Mohit Godiyal')]")).click();
        teamMemberSaveButton.click();
        try {
            wait.until(ExpectedConditions.visibilityOf(InvestigatorConfirmPopup));
            if (InvestigatorConfirmPopup.isDisplayed()) {
                addToInvestigationTeamButton.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(4000);
    }

    public void selectAdvisor() {
        Select role = new Select(selectInvestigator);
        role.selectByVisibleText("Advisor");
    }

    public void addAdvisorName() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchPersonNameField.click();
        searchPersonNameField.sendKeys("Vahap");
        TimeUnit.SECONDS.sleep(2);
        searchPersonNameField.sendKeys(Keys.ARROW_DOWN);
        searchPersonNameField.sendKeys(Keys.ENTER);
        searchPersonNameField.sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//td[contains(text(),'Chelsa Moncy')]")).click();
        teamMemberSaveButton.click();
        try {
            wait.until(ExpectedConditions.visibilityOf(InvestigatorConfirmPopup));
            if (InvestigatorConfirmPopup.isDisplayed()) {
                addToInvestigationTeamButton.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(4000);
    }

    public void selectOtherResource() {
        Select role = new Select(selectInvestigator);
        role.selectByVisibleText("Other Resource");
    }

    public void addOtherResourceName() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchPersonNameField.click();
        searchPersonNameField.sendKeys("Indu");
        TimeUnit.SECONDS.sleep(2);
        searchPersonNameField.sendKeys(Keys.ARROW_DOWN);
        searchPersonNameField.sendKeys(Keys.ENTER);
        searchPersonNameField.sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//td[contains(text(),'Indu Mittal')]")).click();
        teamMemberSaveButton.click();
        try {
            wait.until(ExpectedConditions.visibilityOf(InvestigatorConfirmPopup));
            if (InvestigatorConfirmPopup.isDisplayed()) {
                addToInvestigationTeamButton.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(4000);
    }

    public void loginintakeOnly() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginPage.properties";
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(path);
        prop.load(input);
        String url = prop.getProperty("url");
        String userName = prop.getProperty("IntakeuserName");
        String password = prop.getProperty("Intakepassword");
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.email().clear();
        loginPage.email().sendKeys(userName);
        loginPage.password().clear();
        loginPage.password().sendKeys(password);
        loginPage.login().click();
        loginPage.iAgree().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    public void verifyContinueButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)");
        boolean mandate1;
        mandate1 = disabledContinueButton.isDisplayed();
        if (mandate1) {
            Assert.assertTrue(mandate1);
            System.out.println("Continue Button is disabled after filling the case details");
        } else {
            System.out.println("Continue Button is not disabled after filling the case details");
        }
    }

    public static void isContinueButtonDisabled() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,750)");
        boolean continueButtonIsDisabled;
        continueButtonIsDisabled = INVCasePage.continueButton.isDisplayed();
        Assert.assertTrue(continueButtonIsDisabled);
    }

    public void employeeHistoryCountValidation() {
        actual_employeeHistoryCount = employeeHistoryCount.getText();
        employeeHistoryCount.click();
        String text = employeeHistoryCountonHistoryPage.getText();
        expected_employeeHistoryCount = text.substring(text.indexOf("(") + 1, text.indexOf(")")).split("Cases")[0].trim();
        Assert.assertEquals(actual_employeeHistoryCount, expected_employeeHistoryCount);
        downloadINVPartyReport.click();
        waitForClickablility(closeEmployeeHistoryPopup, 20).click();
    }

    public void conductInterview() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String text = expectedInterviewLocation.getText();
        expected_InterviewLocation = text.substring(text.indexOf(":") + 1).trim();
        assertEquals(INVProductionStepDef.actual_InterviewLocation, expected_InterviewLocation);
        openingProtocolCheckbox.click();
        openingProtocolNotes.click();
        openingProtocolNotes.sendKeys("Opening protocols are selected");
        Thread.sleep(3000);
        interviewTopicLink.click();
        addInterviewTopic.click();
        interviewTopicSubject.sendKeys("test auto");
        interviewTopicArrow.click();
        interviewTopicQuestion.sendKeys("test");
        interviewTopicResponse.sendKeys("test");
        Thread.sleep(3000);
        closingProtocolLink.click();
        closingProtocolCheckbox.click();
        closingProtocolNotes.sendKeys("close");
        interviewCompleteCheckbox.click();
        Thread.sleep(2000);
    }

    public void editInterview() throws InterruptedException {
        waitForClickablility(editInterviewGearIcon, 60);
        Thread.sleep(2000);
        editInterviewGearIcon.click();
        editInterviewLink.click();
        editInterviewInsideInterviewpage.click();
        addInterviewLocation.sendKeys(" - EDITED");
        actual_EditInterviewLocation = addInterviewLocation.getAttribute("value");
        saveInterviewLocationButton.click();
        Thread.sleep(5000);
        waitForClickablility(saveInterviewLink, 30);
        saveInterviewLink.click();
        returnToInvestigationLink.click();
        Thread.sleep(3000);
        waitForInVisibility(pagegridLoader, 30);
        waitForClickablility(editInterviewLocationOutsideInterviewpage, 30);
        Thread.sleep(5000);
        expected_EditInterviewLocation = editInterviewLocationOutsideInterviewpage.getText();
        Assert.assertEquals(actual_EditInterviewLocation, expected_EditInterviewLocation);
    }

    public void newInterview() throws InterruptedException, AWTException {
//    	waitForVisibility(newInterviewLink,15);
//    	newInterviewLink.click();
//    	addInterviewLocation.sendKeys("Auto - Interview Location - " + randomInt);
//    	addInterviewDate.click();
//    	InterviewDatePicker.click();
//    	attachCompleteInterviewNotes.click();
//        Thread.sleep(3000);
//    	Actions actions = new Actions(driver);
//        actions.click(chooseFileButtonInterview).perform();
//        StringSelection file = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\Image.png");
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_V);
//        Thread.sleep(1000);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        Thread.sleep(1000);
//        robot.keyPress(KeyEvent.VK_TAB);
//        Thread.sleep(1000);
//        robot.keyPress(KeyEvent.VK_TAB);
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        waitForClickablility(actualInterviewNotesDeleteIcon,20);
//        Assert.assertTrue(actualInterviewNotesDeleteIcon.isDisplayed());
//        waitForVisibility(saveInterviewButton,15);
//        waitForElementToBeClickable(saveInterviewButton);
//        saveInterviewButton.click();
    }

    public void deleteInterview() throws InterruptedException {
        waitForVisibility(editInterviewGearIcon, 30);
        waitForClickablility(editInterviewGearIcon, 30);
        Thread.sleep(2000);
        editInterviewGearIcon.click();
        waitForClickablility(deleteInterviewLink, 30).click();
        deleteButton.click();
    }

    public void addCommunication() throws InterruptedException, AWTException {
        waitForVisibility(addCommunicationLink, 30);
        addCommunicationLink.click();
        Thread.sleep(2000);
        waitAndClickButton(selectInvolvedParty);
        TimeUnit.SECONDS.sleep(2);
        selectInvolvedParty.sendKeys(Keys.ARROW_DOWN);
        TimeUnit.SECONDS.sleep(2);
        selectInvolvedParty.sendKeys(Keys.ENTER);
        waitAndClickButton(selectCommunicationType);
        TimeUnit.SECONDS.sleep(2);
        selectCommunicationType.sendKeys(Keys.ARROW_DOWN);
        TimeUnit.SECONDS.sleep(2);
        selectCommunicationType.sendKeys(Keys.ENTER);
        selectCommuincationDate.click();
        CommuincationDatePicker.click();
        CommuincationSpecifics.sendKeys("Involved Party Commuincated" + randomInt);
        actual_CommuincationSpecifics = CommuincationSpecifics.getAttribute("value");
//        Actions act = new Actions(driver);
//        act.click(chooseFileButtonCommunication).perform();
//        StringSelection file = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\Image.png");
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_V);
//        Thread.sleep(1000);
//        robot.keyPress(KeyEvent.VK_TAB);
//        Thread.sleep(1000);
//        robot.keyPress(KeyEvent.VK_TAB);
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        waitForClickablility(actualCommunicationDocumentDeleteIcon,20);
//        waitForVisibility(actualCommunicationDocumentName,15);
//        actual_CommunicationDocumentName=actualCommunicationDocumentName.getText().trim();
        waitForVisibility(saveCommunicationButton, 45);
        saveCommunicationButton.click();
        TimeUnit.SECONDS.sleep(2);
        expected_CommuincationSpecifics = expectedCommunicationSpecifics.getText();
//        waitForClickablility(expectedCommunicationDocumentName,15);
//        expected_CommunicationDocumentName=expectedCommunicationDocumentName.getText().trim();
        Assert.assertEquals(actual_CommuincationSpecifics, expected_CommuincationSpecifics);
//        Assert.assertEquals(actual_CommunicationDocumentName, expected_CommunicationDocumentName);
    }

    public void editCommunication() throws InterruptedException {
        waitForVisibility(editCommunicationGearIcon, 15);
        waitForClickablility(editCommunicationGearIcon, 15);
        Thread.sleep(2000);
        editCommunicationGearIcon.click();
        editCommunicationLink.click();
        CommuincationSpecifics.click();
        CommuincationSpecifics.sendKeys("Involved Party Commuincated" + randomInt);
        saveCommunicationButton.click();
        Assert.assertEquals(actual_CommuincationSpecifics, expected_CommuincationSpecifics);
    }

    public void deleteCommunication() throws InterruptedException {
        waitForVisibility(editCommunicationGearIcon, 15);
        waitForClickablility(editCommunicationGearIcon, 15);
        Thread.sleep(2000);
        editCommunicationGearIcon.click();
        deleteCommunicationLink.click();
        deleteButton.click();
    }

    public void scheduleFollowup() throws InterruptedException {
        Thread.sleep(2000);
        scheduleFollowupLink.click();
        Thread.sleep(2000);
        waitAndClickButton(selectFollowupINVParty);
        TimeUnit.SECONDS.sleep(2);
        selectFollowupINVParty.sendKeys(Keys.ARROW_DOWN);
        TimeUnit.SECONDS.sleep(2);
        selectFollowupINVParty.sendKeys(Keys.ENTER);
        actual_FollowupInvolvedParty = FollowupINVParty.getText().replace("(Complainant)", "").trim();
        waitAndClickButton(selectAssignment);
        TimeUnit.SECONDS.sleep(2);
        selectAssignment.sendKeys(Keys.ARROW_DOWN);
        TimeUnit.SECONDS.sleep(2);
        selectAssignment.sendKeys(Keys.ENTER);
        scheduleFollowupDate.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        saveFollowupButton.click();
        TimeUnit.SECONDS.sleep(2);
        expected_FollowupInvolvedParty = expectedFollowupINVParty.getText().trim();
        Assert.assertEquals(actual_FollowupInvolvedParty, expected_FollowupInvolvedParty);
    }

    public void editFollowup() throws InterruptedException {
        waitForVisibility(editFollowupGearIcon, 15);
        waitForClickablility(editFollowupGearIcon, 15);
        Thread.sleep(2000);
        editFollowupGearIcon.click();
        editFollowupLink.click();
        Thread.sleep(2000);
        waitAndClickButton(selectFollowupINVParty);
        TimeUnit.SECONDS.sleep(2);
        selectFollowupINVParty.sendKeys(Keys.ARROW_DOWN);
        TimeUnit.SECONDS.sleep(2);
        selectFollowupINVParty.sendKeys(Keys.ENTER);
        saveFollowupButton.click();
    }

    public void deleteFollowup() throws InterruptedException {
        waitForVisibility(editFollowupGearIcon, 15);
        waitForClickablility(editFollowupGearIcon, 15);
        Thread.sleep(2000);
        editFollowupGearIcon.click();
        deleteFollowupLink.click();
        deleteButton.click();
    }

    public void addCommunicationfromFinalAction() throws InterruptedException {
        waitForVisibility(FinalActionGearIcon, 15);
        waitForClickablility(FinalActionGearIcon, 15);
        Thread.sleep(2000);
        FinalActionGearIcon.click();
        addCommunicationFinalActionLink.click();
        Thread.sleep(2000);
        waitAndClickButton(selectInvolvedParty);
        TimeUnit.SECONDS.sleep(2);
        selectInvolvedParty.sendKeys(Keys.ARROW_DOWN);
        TimeUnit.SECONDS.sleep(2);
        selectInvolvedParty.sendKeys(Keys.ENTER);
        waitAndClickButton(selectCommunicationType);
        TimeUnit.SECONDS.sleep(2);
        selectCommunicationType.sendKeys(Keys.ARROW_DOWN);
        TimeUnit.SECONDS.sleep(2);
        selectCommunicationType.sendKeys(Keys.ENTER);
        selectCommuincationDate.click();
        CommuincationDatePicker.click();
        CommuincationSpecifics.sendKeys("Involved Party Commuincated" + randomInt);
        actual_CommuincationSpecifics = CommuincationSpecifics.getAttribute("value");
        saveCommunicationButton.click();
        TimeUnit.SECONDS.sleep(2);
        expected_CommuincationSpecifics = expectedCommunicationSpecifics.getText();
        Assert.assertEquals(actual_CommuincationSpecifics, expected_CommuincationSpecifics);
    }

    public void scheduleFollowupfromFinalAction() throws InterruptedException {
        waitForVisibility(FinalActionGearIcon, 15);
        waitForClickablility(FinalActionGearIcon, 15);
        Thread.sleep(2000);
        FinalActionGearIcon.click();
        scheduleFollowupFinalActionLink.click();
        Thread.sleep(2000);
        waitAndClickButton(selectFollowupINVParty);
        TimeUnit.SECONDS.sleep(2);
        selectFollowupINVParty.sendKeys(Keys.ARROW_DOWN);
        TimeUnit.SECONDS.sleep(2);
        selectFollowupINVParty.sendKeys(Keys.ENTER);
        actual_FollowupInvolvedParty = FollowupINVParty.getText().replace("(Complainant)", "").trim();
        waitAndClickButton(selectAssignment);
        TimeUnit.SECONDS.sleep(2);
        selectAssignment.sendKeys(Keys.ARROW_DOWN);
        TimeUnit.SECONDS.sleep(2);
        selectAssignment.sendKeys(Keys.ENTER);
        scheduleFollowupDate.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        saveFollowupButton.click();
        TimeUnit.SECONDS.sleep(2);
        expected_FollowupInvolvedParty = expectedFollowupINVParty.getText().trim();
        Assert.assertEquals(actual_FollowupInvolvedParty, expected_FollowupInvolvedParty);
    }

    public void recordActionTakenfromFinalAction() throws InterruptedException, AWTException {
        waitForVisibility(FinalActionGearIcon, 15);
        waitForClickablility(FinalActionGearIcon, 15);
        Thread.sleep(2000);
        FinalActionGearIcon.click();
        waitForVisibility(recordActionTakenLink, 15);
        recordActionTakenLink.click();
        Thread.sleep(2000);
        recordFinalActionDate.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
//        Actions act = new Actions(driver);
//        act.click(chooseFileButtonFinalAction).perform();
//        StringSelection file = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\Image.png");
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_V);
//        Thread.sleep(1000);
//        robot.keyPress(KeyEvent.VK_TAB);
//        Thread.sleep(1000);
//        robot.keyPress(KeyEvent.VK_TAB);
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        waitForClickablility(actualRecordActionDocumentDeleteIcon,20);
//        waitForVisibility(actualRecordActionDocumentName,15);
//        actual_RecordActionDocumentName=actualRecordActionDocumentName.getText().trim();
        documentRestrictedCheckbox.click();
        saveFinalActionButton.click();
        Thread.sleep(2000);
//        waitForClickablility(expectedRecordActionDocumentName,15);
//        expected_RecordActionDocumentName=expectedRecordActionDocumentName.getText().trim();
//        Assert.assertEquals(actual_RecordActionDocumentName, expected_RecordActionDocumentName);
    }

    public void clickCommitteRadioButtonwithApprovalOrder() throws InterruptedException {
        boolean committee;
        committee = committeRadioButton.isSelected();
        if (committee) {
        } else {
            committeRadioButton.click();
        }
        approvalOrderCheckbox.click();
    }

    public void clickindividualRadioButton() {
        individualRadioButton.click();
        approvalOrderCheckbox.click();
    }

    public void clickindividualRadioButtonwithApprovalOrder() {
        individualRadioButton.click();
        approvalOrderCheckbox.click();
    }

    public void enterIndiviualUserName() throws InterruptedException {
        enterIndiviualUserName.click();
        enterIndiviualUserName.sendKeys("Mohit Godiyal");
        waitForClickablility(clickInividualUserName, 15);
        clickInividualUserName.click();
        waitForClickablility(actualIndividualUserName, 15);
        actual_IndividualUserName = actualIndividualUserName.getText().trim();
    }

    public void clickindividualSendButton() throws InterruptedException {
        SendButton.click();
        mailsentpopup.click();
        Thread.sleep(5000);
        waitForClickablility(expectedIndividualUserName, 15);
        expected_IndividualUserName = expectedIndividualUserName.getText().trim();
        assertEquals(actual_IndividualUserName, expected_IndividualUserName);
    }

    public void isSaveButtonDisabled() {
        boolean saveButtonIsDisabled;
        saveButtonIsDisabled = iNVpopupSaveButton.isDisplayed();
        Assert.assertTrue(saveButtonIsDisabled);
    }

    public static void LegalHoldRoleUserLogin() throws IOException, InterruptedException {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginPage.properties";
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);
        String url = properties.getProperty("url");
        String userName = properties.getProperty("LegaladvisorUser");
        String password = properties.getProperty("Legaladvisorpassword");
        driver.get(url);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.email().clear();
        loginPage.email().sendKeys(userName);
        loginPage.password().clear();
        loginPage.password().sendKeys(password);
        loginPage.login().click();
        loginPage.iAgree().click();
        Thread.sleep(2000);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        System.out.println(loginPage.name().getText());
    }

    public static void legalreviewrequesttab() {
        legalreviewtab.click();
        String text = legalreviewtab.getText();
        String legalReviewTabCount = text.substring(text.indexOf("(") + 1, text.indexOf(")")).trim();
        int actualLegalReviewCount = Integer.parseInt(legalReviewTabCount);
        int expectedLegalReviewCount = legalreviewcasecount.size();
        if (actualLegalReviewCount == 20) {
            Assert.assertEquals(actualLegalReviewCount, expectedLegalReviewCount);
        } else if (actualLegalReviewCount > 20) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", pageEndCountLegalReview);
            String[] endCount = pageEndCountLegalReview.getText().split(" ");
            int casePageEndCountLegalReview = Integer.parseInt((endCount[endCount.length - 1]).trim());
            Assert.assertEquals(actualLegalReviewCount, casePageEndCountLegalReview);
        }
        legalreviewcase.get(0).click();
        attorneyclientprivilegepopup.click();
    }

    public static void competelegalreview() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("window.scrollBy(0,-750)");
        Thread.sleep(2000);
        clickWithJS(determinetab);
        executor.executeScript("window.scrollBy(0,750)");
        Thread.sleep(2000);
        waitForClickablility(legalreviewcompletecheckbox, 15).click();
        waitForClickablility(legalcasesavebutton, 15).click();
        legalsuccesssentpopup.click();
        Driver.getDriver().navigate().refresh();

        //executor.executeScript("window.scrollBy(0,-750)");
        Thread.sleep(2000);
        Assert.assertTrue(casetstatuslegalreviewcomplete.getText().contains("Legal Review Complete"));
        Assert.assertTrue(expectedlegalcaseName.getText().contains(INVProductionStepDef.Actual_caseName));
    }
    public void selectSubjects() throws InterruptedException {
        subjectDropdown.click();
        Thread.sleep(2000);
        subjectDropdownSearchBox.sendKeys("Paramita");
        Thread.sleep(5000);
        subjectDropdownSearchResault.click();
        recommendedActionSaveButton.click();
    }

    public void selectIssueDisposition() throws Exception {
        Select issueDisposition = new Select(selectIssueDispositionDropdown);
        selectIssueDispositionDropdown.click();
        Thread.sleep(2000);
        issueDisposition.selectByVisibleText(getAllExcelData("Issue Disposition"));
    }
    public void selectOverallIssueDisposition() throws Exception {
        Select issueDisposition = new Select(selectOverallIssueDispositionDropdown);
        selectOverallIssueDispositionDropdown.click();
        Thread.sleep(2000);
        issueDisposition.selectByVisibleText(getAllExcelData("Issue Disposition"));
    }
}
