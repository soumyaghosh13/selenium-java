package com.HRA.pageObjects;

import com.HRA.helper.*;
import org.apache.poi.sl.usermodel.Sheet;
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
import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.HRA.helper.BrowserUtilities.waitForElementToBeClickable;
import static com.HRA.helper.BrowserUtilities.waitForElementToBeVisible;
import static com.HRA.helper.ExcelReadCellData.totalRowNumber;
import static com.HRA.pageObjects.ActionNewAdminRedesignPage.actual_actionName;
import static com.HRA.pageObjects.AdminGroupPage.actual_groupName;
import static com.HRA.pageObjects.AdminIssueDispositionsPage.issueDispositionName;
import static com.HRA.pageObjects.DocumentMaterialPage.actual_DocumentMaterialName;
import static com.HRA.pageObjects.GlobalNavigationsPage.administrationTab;
import static com.HRA.pageObjects.InterimActionsPage.actual_interimactionName;
import static com.HRA.pageObjects.InvolvedPartyRelationshipsPage.actual_INVRelationshipName;
import static com.HRA.pageObjects.IssueCategoryAdminPage.actual_categoryName;
import static com.HRA.pageObjects.IssueCategoryAdminPage.actual_childCategoryName;
import static com.HRA.pageObjects.LocationAdminRedesignPage.actual_parentLocationName;
import static com.HRA.pageObjects.ManagERNotificationPage.actual_notificationName;
import static com.HRA.pageObjects.PolicyGuidelinesPage.actual_PolicyGuidelineName;
import static com.HRA.pageObjects.TagManagementPage.actual_tagName;

public class EndToEndERToINVConversionPage {
    WebDriver driver = Driver.getDriver();

    public EndToEndERToINVConversionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Random random = new Random();
    @FindBy(xpath = "//*[@id='additional-info']//div//a")
    WebElement popupClose;
    @FindBy(xpath = "//div[@class='c-casesNumber jq-master-casenumber']")
    WebElement caseNumber;
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/form/div[1]/div[6]/div[1]/div/div")
    WebElement groupDrodown;
    @FindBy(xpath = "//form[@id='ER-Form']//input[@name='Save']")
    WebElement erSaveButton;
    @FindBy(xpath = "//div[@id='ER-LocaList']//span[@id='LocationName']")
    WebElement locationDropdown;
    @FindBy(xpath = "//*[@id='ER-LocaList']/div[2]/input")
    WebElement locationSearch;
    @FindBy(xpath = "//strong[normalize-space()='+ Add Document']")
    WebElement addRelevantDocument;
    @FindBy(xpath = "//textarea[@placeholder='Enter specifics about this document.']")
    WebElement relevantDocumentTextArea;
    @FindBy(xpath = "//input[@id='chkReviewed']")
    WebElement checkboxDocumentReviewed;
    @FindBy(xpath = "//input[@name='chkRestricted']")
    WebElement checkboxRestrictedToSuperAdmin;
    @FindBy(xpath = "//input[@id='jq-btnsavedocument']")
    WebElement documentSave;
    @FindBy(xpath = "//span[@title='Delete']")
    WebElement documentCross;
    @FindBy(xpath = "//form[@name='frmaddissue']//div[@class='c-form__fieldInput c-form__dropDownLink js-from-drop-down-link tree-group-button']")
    WebElement issueDropdown;
    @FindBy(xpath = "//textarea[@name='BriefExplanation']")
    WebElement briefExplainTextArea;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate']")
    WebElement issueSave;
    @FindBy(id = "document-modal")
    WebElement addDocumentModal;
    @FindBy(xpath = "//strong[contains(text(),'+ Add Action')]")
    WebElement addAction;
    @FindBy(xpath = "//*[@id='jq-dropdownautocomplete-3']/div[1]")
    WebElement actionMenu;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate']")
    WebElement saveAction;
    @FindBy(xpath = "//div[@class='c-form jq-morefield-placeholder']//a[@class='js-tab-link disable-on-edit jq-formel-employee'][normalize-space()='Former Employee']")
    WebElement formerEmployeeTab;
    @FindBy(xpath = "//div[@modulename='involvedparty']//a[@class='js-tab-link disable-on-edit']")
    WebElement otherTab;
    @FindBy(xpath = "//a[@class='linkGreen jq-addnewdetails jq-lnkaddinvparty jq-setaccess']//strong")
    WebElement addInvolveParty;
    @FindBy(xpath = "//div[@id='document-issue-event']//div[@id='formel-employee']//input[2]")
    WebElement manualEntryRadioButton;
    @FindBy(xpath = "//div[@modulename='involvedparty']//select[@id='ER-RelationList']")
    WebElement relationDropdown;
    @FindBy(xpath = "(//input[@id='ExternalFirstName'])[2]")
    WebElement firstNameTextArea;
    @FindBy(xpath = "(//input[@id='ExternalLastName'])[2]")
    WebElement lastNameTextArea;
    @FindBy(xpath = "//textarea[@name='AdditionalInfo']")
    WebElement additionalInfo;
    @FindBy(xpath = "//div[@id='innerpagepanel']//div[@id='other-employee']//input[2]")
    WebElement anonymousRadioButton;
    @FindBy(xpath = "(//input[contains(@name,'AnonymousFirstName')])[1]")
    WebElement nickNameTextArea;
    @FindBy(xpath = "(//input[contains(@name,'AnonymousDescription')])[1]")
    WebElement descriptionTextArea;
    @FindBy(xpath = "(//textarea[contains(@name,'IndentifictionAttempts')])[1]")
    WebElement indentifictionAttempts;
    @FindBy(xpath = "//a[@href='#!'][normalize-space()='Advanced Search']")
    WebElement advancdeSearch;
    @FindBy(xpath = "//div[@class='ddl-ac-selected']")
    List<WebElement> fieldDropDown;
    @FindBy(xpath = "//input[@placeholder='Search']")
    List<WebElement> fieldSearch;
    @FindBy(xpath = "//*[@id='jq-dropdownautocomplete-11']//input")
    List<WebElement> anotherFieldSearch;
    @FindBy(xpath = "//div[@class='jq-adv-srch-content']//input")
    List<WebElement> criteria;
    @FindBy(xpath = "//label[normalize-space()='Criteria']/following-sibling::div")
    WebElement groupCriteria;
    @FindBy(xpath = "//select[@class='jq-adv-srch-val']")
    WebElement legalHoldCriteria;
    @FindBy(xpath = "//input[@class='jq-search-input-tree']")
    WebElement groupSearchCriteria;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-adv-srch-btn']")
    WebElement searchButtonForAdvanceSearch;
    @FindBy(xpath = "//input[@value='Clear All']")
    WebElement clearAllButtonForAdvanceSearch;
    @FindBy(xpath = "//a[@sortby='CaseNumber']")
    WebElement caseNumberinResultTable;
    @FindBy(xpath = "//a[@sortby='CaseName']")
    WebElement caseNameinResultTable;
    @FindBy(xpath = "//i[@title='Legal Hold']")
    List<WebElement> legalHoldinResultTable;
    @FindBy(xpath = "//a[@sortby='GroupName']")
    WebElement caseGroupinResultTable;
    @FindBy(xpath = "//a[@sortby='LocationName']")
    WebElement caseLocationinResultTable;
    @FindBy(xpath = "//a[@sortby='LeadInvestigator']")
    WebElement caseOwnerinResultTable;
    @FindBy(xpath = "//i[@class='fa fa-plus']")
    WebElement plusIconForAdvanceSearch;
    @FindBy(xpath = "//span[@class='jq-adv-srch-res-qry']")
    WebElement searchQuery;
    @FindBy(xpath = "//input[@module='Profiles']")
    WebElement employeeRadioButton;
    @FindBy(xpath = "//*[@id='tab-cases']//img")
    WebElement noResultFound;
    @FindBy(xpath = "//a[@class='saved-sc-expand jq-adv-srch-saved']")
    WebElement saveSearch;
    @FindBy(xpath = "//input[@class='c-form__input required jq-search-name-txt']")
    WebElement saveSearchName;
    @FindBy(xpath = "//a[@class='c-btn jq-consolidate-save-search-confirm jq-btnvalidate']")
    WebElement saveButtonSaveSearch;
    @FindBy(xpath = "//a[@class='jq-saved-searchName']")
    WebElement saveSearchDropdown;




    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\WriteExcel.xlsx";


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));


    public void verifyERCaseCreated() {
        waitForElementToBeVisible(caseNumber);
        Assert.assertTrue(caseNumber.getText().contains("ER"));
    }

    public void closePopup() {
        try {
            wait.until(ExpectedConditions.visibilityOf(popupClose));
            if (popupClose.isDisplayed()) {
                popupClose.click();
            }
        } catch (Exception e) {

        }
    }

    public void selectDynamicIssueCategory() throws Exception {
        String parentIssueCategory = getAllExcelData("Issue Category");
        String childIssueCategory = getAllExcelData("Child Issue Category");
        waitForElementToBeClickable(issueDropdown);
        issueDropdown.click();
        Thread.sleep(2000);
        List<WebElement> categories = driver.findElements(By.xpath("//div[contains(@class,'tree-node-middle-nochild jq-static-tree-arrow tree-node-haschild tree-node-last-haschild')]"));
        categories.get(0).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + parentIssueCategory + "'" + "])/../div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + childIssueCategory + "'" + "])"))).click();
        Thread.sleep(2000);
        briefExplainTextArea.click();
        briefExplainTextArea.sendKeys("This issue is related to harrasment and action needs to be taken ");
        waitForElementToBeClickable(issueSave);
        issueSave.click();
        Thread.sleep(6000);
    }

    public void addRelevantDocuments() throws AWTException, InterruptedException {
//        set it true if you want to upload document from local
        boolean uploadOrNot = false;
//        boolean uploadOrNot = true;
        waitForElementToBeClickable(addRelevantDocument);
        addRelevantDocument.click();
        waitForElementToBeClickable(relevantDocumentTextArea);
        relevantDocumentTextArea.sendKeys("Automation Document" + random.nextInt());
        if (uploadOrNot) {
            Thread.sleep(2000);
            WebElement fileUpload = driver.findElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/input[1]"));
            Actions act = new Actions(driver);
            act.click(fileUpload).perform();
            StringSelection file = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\Image.png");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_V);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            waitForElementToBeClickable(documentCross);
            waitForElementToBeClickable(documentSave);
            Assert.assertTrue(documentSave.isEnabled());

        } else {
            waitForElementToBeClickable(checkboxDocumentReviewed);
            checkboxDocumentReviewed.click();
            waitForElementToBeClickable(checkboxRestrictedToSuperAdmin);
            checkboxRestrictedToSuperAdmin.click();
            waitForElementToBeClickable(documentSave);
            Assert.assertTrue(documentSave.isEnabled());
        }
        waitForElementToBeClickable(documentSave);
        documentSave.click();
        BrowserUtilities.waitForInVisibility(addDocumentModal,30);
    }

    public void writeCoreDataInExcel() throws IOException {
        String[] valueToWrite = {actual_groupName,actual_parentLocationName,actual_categoryName,actual_childCategoryName,actual_notificationName,actual_interimactionName,actual_PolicyGuidelineName,actual_INVRelationshipName,actual_actionName,actual_DocumentMaterialName,actual_tagName,issueDispositionName};
//        String[] valueToWrite = {"Admin Group - B","Delhi1","Space Test","Complainant notified Human Resources"};
        ExcelWriter objExcelFile = new ExcelWriter();
        objExcelFile.writeExcel(System.getProperty("user.dir")+"\\src\\test\\resources\\TestDataAndAttachments","WriteExcel.xlsx","sheet",valueToWrite);
        System.out.println("Excel Write Done Successfully");
        ExcelReader exfile = new ExcelReader();
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments";
        exfile.readExcel(filePath,"WriteExcel.xlsx","sheet");

    }
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
    public void selectDynamicAction() throws Exception {
        String actionName = getAllExcelData("Action");
        addAction.click();
        Thread.sleep(3000);
        actionMenu.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'"+ actionName +"')]")).click();
        Thread.sleep(2000);
        saveAction.click();
        WebElement closepopup = driver.findElement(By.xpath("//h4[contains(text(),'More Information')]"));

        if (closepopup.isDisplayed()) {
            driver.findElement(By.xpath("//h4[contains(text(),'More Information')]/../a")).click();
        }
        Thread.sleep(3000);
    }

    public void selectFormerEmployee() {
        BrowserUtilities.waitForElementToBeClickable(formerEmployeeTab);
        formerEmployeeTab.click();
        BrowserUtilities.waitForElementToBeClickable(manualEntryRadioButton);
        manualEntryRadioButton.click();
    }

    public void selectOtherExternal() throws Exception {
        String relationshipName = getAllExcelData("Relationship");
        waitForElementToBeClickable(addInvolveParty);
        addInvolveParty.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='87']")).click();
        BrowserUtilities.waitForElementToBeClickable(otherTab);
        otherTab.click();
        waitForElementToBeClickable(relationDropdown);
        Select rd = new Select(relationDropdown);
        rd.selectByVisibleText(relationshipName);
        waitForElementToBeClickable(firstNameTextArea);
        firstNameTextArea.sendKeys("Soumya");
        waitForElementToBeClickable(lastNameTextArea);
        lastNameTextArea.sendKeys("Ghosh");
        waitForElementToBeClickable(additionalInfo);
        additionalInfo.sendKeys("This is sample input for Automation Test");
    }


    public void selectOtherAnonymous() throws InterruptedException{
        waitForElementToBeClickable(addInvolveParty);
        addInvolveParty.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='153']")).click();
        BrowserUtilities.waitForElementToBeClickable(otherTab);
        otherTab.click();
        waitForElementToBeClickable(anonymousRadioButton);
        anonymousRadioButton.click();
        waitForElementToBeClickable(nickNameTextArea);
        nickNameTextArea.sendKeys("Soumya");
        waitForElementToBeClickable(descriptionTextArea);
        descriptionTextArea.sendKeys("This is sample input for Automation Test");
        waitForElementToBeClickable(indentifictionAttempts);
        indentifictionAttempts.sendKeys("This is sample input for Automation Test");
    }
    public void advanceSearch(String optionName, String subMenuOption) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(advancdeSearch)).click();
        wait.until(ExpectedConditions.visibilityOf(clearAllButtonForAdvanceSearch)).click();
        wait.until(ExpectedConditions.elementToBeClickable(fieldDropDown.get(7))).click();
        wait.until(ExpectedConditions.elementToBeClickable(fieldSearch.get(7))).sendKeys(optionName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='"+optionName+"']")).click();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(criteria.get(1))).sendKeys(subMenuOption);
        }
        catch(Exception e){
            System.out.println("Something Went Wrong in Input Value");
        }
        try {
            wait.until(ExpectedConditions.elementToBeClickable(groupCriteria)).click();
            wait.until(ExpectedConditions.elementToBeClickable(groupSearchCriteria)).sendKeys(subMenuOption);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[contains(text(),'"+subMenuOption+"')]")).click();
        }
        catch(Exception e){
            System.out.println("Something Went Wrong in Selecting Dropdown");
        }
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonForAdvanceSearch)).click();
        wait.until(ExpectedConditions.visibilityOf(caseNameinResultTable));
        Assert.assertTrue(caseGroupinResultTable.isDisplayed());
        Assert.assertTrue(caseNumberinResultTable.isDisplayed());
        Assert.assertTrue(caseOwnerinResultTable.isDisplayed());
        Assert.assertTrue(caseNameinResultTable.isDisplayed());
        Assert.assertTrue(caseLocationinResultTable.isDisplayed());

        try {
            Thread.sleep(2000);
            WebElement resultTable = driver.findElement(By.xpath("//a[@class='anc jq-RedirectCases'][normalize-space()='" + subMenuOption + "']"));
            wait.until(ExpectedConditions.visibilityOf(resultTable));
            Assert.assertTrue(resultTable.isDisplayed());
        }
        catch (Exception e){
            System.out.println("Something Went Wrong");
        }

    }
    public void clickOnAddIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(plusIconForAdvanceSearch)).click();
    }
    public void clickOnAdvanceSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonForAdvanceSearch)).click();

    }

    public void advanceSearchWithDropdown(String optionName, String subMenuOption,int fieldRow,int criteriaRow) throws InterruptedException {
        Thread.sleep(2000);
       wait.until(ExpectedConditions.elementToBeClickable(fieldDropDown.get(fieldRow))).click();
       wait.until(ExpectedConditions.elementToBeClickable(fieldSearch.get(fieldRow))).sendKeys(optionName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='"+optionName+"']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(groupCriteria)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(groupSearchCriteria)).sendKeys(subMenuOption);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'"+subMenuOption+"')]")).click();
    }

    public void advanceSearchWithText(String optionName, String subMenuOption,int fieldRow,int criteriaRow) throws InterruptedException {
        Thread.sleep(2000);
        fieldDropDown.get(fieldRow).click();
        wait.until(ExpectedConditions.elementToBeClickable(fieldSearch.get(fieldRow))).sendKeys(optionName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='" + optionName + "']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(criteria.get(criteriaRow))).sendKeys(subMenuOption);

    }
    public void clickAdvanceSearchAndClearAll() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(advancdeSearch)).click();
        wait.until(ExpectedConditions.visibilityOf(clearAllButtonForAdvanceSearch)).click();
        Thread.sleep(3000);

    }
    public void verifySearchQuery(String expectedQuery){
        wait.until(ExpectedConditions.visibilityOf(searchQuery));
        Assert.assertTrue(searchQuery.isDisplayed());
        Assert.assertTrue(searchQuery.getText().contains(expectedQuery));
    }

    public void verifyResultTableDisplayed() throws InterruptedException {
        Thread.sleep(50000);

        wait.until(ExpectedConditions.visibilityOf(caseNameinResultTable));
        Assert.assertTrue(caseNameinResultTable.isDisplayed());
        Assert.assertTrue(caseGroupinResultTable.isDisplayed());
        Assert.assertTrue(caseNumberinResultTable.isDisplayed());
        Assert.assertTrue(caseOwnerinResultTable.isDisplayed());
        Assert.assertTrue(caseLocationinResultTable.isDisplayed());
    }
    public void verifyTableColumnData(String value){
        wait.until(ExpectedConditions.visibilityOf(caseNameinResultTable));
        List<WebElement> result = driver.findElements(By.xpath("//td[contains(text(),'"+value+"')]"));
        for(int i=1;i<result.size();i++){
            Assert.assertTrue(result.get(i).getText().contains(value));
        }
        System.out.println("Table Data Matched Successfully");
    }
    public void verifyLegalHold(){
        wait.until(ExpectedConditions.visibilityOf(caseNameinResultTable));
                for(int i=4;i<legalHoldinResultTable.size();i++) {
                    Assert.assertTrue(legalHoldinResultTable.get(i).isDisplayed());
                }
    }
    public void advanceSearchWithLegalHold(String optionName,int fieldRow) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(fieldDropDown.get(fieldRow))).click();
        wait.until(ExpectedConditions.elementToBeClickable(fieldSearch.get(fieldRow))).sendKeys(optionName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='"+optionName+"']")).click();
        Select legalHold = new Select(legalHoldCriteria);
        wait.until(ExpectedConditions.elementToBeClickable(legalHoldCriteria)).click();
        legalHold.selectByIndex(1);
    }
    public void verifyAttorneyClientPrivilege(){
        wait.until(ExpectedConditions.visibilityOf(caseNameinResultTable));
        List<WebElement> resultData = driver.findElements(By.xpath("//img"));
        for(int i=11;i<30;i++) {
            Assert.assertTrue(resultData.get(i).isDisplayed());
        }
    }
    public void selectEmployeeSearch() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(employeeRadioButton)).click();
        Thread.sleep(5000);
    }
    public void verifyEmployeeSearch(String option) throws InterruptedException {
        Thread.sleep(5000);
        WebElement employeeResult = driver.findElement(By.xpath("//td[normalize-space()='"+option+"']"));
        wait.until(ExpectedConditions.visibilityOf(employeeResult));
        Assert.assertEquals(employeeResult.getText(),option);
    }
    public void addMoreFilters() throws InterruptedException {
        Thread.sleep(3000);
        WebElement plusButton = driver.findElement(By.xpath("(//a[@class='add-search-field jq-adv-srch-new-row'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(plusButton)).click();
        WebElement selectField1 = driver.findElement(By.xpath("//div[@id='jq-dropdownautocomplete-12']//div[@class='ddl-ac-selected']"));
        WebElement selectSearch1 = driver.findElement(By.xpath("//div[@id='jq-dropdownautocomplete-12']//input[@placeholder='Search']"));
        selectField1.click();
        selectSearch1.sendKeys("Action");
        driver.findElement(By.xpath("(//span[normalize-space()='Action'])[1]")).click();
        WebElement criteria1 = driver.findElement(By.xpath("//div[@id='jq-dropdownautocomplete-13']//div[@class='ddl-ac-selected']"));
        WebElement criteriaSearch1 = driver.findElement(By.xpath("//div[@id='jq-dropdownautocomplete-13']//input[@placeholder='Search']"));
        criteria1.click();
        Thread.sleep(2000);
        criteriaSearch1.sendKeys("Sample Automation Action 12345");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Sample Automation Action 12345']")).click();
        WebElement plusButton3 = driver.findElement(By.xpath("(//a[@class='add-search-field jq-adv-srch-new-row'])[3]"));
        plusButton3.click();
        WebElement field4 = driver.findElement(By.xpath("//body[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]"));
        WebElement fieldSearch4 = driver.findElement(By.xpath("//body[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/input[1]"));
        field4.click();
        fieldSearch4.sendKeys("Notification Method");
        driver.findElement(By.xpath("//span[normalize-space()='Notification Method']")).click();
        WebElement criteria4 = driver.findElement(By.xpath("//body[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[3]/div[1]/div[1]/div[1]"));
        WebElement criteriaSearch4 = driver.findElement(By.xpath("//body[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[3]/div[1]/div[1]/div[2]/input[1]"));
        criteria4.click();
        criteriaSearch4.sendKeys("Sample Notification Method 12345");
        driver.findElement(By.xpath("//span[normalize-space()='Sample Automation Notification 12345']")).click();

    }
    public void advanceSeachWithCaseType() throws InterruptedException {
        WebElement field4 = driver.findElement(By.xpath("//*[@id='jq-dropdownautocomplete-11']/div[1]"));
        WebElement fieldSearch4 = driver.findElement(By.xpath("//*[@id='jq-dropdownautocomplete-11']/div[2]/input"));
        field4.click();
        fieldSearch4.sendKeys("Case Type");
        driver.findElement(By.xpath("//span[normalize-space()='Case Type']")).click();
        WebElement criteria4 = driver.findElement(By.xpath("//*[@id='jq-dropdownautocomplete-12']/div[1]"));
        WebElement criteriaSearch4 = driver.findElement(By.xpath("//*[@id='jq-dropdownautocomplete-12']/div[2]/input"));
        criteria4.click();
        criteriaSearch4.sendKeys("PH");
        driver.findElement(By.xpath("//span[normalize-space()='PH']")).click();
    }
    public void verifyNoResultFound(){
        wait.until(ExpectedConditions.visibilityOf(noResultFound));
        Assert.assertTrue(noResultFound.isDisplayed());
    }

    public void saveSearch(){
        wait.until(ExpectedConditions.visibilityOf(saveSearch));
        Assert.assertTrue(saveSearch.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(saveSearch)).click();
        wait.until(ExpectedConditions.elementToBeClickable(saveSearchDropdown)).click();
    }
}
