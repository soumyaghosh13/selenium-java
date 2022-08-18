package com.HRA.pageObjects;

import com.HRA.helper.Driver;
import com.HRA.helper.ExcelReadCellData;
import com.HRA.helper.ExcelReader;
import com.HRA.helper.ExcelWriter;
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
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.HRA.helper.BrowserUtilities.*;
import static com.HRA.pageObjects.ActionNewAdminRedesignPage.actual_actionName;
import static com.HRA.pageObjects.AdminGroupPage.actual_groupName;
import static com.HRA.pageObjects.EndToEndINVToERConversionPage.groupDropdownSearchBox;
import static com.HRA.pageObjects.EndToEndINVToERConversionPage.locationDropdownSearchBox;
import static com.HRA.pageObjects.LocationAdminRedesignPage.actual_parentLocationName;
import static com.HRA.pageObjects.ManagERNotificationPage.random;

public class INVCaseLegalHoldPage {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    Actions actions = new Actions(driver);
    EndToEndINVToERConversionPage endToEndINVToERConversionPage = new EndToEndINVToERConversionPage(driver);

    public INVCaseLegalHoldPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static String actual_LegalHoldCaseName;

    @FindBy(xpath = "//i[@class='fa fa-plus active tooltip']")
    WebElement addLegalHoldPlusButton;
    @FindBy(xpath = "(//input[@name='rdoHoldOn'])[2]")
    WebElement locationRadioButton;
    @FindBy(xpath = "//div[@id='innerpagepanel']//input[3]")
    WebElement groupRadioButton;
    @FindBy(xpath = "(//input[@name='rdoHoldOn'])[4]")
    WebElement caseRadioButton;
    @FindBy(xpath = "(//input[@name='rdoHoldOn'])[1]")
    WebElement profileRadioButton;
    @FindBy(xpath = "(//input[@value='Save'])[1]")
    WebElement legalHoldSaveButton;
    @FindBy(xpath = "//div[@class='child-modal__heading font-bold']")
    WebElement popUpTitleLegalHold;
    @FindBy(xpath = "//*[@id='location-tooltip']//input")
    WebElement popupClose;
    @FindBy(xpath = "//*[@id='jq-btncloseconfirm']")
    WebElement popupCloseLegal;
    @FindBy(xpath = "//div[normalize-space()='LEGAL HOLD']")
    WebElement legalHoldBanner;
    @FindBy(xpath = "(//input[@name='CaseName'])[1]")
    WebElement legalHoldCaseName;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btn-save-legalhold jq-btnvalidate']")
    WebElement saveButtonLegalHold;
    @FindBy(xpath = "//form[@id='ER-Form']//input[@name='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//div[@url='/master/GetAllGroups']//div[@class='c-form__fieldInput c-form__dropDownLink js-from-drop-down-link tree-group-button']")
    WebElement GroupSelectLegalHold;
    @FindBy(xpath = "//div[@url='/master/GetLocations']//div[@class='c-form__fieldInput c-form__dropDownLink js-from-drop-down-link tree-group-button']")
    WebElement legalHoldLocationDropdown;
    @FindBy(xpath = "//div[@class='modal-loader']")
    WebElement loader;
    @FindBy(xpath = "(//i[@class='fa fa-list-ul'])[3]")
    WebElement groupSelectINVCase;
    @FindBy(xpath = "(//i[@title='Legal Hold'])[1]")
    WebElement legalHoldGroupFlag;
    @FindBy(xpath = "(//i[@title='Legal Hold'])[2]")
    WebElement legalHoldLocationFlag;
    @FindBy(xpath = "(//span[@class='kebab'])[1]")
    WebElement gearIconInvolveParty;
    @FindBy(xpath = "//a[@class='js-tab-link is-active'][normalize-space()='Current Employee']")
    WebElement currentEmployeeTab;
    @FindBy(xpath = "//input[@class='c-form__input jq-invparty-basicsearch-searchbox ui-autocomplete-input']")
    WebElement employeeSearch;
    @FindBy(xpath = "//td[normalize-space()='Deepak']")
    WebElement employeeSeachResult;
    @FindBy(xpath = "//span[@id='Person']//i[@title='Legal Hold']")
    List<WebElement> legalHoldFlagEmployee;
    @FindBy(xpath = "//div[@class='jq-errormessage text-danger']")
    WebElement errorMessageEmployee;
    @FindBy(xpath = "//li[@class='jq-legalhold-item active']")
    WebElement employeeInList;
    @FindBy(xpath = "//div[@class='show-detailstble jq-viewPersonDetails']//span[@id='Person']")
    WebElement employeeAdded;
    @FindBy(xpath = "//a[normalize-space()='Administration']")
    WebElement adminTab;
    @FindBy(xpath = "//div[@class='c-form jq-morefield-placeholder']//div[@id='current-employee']//div[@class='jq-invparty-basicsearch-searchparty']//input[@type='text']")
    WebElement searchEmployee;
    @FindBy(id = "Person")
    WebElement addedEmployee;
    @FindBy(xpath = "(//i[@title='Legal Hold'])[3]")
    WebElement involvePartyLegalHoldFlag;
    @FindBy(xpath = "//input[@placeholder='Search Case # or Name, Employee Name or EID']")
    WebElement searchBar;
    @FindBy(xpath = "//strong[contains(text(),'+ Add Recommended Action')]")
    WebElement addRecommendedActionButton;
    @FindBy(xpath = "//select[@id='recommendedactions-CasePartiesList']")
    WebElement involvedPartyDropdown;
//    @FindBy(xpath = "(//*[@id='recommendedactions-ActionsList'])/..")
    @FindBy(xpath = "//*[@id='jq-dropdownautocomplete-7']//div[1]")
    WebElement recommendedActionDropdown;
    @FindBy(xpath = "//*[@id='bootstraphtmleditor4']")
    WebElement specificsTextArea;
    @FindBy(xpath = "(//*[@id='recommendedactions-ActionsList'])//..//input")
    WebElement recommendedActionDropdownSearchBox;
//    @FindBy(xpath = "(//*[@class='c-btn c-btn--small jq-btnsave jq-btnvalidate'])")
    @FindBy(xpath = "//*[@class='c-modal__btn']//input[@dependencygrids='recommendedactions'][1]")
    WebElement recommendedActionSaveButton;
    @FindBy(xpath = "(//input[@name='radIsOnHold'])[2]")
    WebElement offHold;
    @FindBy(xpath = "//*[@id='jq-dropdownautocomplete-6']/div[1]")
    WebElement selectActionField;
    @FindBy(xpath = "//div[@id='document-issue-event']//label[@datacolumnname='Group']/following-sibling::div")
    WebElement groupSelectDropdown;
    @FindBy(xpath = "//div[@id='document-issue-event']//span[@datacolumnname='Loc'][normalize-space()='-- Select Location --']")
    WebElement locationDropdown;
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments\\LegalHold.xlsx";


    //    need to check
//    @FindBy(xpath = "(//a[@class='jq-setaccess gridgear-delete disabled'][normalize-space()='Delete Complainant'])[1]")
    @FindBy(xpath = "//td//li[4]//a[1]")
    WebElement deleteDisble;
    //    @FindBy(xpath = "(//a[@class='jq-setaccess gridgear-edit'][normalize-space()='View / Edit Complainant'])[1]")
    @FindBy(xpath = "//tbody/tr/td/div/ul/li[3]/a[1]")
    WebElement editInvolveParty;

    @FindBy(xpath = "(//span[@id='Person'])[2]")
    WebElement nameInvolveParty;
    @FindBy(xpath = "//div[@id='involvedparty-modal']//a[@class='c-modal__close js-modal-close'][normalize-space()='X']")
    WebElement crossInvolveParty;
    @FindBy(xpath = "(//td[normalize-space()='Deepak'])[2]")
    WebElement firstEmployeeSeachResult;
    @FindBy(xpath = "(//i[@title='Legal Hold'])[2]")
    WebElement employeeLegalHoldFlag;
    @FindBy(xpath = "//select[@class='jq-legalhold-case-searchby']")
    WebElement caseDropdown;
    @FindBy(xpath = "(//input[@class='c-form__input jq-legalhold-casesearch jq-case-typeahed ui-autocomplete-input'])[1]")
    WebElement caseSearchTextArea;
    @FindBy(xpath = "//span[@class='case-name']")
    WebElement searchCaseResult;
    @FindBy(xpath = "//input[@value='Send to Decision Maker']")
    WebElement sendToDecisionMaker;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-confirm-sendToDecisoinMaker js-modal-close']")
    WebElement sendForReview;
    @FindBy(xpath = "//div[normalize-space()='I am the Decision Maker']//input[@name='CaseDecisionMakerTypeId']")
    WebElement imDecisionMaker;
    @FindBy(xpath = "//input[@class='c-btn c-btn--small jq-btnvalidate jq-blockmulticlick']")
    WebElement decisionMakerContinue;
    @FindBy(xpath = "(//input[@type='checkbox'])[21]")
    WebElement finalCheckBox;
    @FindBy(xpath = "//input[@value='Save as Final']")
    WebElement saveFinal;
    @FindBy(xpath = "//input[@value='Close Case']")
    WebElement closeCase;
    @FindBy(xpath = "//div[@class='main']//div//input[@value='Yes, Close Case']")
    WebElement caseCloseConfirm;
    @FindBy(xpath = "//span[@class='c-form__input jq-tree-input selectedtext jq-searchinput jq-AutoPopulate'][normalize-space()='-- Select Location --']")
    WebElement locationSearch;
    @FindBy(xpath = "//*[@class='jq-errormessage text-danger']")
    WebElement errorMessage;


    public String addLegalHoldCaseName() throws InterruptedException {
        int randomInt = random.nextInt(999999999);
        legalHoldCaseName.sendKeys("Auto-Legal-Hold-Case-" + randomInt);
        actual_LegalHoldCaseName = legalHoldCaseName.getAttribute("value");
        Thread.sleep(15000);
        return actual_LegalHoldCaseName;
    }

    public void fillLegalHoldData() {
        waitForElementToBeClickable(groupSelectINVCase);
        groupSelectINVCase.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + AdminGroupPage.actual_groupName + "')]"))).click();

    }

    public void verifyLegalHoldTag() {
        waitForElementToBeVisible(legalHoldBanner);
        Assert.assertTrue(legalHoldBanner.isDisplayed());
        Assert.assertEquals(legalHoldBanner.getText(), "LEGAL HOLD");
    }

    public void verifyLegalHoldFlag() {

        waitForElementToBeVisible(legalHoldGroupFlag);
        Assert.assertTrue(legalHoldGroupFlag.isDisplayed());
        waitForElementToBeVisible(legalHoldLocationFlag);
        Assert.assertTrue(legalHoldLocationFlag.isDisplayed());
        //If you add employee
//            waitForElementToBeVisible(involvePartyLegalHoldFlag);
//            Assert.assertTrue(involvePartyLegalHoldFlag.isDisplayed());

    }

    public void clickOnSave() throws InterruptedException {
        waitForElementToBeClickable(saveButton);
        saveButton.click();
        Thread.sleep(2000);
    }

    public void closePopup() {
        waitForElementToBeClickable(popupClose);
        popupClose.click();
    }

    public void administrationTabDropDownSelectSingle(String optionName) throws InterruptedException {
        Thread.sleep(5000);
        adminTab.click();
        WebElement option = driver.findElement(By.xpath("//*[text()='" + optionName + "']"));
        wait.until(ExpectedConditions.visibilityOf(option));
        actions.moveToElement(option).build().perform();
        Thread.sleep(1000);
        option.click();
        Thread.sleep(2000);
    }


    public void addNewLegalHoldGroup() throws Exception {
        String groupName = getAllExcelData("Group");
        waitForElementToBeClickable(addLegalHoldPlusButton);
        addLegalHoldPlusButton.click();
        waitForElementToBeClickable(groupRadioButton);
        groupRadioButton.click();
        waitForElementToBeClickable(GroupSelectLegalHold);
        GroupSelectLegalHold.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + groupName + "')]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonLegalHold)).click();
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            Assert.assertTrue(errorMessage.isDisplayed());
            System.out.println("Legal Hold Already Existed");
        }
        catch (Exception e) {
            System.out.println("Something Went Wrong");
        }

    }

    public void addNewLegalHoldLocation() throws Exception {
        String locationName = getAllExcelData("Location");
        waitForElementToBeClickable(addLegalHoldPlusButton);
        addLegalHoldPlusButton.click();
        waitForElementToBeClickable(locationRadioButton);
        locationRadioButton.click();
        waitForElementToBeClickable(legalHoldLocationDropdown);
        legalHoldLocationDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + locationName + "')]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonLegalHold)).click();
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            Assert.assertTrue(errorMessage.isDisplayed());
            System.out.println("Legal Hold Already Existed");
        }
        catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
    }


    public void waitForLoader() throws InterruptedException {
//        waitForInVisibility(loader, 10);
        Thread.sleep(10000);
    }

    public void checkGearEditDeleteIsDisable() {
        waitForElementToBeClickable(gearIconInvolveParty);
        gearIconInvolveParty.click();
        waitForElementToBeClickable(editInvolveParty);
        editInvolveParty.click();
        waitForElementToBeVisible(nameInvolveParty);
        Assert.assertTrue(nameInvolveParty.isDisplayed());
        boolean actualValue = deleteDisble.isEnabled();
        if (actualValue)
            System.out.println("Name is enabled");
        else
            System.out.println("Name is disabled");

        waitForElementToBeClickable(crossInvolveParty);
        crossInvolveParty.click();

        waitForElementToBeClickable(gearIconInvolveParty);
        gearIconInvolveParty.click();
        waitForElementToBeVisible(deleteDisble);
        boolean actualValue1 = deleteDisble.isEnabled();
        if (actualValue1)
            System.out.println("Delete Button is enabled");
        else
            System.out.println("Delete Button is disabled");


    }

    public void addNewLegalHoldEmployee() throws InterruptedException {
        waitForElementToBeClickable(addLegalHoldPlusButton);
        addLegalHoldPlusButton.click();
        waitForElementToBeClickable(profileRadioButton);
        profileRadioButton.click();
        Thread.sleep(1000);
        currentEmployeeTab.click();
        employeeSearch.sendKeys("Chander Deepak");
        waitForElementToBeClickable(employeeSeachResult);
        employeeSeachResult.click();
        waitForElementToBeVisible(employeeAdded);
        Assert.assertTrue(employeeAdded.isDisplayed());
        if (legalHoldFlagEmployee.size() > 0) {
            waitForElementToBeClickable(saveButtonLegalHold);
            saveButtonLegalHold.click();
            waitForElementToBeVisible(errorMessageEmployee);
            Assert.assertTrue(errorMessageEmployee.isDisplayed());
            return;
        } else {
            waitForElementToBeClickable(saveButtonLegalHold);
            saveButtonLegalHold.click();
        }

    }

    public void addLegalHoldEmployee() throws InterruptedException {
        Thread.sleep(1000);
        waitForElementToBeClickable(searchEmployee);
        searchEmployee.sendKeys("Chander Deepak");
        waitForElementToBeClickable(firstEmployeeSeachResult);
        firstEmployeeSeachResult.click();
        Thread.sleep(5000);
        waitForElementToBeVisible(addedEmployee);
        Assert.assertTrue(addedEmployee.isDisplayed());
        waitForElementToBeVisible(employeeLegalHoldFlag);
        Assert.assertTrue(employeeLegalHoldFlag.isDisplayed());


    }

    public void addNewLegalHoldCase() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(addLegalHoldPlusButton);
        addLegalHoldPlusButton.click();
        Thread.sleep(2000);
        waitForElementToBeClickable(caseRadioButton);
        caseRadioButton.click();
        waitForElementToBeClickable(caseDropdown);
        Select casedropdown = new Select(caseDropdown);
        casedropdown.selectByIndex(1);
        caseSearchTextArea.sendKeys(actual_LegalHoldCaseName);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[contains(text(),'" + actual_LegalHoldCaseName + "')])[1]")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='frmLegalHoldAdmin']/div[4]//div[2]//ul/li[1]/strong")).isDisplayed());
        waitForElementToBeClickable(saveButtonLegalHold);
        saveButtonLegalHold.click();
    }

    public void searchLegalHoldCase() throws InterruptedException {
        waitForElementToBeClickable(searchBar);
        searchBar.sendKeys(actual_LegalHoldCaseName);
        waitForElementToBeClickable(searchCaseResult);
        searchCaseResult.click();
        System.out.println("INV case converted to Legal Hold");
        closePopup();
    }

    public void closeLegalHoldCase() throws InterruptedException {
        waitForElementToBeClickable(sendToDecisionMaker);
        sendToDecisionMaker.click();
        waitForElementToBeClickable(sendForReview);
        sendForReview.click();
        waitForElementToBeClickable(imDecisionMaker);
        imDecisionMaker.click();
        waitForElementToBeClickable(decisionMakerContinue);
        decisionMakerContinue.click();
        waitForElementToBeClickable(finalCheckBox);
        finalCheckBox.click();
        waitForElementToBeClickable(saveFinal);
        saveFinal.click();
        Thread.sleep(5000);
        waitForElementToBeClickable(closeCase);
        closeCase.click();
        Thread.sleep(5000);
        waitForElementToBeClickable(caseCloseConfirm);
        caseCloseConfirm.click();
        Thread.sleep(5000);
        waitForElementToBeClickable(popupClose);
        popupClose.click();
        Thread.sleep(5000);
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

    public void selectDynamicAction() throws Exception {
        String actionName = getAllExcelData("Action");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,750)");
        Thread.sleep(3000);
        addRecommendedActionButton.click();
        TimeUnit.SECONDS.sleep(2);
        involvedPartyDropdown.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(selectActionField)).click();
        involvedPartyDropdown.sendKeys(Keys.ARROW_DOWN);
        involvedPartyDropdown.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(specificsTextArea)).click();

        wait.until(ExpectedConditions.elementToBeClickable(recommendedActionDropdown)).click();
        Thread.sleep(2000);
        recommendedActionDropdownSearchBox.sendKeys(actionName);
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

    public void addNewOffHoldGroup() throws Exception {
        String groupName = getAllExcelData("Group");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='" + groupName + "']")).click();
        Thread.sleep(2000);
        waitForElementToBeClickable(offHold);
        offHold.click();
        waitForElementToBeClickable(saveButtonLegalHold);
        saveButtonLegalHold.click();
    }

    public void addNewOffHoldLocation() throws Exception {
        String locationName = getAllExcelData("Location");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='" + locationName + "']")).click();
        Thread.sleep(2000);
        waitForElementToBeClickable(offHold);
        offHold.click();
        waitForElementToBeClickable(saveButtonLegalHold);
        saveButtonLegalHold.click();
    }

    public void addNewOffHoldEmployee() throws Exception {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Chander Deepak']")).click();
        Thread.sleep(2000);
        waitForElementToBeClickable(offHold);
        offHold.click();
        waitForElementToBeClickable(saveButtonLegalHold);
        saveButtonLegalHold.click();
    }

    public void verifyOffHold() {
        waitForElementToBeVisible(offHold);
        WebElement disableSave = driver.findElement(By.xpath("//*[@id='frmLegalHoldAdmin']/div[6]/input"));
        Assert.assertFalse(disableSave.isEnabled());
    }

    public void selectLegalHoldGroup() throws Exception {
        String groupName = getAllExcelData("Group");
        groupSelectDropdown.click();
        Thread.sleep(2000);
        groupDropdownSearchBox.click();
        Thread.sleep(2000);
        groupDropdownSearchBox.sendKeys(groupName);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + groupName + "')]"))).click();
    }

    public void selectLegalHoldLocation() throws Exception {
        String locationName = getAllExcelData("Location");
        locationDropdown.click();
        Thread.sleep(2000);
        locationDropdownSearchBox.click();
        Thread.sleep(2000);
        locationDropdownSearchBox.sendKeys(locationName);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='c-form__field']//div[contains(text(),'" + locationName + "')]"))).click();
        Thread.sleep(3000);
    }

    public void writeLegalHoldDataInExcel() throws IOException {
        String[] valueToWrite = {actual_groupName, actual_parentLocationName, actual_actionName};
//        String[] valueToWrite = {"Admin Group - B","Delhi1","Action For HR"};
        ExcelWriter objExcelFile = new ExcelWriter();
        objExcelFile.writeExcel(System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments", "LegalHold.xlsx", "sheet", valueToWrite);
        System.out.println("Excel Write Done Successfully");
        ExcelReader exfile = new ExcelReader();
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataAndAttachments";
        exfile.readExcel(filePath, "LegalHold.xlsx", "sheet");

    }
}
