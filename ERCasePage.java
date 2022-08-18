package com.HRA.pageObjects;

import static com.HRA.helper.Driver.getDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import com.HRA.helper.Driver;
import com.HRA.helper.HighlightElementManager;
import com.HRA.stepdefinitions.ERProductionStepDef;

public class ERCasePage extends BrowserUtilities {

	WebDriver driver = Driver.getDriver();
    public ERCasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    EndToEndINVToERConversionPage ETEINVTOER = new EndToEndINVToERConversionPage(driver);
    
    public static String actual_ActionSpecifics;
    public static String expected_ActionSpecifics;
    public static String actual_IssueDetailsAdded;
    public static String expected_IssueDetailsAdded;
    public static String actual_Action;
    public static String expected_Action;
    public static String actual_IssueCategory;
    public static String expected_IssueCategory;
    Random random = new Random();
    int randomInt = random.nextInt(9999999);
    
    @FindBy(xpath = "//strong[contains(text(),'+ Add Action')]")
    WebElement actionSelect;
    
    @FindBy(xpath = "//div[@id='interimactions-modal']//input[@value='Save']")
    WebElement ActionSaveButton;
    
    @FindBy(xpath = "//div[@id='interimactions-modal']//div[@id=\"jq-dropdownautocomplete-3\"]//span[@class='ddl-ac-text']")
    private WebElement SelectActionField;

    @FindBy(xpath = "//div[@id='interimactions-modal']//div[@id=\"jq-dropdownautocomplete-3\"]//input[@placeholder='Search']")
    public WebElement searchBoxInAddActions;
    
    @FindBy(xpath = "//textarea[@id='interimactions-BriefRationale']")
    private WebElement actionSpecifics;
    
    @FindBy(xpath = "//table[@id='interimactions']//span[@class='kebab']")
    private WebElement editActionGearIcon;
    
    @FindBy(xpath = "//table[@id='interimactions']//a[@class='jq-setaccess gridgear-edit']")
    private WebElement editActionLink;
    
    @FindBy(xpath = "//table[@id='interimactions']//td[8]")
    private WebElement expectedActionSpecifics;
    
    @FindBy(xpath = "//table[@id='interimactions']//a[@class='jq-setaccess gridgear-delete']")
    private WebElement deleteActionLink;
    
    @FindBy(xpath = "//input[@id='jq-btnconfirmalert']")
    private WebElement deleteButton;
    
    @FindBy(xpath = "//div[@id='refreshCaseIsssuesDetail']//div[@class='bootstraphtmleditor jhtc-hide']")
    private WebElement addIssueDetails;
    
    @FindBy(xpath = "//table[@id='issuesdetail']//input[@value='Save']")
    private WebElement saveIssueDetailsButton;    
    
    @FindBy(xpath = "//tr[@class='c-table__evenRow']//div[@class='c-editor-content']")
    private WebElement expectedaddedIssueDetails;
    
    @FindBy(xpath = "//table[@id='issuesdetail']//div[@class='c-edit js-edit floatright']")
    private WebElement editIssueDetailsGearIcon;
    
    @FindBy(xpath = "//table[@id='issuesdetail']//a[@class='jq-setaccess gridgear-issue-edit']")
    private WebElement editIssueDetailsLink;
    
    @FindBy(xpath = "//table[@id='issuesdetail']//a[@class='jq-setaccess gridgear-issue-delete']")
    private WebElement deleteIssueDetailLink; 
    
    @FindBy(xpath = "//table[@id='ercontributors']//span[@class='kebab']")
    private WebElement CaseTeamGearIcon;
    
    @FindBy(xpath = "//table[@id='ercontributors']//a[@class='jq-setaccess gridgear-assignto']")
    private WebElement assignToLink;
    
    @FindBy(xpath = "//div[@id='casereassign-modal']//input[@id='txtPerson']")
    private WebElement newCaseOwnerTextbox;
    
    @FindBy(xpath = "//input[@id='jq-btnReassignCase']")
    private WebElement savenewCaseOwnerButton;   
    
    @FindBy(xpath = "//div[@id='modal-confirm-alert']//label[@class='jq-confirmmodal-msg']")
    private WebElement changeCaseOwnerConfirmationMessage;
    
    @FindBy(xpath = "//table[@id='interimactions']//span[@class='cursor-pointer add-tag jq-add-tag']")
    private WebElement actualActionClicked;
    
    @FindBy(xpath = "//div[@id='divActionSelectedTags']//li/..")
    private WebElement expectedActioninFilter;
    
    @FindBy(xpath = "//table[@id='intakesummary']//span[@class='cursor-pointer add-tag jq-add-tag']")
    private WebElement actualIssueClicked;
    
    @FindBy(xpath = "//div[@id='divIssueSelectedTags']//li/..")
    private WebElement expectedIssueinFilter;
    
    @FindBy(xpath = "//strong[contains(text(),'+ Add Team Member')]")
    private WebElement addTeamMember;
    
    @FindBy(xpath = "//div[@id='ercontributors-modal']//div[@class='c-form__fieldInput']//input")
    private WebElement personTextbox;
    
    @FindBy(xpath = "//div[@id='ercontributors-modal']//input[@value='Save']")
    private WebElement teamContributorSaveButton;
    
    @FindBy(xpath = "//div[@id='addContributorWarning-modal']//input[@type='button']")
    private WebElement confirmPopup;
    
    @FindBy(xpath = "//input[@id='search-field']")
    private WebElement searchCaseNumber;
    
    @FindBy(xpath = "//td[@class=\"jq-caseownertooltip\"]")
    public static WebElement expectedCaseOwnerER;
    
    @FindBy(xpath = "//button[contains(@class,'c-search__formSubmit')]")
    public static WebElement searchIcon;
    
    @FindBy(xpath = "//a[@class=\"anc jq-RedirectCases\"]")
    public static List<WebElement> caseNumber;

    public void SelectActionsMethod() throws Exception {
    	String actionName = ETEINVTOER.getAllExcelData("Action");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,750)");
        actionSelect.click();
        Thread.sleep(2000);
        waitForClickablility(SelectActionField,10);
        SelectActionField.click();
        searchBoxInAddActions.sendKeys(actionName);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[.=" + "'" + actionName + "'" + "])[1]"))).click();
        actionSpecifics.sendKeys("Involved Party Commuincated"+randomInt);
        actual_ActionSpecifics = actionSpecifics.getAttribute("value");
        ActionSaveButton.click();
        try {
            WebElement closepopup = driver.findElement(By.xpath("//h4[contains(text(),'More Information')]"));
            waitForVisibility(closepopup,5);
            if (closepopup.isDisplayed()) {
                driver.findElement(By.xpath("//h4[contains(text(),'More Information')]/../a")).click();
            }
        } catch (Exception e) {

        }
        TimeUnit.SECONDS.sleep(2);
        expected_ActionSpecifics=expectedActionSpecifics.getText().trim();
    	Assert.assertEquals(actual_ActionSpecifics, expected_ActionSpecifics);

    }
    
    public void editActionMethod() throws InterruptedException {
    	waitForClickablility(editActionGearIcon,15);
    	Thread.sleep(2000);
    	editActionGearIcon.click();
    	editActionLink.click();
    	actionSpecifics.click();
    	actionSpecifics.sendKeys("Involved Party Commuincated"+randomInt);
    	actual_ActionSpecifics = actionSpecifics.getAttribute("value");
    	TimeUnit.SECONDS.sleep(2);
    	ActionSaveButton.click();
    	 try {
             WebElement closepopup = driver.findElement(By.xpath("//h4[contains(text(),'More Information')]"));
             waitForVisibility(closepopup,5);
             if (closepopup.isDisplayed()) {
                 driver.findElement(By.xpath("//h4[contains(text(),'More Information')]/../a")).click();
             }
         } catch (Exception e) {

         }
    	 TimeUnit.SECONDS.sleep(2);
         expected_ActionSpecifics=expectedActionSpecifics.getText().trim();
     	 Assert.assertEquals(actual_ActionSpecifics, expected_ActionSpecifics);
    }
    
    public void deleteActionMethod() throws InterruptedException {
    	waitForClickablility(editActionGearIcon,15);
    	Thread.sleep(2000);
    	editActionGearIcon.click();
    	deleteActionLink.click();
    	deleteButton.click();
    }
    
    public void addIssueDetailsMethod() throws InterruptedException {
    	waitForClickablility(addIssueDetails,10);
        addIssueDetails.click();
        addIssueDetails.sendKeys("Issue Details Added"+randomInt);
        actual_IssueDetailsAdded =  addIssueDetails.getText().trim();
        waitForElementToBeClickable(saveIssueDetailsButton);
        saveIssueDetailsButton.click();
        try {
            WebElement closepopup = driver.findElement(By.xpath("//h4[contains(text(),'More Information')]"));
            waitForVisibility(closepopup,5);
            if (closepopup.isDisplayed()) {
                driver.findElement(By.xpath("//h4[contains(text(),'More Information')]/../a")).click();
            }
        } catch (Exception e) {

        }
        waitForVisibility(expectedaddedIssueDetails,15);
        TimeUnit.SECONDS.sleep(2);
        expected_IssueDetailsAdded=expectedaddedIssueDetails.getText().trim();
    	Assert.assertEquals(actual_IssueDetailsAdded, expected_IssueDetailsAdded);

    }
    
    public void editIssueDetailsMethod() throws InterruptedException {
    	waitForClickablility(editIssueDetailsGearIcon,10);
    	Thread.sleep(2000);
    	editIssueDetailsGearIcon.click();
    	editIssueDetailsLink.click();
    	waitForClickablility(addIssueDetails,10);
        addIssueDetails.click();
        addIssueDetails.sendKeys("Issue Details Added"+randomInt);
        actual_IssueDetailsAdded =  addIssueDetails.getText().trim();
        saveIssueDetailsButton.click();
    	 try {
             WebElement closepopup = driver.findElement(By.xpath("//h4[contains(text(),'More Information')]"));
             waitForVisibility(closepopup,5);
             if (closepopup.isDisplayed()) {
                 driver.findElement(By.xpath("//h4[contains(text(),'More Information')]/../a")).click();
             }
         } catch (Exception e) {

         }
    	expected_IssueDetailsAdded=expectedaddedIssueDetails.getText().trim();
     	Assert.assertEquals(actual_IssueDetailsAdded, expected_IssueDetailsAdded);
    }
    
    public void deleteIssueDetailsMethod() throws InterruptedException {
    	waitForClickablility(editIssueDetailsGearIcon,10);
    	Thread.sleep(2000);
    	editIssueDetailsGearIcon.click();
    	deleteIssueDetailLink.click();
    	deleteButton.click();
    	TimeUnit.SECONDS.sleep(2);
    }
    
    public void changeERCaseOwner() throws InterruptedException {
    	waitForClickablility(CaseTeamGearIcon,40);
    	CaseTeamGearIcon.click();
    	assignToLink.click();
    	sendInputKeys(newCaseOwnerTextbox, "Mohit");
         TimeUnit.SECONDS.sleep(2);
         newCaseOwnerTextbox.sendKeys(Keys.ARROW_DOWN);
         newCaseOwnerTextbox.sendKeys(Keys.ENTER);
         newCaseOwnerTextbox.sendKeys(Keys.ENTER);
         savenewCaseOwnerButton.click();
         Assert.assertTrue(changeCaseOwnerConfirmationMessage.getText().contains("Are you sure you want to change the case owner?"));
         deleteButton.click();
         try {
             WebElement confirmpopup = driver.findElement(By.xpath("//div[@id='casereassignwarning-modal']//input[@id='jq-btnReassignCaseOwner']"));
             waitForVisibility(confirmpopup,5);
             if (confirmpopup.isDisplayed()) {
                 driver.findElement(By.xpath("//div[@id='casereassignwarning-modal']//input[@id='jq-btnReassignCaseOwner']")).click();
             }
         } catch (Exception e) {
            
         }
    }
    
    public void verifyactionandIssueincaseInsightsFilter() {
    	 actual_Action = actualActionClicked.getText().trim();
    	 actual_IssueCategory= actualIssueClicked.getText().trim();
    	 actualActionClicked.click();
    	 waitForClickablility(expectedActioninFilter,10);
    	 expected_Action =  expectedActioninFilter.getText().trim();
    	 actualIssueClicked.click();
    	 waitForClickablility(expectedIssueinFilter,10);
    	 expected_IssueCategory =  expectedIssueinFilter.getText().trim();
    	 Assert.assertEquals(actual_Action, expected_Action);
    	 Assert.assertTrue( actual_IssueCategory.contains(expected_IssueCategory));
    }
    
    public static void TeamContributorUserLogin() throws IOException, InterruptedException {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginPage.properties";
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);
        String url = properties.getProperty("url");
        String userName = properties.getProperty("TeamContributorUser");
        String password = properties.getProperty("TeamContributorpassword");
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
    
    public void addTeamContributor() throws InterruptedException, IOException {
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
    	executor.executeScript("window.scrollBy(0,750)");
    	waitForClickablility(addTeamMember,20).click();
        BrowserUtilities.sendInputKeys(personTextbox, "QAUSER1");
        TimeUnit.SECONDS.sleep(2);
        personTextbox.sendKeys(Keys.ARROW_DOWN);
        personTextbox.sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(2);
        waitForClickablility(teamContributorSaveButton,20).click();
        try {
        	 waitForVisibility(confirmPopup,10);
             if (confirmPopup.isDisplayed()) {
                confirmPopup.click();
            }
        } catch (Exception e) {

        }
    }
    
    public void searchCaseNumber() throws InterruptedException, IOException {
    	BrowserUtilities.sendInputKeys(searchCaseNumber,ERProductionStepDef.Actual_caseName);
        TimeUnit.SECONDS.sleep(3);
        BrowserUtilities.waitAndClickButton(searchIcon);
        HighlightElementManager.highlightElement(driver,searchIcon);  
        caseNumber.get(0).click();
    }
}