package com.HRA.pageObjects;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import com.HRA.helper.ExcelReadCellData;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;

import static com.HRA.helper.BrowserUtilities.waitForElementToBeClickable;
import static com.HRA.helper.BrowserUtilities.waitForElementToBeVisible;
import static com.HRA.pageObjects.TagManagementPage.actual_tagName;

public class EndToEndINVToERConversionPage {
    WebDriver driver = Driver.getDriver();

    public EndToEndINVToERConversionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    static String firstName = "Soumya";
    static String groupINV;
    static String locationINV;
    static String caseNameINV;
    static String notificationINV;
    Random random = new Random();
    @FindBy(xpath = "(//input[@name='RoleValue'])[2]")
    WebElement subjectRadioButton;
    @FindBy(xpath = "(//a[@data-tab='formel-employee'][normalize-space()='Former Employee'])[1]")
    WebElement formerEmployeeTab;
    @FindBy(xpath = "(//input[@name='select-menual'])[2]")
    WebElement manualEntryRadioButton;
    @FindBy(xpath = "(//input[@id='ExternalFirstName'])[1]")
    WebElement firstNameTextArea;
    @FindBy(xpath = "(//input[@id='ExternalLastName'])[1]")
    WebElement lastNameTextArea;
    @FindBy(xpath = "(//input[@id='ExternalTitle'])[1]")
    WebElement titleTextArea;
    @FindBy(xpath = "(//input[@id='ExternalEmail'])[1]")
    WebElement emailTextArea;
    @FindBy(xpath = "(//input[@id='ExternalPhone'])[1]")
    WebElement phoneTextArea;
    @FindBy(xpath = "(//input[@name='RoleValue'])[3]")
    WebElement witnessRadioButton;
    @FindBy(xpath = "(//a[@data-tab='other-employee'][normalize-space()='Other'])[1]")
    WebElement otherTab;
    @FindBy(xpath = "(//select[@id='ER-RelationList'])[1]")
    WebElement relationshipDropdown;
    @FindBy(xpath = "(//input[@id='ExternalFirstName'])[2]")
    WebElement witnessfirstNameTextArea;
    @FindBy(xpath = "(//input[@id='ExternalLastName'])[2]")
    WebElement witnesslastNameTextArea;
    @FindBy(xpath = "(//input[@id='ExternalTitle'])[2]")
    WebElement witnesstitleTextArea;
    @FindBy(xpath = "(//input[@id='ExternalEmail'])[2]")
    WebElement witnessemailTextArea;
    @FindBy(xpath = "(//input[@id='ExternalPhone'])[2]")
    WebElement witnessphoneTextArea;
    @FindBy(xpath = "(//strong[contains(text(),'+ Add Involved Party')])[1]")
    WebElement addInvolvePartyButton;
    @FindBy(xpath = "//a[@class='jq-addnewdetails jq-btnsaveanother-ddl'][normalize-space()='Subject']")
    WebElement subjectButton;
    @FindBy(xpath = "//a[@class='jq-addnewdetails jq-btnsaveanother-ddl'][normalize-space()='Witness']")
    WebElement witnessButton;
    @FindBy(xpath = "//div[@modulename='involvedparty']//div[@id='formel-employee']//div[@class='jq-invparty-basicsearch-searchparty']//input[@type='text']")
    WebElement employeeSearchBox;
    @FindBy(xpath = "(//td[contains(text(),'Paramita M1')])[1]")
    WebElement searchResult;
    @FindBy(xpath = "//textarea[@name='AdditionalInfo']")
    WebElement additionalContactInfo;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate']")
    WebElement saveButton;
    @FindBy(xpath = "//span[normalize-space()='Paramita']")
    WebElement involvePartyName1;
    @FindBy(xpath = "//span[normalize-space()='Soumya']")
    WebElement involvePartyName2;
    @FindBy(xpath = "//div[@modulename='involvedparty']//div[@id='current-employee']//div[@class='jq-invparty-basicsearch-searchparty']//input[@type='text']")
    WebElement witnessSearchBox;
    @FindBy(xpath = "//*[@class='ui-menu-item'][2]")
    WebElement witnessSearchResult;
    //    @FindBy(xpath = "//div[@id='document-issue-event']//span[@datacolumnname='Group'][normalize-space()='-- Select Group --']")
    @FindBy(xpath = "//div[@id='document-issue-event']//label[@datacolumnname='Group']/following-sibling::div")
    WebElement groupSelectDropdown;

    @FindBy(xpath = "//div[@id='document-issue-event']//label[@datacolumnname='Group']/following-sibling::div//input[@placeholder='Search']")
    public static WebElement groupDropdownSearchBox;

    @FindBy(xpath = "//*[@id='jq-dropdownautocomplete-1']/div[1]")
    WebElement intermActionDropdown;
    @FindBy(xpath = "//select[@id='relevantpolicy-PolicieGuidelineList']")
    WebElement policyGuidelineDropdown;
    @FindBy(xpath = "//div[@class='c-modal__content']//textarea[@placeholder='Enter specifics about this document.']")
    WebElement policyTextarea;
    @FindBy(xpath = "//div[@id='document-issue-event']//span[@datacolumnname='Loc'][normalize-space()='-- Select Location --']")
    WebElement locationDropdown;

    @FindBy(xpath = "//div[@id='document-issue-event']//label[@datacolumnname='Loc']/following-sibling::div//input[@placeholder='Search']")
    public static WebElement locationDropdownSearchBox;

    @FindBy(xpath = "//div[@isloaded='true']//span[2]//input[1]")
    WebElement policyNowOption;
    @FindBy(xpath = "(//div[@class='c-modal__content']//form[@class='file_upload']//div[@class='c-form__field jq-documenttab-content hide jq-formpanel']//div[@class='c-form__fieldInput c-form__dropDownLink js-from-drop-down-link tree-group-button'])[2]")
    WebElement policyUpload;
    @FindBy(xpath = "//div[@id='jq-documentuploadpanel']//div[4]//div[2]")
    WebElement documentPanel;
    @FindBy(xpath = "//div[@class='c-modal__content']//form[@class='file_upload']//input[@id='jq-btnsavedocument']")
    WebElement policyUploadButton;
    @FindBy(xpath = "//div[@class='c-form jq-morefield-placeholder']//div[@id='current-employee']//div[@class='jq-invparty-basicsearch-searchparty']//input[@type='text']")
    WebElement currentEmployeeSearchBox;
    @FindBy(xpath = "(//li[@class='ui-menu-item'])[2]")
    WebElement employeeSearchResult;
    @FindBy(xpath = "//div[@modulename='interimactions']//select[@name='CasePartiesValue']")
    WebElement involvePartyDropdown;
    @FindBy(xpath = "//div[@class='js-tab-content']//div[@class='c-modal__btn']//input[@value='Continue']")
    WebElement continueButton;
    @FindBy(xpath = "//div[@class='dynamic-modal-content']//input[@value='Continue']")
    WebElement continueConfirmationButton;
    @FindBy(xpath = "//div[@class='c-form jq-morefield-placeholder']//span[contains(text(),'Show Advanced Search')]")
    WebElement advanceSearchButton;
    @FindBy(xpath = "//div[@id='current-employee']//div[@class='jq-invparty-advancesearch-fields']//div[1]//div[1]//div[1]//input[1]")
    WebElement employeeID;
    @FindBy(xpath = "//td[normalize-space()='2657687']")
    WebElement searchResultEmployeeID;
    @FindBy(xpath = "//body/div[@id='document-issue-event']/div/div[@case-type-prefix='ER-']/form[@id='ER-Form']/div[1]")
    WebElement addedResult;
    @FindBy(xpath = "(//input[@value='See Results'])[1]")
    WebElement seeResultButton;
    @FindBy(xpath = "(//a[@data-tab='current-employee'][normalize-space()='Current Employee'])[1]")
    WebElement currentEmployeeTab;
    @FindBy(xpath = "//a[@href='#!'][normalize-space()='Clear All Filter']")
    WebElement clearAllButton;
    @FindBy(xpath = "(//i[@class='fa fa-list-ul icon--blue'])[1]")
    WebElement locationDropdownAdvanceSearch;
    @FindBy(xpath = "//div[contains(text(),'Andhra Pradesh')]")
    WebElement sampleLocationWithEmployee;
    @FindBy(xpath = "//td[normalize-space()='Chelsa']")
    WebElement employeeResultLocation;
    @FindBy(xpath = "//div[@class='c-casesNumber jq-master-casenumber']")
    WebElement caseNumber;
    @FindBy(xpath = "//a[@class='c-casesDetail__infoLink caseCreateEditLink jq-setaccess']")
    WebElement editButtonINVCase;

    @FindBy(xpath = "//div[@id='document-issue-event']//label[@datacolumnname='Group']/following-sibling::div")
    WebElement editGroupDropdown;

    @FindBy(xpath = "//div[@id='document-issue-event']//label[@datacolumnname='Loc']/following-sibling::div")
    WebElement editLocationDropdown;
    @FindBy(xpath = "//div[@class='c-form jq-morefield-placeholder']//div[@class='ddl-ac-selected']")
    WebElement editNotificationDropdown;
    @FindBy(xpath = "//div[@class='c-form jq-morefield-placeholder']//input[@name='CaseName']")
    WebElement editCaseName;
    @FindBy(xpath = "//textarea[@class='auto-expands-textarea jq-auto-expands-textarea jq-customattrinput c-form__input']")
    WebElement editAutOExpand;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small caseCreateEditFormSubmit jq-btnvalidate jq-blockmulticlick jq-queue-saveandgo']")
    WebElement editSave;
    @FindBy(xpath = "//div[@class='c-form jq-morefield-placeholder']//input[@placeholder='Search']")
    WebElement editNotificationSearch;
    @FindBy(xpath = "//span[contains(text(),'AA')]")
    WebElement staticNotificationData;
    @FindBy(xpath = "//input[@class='jq-search-input-tree']")
    WebElement editGroupSearch;
    @FindBy(xpath = "//div[contains(text(),'Administration Genoa')]")
    WebElement staticGroupData;
    @FindBy(xpath = "//div[@module='locationtree']//input[@placeholder='Search']")
    WebElement editLocationSearch;
    @FindBy(xpath = "//div[contains(text(),'Andhra Pradesh')]")
    WebElement staticLocationData;
    @FindBy(xpath = "//a[normalize-space()='Administration Genoa']")
    WebElement staticGroupDataResult;
    @FindBy(xpath = "//a[@class='cursor-pointer add-tag jq-add-tag'][normalize-space()='Andhra Pradesh']")
    WebElement staticLocationDataResult;
    @FindBy(xpath = "(//*[@id='innerpagepanel']//h4)[1]")
    WebElement caseNameResult;
    @FindBy(xpath = "//div[@class='c-casesDetail__infoArea']//div[@class='o-grid__row']//div[1]//span[1]")
    WebElement headerGroupINV;
    @FindBy(xpath = "//div[@class='c-casesDetail__infoArea']//div[4]//span[1]")
    WebElement headerLocationINV;
    @FindBy(xpath = "//div[@class='c-casesDetail__infoArea']//div[6]//span[1]")
    WebElement headerNotificationINV;
    @FindBy(xpath = "//*[@id='divcasedetailheader']//a/strong")
    WebElement addTagButton;
    @FindBy(xpath = "//div[@select-control='testmultiselect']//div[1]")
    WebElement tagDropdown;
    @FindBy(xpath = "//div[@select-control='testmultiselect']//div//input[@placeholder='Search']")
    WebElement tagSearchTextArea;
    @FindBy(xpath = "//input[@id='btnAddCaseTag']")
    WebElement tagSaveButton;
    
    @FindBy(xpath = "//div[@id='intakesummary-modal']//div[@class='ddl-group-tree']//input[@placeholder='Search']")
    WebElement issuecategoryDropdownSearchBox;

    @FindBy(xpath = "//div[@modulename='interimactions']//input[@placeholder='Search']")
    WebElement interActionSearch;


    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\WriteExcel.xlsx";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public void selectDynamicNotificationMethod() throws Exception {
        String notificationName = getAllExcelData("Notification Method");
        Thread.sleep(2000);
        BrowserUtilities.waitForElementToBeClickable(editNotificationDropdown);
        editNotificationDropdown.click();
        BrowserUtilities.waitForElementToBeClickable(editNotificationSearch);
        editNotificationSearch.click();
        Thread.sleep(2000);
        editNotificationSearch.sendKeys(notificationName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'" + notificationName + "')]")).click();
        Thread.sleep(4000);

        //The following click action does not have any effect on the test case. We added that to preven the
        // double click on the notification method that causes test to fail
        editCaseName.click();
//        Actions actions = new Actions(Driver.getDriver());
//        actions.sendKeys(Keys.TAB).build().perform();
    }

    public void selectDynamicGroup() throws Exception {
        String groupName = getAllExcelData("Group");
        groupSelectDropdown.click();
        Thread.sleep(2000);
        groupDropdownSearchBox.click();
        Thread.sleep(2000);
        groupDropdownSearchBox.sendKeys(groupName);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + groupName + "')]"))).click();
    }

    public void selectDynamicLocation() throws Exception {
        String locationName = getAllExcelData("Location");
        locationDropdown.click();
        Thread.sleep(2000);
        locationDropdownSearchBox.click();
        Thread.sleep(2000);
        locationDropdownSearchBox.sendKeys(locationName);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + locationName + "')]"))).click();
        Thread.sleep(3000);
    }

    public void selectDynamicIssueCategory() throws Exception {
        String categoryName = getAllExcelData("Issue Category");
        String childCategoryName = getAllExcelData("Child Issue Category");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//form[@name='frmaddissue']//div[@class='c-form__fieldInput c-form__dropDownLink js-from-drop-down-link tree-group-button']")).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + categoryName + "'" + "])/../div[1]"))).click();
        //Thread.sleep(2000);
        issuecategoryDropdownSearchBox.click();
        Thread.sleep(2000);
        issuecategoryDropdownSearchBox.sendKeys(childCategoryName);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[.=" + "'" + childCategoryName + "'" + "])"))).click();
        Thread.sleep(2000);
    }

    public void selectDynamicInterimAction() throws Exception {
        String interimActionName = getAllExcelData("Interim Action");
        BrowserUtilities.waitForElementToBeClickable(intermActionDropdown);
        Select involvePartylist = new Select(involvePartyDropdown);
        involvePartylist.selectByIndex(1);
        BrowserUtilities.waitForElementToBeClickable(intermActionDropdown);
        intermActionDropdown.click();
        Thread.sleep(2000);
        interActionSearch.sendKeys(interimActionName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'" + interimActionName + "')]")).click();
        Thread.sleep(2000);

    }

    public void selectDynamicPolicy() throws Exception {
        String policyGuidelineName = getAllExcelData("Policy Guideline");
        Select policy = new Select(policyGuidelineDropdown);
        policy.selectByVisibleText(policyGuidelineName);
        BrowserUtilities.waitForElementToBeClickable(policyTextarea);
        policyTextarea.click();
        policyTextarea.sendKeys("This is policy of the company");
        Thread.sleep(2000);
        boolean policyDoc;
        policyDoc = policyNowOption.isSelected();
        if (policyDoc) {

        } else {
            policyNowOption.click();
        }
        BrowserUtilities.waitForElementToBeClickable(policyUpload);
        policyUpload.click();
        BrowserUtilities.waitForElementToBeClickable(documentPanel);
        documentPanel.click();
   /*   Select doc = new Select(driver.findElement(By.xpath("//div[@class='c-modal__content']//form[@class='file_upload']//select[@id='DocumentLibrary']")));
      doc.selectByIndex(6); */
        BrowserUtilities.waitForElementToBeClickable(policyUploadButton);
        policyUploadButton.click();
        driver.findElement(By.xpath("//div[@isloaded='true']//span[2]//input[1]")).click();
    }


    public void selectSubjectFormerEmployee() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(subjectRadioButton);
        subjectRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(formerEmployeeTab);
        formerEmployeeTab.click();
        BrowserUtilities.waitForElementToBeClickable(manualEntryRadioButton);
        manualEntryRadioButton.click();

    }

    public void fillManualEntryFormerEmployee() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(firstNameTextArea);
        firstNameTextArea.sendKeys(firstName);
        BrowserUtilities.waitForElementToBeClickable(lastNameTextArea);
        lastNameTextArea.sendKeys("Ghosh");
        BrowserUtilities.waitForElementToBeClickable(titleTextArea);
        titleTextArea.sendKeys("Automation Tester");
        BrowserUtilities.waitForElementToBeClickable(emailTextArea);
        emailTextArea.sendKeys("sghosh@chenoainc.com");
        BrowserUtilities.waitForElementToBeClickable(phoneTextArea);
        phoneTextArea.sendKeys("9876543210");

    }

    public void selectWitness() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(witnessRadioButton);
        witnessRadioButton.click();
        BrowserUtilities.waitForElementToBeClickable(otherTab);
        otherTab.click();
    }

    public void selectDynamicRelationship() throws Exception {
        String relationshipName = getAllExcelData("Relationship");
        BrowserUtilities.waitForElementToBeClickable(relationshipDropdown);
        Select relationdropdown = new Select(relationshipDropdown);
        relationdropdown.selectByVisibleText(relationshipName);
    }

    public void fillWitnessForm() throws InterruptedException {

        BrowserUtilities.waitForElementToBeClickable(witnessfirstNameTextArea);
        witnessfirstNameTextArea.sendKeys(firstName);
        BrowserUtilities.waitForElementToBeClickable(witnesslastNameTextArea);
        witnesslastNameTextArea.sendKeys("Ghosh");
        BrowserUtilities.waitForElementToBeClickable(witnesstitleTextArea);
        witnesstitleTextArea.sendKeys("Automation Tester");
        BrowserUtilities.waitForElementToBeClickable(witnessemailTextArea);
        witnessemailTextArea.sendKeys("sghosh@chenoainc.com");
        BrowserUtilities.waitForElementToBeClickable(witnessphoneTextArea);
        witnessphoneTextArea.sendKeys("9876543210");

    }

    public void addSubjectFromInvolveParties() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(addInvolvePartyButton);
        addInvolvePartyButton.click();
        BrowserUtilities.waitForElementToBeClickable(subjectButton);
        subjectButton.click();
        BrowserUtilities.waitForElementToBeClickable(formerEmployeeTab);
        formerEmployeeTab.click();
        Thread.sleep(2000);
        BrowserUtilities.waitForElementToBeClickable(employeeSearchBox);
        employeeSearchBox.sendKeys("Paramita");
        Thread.sleep(2000);
        BrowserUtilities.waitForElementToBeClickable(searchResult);
        searchResult.click();
        BrowserUtilities.waitForElementToBeClickable(additionalContactInfo);
        additionalContactInfo.sendKeys("This is generated during automation script run");
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        saveButton.click();
        try {
            WebElement closepopup = driver.findElement(By.xpath("//h4[contains(text(),'More Information')]"));
            wait.until(ExpectedConditions.visibilityOf(closepopup));
            if (closepopup.isDisplayed()) {
                driver.findElement(By.xpath("//h4[contains(text(),'More Information')]/../a")).click();
            }
        } catch (Exception e) {
        }
    }

    public void verifyInvolvePartyAdded() {
        waitForElementToBeVisible(involvePartyName1);
        Assert.assertEquals(involvePartyName1.getText(), "Paramita");
        waitForElementToBeVisible(involvePartyName2);
        Assert.assertEquals(involvePartyName2.getText(), firstName);
    }

    public void addWitnessFromInvolveParty() throws InterruptedException {
        Thread.sleep(1000);
        BrowserUtilities.waitForElementToBeClickable(addInvolvePartyButton);
        addInvolvePartyButton.click();
        BrowserUtilities.waitForElementToBeClickable(witnessButton);
        witnessButton.click();
        BrowserUtilities.waitForElementToBeClickable(witnessSearchBox);
        Thread.sleep(1000);
        witnessSearchBox.sendKeys("Paramita");
        Thread.sleep(1000);
        witnessSearchResult.click();
        Thread.sleep(1000);
        additionalContactInfo.sendKeys("This is generated during automation script run");
        BrowserUtilities.waitForElementToBeClickable(saveButton);
        saveButton.click();
        try {
            WebElement closepopup = driver.findElement(By.xpath("//h4[contains(text(),'More Information')]"));
            wait.until(ExpectedConditions.visibilityOf(closepopup));
            if (closepopup.isDisplayed()) {
                driver.findElement(By.xpath("//h4[contains(text(),'More Information')]/../a")).click();
            }
        } catch (Exception e) {
        }
    }

    public void addComplainant() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", currentEmployeeSearchBox);
        Thread.sleep(500);
        BrowserUtilities.waitForElementToBeClickable(currentEmployeeSearchBox);
        currentEmployeeSearchBox.sendKeys("Paramita");
        Thread.sleep(2000);
        driver.findElements(By.xpath("//li[@class='ui-menu-item']//tbody/tr[1]/td[1]")).get(0).click();
    }

    public void acceptContinuePopup() throws InterruptedException {
        Thread.sleep(1000);
        BrowserUtilities.waitForElementToBeClickable(continueButton);
        continueButton.click();
        BrowserUtilities.waitForElementToBeClickable(continueConfirmationButton);
        continueConfirmationButton.click();
        Thread.sleep(2000);

    }

    public void addUserAdvanceSearchLocation() throws InterruptedException {
        currentEmployeeTab.click();
        BrowserUtilities.waitForElementToBeClickable(advanceSearchButton);
        advanceSearchButton.click();
        BrowserUtilities.waitForElementToBeClickable(locationDropdownAdvanceSearch);
        locationDropdownAdvanceSearch.click();
        BrowserUtilities.waitForElementToBeClickable(sampleLocationWithEmployee);
        sampleLocationWithEmployee.click();
        BrowserUtilities.waitForElementToBeClickable(seeResultButton);
        seeResultButton.click();
        BrowserUtilities.waitForElementToBeClickable(employeeResultLocation);
        Assert.assertTrue(employeeResultLocation.isDisplayed());
        employeeResultLocation.click();
        System.out.println("Advance Search By Location successfully done");

    }

    public void addUserAdvanceSearchID() throws InterruptedException {
        currentEmployeeTab.click();
        BrowserUtilities.waitForElementToBeClickable(advanceSearchButton);
        advanceSearchButton.click();
        BrowserUtilities.waitForElementToBeClickable(employeeID);
        employeeID.sendKeys("2657687");
        BrowserUtilities.waitForElementToBeClickable(seeResultButton);
        seeResultButton.click();
        BrowserUtilities.waitForElementToBeClickable(searchResultEmployeeID);
        Assert.assertTrue(searchResultEmployeeID.isDisplayed());
        searchResultEmployeeID.click();
        Assert.assertTrue(addedResult.isDisplayed());
        System.out.println("Advance Search By ID successfully done");
    }

    public void verifyINVToERConversion() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeVisible(caseNumber);
        Assert.assertTrue(caseNumber.getText().contains("ER"));
    }

    public void verifyINVCaseCreated() {
        waitForElementToBeVisible(caseNumber);
        Assert.assertTrue(caseNumber.getText().contains("INV"));
    }

    public void editINVCase() throws InterruptedException {
        BrowserUtilities.waitForElementToBeClickable(editButtonINVCase);
        editButtonINVCase.click();
        Thread.sleep(5000);
        BrowserUtilities.waitForElementToBeClickable(editCaseName);
        editCaseName.clear();
        editCaseName.sendKeys("Automation Case Edit - " + random.nextInt());

        BrowserUtilities.waitForElementToBeClickable(editNotificationDropdown);
        editNotificationDropdown.click();
        BrowserUtilities.waitForElementToBeClickable(editNotificationSearch);
        editNotificationSearch.click();
        editNotificationSearch.sendKeys("AA");
        BrowserUtilities.waitForElementToBeClickable(staticNotificationData);
        staticNotificationData.click();

        BrowserUtilities.waitForElementToBeClickable(editGroupDropdown);
        editGroupDropdown.click();
        BrowserUtilities.waitForElementToBeClickable(editGroupSearch);
        editGroupSearch.click();
        BrowserUtilities.waitForElementToBeClickable(staticGroupData);
        staticGroupData.click();

        BrowserUtilities.waitForElementToBeClickable(editLocationDropdown);
        editLocationDropdown.click();
        BrowserUtilities.waitForElementToBeClickable(editLocationSearch);
        editLocationSearch.click();
        BrowserUtilities.waitForElementToBeClickable(staticLocationData);
        staticLocationData.click();

        BrowserUtilities.waitForElementToBeClickable(editAutOExpand);
        editAutOExpand.sendKeys("Auto" + random.nextInt());

        BrowserUtilities.waitForElementToBeClickable(editSave);
        editSave.click();
        Thread.sleep(2000);
    }

    public void verifyEdit() {
        BrowserUtilities.waitForElementToBeVisible(caseNameResult);
        Assert.assertTrue(caseNameResult.getText().contains("Automation Case Edit"));
        Assert.assertNotEquals(caseNameResult.getText(), caseNameINV);
        BrowserUtilities.waitForElementToBeVisible(headerGroupINV);
        Assert.assertTrue(headerGroupINV.isDisplayed());
        Assert.assertNotEquals(headerGroupINV.getText(), groupINV);
        BrowserUtilities.waitForElementToBeVisible(headerLocationINV);
        Assert.assertTrue(headerLocationINV.isDisplayed());
        Assert.assertNotEquals(headerLocationINV.getText(), locationINV);
        BrowserUtilities.waitForElementToBeVisible(headerNotificationINV);
        Assert.assertTrue(headerNotificationINV.isDisplayed());
        Assert.assertNotEquals(headerNotificationINV.getText(), notificationINV);

    }

    public void verifyINVCaseCreate() throws Exception {
        String locationName = getAllExcelData("Location");
        String groupName = getAllExcelData("Group");
        String notificationName = getAllExcelData("Notification Method");

        BrowserUtilities.waitForElementToBeVisible(caseNameResult);
        caseNameINV = caseNameResult.getText();
        Assert.assertTrue(caseNameResult.getText().contains("Auto - Investigation Case"));
        BrowserUtilities.waitForElementToBeVisible(headerGroupINV);
        groupINV = headerGroupINV.getText();
        Assert.assertTrue(headerGroupINV.isDisplayed());
        Assert.assertTrue(headerGroupINV.getText().contains(groupName));
        BrowserUtilities.waitForElementToBeVisible(headerLocationINV);
        locationINV = headerLocationINV.getText();
        Assert.assertTrue(headerLocationINV.isDisplayed());
        Assert.assertTrue(headerLocationINV.getText().contains(locationName));
        BrowserUtilities.waitForElementToBeVisible(headerNotificationINV);
        notificationINV = headerNotificationINV.getText();
        Assert.assertTrue(headerNotificationINV.isDisplayed());
        Assert.assertTrue(headerNotificationINV.getText().contains(notificationName));
    }

    public void addTagINVCaseHeader() throws Exception {
        String tagName = getAllExcelData("Tag Management");
        waitForElementToBeClickable(addTagButton);
        addTagButton.click();
        waitForElementToBeClickable(tagDropdown);
        tagDropdown.click();
        waitForElementToBeClickable(tagSearchTextArea);
        tagSearchTextArea.sendKeys(tagName);
        driver.findElement(By.xpath("//span[normalize-space()='" + tagName + "']")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Tags']")).click();
        waitForElementToBeClickable(tagSaveButton);
        tagSaveButton.click();
    }

    public void verifyTagINVCaseHeader() throws Exception {
        String tagName = getAllExcelData("Tag Management");
        waitForElementToBeClickable(addTagButton);
        Assert.assertTrue(driver.findElement(By.xpath("//li[@title='" + tagName + "']")).isDisplayed());
    }

    public String getAllExcelData(String arg) throws Exception {
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
}
