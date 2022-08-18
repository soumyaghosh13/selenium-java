package com.HRA.pageObjects;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.HRA.helper.Driver;
import com.HRA.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ManagERCasePage {
    WebDriver driver = Driver.getDriver();

    public ManagERCasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);
    Random random = new Random();
    int randomInt = random.nextInt(9999999);
    public static String Actual_caseNumber;
    String Expected_caseNumber;
    String empMessage;
    String noEmail;
    String reviewlettersentMessage;
    String reviewlettercompletetMessage;
    String caseapprovalSentMessage;
    String caseApprovalcompleteMessage;
    String caseSuccessMessage;

    @FindBy(xpath = "(//*[@class='clean d-block jq-btn-search'])[1]")
    WebElement searchicon;

    @FindBy(xpath = "(//div[@class='search-typeahead']//label[@for='dashboard-searchemployee'])[1]")
    WebElement enterText;

    @FindBy(xpath = "(//div[@class='search-typeahead']//input[@id='dashboard-searchemployee'])[1]")
    WebElement sendKeys;

    @FindBy(xpath = "//span[contains(text(),'verma divas, Alberta')]")
    WebElement clickEmpName;

    @FindBy(xpath = "//div[@class='jq-workflowlist']//div//a[@workflowid='594']/span[@class='material-icons']")
    WebElement clickWorkFlow;

    @FindBy(xpath = "//a[@class='btn btn-primary jq-wf-modal-continueaction']")
    WebElement Continue;

    @FindBy(xpath = "//*[@class='fa fa-times close-help-popup jq-helptext-close']")
    WebElement closeTips;

    @FindBy(xpath = "//*[@class='radio jq-mgr-caseflow-panel-actions columnFlexDirection ']//input")
    WebElement directmanagerAction;

    @FindBy(xpath = "(//*[@class='radio jq-mgr-caseflow-panel-actions']//input)[2]")
    WebElement secondmanagerAction;

    @FindBy(xpath = "(//*[@class='radio jq-mgr-caseflow-panel-actions']//input)[3]")
    WebElement HRUserAction;

    @FindBy(xpath = "//*[@class='btn btn-primary jq-mgr-caseflow-btn-next ml-1rem jq-btnvalidate']")
    WebElement issueNext;

    @FindBy(xpath = "(//*[@class='required jq-focus-target'])[1]")
    WebElement enterDetails;

    @FindBy(xpath = "(//*[@class='actions'])[2]//a[2][@class='btn btn-primary jq-mgr-caseflow-btn-next ml-1rem jq-btnvalidate']")
    WebElement detailsNext;

    @FindBy(xpath = "(//*[@class='material-icons p-right-0_5rem'])[2]")
    WebElement docLibrary;

    @FindBy(xpath = "(//*[@class='material-icons p-right-0_5rem'])[3]")
    WebElement document;

    @FindBy(xpath = "//*[@class='bluetext jq-fileupload-browse']")
    WebElement browse;

    @FindBy(xpath = "//*[@class='btn btn-primary jq-savedocumenttocase jq-btnvalidate']")
    WebElement addtoCase;

    @FindBy(xpath = "//*[@class='material-icons p-right-0_5rem']")
    WebElement email;

    @FindBy(xpath = "((//*[@class='overflow m-bottom-2rem'])[2]//span[2])[1]")
    WebElement emailCheckbox;

    @FindBy(xpath = "//*[@class='btn btn-primary jq-btnvalidate']")
    WebElement attachEmail;

    @FindBy(xpath = "(//*[@class='c-modal__close js-modal-close'])[7]")
    WebElement emailClose;

    @FindBy(xpath = "(//*[@class='button filled bottom jq-filterdropdown-title'])[2]")
    WebElement docSelect;

    @FindBy(xpath = "//div[@class='options bottom jq-option-disabled jq-option-enabled']//li[contains(text(),'All')]")
    WebElement docSelect1;

    @FindBy(xpath = "//div[@id='jq-searchclientdata-policy']//span[contains(text(),'EmployeeRelationsReport_ER-20-05-303.pdf')]")
    WebElement selCheckbox;

    @FindBy(xpath = "(//*[@class='btn btn-primary jq-btnvalidate'])[2]")
    WebElement attachDoc;

    @FindBy(xpath = "(//*[@class='actions'])//a[@class='btn btn-primary jq-mgr-caseflow-btn-next m-right-0_5rem']")
    WebElement matNext;

    @FindBy(xpath = "(//*[@class='actions'])//a[@class='btn btn-primary jq-mgr-caseflow-btn-next ml-1rem jq-btnvalidate jq-btn-action-change']")
    WebElement actionNext;

    @FindBy(xpath = "//*[@class='actions']//a[@class='btn btn-primary jq-mgr-caseflow-btn-next ml-1rem jq-letter-initiate']")
    WebElement prepareLetter;

    @FindBy(xpath = "//*[@class='c-form__field']//input[@type='radio']")
    WebElement radioHarras;

    @FindBy(xpath = "(//*[@class='c-form__field']//input[@type='radio'])[2]")
    WebElement radioHarras2;

	@FindBy(xpath = "//*[@class='btn btn-secondary btn-icon jq-edittemplate-row jq-action-button']")
	WebElement editTextBox;
	
	@FindBy(xpath = "//*[@class='fa fa-list-ul']")
	WebElement bulletClick;
	
	@FindBy(xpath = "//*[@class='fa fa-list-ol']")
	WebElement numberClick;
	
	@FindBy(xpath = "//*[@class='bootstraphtmleditor jhtc-active']")
	WebElement sendText;
	
	@FindBy(xpath = "(//*[@class='btn btn-primary btn-small jq-action-save hdn'])[2]")
	WebElement saveText;
	
//	@FindBy(xpath = "//div[@class='jq-manager-actions']")
	@FindBy(xpath = "(//*[contains(text(),'Finish Editing')])[1]")
	WebElement finishEditButton;
	
	@FindBy(xpath = "//*[@class='btn btn-primary jq-btn-letter-action hdn jq-letter-finish-edit']")
	WebElement finishEditingButton;

    @FindBy(xpath = "//*[@class='btn btn-primary jq-btn-letter-action hdn']")
    WebElement finishEditingButtonApproval;

    @FindBy(xpath = "//*[@class='btn btn-primary jq-modal-btn-send-feedback']")
    WebElement sendRCChanges;

    @FindBy(xpath = "//input[@value='6']")
    WebElement sendwithFeedback;

    @FindBy(xpath = "//input[@value='12']")
    WebElement ApprovalsendwithFeedback;

    @FindBy(xpath = "//*[@class='btn btn-primary ml-1rem jq-mgr-caseflow-btn-next jq-mgr-send-for-review jq-review-need']")
    WebElement reviewButton;

    @FindBy(xpath = "//*[@class='btn btn-primary save jq-modal-ok']")
    WebElement reviewClose;

    @FindBy(xpath = "//div[@id='filterbytext']")
    WebElement filterClick;

    @FindBy(xpath = "//div[@class='options bottom jq-todofilters']//li[@value='17']")
    WebElement reviewClick;

    @FindBy(xpath = "//*[@class='btn btn-small btn-secondary']//i[contains(text(),'forward')]")
    WebElement viewNotificationButton;

    @FindBy(xpath = "(//div[@class='actions']//a[@class='btn btn-primary jq-route-to'])[1]")
    WebElement reviewLetter;

    @FindBy(xpath = "//*[@class='btn btn-primary jq-btn-letter-action hdn']")
    WebElement reviewComplete;

    @FindBy(xpath = "//*[@class='btn btn-primary jq-modal-ok']")
    WebElement reviewConfirm;

    @FindBy(xpath = "(//div[@class='actions']//a[contains(text(),'Skip this step')])[2]")
    WebElement reviewSkip;

    @FindBy(xpath = "//div[@class='actions']//a[@class='btn btn-primary jq-mgr-caseflow-btn-next jq-btnvalidate']")
    WebElement sendApproval;

    @FindBy(xpath = "//div[@class='jq-topaction-buttons']//a[@class='btn btn-primary jq-btn-letter-action hdn']")
    WebElement sendApprovalTwo;

    @FindBy(xpath = "//div[@class='options bottom jq-todofilters']//li[@value='19']")
    WebElement approvalPending;

    @FindBy(xpath = "//div[@class='options bottom jq-todofilters']//li[@value='20']")
    WebElement caseApproved;

    @FindBy(xpath = "//a[@class='btn btn-primary jq-mgr-caseflow-btn-next jq-btnvalidate jq-isclosebtn jq-reopen-case-close-button']")
    WebElement sendcloseIssue;

    @FindBy(xpath = "//*[@class='c-modal__content marginTop10']//p[@class='fg-gray jq-message']")
    WebElement caseCloseSuccessMessage;

    @FindBy(xpath = "//*[@class='btn btn-primary save jq-modal-ok']")
    WebElement caseSuccessPopup;

    @FindBy(xpath = "(//*[@class='jq-case-letterdelivery-type'])[1]//input[@name='LetterDeliveryMethodId']")
    WebElement sendAsEmail;

    @FindBy(xpath = "//*[@class='jq-form-valid-email required jq-focus-target']")
    WebElement sendEmailSendkeys;

    @FindBy(xpath = "//*[@class='btn btn-small btn-secondary jq-print-caseletter']")
    WebElement printLetter;

    @FindBy(xpath = "(//*[@class='jq-case-letterdelivery-type'])[2]//input[@name='LetterDeliveryMethodId']")
    WebElement emailasPDF;

    @FindBy(xpath = "//*[@class='send-as-esign field jq-case-letterdelivery-body jq-formpanel']//div//textarea[@name='EmailBody']")
    WebElement entertextclick;

    @FindBy(xpath = "//*[@class='jq-focus-target'][@name='EmailBody']")
    WebElement entertextsendkeys;

    @FindBy(xpath = "(//*[@class='jq-case-letterdelivery-type'])[3]//input[@name='LetterDeliveryMethodId']")
    WebElement eSignature;

    @FindBy(xpath = "(//*[@class='jq-case-letterdelivery-type'])[4]//input[@name='LetterDeliveryMethodId']")
    WebElement inPerson;

    @FindBy(xpath = "//*[@class='ddl-ac-selected']")
    WebElement SelectIndividualHRUser;

    @FindBy(xpath = "//input[@class='jq-search-input-dropdownautocomplete ui-autocomplete-input']")
    WebElement IndividualHRUser;

    @FindBy(xpath = "//*[@class='btn btn-primary jq-modal-ok']")
    WebElement confirmation;

    @FindBy(xpath = "//*[@class='js-tab-link approval-tab'][@data-tab='managER']")
    WebElement managERTab;

    @FindBy(xpath = "//*[@class='jq-RedirectCases']")
    WebElement HRUsercase;

    @FindBy(xpath = "//*[@class='c-content__main c-content__mainTable']//a[@class='anchor-link linkGreen']")
    WebElement reviewHRUsercase;

    @FindBy(xpath = "//div[@class='actions']/a[contains(text(),'View Suggested Changes')]")
    WebElement viewSuggestedChanges;


    @FindBy(xpath = "(//div[@class='actions']/a[contains(text(),'View Suggested Changes')])[2]")
    WebElement viewSuggestedChangesApproval;


    @FindBy(xpath = "//a[@class=\"btn btn-primary jq-btn-letter-action hdn jq-accept-all\"]")
    WebElement acceptAllChanges;

    @FindBy(xpath = "//*[@class='btn btn-primary jq-btn-letter-action jq-btn-letter-mgr-sendreview hdn']")
    WebElement sendReviewButton;

    @FindBy(xpath = "//*[@class='btn btn-primary jq-btn-letter-action jq-btn-letter-mgr-sendapproval hdn']")
    WebElement sendApprovalButton;

    @FindBy(xpath = "/html/body/div[5]/app-root/div/div[2]/div[1]/div/div/div[2]/a")
    WebElement addNote;

    @FindBy(xpath = "/html/body/div[5]/app-root/div/div[3]/div/div[2]/div[1]/div/div/div/textarea")
    WebElement addNoteTextEnter;

    @FindBy(xpath = "/html/body/div[5]/app-root/div/div[3]/div/div[2]/div[2]/div/div/div/div/div/i")
    WebElement datePicker;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[5]/a")
    WebElement highlighteDate;

    @FindBy(xpath = "/html/body/div[5]/app-root/div/div[3]/div/div[2]/div[3]/a[1]")
    WebElement addNoteSubmit;

    @FindBy(xpath = "//*[@id='jq-div-closedcase-timeline-list']/div[1]/div[1]/div/ul/li[2]/a")
    WebElement noteSection;

    @FindBy(xpath = "//*[@id='jq-div-closedcase-timeline-list']/div[3]/ul/div[1]/h4/span")
    WebElement noteCount;

	@FindBy(xpath = "//input[@class='jq-focus-target required']")
	WebElement subjectChangeEnable;

	@FindBy(xpath = "//a[@class='addcc jq-addcc']")
	WebElement addCC;

	@FindBy(xpath = "//input[@class='jq-form-valid-mulemail required jq-focus-target']")
	WebElement CCtextfield;  
	
	@FindBy(xpath = "//a[@class=\"btn btn-primary jq-mgr-caseflow-btn-next jq-btnvalidate jq-isclosebtn\"]")
	WebElement closeEsignIssue;  
	
	@FindBy(xpath = "//div[@class=\"jq-esign-signee-list\"]//div[@class=\"status-received\"]")
	List<WebElement> esignStatus;
	
	@FindBy(xpath = "(//a[@class='btn btn-primary jq-mgr-caseflow-btn-next jq-btnvalidate jq-isclosebtn jq-reopen-case-close-button'])")
	WebElement sendcloseIssueforEsign; 
	
	@FindBy(xpath = "//a[contains(text(),'Continue to Next Step')]")
	WebElement continuesToNextStep;     
	
	@FindBy(xpath = "//a[contains(text(),'Continue to Letter Delivery')]")
	WebElement continueToLetterDelivery;     

    public void addNote() throws InterruptedException {
        Thread.sleep(2000);
        noteSection.click();
        int startingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));
        System.out.println("Note Count at Start ----> " + startingCount);
        Thread.sleep(2000);
        addNote.click();
        Thread.sleep(2000);
        addNoteTextEnter.sendKeys("i'm batman");
        Thread.sleep(2000);
        datePicker.click();
        Thread.sleep(2000);
        highlighteDate.click();
        Thread.sleep(2000);
        addNoteSubmit.click();
        Thread.sleep(2000);
        int endingCount = Integer.parseInt(noteCount.getText().replaceAll("[^0-9]", ""));
        System.out.println("Note Count at End ----> " + endingCount);

        Assert.assertTrue(endingCount > startingCount);

    }


    public void clickOnEmployee() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(enterText));
        enterText.click();
        Thread.sleep(2000);
        sendKeys.sendKeys("verma divas");
        Thread.sleep(2000);
        boolean empFound;
        empFound = driver.findElement(By.xpath("//span[@class='completer-list-item']")).isDisplayed();
        if (empFound) {
            empMessage = driver.findElement(By.xpath("//*[@class='completer-item-text']//span//span[@datacolumn='Name']")).getText();
            driver.findElement(By.xpath("//span[@class='completer-list-item']")).click();
        } else {
            empMessage = driver.findElement(By.xpath("//*[@class='completer-item-text']//span//span[@datacolumn='Name']")).getText();
        }
        Thread.sleep(5000);
    }

    public void clickOnWorkflow() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        clickWorkFlow.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(Continue));
        Continue.click();
    }

    public void selectIssueandfilldetails() throws InterruptedException, AWTException {
        //issueNext.click();
        //Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(closeTips));
        closeTips.click();
        wait.until(ExpectedConditions.visibilityOf(enterDetails));
        enterDetails.click();
        enterDetails.sendKeys("Employee concerns about timings!");
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement((By.xpath("(//*[@class='actions'])[2]/a[2]")));
        action.moveToElement(we).click().perform();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(4000);
    }

    public void attachMaterials() throws InterruptedException, AWTException {
        docLibrary.click();
        Thread.sleep(2000);
        docSelect.click();
        Thread.sleep(1000);
        docSelect1.click();
        Thread.sleep(1000);
        selCheckbox.click();
        attachDoc.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(2000);
        document.click();
        Actions act = new Actions(driver);
        act.click(browse).perform();
        StringSelection file = new StringSelection("C:\\Users\\Dilip Kumar Singh\\Downloads\\down.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(addtoCase));
        addtoCase.click();
        Thread.sleep(2000);
    }

    public void attachmaterialsnext() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", matNext);
        js.executeScript("arguments[0].click();", matNext);
        //matNext.click();
        Thread.sleep(2000);
    }

    public void selectAction(String action) throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        if (action.equalsIgnoreCase("Direct Manager")) {
            wait.until(ExpectedConditions.visibilityOf(directmanagerAction));
            directmanagerAction.click();
            actionNext.click();
            Actual_caseNumber = driver.findElement(By.xpath("//*[@class='text-uc weight-normal']")).getText();
            Thread.sleep(3000);
        }
        if (action.equalsIgnoreCase("Second Level Manager")) {
            wait.until(ExpectedConditions.visibilityOf(directmanagerAction));
            //secondmanagerAction.click();
            directmanagerAction.click();
            actionNext.click();
            Actual_caseNumber = driver.findElement(By.xpath("//*[@class='text-uc weight-normal']")).getText();
            Thread.sleep(3000);
        }
        if (action.equalsIgnoreCase("HR User")) {
            wait.until(ExpectedConditions.visibilityOf(directmanagerAction));
            //HRUserAction.click();
            directmanagerAction.click();
            actionNext.click();
            Actual_caseNumber = driver.findElement(By.xpath("//*[@class='text-uc weight-normal']")).getText();
            Thread.sleep(3000);
        }
    }

    public void createLetter() throws InterruptedException {
        //TODO CHECK THIS METHOD AND DELETE IT
        //THESE LINES COMMENTED OUT BECAUSE WE USED ANOTHER STEP DEFINITION FOR THE ACTION
        //IF THERE ARE NO ISSUES DELETE THE COMMENTED PART
//       Thread.sleep(2000);
//       boolean checkbox;
//  	   checkbox  = driver.findElement(By.xpath("(//div[@class='jq-div-include-history']/label//span[@class='checkmark'])[1]")).isEnabled();
//  	   if(checkbox)
//  	   {
//  		   driver.findElement(By.xpath("(//div[@class='jq-div-include-history']/label//span[@class='checkmark'])[1]")).click();
//  		   driver.findElement(By.xpath("//*[@class='jq-div-caseflow-casehistory marginTop10']//span[@class='checkmark']")).click();
//  		   System.out.println("History checkbox is selected");
//  	   }
//  	   else
//  	   {
//  		   System.out.println("History checkbox not selected");
//  		   Thread.sleep(2000);
//  	   }
//    	prepareLetter.click();
//    	Thread.sleep(4000);
        radioHarras.click();
        Thread.sleep(2000);
        editTextBox.click();
        Thread.sleep(2000);
        bulletClick.click();
        Thread.sleep(2000);
        numberClick.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(sendText));
        sendText.click();
        sendText.clear();
        sendText.sendKeys("Sending letter to employee: ");
        Thread.sleep(2000);
        saveText.click();
        Thread.sleep(2000);
        finishEditButton.click();
        System.out.println("Letter created successfully!!");
        Thread.sleep(4000);
    }

    public void sendReview() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        ;
        wait.until(ExpectedConditions.visibilityOf(reviewButton));
        reviewButton.click();
        wait.until(ExpectedConditions.visibilityOf(reviewClose));
        reviewClose.click();
        reviewlettersentMessage = driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[3]//span")).getText();
        System.out.println(reviewlettersentMessage);
        Thread.sleep(2000);
    }

    public void skipReview() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(reviewSkip));
        reviewSkip.click();
        Thread.sleep(2000);
    }

    public void loginDirectManager() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginManagER.properties";
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(path);
        prop.load(input);
        String url = prop.getProperty("url");
        String userName = prop.getProperty("directmanageruser");
        String password = prop.getProperty("directmanagerpassowrd");
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailManagER()));
        loginPage.emailManagER().clear();
        loginPage.emailManagER().sendKeys(userName);
        loginPage.passwordManagER().clear();
        loginPage.passwordManagER().sendKeys(password);
        loginPage.ManagERnewLogin().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=' I Agree']")));
        loginPage.ManagERiAgree().click();

         /*
        We need to check if the "Lets Catch up" pop up window shows up. It prevents click actions when it shows up.
         */
        try {
            wait.until(ExpectedConditions.visibilityOf(LoginPage.reminderPopUp));
            LoginPage.reminderPopUpCloseButton.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lets Catch up POP UP did not show.");
        }

        wait.until(ExpectedConditions.visibilityOf(loginPage.ERname()));
        if (loginPage.closePopupER().isDisplayed()) {
            loginPage.closePopupER().click();
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        log.info("Login test passed, logged by " + loginPage.ERname().getText());
        Thread.sleep(3000);

    }

    public void loginSecondLevelManager() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginManagER.properties";
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(path);
        prop.load(input);
        String url = prop.getProperty("url");
        String userName = prop.getProperty("secondmanageruser");
        String password = prop.getProperty("secondmanagerpassowrd");
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailManagER()));
        loginPage.emailManagER().clear();
        loginPage.emailManagER().sendKeys(userName);
        loginPage.passwordManagER().clear();
        loginPage.passwordManagER().sendKeys(password);
        loginPage.ManagERnewLogin().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=' I Agree']")));
        loginPage.ManagERiAgree().click();

        /*
        We need to check if the "Lets Catch up" pop up window shows up. It prevents click actions when it shows up.
         */
        try {
            wait.until(ExpectedConditions.visibilityOf(LoginPage.reminderPopUp));
            LoginPage.reminderPopUpCloseButton.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lets Catch up POP UP did not show.");
        }

        wait.until(ExpectedConditions.visibilityOf(loginPage.ERname()));
        if (loginPage.closePopupER().isDisplayed()) {
            loginPage.closePopupER().click();
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        System.out.println(loginPage.ERname().getText());
        Thread.sleep(3000);

    }

    public void loginHRApprover() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginManagER.properties";
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(path);
        prop.load(input);
        String url = prop.getProperty("url");
        String userName = prop.getProperty("HRuser");
        String password = prop.getProperty("HRpassword");
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailManagER()));
        loginPage.emailManagER().clear();
        loginPage.emailManagER().sendKeys(userName);
        loginPage.passwordManagER().clear();
        loginPage.passwordManagER().sendKeys(password);
        loginPage.ManagERnewLogin().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=' I Agree']")));
        loginPage.ManagERiAgree().click();

        /*
        We need to check if the "Lets Catch up" pop up window shows up. It prevents click actions when it shows up.
         */
        try {
            wait.until(ExpectedConditions.visibilityOf(LoginPage.reminderPopUp));
            LoginPage.reminderPopUpCloseButton.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lets Catch up POP UP did not show.");
        }

        wait.until(ExpectedConditions.visibilityOf(loginPage.ERname()));
        if (loginPage.closePopupER().isDisplayed()) {
            loginPage.closePopupER().click();
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        Thread.sleep(3000);

    }

    public void loginHRUser() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String key = "qa";
        String path = "src/test/resources/properties/qa/LoginPage.properties";
// 		String path = "src/test/resources/properties/UAT/LoginPage.properties";
// 		String path = "src/test/resources/properties/Prod/LoginPage.properties";
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(path);
        prop.load(input);
        String url = prop.getProperty("url");
        String userName = prop.getProperty("HRuser");
        String password = prop.getProperty("HRpassword");
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.email().clear();
        loginPage.email().sendKeys(userName);
        loginPage.password().clear();
        loginPage.password().sendKeys(password);
        loginPage.login().click();
        loginPage.iAgree().click();
        Thread.sleep(5000);


        /*
        If we start seeing the catch up notification popup on the core app we can uncomment the try catch here
        We need to check if the "Lets Catch up" pop up window shows up. It prevents click actions when it shows up.
         */
//        try {
//            wait.until(ExpectedConditions.visibilityOf(LoginPage.reminderPopUp));
//            LoginPage.reminderPopUpCloseButton.click();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Lets Catch up POP UP did not show.");
//        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    public void filterviewnotification() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(viewNotificationButton));
        viewNotificationButton.click();
    }

    public void reviewComplete() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        ;
        try {
            wait.until(ExpectedConditions.visibilityOf(closeTips));
            closeTips.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(reviewLetter));
        reviewLetter.click();
        wait.until(ExpectedConditions.elementToBeClickable(reviewComplete));
        reviewComplete.click();

        try {
            reviewConfirm.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        reviewlettercompletetMessage = driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[3]//span")).getText();
        System.out.println(reviewlettercompletetMessage);
    }

    public void reviewletterChanges(String reviewChanges) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//    		wait.until(ExpectedConditions.visibilityOf(closeTips));
//            closeTips.click();
        wait.until(ExpectedConditions.visibilityOf(reviewLetter));
        reviewLetter.click();
        radioHarras2.click();
        Thread.sleep(2000);
        finishEditingButton.click();
        System.out.println("Letter created successfully!!");
        if (reviewChanges.equalsIgnoreCase("Review complete with changes")) {
            wait.until(ExpectedConditions.visibilityOf(sendRCChanges));
            sendRCChanges.click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(reviewConfirm));
            reviewConfirm.click();
        } else if (reviewChanges.equalsIgnoreCase("Send with feedback")) {
            wait.until(ExpectedConditions.visibilityOf(sendRCChanges));
            sendwithFeedback.click();
            wait.until(ExpectedConditions.visibilityOf(sendRCChanges));
            sendRCChanges.click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(reviewConfirm));
            reviewConfirm.click();
        }
        Thread.sleep(4000);
    }

    public void approveletterChanges(String reviewChanges) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//    		wait.until(ExpectedConditions.visibilityOf(closeTips));
//            closeTips.click();
        wait.until(ExpectedConditions.visibilityOf(reviewHRUsercase));
        reviewHRUsercase.click();
        radioHarras2.click();
        Thread.sleep(2000);
        finishEditingButtonApproval.click();
        System.out.println("Letter created successfully!!");
        if (reviewChanges.equalsIgnoreCase("Approved with Changes")) {
            wait.until(ExpectedConditions.visibilityOf(sendRCChanges));
            sendRCChanges.click();
            Thread.sleep(1000);
//        	wait.until(ExpectedConditions.visibilityOf(reviewConfirm));
//    		reviewConfirm.click();
        } else if (reviewChanges.equalsIgnoreCase("Approval Send with feedback")) {
            wait.until(ExpectedConditions.visibilityOf(ApprovalsendwithFeedback));
            ApprovalsendwithFeedback.click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(sendRCChanges));
            sendRCChanges.click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(reviewConfirm));
            wait.until(ExpectedConditions.elementToBeClickable(reviewConfirm));
            reviewConfirm.click();
            Thread.sleep(1000);
//            	wait.until(ExpectedConditions.visibilityOf(reviewConfirm));
//        		reviewConfirm.click();
        }
        Thread.sleep(4000);
    }

    public void sendCaseReviewinCaseSendwithfeedback() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
// 	    	   wait.until(ExpectedConditions.visibilityOf(closeTips));
// 	           closeTips.click();
        wait.until(ExpectedConditions.visibilityOf(viewNotificationButton));
        viewNotificationButton.click();
        wait.until(ExpectedConditions.visibilityOf(viewSuggestedChanges));
        viewSuggestedChanges.click();
        wait.until(ExpectedConditions.visibilityOf(acceptAllChanges));
        acceptAllChanges.click();
        wait.until(ExpectedConditions.visibilityOf(sendReviewButton));
        sendReviewButton.click();
        //Thread.sleep(3000);
        //caseapprovalSentMessage= driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[4]//span")).getText();
        //System.out.println(caseapprovalSentMessage);
        Thread.sleep(4000);
    }

    public void sendCaseApprovalinCaseSendwithFeedback() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(viewNotificationButton));
        viewNotificationButton.click();
// 	    	   wait.until(ExpectedConditions.visibilityOf(closeTips));
// 	           closeTips.click();
        wait.until(ExpectedConditions.visibilityOf(viewSuggestedChangesApproval));
        viewSuggestedChangesApproval.click();
        wait.until(ExpectedConditions.visibilityOf(acceptAllChanges));
        acceptAllChanges.click();
        wait.until(ExpectedConditions.visibilityOf(sendApprovalButton));
        sendApprovalButton.click();
        //Thread.sleep(3000);
        //caseapprovalSentMessage= driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[4]//span")).getText();
        //System.out.println(caseapprovalSentMessage);
        Thread.sleep(4000);
    }

    public void sendCaseApprovalinCaseSendwithfeedback() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(viewNotificationButton));
        viewNotificationButton.click();
// 	    	   wait.until(ExpectedConditions.visibilityOf(closeTips));
// 	           closeTips.click();
        wait.until(ExpectedConditions.visibilityOf(sendApproval));
        sendApproval.click();
        wait.until(ExpectedConditions.visibilityOf(reviewClose));
        reviewClose.click();
        //caseapprovalSentMessage= driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[4]//span")).getText();
        //System.out.println(caseapprovalSentMessage);
        Thread.sleep(2000);
    }


    public void sendCaseApprovalinCaseRCwithChanges() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(viewNotificationButton));
        viewNotificationButton.click();
// 	    	   wait.until(ExpectedConditions.visibilityOf(closeTips));
// 	           closeTips.click();
        wait.until(ExpectedConditions.visibilityOf(viewSuggestedChanges));
        viewSuggestedChanges.click();
        wait.until(ExpectedConditions.visibilityOf(acceptAllChanges));
        acceptAllChanges.click();
        continuesToNextStep.click();
        wait.until(ExpectedConditions.visibilityOf(sendApproval));
        sendApproval.click();
        wait.until(ExpectedConditions.visibilityOf(reviewClose));
        reviewClose.click();
        //caseapprovalSentMessage= driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[4]//span")).getText();
        //System.out.println(caseapprovalSentMessage);
        Thread.sleep(2000);
    }

    public void sendCaseApprovalinSkipReviewCase() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(closeTips));
        closeTips.click();
        wait.until(ExpectedConditions.visibilityOf(sendApproval));
        sendApproval.click();
        wait.until(ExpectedConditions.visibilityOf(reviewClose));
        reviewClose.click();
        //caseapprovalSentMessage= driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[4]//span")).getText();
        //System.out.println(caseapprovalSentMessage);
        Thread.sleep(2000);
    }

    public void sendCaseApprovaltoHRUser() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
// 	    	   wait.until(ExpectedConditions.visibilityOf(closeTips));
// 	           closeTips.click();
        wait.until(ExpectedConditions.visibilityOf(SelectIndividualHRUser));
        SelectIndividualHRUser.click();
        IndividualHRUser.click();
        IndividualHRUser.sendKeys("QA HRAPPROVER");
        TimeUnit.SECONDS.sleep(2);
        IndividualHRUser.sendKeys(Keys.ARROW_DOWN);
        IndividualHRUser.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(sendApproval));
        sendApproval.click();
        wait.until(ExpectedConditions.visibilityOf(reviewClose));
        reviewClose.click();
        //caseapprovalSentMessage= driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[4]//span")).getText();
        //System.out.println(caseapprovalSentMessage);
        Thread.sleep(2000);
    }

    public void caseapprovalnotification() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOf(viewNotificationButton));
        viewNotificationButton.click();
    }

    public void approvalCaseComplete() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//     	   wait.until(ExpectedConditions.visibilityOf(closeTips));
//           closeTips.click();
        wait.until(ExpectedConditions.visibilityOf(reviewLetter));
        reviewLetter.click();
        wait.until(ExpectedConditions.visibilityOf(sendApprovalTwo));
        sendApprovalTwo.click();
        //caseApprovalcompleteMessage= driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[4]//span")).getText();
        //System.out.println(caseApprovalcompleteMessage);
        Thread.sleep(2000);
    }

    public void approvalCaseCompleteinSkipReviewCase() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(closeTips));
        closeTips.click();
        Thread.sleep(2000);
        reviewLetter.click();
        wait.until(ExpectedConditions.visibilityOf(sendApprovalTwo));
        sendApprovalTwo.click();
        Thread.sleep(2000);
        confirmation.click();
        //caseApprovalcompleteMessage= driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[4]//span")).getText();
        //System.out.println(caseApprovalcompleteMessage);
        Thread.sleep(2000);
    }

    public void caseHRUseraprovedwithchanges() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(viewNotificationButton));
        viewNotificationButton.click();
        wait.until(ExpectedConditions.visibilityOf(viewSuggestedChangesApproval));
        viewSuggestedChangesApproval.click();
        wait.until(ExpectedConditions.visibilityOf(acceptAllChanges));
        acceptAllChanges.click();
        continueToLetterDelivery.click();
//           wait.until(ExpectedConditions.visibilityOf(sendApproval));
//           sendApproval.click();
//    	   wait.until(ExpectedConditions.visibilityOf(reviewClose));
//           reviewClose.click();
//       	   caseapprovalSentMessage= driver.findElement(By.xpath("(//*[@class='title jq-mgr-caseflow-panel-timeline-title'])[5]//span")).getText();
        //caseapprovalSentMessage= driver.findElement(By.xpath("(//*[@jq-caseflow-panel-type='Approve']//span[1])[1]")).getText();
        Thread.sleep(2000);

    }


    public void caseapprovednotification() throws InterruptedException {
        filterClick.click();
        Thread.sleep(2000);
        caseApproved.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(viewNotificationButton));
        viewNotificationButton.click();
    }

    public void letterDelivery(String letterDeliveryMethod) throws InterruptedException, AWTException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        if (letterDeliveryMethod.equalsIgnoreCase("send as email")) {
            wait.until(ExpectedConditions.visibilityOf(sendAsEmail));
            sendAsEmail.click();
            sendEmailSendkeys.clear();
            Thread.sleep(2000);
            sendEmailSendkeys.sendKeys("QAHRApprover@hracuity.net");
			try {
				if(subjectChangeEnable.isEnabled())
				{
					System.out.println("Subject change field is enabled.");
					Assert.assertTrue(subjectChangeEnable.isEnabled());
					subjectChangeEnable.clear();
					subjectChangeEnable.sendKeys("Auto - Performance");
					addCC.click();
					CCtextfield.click();
					CCtextfield.sendKeys("QAHRApprover@hracuity.net");
				}
			}
			catch(Exception e){
				System.out.println("Subject change field is not enabled.");
			}
			Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(sendcloseIssue)).click();
	       // sendcloseIssue.click();
	        wait.until(ExpectedConditions.visibilityOf(caseCloseSuccessMessage));
	        caseSuccessMessage = caseCloseSuccessMessage.getText();
	        wait.until(ExpectedConditions.elementToBeClickable(caseSuccessPopup)).click();
	        Expected_caseNumber = driver.findElement(By.xpath("//*[@class='text-uc weight-normal']")).getText();	       
	        Assert.assertEquals(Actual_caseNumber, Expected_caseNumber);
	        Thread.sleep(4000);
		}

        if (letterDeliveryMethod.equalsIgnoreCase("email as PDF")) {
            wait.until(ExpectedConditions.visibilityOf(emailasPDF));
            emailasPDF.click();
            //wait.until(ExpectedConditions.visibilityOf(sendAsEmail));
            //sendAsEmail.click();
            sendEmailSendkeys.clear();
            Thread.sleep(2000);
            sendEmailSendkeys.sendKeys("QAHRApprover@hracuity.net");
            //Thread.sleep(2000);
            //entertextclick.click();
            wait.until(ExpectedConditions.visibilityOf(entertextsendkeys));
            entertextsendkeys.clear();
            entertextsendkeys.sendKeys("Case is closed!");
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(sendcloseIssue)).click();
           // sendcloseIssue.click();
            wait.until(ExpectedConditions.visibilityOf(caseCloseSuccessMessage));
            caseSuccessMessage = caseCloseSuccessMessage.getText();
            wait.until(ExpectedConditions.elementToBeClickable(caseSuccessPopup)).click();
            Expected_caseNumber = driver.findElement(By.xpath("//*[@class='text-uc weight-normal']")).getText();
            Assert.assertEquals(Actual_caseNumber, Expected_caseNumber);
            Thread.sleep(4000);
        }

        if (letterDeliveryMethod.equalsIgnoreCase("In person")) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
            wait.until(ExpectedConditions.elementToBeClickable(inPerson));
            //wait.until(ExpectedConditions.visibilityOf(inPerson));
            inPerson.click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(sendcloseIssue)).click();
           // sendcloseIssue.click();
            wait.until(ExpectedConditions.visibilityOf(caseCloseSuccessMessage));
            caseSuccessMessage = caseCloseSuccessMessage.getText();
            wait.until(ExpectedConditions.elementToBeClickable(caseSuccessPopup)).click();
            Expected_caseNumber = driver.findElement(By.xpath("//*[@class='text-uc weight-normal']")).getText();
            Assert.assertEquals(Actual_caseNumber, Expected_caseNumber);
            Thread.sleep(4000);
        }
        
        if (letterDeliveryMethod.equalsIgnoreCase("Send for e-signature")) {
            wait.until(ExpectedConditions.visibilityOf(eSignature));
            eSignature.click();
            //wait.until(ExpectedConditions.visibilityOf(sendAsEmail));
            //sendAsEmail.click();
            sendEmailSendkeys.clear();
            Thread.sleep(2000);
            sendEmailSendkeys.sendKeys("QAHRApprover@hracuity.net");
            //Thread.sleep(2000);
            //entertextclick.click();
            wait.until(ExpectedConditions.visibilityOf(entertextsendkeys));
            entertextsendkeys.clear();
            entertextsendkeys.sendKeys("Case is closed!");
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(sendcloseIssueforEsign));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", sendcloseIssueforEsign);
            //wait.until(ExpectedConditions.elementToBeClickable(sendcloseIssueforEsign)).click();
            wait.until(ExpectedConditions.visibilityOf(caseCloseSuccessMessage));
            caseSuccessMessage = caseCloseSuccessMessage.getText();
            wait.until(ExpectedConditions.elementToBeClickable(caseSuccessPopup)).click();
            Expected_caseNumber = driver.findElement(By.xpath("//*[@class='text-uc weight-normal']")).getText();
             Assert.assertEquals(Actual_caseNumber, Expected_caseNumber);
             Thread.sleep(4000);
        }      
    }
    
    public void closeEsignCase() throws InterruptedException
    {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	 Thread.sleep(2000);
    	 wait.until(ExpectedConditions.elementToBeClickable(esignStatus.get(0)));
    	 Assert.assertTrue(esignStatus.get(0).getText().contains("Submitted"));
    	 wait.until(ExpectedConditions.elementToBeClickable(esignStatus.get(1)));
    	 Assert.assertTrue(esignStatus.get(1).getText().contains("Submitted"));
    	 wait.until(ExpectedConditions.elementToBeClickable(closeEsignIssue)).click();
         wait.until(ExpectedConditions.visibilityOf(caseCloseSuccessMessage));
         caseSuccessMessage = caseCloseSuccessMessage.getText();
         wait.until(ExpectedConditions.elementToBeClickable(caseSuccessPopup)).click();
         Expected_caseNumber = driver.findElement(By.xpath("//*[@class='text-uc weight-normal']")).getText();
         Assert.assertEquals(Actual_caseNumber, Expected_caseNumber);
         Thread.sleep(4000);
    }

    public void clickmanagERatb() {
        try {
            WebElement decisionmakerapprovalinactive = driver.findElement(By.xpath("//*[@class='c-my-queue case-tab-class']"));
            decisionmakerapprovalinactive.click();


        } catch (NoSuchElementException e) {
            WebElement decisionmakerapprovalactive = driver.findElement(By.xpath("//*[@class='c-my-queue case-tab-class is-active']"));
            decisionmakerapprovalactive.click();
        }
        managERTab.click();
    }

    public void clickandviewCaseHRUser() {
        HRUsercase.click();
    }

    public void approveHRUsercase() throws InterruptedException {
        reviewHRUsercase.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(sendApprovalTwo));
        sendApprovalTwo.click();
        Thread.sleep(2000);
        //confirmation.click();
        String Case_Status = driver.findElement(By.xpath("//*[@id='custom-selection']//span")).getText();
        System.out.println("Case Status after case approve is :" + Case_Status);
        Assert.assertEquals(Case_Status, "Approval Complete");
    }
}
