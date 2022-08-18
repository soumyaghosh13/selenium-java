package com.HRA.pageObjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import com.HRA.helper.ExcelReadCellData;

public class ManagERWorkflowTempPage {

    WebDriver driver = Driver.getDriver();

    public ManagERWorkflowTempPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    int randomInt = random.nextInt(9999999);
    String actual_workflowName;
    public static String concernName;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\ManagER.xlsx";


    @FindBy(xpath = "//*[text()='Step 5: Workflows']")
    private WebElement workflowtab;

    @FindBy(xpath = "//i[@class='fa fa-plus tooltip']")
    private WebElement addSymbol;

    @FindBy(id = "txtWorkflowName")
    private WebElement workflowNameField;

    @FindBy(xpath = "//input[@value='Add']")
    private WebElement addButton;

    @FindBy(xpath = "(//a[text()='Cancel'])[4]")
    private WebElement CancelButton;

    @FindBy(xpath = "//*[@class='dot color6']")
    private WebElement chooseColor;

    //Xpaths for Issue And Action

    @FindBy(id = "txtConcernTypeName")
    private WebElement concernNameField;

    @FindBy(xpath = "(//span[@name='IssueSubCategoryName'])[1]")
    private WebElement selectSubCat;

    @FindBy(xpath = "//select[@name='ddlActionList']")
    private WebElement selectActionDDL;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btn-preview-1 jq-btnvalidate']")
    private WebElement PreviewButton;

    @FindBy(xpath = "//div[@class='c-modal__btn jq-action-save-input']/input[@value='Preview']")
    private WebElement previewaction;

    @FindBy(xpath = "//div[@id='section-preview']//a[@class='c-modal__close js-modal-close']")
    private WebElement previewclose;

    @FindBy(xpath = "//div[@class='c-modal__btn jq-action-save-input']/input[@value='Save And Next']")
    private WebElement saveNextButton;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small step2 jq-btnvalidate jq-save-action']")
    private WebElement SaveNextButtonInGroupsAndLocations;

    @FindBy(xpath = "//*[@id='bootstraphtmleditor0']")
    private WebElement writingTip;

    @FindBy(xpath = "(//*[@class='fa fa-list-ul'])[2]")
    private WebElement bullet;

    @FindBy(xpath = "(//*[@class='fa fa-list-ol'])[1]")
    private WebElement numbering;

    //xpaths for Writing Tips

    @FindBy(id = "bootstraphtmleditor1")
    private WebElement writingTipField;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btn-preview-2 jq-btnvalidate']")
    private WebElement previewtip;

    @FindBy(xpath = "(//*[@class='c-modal__close js-modal-close'])[3]")
    private WebElement previewclse;

    @FindBy(xpath = "//input[@class='c-btn c-btn--small step3 jq-form-save jq-btnvalidate']")
    private WebElement SaveNextButtonWT;

    //Xpaths for Action Workflows

    // Direct Manager

    @FindBy(xpath = "//span[text()='Manager Action']")
    private WebElement ActionPointedClick;

    @FindBy(xpath = "(//*[@class='jq-configaction-rbtnsendletter'])[3]")
    private WebElement yesRadioButtonAP;

    @FindBy(xpath = "(//input[@type='radio'])[6]")
    private WebElement NoRadioButtonAP;

    @FindBy(xpath = "(//select[@class='jq-configaction-ddlchoosetemplate'])[2]")
    private WebElement chooseTemplateDDL;

    @FindBy(xpath = "(//input[@value='0'])[7]")
    private WebElement NoApprovalRadioButton;

    @FindBy(xpath = "(//*[@class='jq-configaction-rbtreview'])[4]")
    private WebElement requiredReviewRadioButton;

    @FindBy(xpath = "(//*[@class='jq-configaction-rbtnapprover'])[5]")
    private WebElement requiredApprovalRadioButton;

    @FindBy(xpath = "(//input[@value='1'])[10]")
    private WebElement DirectManagerRadioButton;

    @FindBy(xpath = "(//input[@value='2'])[3]")
    private WebElement LevelManagerRadioButton;

    @FindBy(xpath = "(//input[@value='3'])[2])")
    private WebElement HumanResourseUserRadioButton;

    @FindBy(xpath = "(//a[text()='Save and Next'])[2]")
    private WebElement saveNextButtonConfigureApp;

    //Second Level Manager

    @FindBy(xpath = "(//*[@class='jq-configaction-rbtnsendletter'])[5]")
    private WebElement YesLetterTempRadioButton;

    @FindBy(xpath = "(//input[@type='radio'])[20]")
    private WebElement NoLetterTempRadioButton;

    @FindBy(xpath = "(//select[@class='jq-configaction-ddlchoosetemplate'])[3]")
    private WebElement selectActionTemplateDDL;

    @FindBy(xpath = "(//input[@type='radio'])[21]")
    private WebElement NOManagerApprovalRadioButton;

    @FindBy(xpath = "(//*[@class='jq-configaction-rbtreview'])[6]")
    private WebElement ReqManagerReviewRadioButton;

    @FindBy(xpath = "(//input[@class='jq-configaction-rbtnapprover'])[6]")
    private WebElement ReqManagerApprovalRadioButton;

    @FindBy(xpath = "(//input[@type='radio'])[23]")
    private WebElement DirectManagerActionRB;

    @FindBy(xpath = "(//div[@class='c-form__field margin-top-5']//input[@value='2'])[4]")
    private WebElement levelManagerActionRB;

    @FindBy(xpath = "(//input[@value='3'])[2]")
    private WebElement HumanResourseUserActionRB;

    @FindBy(xpath = "(//a[text()='Save and Next'])[3]")
    private WebElement SaveNextActionButton;

    // Human Resource

    @FindBy(xpath = "(//*[@class='jq-configaction-rbtnsendletter'])[7]")
    private WebElement YesLetterTempRB;

    @FindBy(xpath = "(//input[@type='radio'])[27]")
    private WebElement NoLetterTempRB;

    @FindBy(xpath = "(//*[@class='jq-configaction-ddlchoosetemplate'])[4]")
    private WebElement SelectLetterTemp;

    @FindBy(xpath = "(//input[@type='radio'])[28]")
    private WebElement NoLetterTemp2;

    @FindBy(xpath = "(//*[@class='jq-configaction-rbtreview'])[8]")
    private WebElement ReqReviewButton;

    @FindBy(xpath = "(//*[@class='jq-configaction-rbtnapprover'])[8]")
    private WebElement ReqApprovalButton;

    @FindBy(xpath = "(//input[@type='radio'])[30]")
    private WebElement DirectManagerLetterTempRB;

    @FindBy(xpath = "(//input[@type='radio'])[31]")
    private WebElement LevelManagerLetterTempRB;

    @FindBy(xpath = "(//input[@value='3'])[2]")
    private WebElement humanResourseUserLetterTempRB;

    @FindBy(xpath = "(//input[@value='3'])[2]")
    private WebElement HumanResourseUserLetterTempRBforEndtoEnd;

    @FindBy(xpath = "(//a[text()='Save and Next'])[4]")
    private WebElement SaveandNextLetterTempButton;

    //    @FindBy(xpath = "//*[@class='label-link jq-workflow-publish']")
    @FindBy(xpath = "//div[@class='jq-adminsection jq-addeditsection']//a[contains(text(),'Activate')]")
    private WebElement activateWorkFlow;

    @FindBy(xpath = "//*[@class='c-btn c-btn--small yesCallback']")
    private WebElement activateOkButton;

    @FindBy(xpath = "//*[@id='AllegationName']")
    private WebElement searchSendkeys;

    @FindBy(xpath = "//*[@class='c-search__formSubmit btn_search']")
    private WebElement SearchIcon;

    @FindBy(xpath = "//*[@class='jq-workflow-selected']")
    private WebElement SampWork;

    @FindBy(xpath = "//*[@class='label-link jq-workflow-publish']")
    private WebElement inactiveWorkflow;

    @FindBy(xpath = "//*[@class='c-btn c-btn--small yesCallback']")
    private WebElement inactiveWorkflowOk;

    @FindBy(xpath = "//*[@class='fa fa-search tooltip']")
    private WebElement searchIcon;

    @FindBy(xpath = "//*[@class='c-form__fieldSelect']//select")
    private WebElement workflowStatus;

    @FindBy(xpath = "//*[@id='search-result']")
    private WebElement searchButton;

    @FindBy(xpath = "//tr[@class='row c-table__evenRow']//td[2][@class='admingrid-col anchor-iseditlink jq-iseditlink']")
    WebElement getWorklfow;

    @FindBy(xpath = "//*[@class='fa fa-trash tooltip']")
    WebElement deleteWorklfow;

    @FindBy(xpath = "//*[@id='jq-btnconfirmalert']")
    WebElement deleteButton;

    @FindBy(xpath = "//div[@jq-track-changes-flag='true']//div//form//div//div[@module='issuetree']//div//i[@aria-hidden='true']")
    WebElement issueCategoryDropDown;

    @FindBy(xpath = "//div[@id='ddl-group-tree-1']//span[@id='GroupName']")
    WebElement groupSelectDropdown;

    @FindBy(xpath = "//div[@id='ddl-group-tree-1']//*[@class='jq-search-input-tree']")
    WebElement groupSelectDropdownSearch;

    @FindBy(xpath = "(//div[@class='tree-data-clearall jq-tree-data-clearall'])[1]")
    WebElement clearAllButtonInGroupDropdown;

    @FindBy(xpath = "(//div[@class='tree-data-clearall jq-tree-data-clearall'])[2]")
    WebElement clearAllButtonInLocationDropdown;

    @FindBy(xpath = "//*[contains(text(),'Automation Group')]")
    WebElement automationGroup;

    @FindBy(xpath = "//div[@id='ddl-group-tree-2']//span[@id='LocationName']")
    WebElement locationDropdown;

    @FindBy(xpath = "//div[@id='ddl-group-tree-2']//*[@class='jq-search-input-tree']")
    WebElement locationSelectDropdownSearch;

    @FindBy(xpath = "//*[contains(text(),'Automation Location')]")
    WebElement automationLocation;

    @FindBy(xpath = "//span[@class='btn btn-primary jq-btn-continue-action']")
    WebElement takeAnotherActionButton;
    @FindBy(xpath = "//a[@class='btn btn-primary jq-modal-continueaction-sameIssue']")
    WebElement sameIssue;
    @FindBy(xpath = "//a[@class='btn btn-primary jq-modal-continueation-differentIssue']")
    WebElement differentIssue;
    @FindBy(xpath = "(//span[@class='fa fa-eye'])[1]")
    WebElement eyeButton;
    @FindBy(xpath = "(//span[contains(text(),'Issue Number:')])[1]")
    WebElement issueNumber;
    @FindBy(xpath = "//app-root[@class='content']//h4[contains(text(),'Open')]")
    WebElement openTab;
    
    @FindBy(xpath = "//span[@class='tree-group-check-outer jq-tree-group-custom-check jq-tree-group-custom-check-haschild tree-group-check-outer-checked']")
    WebElement groupAllSelect;
    
    @FindBy(xpath = "//span[@class='tree-group-check-outer jq-tree-group-custom-check jq-tree-group-custom-check-haschild tree-group-check-outer-checked']")
    WebElement locationAllSelect;
    
    @FindBy(xpath = "//input[@id='HelpfulResourcesTitle']")
    WebElement titleTextbox;
    
    @FindBy(xpath = "//div[@class='collapse jq-workflow-step5']//div[@id='bootstraphtmleditor2']")
    WebElement contentTextBox;
    
    @FindBy(xpath = "//div[@class='collapse jq-workflow-step5']//a")
    WebElement clickConfigureHelpSection;
    
    @FindBy(xpath = "//div[@class='collapse jq-workflow-step5']//input[@value='Save and Next']")
    WebElement clickConfigureHelpSectionSaveButton;

    @FindBy(xpath = "//span[@data-modal='#model-casereopen'][normalize-space()='lock_open']")
    public List<WebElement> reopenIconsInIssueHistory;

    @FindBy(xpath = "(//span[contains(text(),'lock_open')])[1]")
    WebElement reopenButton;

    @FindBy(xpath = "//textarea[@data-testid='input-reason']")
    WebElement reopenReason;

    @FindBy(xpath = "//h4[normalize-space()='Re-Open Reason']")
    WebElement reopenBanner;

    @FindBy(xpath = "//span[@data-testid='caseNumber']")
    WebElement reopenCaseNumber;

    @FindBy(xpath = "//input[@data-testid='case-reopen']")
    WebElement reopenSaveButton;

    @FindBy(xpath = "//*[@id='jq-mgr-caseflow-placeholder']/div[2]//span")
    WebElement reopenLog;

    public void clickWorkflowTab() {
        workflowtab.click();
    }

    public void CreateWorkflowMethod() {
        addSymbol.click();
        workflowNameField.sendKeys("Auto - PolicyWorkflow " + randomInt);
        actual_workflowName = workflowNameField.getAttribute("value");
        addButton.click();
    }

    public void ChooseColorMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(chooseColor));
        chooseColor.click();
    }

    public void CreateIssueActionsMethod() throws Exception {
        String categoryName = getAllManagERExcelData("Issue Category");
        String childCategoryName = getAllManagERExcelData("Child Issue Category");
        String actionName = getAllManagERExcelData("Action");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(concernNameField));
        concernName = "Auto - Policy Concerns " + randomInt;
        concernNameField.sendKeys(concernName);
        selectSubCat.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + categoryName + "'" + "])/../div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + childCategoryName + "'" + "])"))).click();
        writingTip.clear();
        Thread.sleep(2000);
        bullet.click();
        numbering.click();
        writingTip.sendKeys("If you have a policy concern with an employee, here is what you should do :");
        Thread.sleep(2000);
        selectActionDDL.click();
        Select select = new Select(selectActionDDL);
        Thread.sleep(2000);
        select.selectByVisibleText(actionName);
        previewaction.click();
        previewclose.click();
        Thread.sleep(2000);
        saveNextButton.click();
    }

    public void configureGroupsAndLocations() throws Exception {
        String groupName = getAllManagERExcelData("Group");
        String locationName = getAllManagERExcelData("Location");

        groupSelectDropdown.click();
        //Assert.assertTrue(groupAllSelect.isDisplayed());
        clearAllButtonInGroupDropdown.click();
        groupSelectDropdownSearch.click();
        groupSelectDropdownSearch.sendKeys("Automation Group");
        wait.until(ExpectedConditions.elementToBeClickable(automationGroup)).click();
        groupSelectDropdown.click();

        locationDropdown.click();
        //Assert.assertTrue(locationAllSelect.isDisplayed());
        clearAllButtonInLocationDropdown.click();
        locationSelectDropdownSearch.click();
        locationSelectDropdownSearch.sendKeys("Automation Location");
        wait.until(ExpectedConditions.elementToBeClickable(automationLocation)).click();
        locationDropdown.click();

        BrowserUtilities.waitForElementToBeClickable(SaveNextButtonInGroupsAndLocations);
        SaveNextButtonInGroupsAndLocations.click();
    }

    public void CreateWritingTipMethod() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(writingTipField);
        writingTipField.clear();
        writingTipField.sendKeys("Be sure to include all the relevant details of the concern, incident or specific behavior.");
        previewtip.click();
        previewclse.click();
        Thread.sleep(2000);
        SaveNextButtonWT.click();
        Thread.sleep(1000);
    }

    public void CreateActionWithTemplateWorkflow() throws Exception {
        String letterName = getAllManagERExcelData("Letter Template");
        Thread.sleep(2000);
        //ActionPointedClick.click();
        yesRadioButtonAP.click();
        chooseTemplateDDL.click();
        Select select = new Select(chooseTemplateDDL);
        select.selectByIndex(1);
//        if you want to run from excel
//        select.selectByVisibleText(letterName);
        Thread.sleep(2000);

        saveNextButtonConfigureApp.click();
        Thread.sleep(1000);
    }


    public void CreateActionNoTemplateWorkflow() throws InterruptedException {
        saveNextButtonConfigureApp.click();
        Thread.sleep(1000);
    }

    public void ReviewerAction() throws Exception {
        String letterTemplate = getAllManagERExcelData("Letter Template");
        yesRadioButtonAP.click();
        Thread.sleep(2000);
        chooseTemplateDDL.click();
        Thread.sleep(2000);
        Select select = new Select(chooseTemplateDDL);
        select.selectByVisibleText(letterTemplate);
        requiredReviewRadioButton.click();
        Thread.sleep(2000);
        saveNextButtonConfigureApp.click();
        Thread.sleep(1000);
    }

    public void DirectMAnagerAction() throws Exception {
        String letterTemplate = getAllManagERExcelData("Letter Template");
        yesRadioButtonAP.click();
        chooseTemplateDDL.click();
        Select select = new Select(chooseTemplateDDL);
        select.selectByVisibleText(letterTemplate);
        requiredReviewRadioButton.click();
        requiredApprovalRadioButton.click();
        Thread.sleep(2000);
        saveNextButtonConfigureApp.click();
        Thread.sleep(1000);
    }

    public void SecondLevelMAnagerAction() throws Exception {
        String letterTemplate = getAllManagERExcelData("Letter Template");
        yesRadioButtonAP.click();
        chooseTemplateDDL.click();
        Select select = new Select(chooseTemplateDDL);
        select.selectByVisibleText(letterTemplate);
        requiredReviewRadioButton.click();
        requiredApprovalRadioButton.click();
        Thread.sleep(2000);
//        YesLetterTempRadioButton.click();
//        selectActionTemplateDDL.click();
//        Select select = new Select(selectActionTemplateDDL);
//        select.selectByVisibleText(actual_LetterTemplate);
//        ReqManagerReviewRadioButton.click();
//        ReqManagerApprovalRadioButton.click();
        levelManagerActionRB.click();
        Thread.sleep(2000);
        saveNextButtonConfigureApp.click();
        //SaveNextActionButton.click();
    }

    public void HumanResourceAction() throws Exception {
        String letterTemplate = getAllManagERExcelData("Letter Template");
        yesRadioButtonAP.click();
        chooseTemplateDDL.click();
        Select select = new Select(chooseTemplateDDL);
        select.selectByVisibleText(letterTemplate);
        //RequiredReviewRadioButton.click();
        requiredApprovalRadioButton.click();
        Thread.sleep(2000);
//        YesLetterTempRB.click();
//        SelectLetterTemp.click();
//        Select sel = new Select(SelectLetterTemp);
//        sel.selectByVisibleText(actual_LetterTemplate);
//        ReqReviewButton.click();
//        ReqApprovalButton.click();
        humanResourseUserLetterTempRB.click();
        Thread.sleep(2000);
        saveNextButtonConfigureApp.click();
        //SaveandNextLetterTempButton.click();
    }

    public void HumanResourceActionEndtoEnd() throws Exception {
        String letterTemplate = getAllManagERExcelData("Letter Template");
        yesRadioButtonAP.click();
        chooseTemplateDDL.click();
        Select select = new Select(chooseTemplateDDL);
        select.selectByVisibleText(letterTemplate);
        requiredApprovalRadioButton.click();
        HumanResourseUserLetterTempRBforEndtoEnd.click();
        Thread.sleep(2000);
        saveNextButtonConfigureApp.click();
    }

    public void activateWorkFlow() throws InterruptedException {
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(activateWorkFlow)).click();
        //activateWorkFlow.click();
        Thread.sleep(2000);
        activateOkButton.click();
        Thread.sleep(5000);
    }

    public void SearchWorkflow() throws InterruptedException {
        searchIcon.click();
        Thread.sleep(2000);
        searchSendkeys.sendKeys(actual_workflowName);
        Select select = new Select(workflowStatus);
        select.selectByVisibleText("Active");
        searchButton.click();
        getWorklfow.click();
        inactiveWorkflow.click();
        Thread.sleep(2000);
        inactiveWorkflowOk.click();
        Thread.sleep(4000);
    }

    public void deleteWorkflow() throws InterruptedException {
        deleteWorklfow.click();
        deleteButton.click();
        Thread.sleep(4000);
    }

    public void CreateMultipleIssueActionsMethod() throws Exception {
        String categoryName = getAllManagERExcelData("Issue Category");
        String childCategoryName = getAllManagERExcelData("Child Issue Category");
        String actionName = getAllManagERExcelData("Action");
        System.out.println(categoryName + childCategoryName + actionName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(concernNameField));
        concernName = "Auto - Policy Concerns " + randomInt;
        concernNameField.sendKeys(concernName);

//        to run from excel sheet
        issueCategoryDropDown.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + categoryName + "'" + "])/../div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + childCategoryName + "'" + "])"))).click();
        Thread.sleep(1000);
        issueCategoryDropDown.click();
        driver.findElement(By.xpath("//input[@class='jq-search-input-tree']")).sendKeys("Alternate");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[contains(text(),'Select All')])[21]")).click();
        driver.findElement(By.xpath("//div[@jq-track-changes-flag='true']//div//form//div//div[@module='issuetree']//div//i[@aria-hidden='true']")).click();

        writingTip.clear();
        Thread.sleep(2000);
        bullet.click();
        numbering.click();
        writingTip.sendKeys("If you have a policy concern with an employee, here is what you should do :");
        Thread.sleep(2000);
        selectActionDDL.click();
        Select select = new Select(selectActionDDL);
        Thread.sleep(2000);
//        to run from excel
//        select.selectByVisibleText(actionName);
        select.selectByIndex(1);
        previewaction.click();
        previewclose.click();
        Thread.sleep(2000);
        saveNextButton.click();
    }


    public void CloseNotificationPopup() throws InterruptedException {
    /*
+ We need to check if the "Lets Catch up" pop up window shows up on the issues page. It prevents click actions
+ once it shows up.
+ */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        LoginPage loginPage = new LoginPage(driver);
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='jq-cacthall-notification']//div//div//div//div//a[@href='#'][normalize-space()='X']"))));
            driver.findElement(By.xpath("//div[@id='jq-cacthall-notification']//div//div//div//div//a[@href='#'][normalize-space()='X']")).click();
        } catch (Exception e) {
            e.printStackTrace();

        }
        wait.until(ExpectedConditions.visibilityOf(loginPage.ERname()));
        if (loginPage.closePopupER().isDisplayed()) {
            loginPage.closePopupER().click();
        }
    }

    public String getAllManagERExcelData(String arg) throws Exception {
        ExcelReadCellData excelData = new ExcelReadCellData(filePath);
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("sheet");
        XSSFRow row = sheet.getRow(0);
        int colNum = row.getLastCellNum();
        int rowNum = sheet.getLastRowNum() + 1;
        String cellData = excelData.getCellData("sheet", arg, rowNum);
        return cellData;
    }
    public void takeAnotherAction() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(takeAnotherActionButton)).click();

    }
    public void sameIssue() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(sameIssue)).click();

    }
    public void differentIssue() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(differentIssue)).click();

    }
    public void clickOnViewCase() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(openTab));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", issueNumber);
        wait.until(ExpectedConditions.visibilityOf(issueNumber));
        Thread.sleep(2000);

        Actions hover = new Actions(driver);
        hover.moveToElement(eyeButton).click().build().perform();

    }
    
    public void configureHelpfulResources()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(clickConfigureHelpSection)).click();
    	titleTextbox.click();
    	titleTextbox.sendKeys("Helful Resources Title Automated");
    	contentTextBox.click();
    	contentTextBox.sendKeys("The following are the helpful tips you may need to complete as part of documenting a managER issue.");  
    	clickConfigureHelpSectionSaveButton.click();
    }
    
    public void reopenCase() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(reopenButton)).click();
        Thread.sleep(2000);
        Assert.assertTrue(reopenBanner.isDisplayed());
        Assert.assertTrue(reopenCaseNumber.isDisplayed());
        String messageReopen = "Reason For Reopen - "+ randomInt;
        wait.until(ExpectedConditions.elementToBeClickable(reopenReason)).sendKeys(messageReopen);
        Assert.assertTrue(reopenSaveButton.isEnabled());
        wait.until(ExpectedConditions.elementToBeClickable(reopenSaveButton)).click();
        Thread.sleep(2000);
        Assert.assertTrue(reopenLog.getText().contains("closed to In Progress"));
        Assert.assertTrue(reopenLog.getText().contains(messageReopen));


    }
    public void verifyReopenCaseIsVisible() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(reopenIconsInIssueHistory.get(0).isDisplayed());

    }
}
