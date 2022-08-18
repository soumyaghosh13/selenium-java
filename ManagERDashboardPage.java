package com.HRA.pageObjects;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import com.HRA.helper.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.HRA.pageObjects.ActionNewAdminRedesignPage.actual_actionName;
import static com.HRA.pageObjects.AdminGroupPage.actual_groupName;
import static com.HRA.pageObjects.DocumentMaterialPage.actual_DocumentMaterialName;
import static com.HRA.pageObjects.InterimActionsPage.actual_interimactionName;
import static com.HRA.pageObjects.InvolvedPartyRelationshipsPage.actual_INVRelationshipName;
import static com.HRA.pageObjects.IssueCategoryAdminPage.actual_categoryName;
import static com.HRA.pageObjects.IssueCategoryAdminPage.actual_childCategoryName;
import static com.HRA.pageObjects.LocationAdminRedesignPage.actual_parentLocationName;
import static com.HRA.pageObjects.ManagERLetterTempPage.actual_LetterTemplate;
import static com.HRA.pageObjects.ManagERNotificationPage.actual_notificationName;
import static com.HRA.pageObjects.PolicyGuidelinesPage.actual_PolicyGuidelineName;
import static com.HRA.pageObjects.ActionNewAdminRedesignPage.limitvalue;
import static com.HRA.pageObjects.ActionNewAdminRedesignPage.timePeriodvalue;


public class ManagERDashboardPage{

    WebDriver driver = Driver.getDriver();
    
    public ManagERDashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);
    Random random = new Random();
    int randomInt = random.nextInt(1000);
    String Actual_caseNumber;
    String Expected_caseNumber;
    String IssueText;
    String EmployeeText;
    String Actual_empName;
    String Expected_empName;
    String Actual_issueNumber;
    String Expected_issueNumber;
    boolean ListView;
    boolean CardView;
    String issueCountInFilter;
    String ActualManagerName;
    String ExpectedManagerName;

    @FindBy(xpath = "//*[@class=\"jq-tab-issue\"]")
    WebElement Issues;

    @FindBy(xpath = "//*[@id=\"filterbytext_CaseStatus\"]")
    WebElement issuFilter;

    @FindBy(xpath = "(//*[@id=\"filterlist\"])[2]/li[contains(text(),'Approval Complete')]")
    WebElement approvalComplete;

    @FindBy(xpath = "(//*[@id=\"filterlist\"])[2]/li[@value=\"7\"]")
    WebElement Closed;

    @FindBy(xpath = "(//*[@id=\"filterlist\"])[2]/li[@value=\"13\"]")
    WebElement approvalPending;

    @FindBy(xpath = "//*[@class=\"employees-list jq-issue-grid-all marginTop30\"]//span[@datacolumn=\"Status\"]")
    WebElement issueFilterResult;

    @FindBy(xpath = "//*[@class=\"is-active jq-tab-employee\"]")
    WebElement Employee;

    @FindBy(xpath = "//*[@class=\"jq-link-issueview\"]")
    WebElement listView;

    @FindBy(xpath = "//*[@class=\"employee-list jq-employee-list-header\"]")
    WebElement listViewDisplay;

    @FindBy(xpath = "//*[@class=\"jq-link-cardview\"]")
    WebElement cardView;

    @FindBy(xpath = "//*[@class=\"employee jq-route-to jq-empexists\"]")
    WebElement cardViewDisplay;

    @FindBy(xpath = "//*[@class=\"jq-route-to\"]")
    WebElement EmpListName;

    @FindBy(xpath = "//*[@class=\"name m-bottom-0_5rem\"]/a")
    WebElement EmpCardName;

    @FindBy(xpath = "//*[@class=\"breadcrumbs\"]//a")
    WebElement HomepageLink;

    @FindBy(xpath = "//*[@class=\"jq-route-to bold jq-hratrack-referer\"]")
    WebElement firstIssue;


    @FindBy(xpath = "(//*[@id=\"filterbytext_CaseStatus\"])[1]")
    WebElement filterByText;

    @FindBy(xpath = "(//a[.=\"Load More\"])[3]")
    WebElement loadMoreButton;

    @FindBy(xpath = "//*[@class=\"employees-list jq-issue-grid-all marginTop30\"]/div")
    List<WebElement> elementsOfTable;

    @FindBy(xpath = "(//div[@class=\"tab-employee-issue\"]/ul/li)[2]")
    public WebElement tabEmloyeeIssue;

    @FindBy(xpath = "//*[@id=\"filterbytext_CaseStatus\"]")
    public WebElement issueFilterDropdown;

    @FindBy(xpath = "(//*[@id=\"filterlist\"])[2]/li")
    public List<WebElement> issueFilterList;

    @FindBy(xpath = "//div[@class='employees-list jq-issue-grid-all marginTop30']//a[@attrcolumn='PersonId']")
    public List<WebElement> employeeColumnInTable;

    @FindBy(xpath = "//a[.=\"View Prior History\"]")
    public List<WebElement> viewPriorHistoryLink;

    @FindBy(xpath = "//a[.=\"Close Prior History\"]")
    public List<WebElement> closePriorHistoryLink;

    @FindBy(xpath = "//span[@datacolumn=\"ConcernTypeName\"]/../../..//a[.=\"Full Details\"]")
    public List<WebElement> fullDetailsLink;

    @FindBy(xpath = "//*[@class=\"vertical-center\"]//span[@datacolumn=\"ConcernTypeName\"]")
    public List<WebElement> actualmanagerName;

    @FindBy(xpath = "//h2[@class=\"flex-1\"]/span[@datacolumn=\"ConcernTypeName\"]")
    public List<WebElement> expectedmanagerName;

    @FindBy(xpath = "//h5[1]")
    WebElement notificationPopupHeader;
    @FindBy(xpath = "//span[@class='jq-catchUp-notif-count']")
    WebElement notificationCount;
    @FindBy(xpath = "//div[@id='announcement']//div//div//div//p[contains(text(),'Announcements')]")
    WebElement announcements;
    @FindBy(xpath = "//div[@id='announcement']//a[@title='Click to copy link'][normalize-space()='QA ManagER lINK']")
    WebElement managERLink;
    @FindBy(xpath = "//div[@class='modal_content']//div[1]//div[1]//a[1]//span[1]")
    WebElement notificationDelete;
    @FindBy(xpath = "//a[@class='btn btn-primary jq-deletemodal-delete']")
    WebElement deleteConfirm;
    @FindBy(xpath = "//div[@class='notification-header']//div//a[@class='c-modal__close js-modal-close'][normalize-space()='X']")
    WebElement notificationClose;
    @FindBy(xpath = "//body[1]/div[12]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[4]/a[1]")
    WebElement sendReminder;
    @FindBy(xpath = "//a[@class='btn btn-primary jq-modal-ok']")
    WebElement reminderOk;



//	//*[@class="vertical-center"]//span[@datacolumn="ConcernTypeName"]/../../..//a[.="Full Details"]


    public void verifyIssueTextVisible() throws IOException {
        try {
            IssueText = Issues.getText();
            Issues.click();
            log.info("Issue text is visible - " + IssueText);
        } catch (Exception e) {
            log.info("Issue text not visible - " + IssueText);
        }
    }

    public void clickOnIssueFilter(String issueFilter) throws IOException, Throwable {
        if (issueFilter.equalsIgnoreCase("Approval Complete")) {
            BrowserUtilities.waitAndClickButton(issuFilter);
            BrowserUtilities.waitAndClickButton(approvalComplete);
        } else if (issueFilter.equalsIgnoreCase("Closed")) {
            BrowserUtilities.waitAndClickButton(issuFilter);
            BrowserUtilities.waitAndClickButton(Closed);
        } else if (issueFilter.equalsIgnoreCase("Review Pending")) {
            BrowserUtilities.waitAndClickButton(issuFilter);
            BrowserUtilities.waitAndClickButton(approvalPending);
        }
    }

    public void verifyIssueFilter(String issueFilter) throws IOException {
        if (issueFilter.equalsIgnoreCase("Approval Complete")) {
            if (issueFilter.equals(issueFilterResult.getText().trim())) {
                log.info("Actual issue filter - " + issueFilter +
                        ", matched with Expected issue filter - " + issueFilterResult.getText().trim());
            } else {
                log.info("Actual issue filter - " + issueFilter +
                        ", did not matched with Expected issue filter - " + issueFilterResult.getText().trim());
            }
        }

        if (issueFilter.equalsIgnoreCase("Closed")) {
            if (issueFilter.equals(issueFilterResult.getText().trim())) {
                log.info("Actual issue filter - " + issueFilter +
                        ", matched with Expected issue filter - " + issueFilterResult.getText().trim());
            } else {
                log.info("Actual issue filter - " + issueFilter +
                        ", did not matched with Expected issue filter - " + issueFilterResult.getText().trim());
            }
        }

        if (issueFilter.equalsIgnoreCase("Review Pending")) {
            if (issueFilter.equals(issueFilterResult.getText().trim())) {
                log.info("Actual issue filter - " + issueFilter +
                        ", matched with Expected issue filter - " + issueFilterResult.getText().trim());
            } else {
                log.info("Actual issue filter - " + issueFilter +
                        ", did not matched with Expected issue filter - " + issueFilterResult.getText().trim());
            }
        }
    }

    public void verifyEmployeeTextVisible() throws IOException {
        try {
            EmployeeText = Employee.getText();
        } catch (Exception e) {
            log.info("Employee text not visible - " + EmployeeText);
        }
    }

    public void clickandverifyEmployeeView(String issueFilter) throws IOException, Throwable {
        if (issueFilter.equalsIgnoreCase("List View")) {
            BrowserUtilities.waitAndClickButton(listView);
            ListView = listViewDisplay.isDisplayed();
            log.info("List view is visible");
        } else if (issueFilter.equalsIgnoreCase("Card View")) {

            //click(cardView);
            CardView = cardViewDisplay.isDisplayed();

            log.info("Card view is visible");
        } else {
            log.info("Employees are not present");
        }
    }

    public void takeTheNumberOfFilterByTexts() throws IOException {
        String text = filterByText.getText();
        issueCountInFilter = text.substring(text.indexOf("(") + 1, text.indexOf(")")).trim();
        log.info("Take the number of which text on the filter");
    }

    public void clickLoadMoreButton() {
        while (loadMoreButton.isDisplayed()) {
            BrowserUtilities.waitAndClickButton(loadMoreButton);
        }
    }


    public void clickandverifyEmployeeName(String issueFilter) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        if (issueFilter.equalsIgnoreCase("List View")) {
            wait.until(ExpectedConditions.visibilityOf(EmpListName));
            Actual_empName = driver.findElement(By.xpath("//*[@class=\"jq-route-to\"]")).getText();
            BrowserUtilities.waitAndClickButton(EmpListName);
            Thread.sleep(2000);
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//h2[@class=\"fg-gray_dark m-top-0_5rem m-bottom-0_5rem\"]"), "Loading..."));
            Expected_empName = driver.findElement(By.xpath("//h2[@class=\"fg-gray_dark m-top-0_5rem m-bottom-0_5rem\"]")).getText();
            BrowserUtilities.waitAndClickButton(HomepageLink);
            if (Actual_empName.contains(Expected_empName)) {
                {
                    log.info("The Expected employee name : " + Expected_empName + "is matched with Actual employee name :" + Actual_empName);
                }
            } else {
                log.info("FAILED!!! - The Expected employee name : " + Expected_empName + "is not matched with Actual employee name :" + Actual_empName);
            }
        } else if (issueFilter.equalsIgnoreCase("Card View")) {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@datacolumn=\"FullName\"]")));
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//a[@datacolumn=\"FullName\"]"), "Loading..."));
            Actual_empName = driver.findElement(By.xpath("//a[@datacolumn=\"FullName\"]")).getText();
            BrowserUtilities.waitAndClickButton(EmpCardName);
            Thread.sleep(2000);
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//h2[@class=\"fg-gray_dark m-top-0_5rem m-bottom-0_5rem\"]"), "Loading..."));
            Expected_empName = driver.findElement(By.xpath("//h2[@class=\"fg-gray_dark m-top-0_5rem m-bottom-0_5rem\"]")).getText();
            BrowserUtilities.waitAndClickButton(HomepageLink);
            if (Actual_empName.contains(Expected_empName)) {
                {
                    log.info("The Expected employee name : " + Expected_empName + "is matched with Actual employee name :" + Actual_empName);
                }
            } else {
                log.info("FAILED!!! - The Expected employee name : " + Expected_empName + "is not matched with Actual employee name :" + Actual_empName);
            }
        }
    }

    public void clickandverifyIssue() throws IOException {
        try {
            Actual_issueNumber = driver.findElement(By.xpath("//*[@datacolumn=\"CaseNumber\"]")).getText();
            BrowserUtilities.waitAndClickButton(firstIssue);
            log.info("User is able to see roles permissions ");
            Expected_issueNumber = driver.findElement(By.xpath("//*[@datacolumn=\"CaseNumber\"]")).getText();
            if (Actual_issueNumber.contains(Expected_issueNumber)) {
                {
                    log.info("The Expected issue number : " + Expected_issueNumber + "is matched with Actual issue number :" + Actual_issueNumber);
                }
            }
        } catch (Exception e) {
            log.info("FAILED!!! - The Expected issue number : " + Expected_issueNumber + "is not matched with Actual issue number :" + Actual_issueNumber);
            Assert.fail("User is not able to see roles permissions " + e.getMessage());
        }
    }


    public void countTheStatusText() {
        int count = elementsOfTable.size();
        Assert.assertEquals(count, Integer.parseInt(issueCountInFilter));
    }

    public void clickViewPriorHistoryLink() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(viewPriorHistoryLink.get(0)));
            if (viewPriorHistoryLink.get(0).isDisplayed()) {
                viewPriorHistoryLink.get(0).click();
                wait.until(ExpectedConditions.visibilityOf(closePriorHistoryLink.get(0)));
                closePriorHistoryLink.get(0).click();
                Thread.sleep(2000);
                viewPriorHistoryLink.get(0).click();
                wait.until(ExpectedConditions.visibilityOf(actualmanagerName.get(0)));
                ActualManagerName = actualmanagerName.get(0).getText().replace(" - Test 1", "").trim();
                System.out.println(ActualManagerName);
                wait.until(ExpectedConditions.visibilityOf(fullDetailsLink.get(0)));
                fullDetailsLink.get(0).click();
                wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//h2[@class=\"flex-1\"]/span[@datacolumn=\"ConcernTypeName\"]"), "Loading..."));
                wait.until(ExpectedConditions.visibilityOf(expectedmanagerName.get(0)));
                ExpectedManagerName = expectedmanagerName.get(0).getText().trim();
                System.out.println(ExpectedManagerName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clickclosePriorHistoryLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(closePriorHistoryLink.get(0)));
        if (closePriorHistoryLink.get(0).isDisplayed()) {
            closePriorHistoryLink.get(0).click();
        }
    }

    public void clickIssueInEmployeeHistoryList() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(actualmanagerName.get(0)));
        ActualManagerName = actualmanagerName.get(0).getText().replace(" - Test 1", "").trim();
        System.out.println(ActualManagerName);
        wait.until(ExpectedConditions.visibilityOf(fullDetailsLink.get(0)));
        fullDetailsLink.get(0).click();
    }

    public void verifyIssueName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//h2[@class=\"flex-1\"]/span[@datacolumn=\"ConcernTypeName\"]"), "Loading..."));
        wait.until(ExpectedConditions.visibilityOf(expectedmanagerName.get(0)));
        ExpectedManagerName = expectedmanagerName.get(0).getText().trim();
        System.out.println(ExpectedManagerName);
    }

    public void writeManagERDataInExcel() throws IOException {
        String[] valueToWrite = {actual_groupName,actual_parentLocationName,actual_categoryName,actual_childCategoryName,actual_notificationName,actual_actionName,actual_LetterTemplate,limitvalue,timePeriodvalue};
        ExcelWriter objExcelFile = new ExcelWriter();
        objExcelFile.writeExcel(System.getProperty("user.dir")+"\\src\\test\\resources\\TestDataAndAttachments","ManagER.xlsx","sheet",valueToWrite);
        System.out.println("Excel Write Done Successfully");
    }

    public void verifyNotificationPopup() throws IOException, InterruptedException {
        String expected = "Let's Catch Up..";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(notificationPopupHeader));
        Assert.assertEquals(notificationPopupHeader.getText(),expected);
        wait.until(ExpectedConditions.visibilityOf(announcements));
        Assert.assertTrue(announcements.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(managERLink));
        Assert.assertTrue(managERLink.isDisplayed());
        int startCount = Integer.parseInt(notificationCount.getText());
        if(startCount>0) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(sendReminder)).click();
                wait.until(ExpectedConditions.elementToBeClickable(reminderOk)).click();
            }
            catch (Exception e){
                System.out.println("Reminder Not Send, Something Went Wrong");
            }
            wait.until(ExpectedConditions.elementToBeClickable(notificationDelete)).click();
            wait.until(ExpectedConditions.elementToBeClickable(deleteConfirm)).click();
            Thread.sleep(4000);
            int endCount = Integer.parseInt(notificationCount.getText());
            System.out.println("start" + startCount);
            System.out.println("end" + endCount);
            Assert.assertTrue(startCount > endCount);
        }
        else {
            System.out.println("No Notification Present Now");
        }
    wait.until(ExpectedConditions.elementToBeClickable(notificationClose)).click();

    }

}