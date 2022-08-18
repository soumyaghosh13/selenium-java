package com.HRA.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.HRA.helper.BrowserUtilities;
import com.HRA.helper.Driver;
import com.HRA.helper.LoggerHelper;
import org.apache.log4j.Logger;
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

import com.HRA.Dashboard.or.HraTabsNCaseListingOR;
import lombok.Data;

/**
 * @author RenuSharma
 */
@Data
public class HraTabsNCaseListingPage {

    WebDriver driver = Driver.getDriver();

    public HraTabsNCaseListingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Logger log = LoggerHelper.getLogger(LoggerHelper.class);

    @FindBy(xpath = HraTabsNCaseListingOR.caseNumberHeader)
    public WebElement caseNumberHeader;

    @FindBy(xpath = HraTabsNCaseListingOR.myCases)
    public WebElement myCases;
    @FindBy(xpath = HraTabsNCaseListingOR.myPriorityCases)
    public WebElement myPriorityCases;
    @FindBy(xpath = HraTabsNCaseListingOR.allCases)
    public WebElement allCases;
    @FindBy(xpath = HraTabsNCaseListingOR.myQueue)
    public WebElement myQueue;
    @FindBy(xpath = HraTabsNCaseListingOR.decisionMakerApproval)
    public WebElement decisionMakerApproval;
    @FindBy(xpath = HraTabsNCaseListingOR.decisionMakerApprovalCount)
    public WebElement decisionMakerApprovalCount;

    @FindBy(xpath = HraTabsNCaseListingOR.pageEndCount)
    public WebElement pageEndCount;

    @FindBy(xpath = HraTabsNCaseListingOR.openCases)
    public WebElement openCases;
    @FindBy(xpath = HraTabsNCaseListingOR.openCasesCount)
    public WebElement openCasesCount;
    @FindBy(xpath = HraTabsNCaseListingOR.openCasesGreen)
    public WebElement openCasesGreen;
    @FindBy(xpath = HraTabsNCaseListingOR.openCasesYellow)
    public WebElement openCasesYellow;
    @FindBy(xpath = HraTabsNCaseListingOR.openCasesRed)
    public WebElement openCasesRed;

    @FindBy(xpath = HraTabsNCaseListingOR.employeeRelations)
    public WebElement employeeRelations;
    @FindBy(xpath = HraTabsNCaseListingOR.employeeRelationsCount)
    public WebElement employeeRelationsCount;
    @FindBy(xpath = HraTabsNCaseListingOR.employeeRelationsGreen)
    public WebElement employeeRelationsGreen;
    @FindBy(xpath = HraTabsNCaseListingOR.employeeRelationsYellow)
    public WebElement employeeRelationsYellow;
    @FindBy(xpath = HraTabsNCaseListingOR.employeeRelationsRed)
    public WebElement employeeRelationsRed;

    @FindBy(xpath = HraTabsNCaseListingOR.investigation)
    public WebElement investigation;
    @FindBy(xpath = HraTabsNCaseListingOR.investigationCount)
    public WebElement investigationCount;
    @FindBy(xpath = HraTabsNCaseListingOR.investigationGreen)
    public WebElement investigationGreen;
    @FindBy(xpath = HraTabsNCaseListingOR.investigationYellow)
    public WebElement investigationYellow;
    @FindBy(xpath = HraTabsNCaseListingOR.investigationRed)
    public WebElement investigationRed;

    @FindBy(xpath = HraTabsNCaseListingOR.managERCount)
    public WebElement managERCount;

    @FindBy(xpath = HraTabsNCaseListingOR.postHire)
    public WebElement postHire;
    @FindBy(xpath = HraTabsNCaseListingOR.postHireCount)
    public WebElement postHireCount;
    @FindBy(xpath = HraTabsNCaseListingOR.postHireGreen)
    public WebElement postHireGreen;
    @FindBy(xpath = HraTabsNCaseListingOR.postHireYellow)
    public WebElement postHireYellow;
    @FindBy(xpath = HraTabsNCaseListingOR.postHireRed)
    public WebElement postHireRed;

    @FindBy(xpath = HraTabsNCaseListingOR.exitInterview)
    public WebElement exitInterview;
    @FindBy(xpath = HraTabsNCaseListingOR.exitInterviewCount)
    public WebElement exitInterviewCount;
    @FindBy(xpath = HraTabsNCaseListingOR.exitInterviewGreen)
    public WebElement exitInterviewGreen;
    @FindBy(xpath = HraTabsNCaseListingOR.exitInterviewYellow)
    public WebElement exitInterviewYellow;
    @FindBy(xpath = HraTabsNCaseListingOR.exitInterviewRed)
    public WebElement exitInterviewRed;

    @FindBy(xpath = HraTabsNCaseListingOR.gearHomePage)
    public WebElement gearHomePage;
    @FindBy(xpath = HraTabsNCaseListingOR.deleteCase)
    public WebElement deleteCase;
    @FindBy(xpath = HraTabsNCaseListingOR.popupDelete)
    public WebElement popupDelete;
    @FindBy(xpath = HraTabsNCaseListingOR.popUpCancel)
    public WebElement popUpCancel;
    @FindBy(xpath = HraTabsNCaseListingOR.reasonTextBox)
    public WebElement reasonTextBox;
    @FindBy(xpath = HraTabsNCaseListingOR.deleteReasonConfirm)
    public WebElement deleteReasonConfirm;
    @FindBy(xpath = HraTabsNCaseListingOR.cancelDeleteReason)
    public WebElement cancelDeleteReason;

    @FindBy(xpath = HraTabsNCaseListingOR.reAssignCaseOwner)
    public WebElement reAssignCaseOwner;
    @FindBy(xpath = HraTabsNCaseListingOR.reAssignCaseOwnerTextBox)
    public WebElement reAssignCaseOwnerTextBox;
    @FindBy(xpath = HraTabsNCaseListingOR.reAssignCaseOwnerSave)
    public WebElement reAssignCaseOwnerSave;
    @FindBy(xpath = HraTabsNCaseListingOR.reAssignCaseOwnerCancel)
    public WebElement reAssignCaseOwnerCancel;
    @FindBy(xpath = HraTabsNCaseListingOR.reAssignCaseOwnerConfirmOk)
    public WebElement reAssignCaseOwnerConfirmOk;
    @FindBy(xpath = HraTabsNCaseListingOR.reAssignCaseOwnerConfirmCancel)
    public WebElement reAssignCaseOwnerConfirmCancel;
    @FindBy(xpath = HraTabsNCaseListingOR.newCaseowner)
    public WebElement newCaseowner;
    @FindBy(xpath = HraTabsNCaseListingOR.searchCaseNumber)
    public WebElement searchCaseNumber;
    @FindBy(xpath = HraTabsNCaseListingOR.searchButton)
    public WebElement searchButton;
    @FindBy(xpath = HraTabsNCaseListingOR.caseNotFound)
    public WebElement caseNotFound;

    @FindBy(xpath = HraTabsNCaseListingOR.allOpenAgeTab)
    public WebElement allOpenAgeTab;
    @FindBy(xpath = HraTabsNCaseListingOR.dayscheckbox1130)
    public WebElement dayscheckbox1130;
    @FindBy(xpath = HraTabsNCaseListingOR.dayscheckbox6190)
    public WebElement dayscheckbox6190;
    @FindBy(xpath = HraTabsNCaseListingOR.greaterthen90days)
    public WebElement greaterthen90days;
    @FindBy(xpath = HraTabsNCaseListingOR.dayscheckbox1130casecount)
    public WebElement dayscheckbox1130casecount;
    @FindBy(xpath = HraTabsNCaseListingOR.dayscheckbox6190casecount)
    public WebElement dayscheckbox6190casecount;
    @FindBy(xpath = HraTabsNCaseListingOR.greaterthen90dayscasecount)
    public WebElement greaterthen90dayscasecount;
    @FindBy(xpath = HraTabsNCaseListingOR.allOpenAgeTabClose)
    public WebElement allOpenAgeTabClose;
    @FindBy(xpath = HraTabsNCaseListingOR.filterClose)
    public WebElement filterClose;

    @FindBy(xpath = HraTabsNCaseListingOR.allOpenHealthTab)
    public WebElement allOpenHealthTab;
    @FindBy(xpath = HraTabsNCaseListingOR.percent50orlesscheckbox)
    public WebElement percent50orlesscheckbox;
    @FindBy(xpath = HraTabsNCaseListingOR.percent51to75checkbox)
    public WebElement percent51to75checkbox;
    @FindBy(xpath = HraTabsNCaseListingOR.percent91to100checkbox)
    public WebElement percent91to100checkbox;
    @FindBy(xpath = HraTabsNCaseListingOR.percent50orlesshealthcasecount)
    public WebElement percent50orlesshealthcasecount;
    @FindBy(xpath = HraTabsNCaseListingOR.percent51to75healthcasecount)
    public WebElement percent51to75healthcasecount;
    @FindBy(xpath = HraTabsNCaseListingOR.percent91to100healthcasecount)
    public WebElement percent91to100healthcasecount;
    @FindBy(xpath = HraTabsNCaseListingOR.allOpenHealthTabClose)
    public WebElement allOpenHealthTabClose;


    static int ocCount = 0;
    static String caseNumber = null;

    //
    public void userClickOnMyQueueTab() throws IOException {
        myQueue.click();
    }

    public void userClickOnDecisionMakerApprovalTab() throws Throwable {
        decisionMakerApproval.click();
        try {
            if (decisionMakerApprovalCount.isDisplayed()) {
                int count = Integer.parseInt(decisionMakerApprovalCount.getText());
            }
        } catch (NoSuchElementException e) {
        }
    }

    public void userClickOnCaseCategoryTab(String casesCategory) throws Throwable {

        if (casesCategory.equalsIgnoreCase("My Cases")) {
            myCases.click();
        } else if (casesCategory.equalsIgnoreCase("My Priority Cases")) {
            myPriorityCases.click();
        } else if (casesCategory.equalsIgnoreCase("All cases")) {
            allCases.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(caseNumberHeader));
    }

    public void userClickOnTab(String caseType) throws Throwable {
        Actions action = new Actions(driver);
        if (caseType.equalsIgnoreCase("open cases")) {
            openCases.click();
            if (openCasesGreen.isDisplayed()) {
                action.moveToElement(openCasesGreen).perform();
                System.out.println("open cases less than 30 days " + openCasesGreen.getText());
                log.info("open cases less than 30 days" + openCasesGreen.getText());
            }
            if (openCasesYellow.isDisplayed()) {
                action.moveToElement(openCasesYellow).perform();
                System.out.println("open cases less than 60 days " + openCasesYellow.getText());
                log.info("open cases less than 60 days " + openCasesYellow.getText());
            }
            if (openCasesRed.isDisplayed()) {
                action.moveToElement(openCasesRed).perform();
                System.out.println("open cases more than 60 days " + openCasesRed.getText());
                log.info("open cases more than 60 days " + openCasesRed.getText());
            }

        } else if (caseType.equalsIgnoreCase("employee relations")) {
            employeeRelations.click();

            if (employeeRelationsGreen.isDisplayed()) {
                action.moveToElement(employeeRelationsGreen).perform();
                System.out.println("employee relations cases less than 30 days " + employeeRelationsGreen.getText());
                log.info(
                        "open cases less than 30 days" + employeeRelationsGreen.getText());
            }
            if (employeeRelationsYellow.isDisplayed()) {
                action.moveToElement(employeeRelationsYellow).perform();
                System.out.println("employee relations cases less than 60 days " + employeeRelationsYellow.getText());
                log.info(
                        "open cases less than 60 days " + employeeRelationsYellow.getText());
            }
            if (employeeRelationsRed.isDisplayed()) {
                action.moveToElement(employeeRelationsRed).perform();
                System.out.println("employee relations cases more than 60 days " + employeeRelationsRed.getText());
                log.info(
                        "open cases less than 60 days " + employeeRelationsRed);
            }

        } else if (caseType.equalsIgnoreCase("investigation")) {
            investigation.click();

            if (investigationGreen.isDisplayed()) {
                action.moveToElement(investigationGreen).perform();
                System.out.println("Investigation cases less than 30 days " + investigationGreen.getText());
                log.info(
                        "Investigation less than 30 days" + investigationGreen);
            }
            if (investigationYellow.isDisplayed()) {
                action.moveToElement(investigationYellow).perform();
                System.out.println("Investigation cases less than 60 days " + investigationYellow.getText());
                log.info(
                        "Investigation less than 60 days" + investigationYellow);
            }
            if (investigationRed.isDisplayed()) {
                action.moveToElement(investigationRed).perform();
                System.out.println("Investigation cases more than 60 days " + investigationRed.getText());
                log.info(
                        "Investigation more than 60 days" + investigationRed);
            }
        } else if (caseType.equalsIgnoreCase("post hire")) {
            postHire.click();

            if (postHireGreen.isDisplayed()) {
                action.moveToElement(postHireGreen).perform();
                System.out.println("Post hire cases less than 30 days " + postHireGreen.getText());
                log.info("Post hire case less than 30 days" + postHireGreen.getText());
            }
            if (postHireYellow.isDisplayed()) {
                action.moveToElement(postHireYellow).perform();
                System.out.println("Post hire cases less than 60 days " + postHireYellow.getText());
                log.info(
                        "Post hire case less than 60 days" + postHireYellow);
            }
            if (postHireRed.isDisplayed()) {
                action.moveToElement(postHireRed).perform();
                System.out.println("Post hire cases more than 60 days " + postHireRed.getText());
                log.info("Post hire case more than 60 days" + postHireRed.getText());
            }

        } else if (caseType.equalsIgnoreCase("exit interview")) {
            exitInterview.click();

            if (exitInterviewGreen.isDisplayed()) {
                action.moveToElement(exitInterviewGreen).perform();
                System.out.println("Exit interview cases less than 30 days " + exitInterviewGreen.getText());
                log.info(
                        "Exit interview case less than 30 days" + exitInterviewGreen);
            }
            if (exitInterviewYellow.isDisplayed()) {
                action.moveToElement(exitInterviewYellow).perform();
                System.out.println("Exit interview cases less than 60 days " + exitInterviewYellow.getText());
                log.info(
                        "Exit interview case less than 60 days" + exitInterviewYellow);
            }
            if (exitInterviewRed.isDisplayed()) {
                action.moveToElement(exitInterviewRed).perform();
                System.out.println("Exit interview cases more than 60 days " + exitInterviewRed.getText());
                log.info(
                        "Exit interview case more than 60 days" + exitInterviewRed);
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(caseNumberHeader));
        log.info("When I Clicked on " + caseType);
    }

    public void userGetsCount(String cases) throws Throwable {
        int casesCount = 0;

        if (cases.equalsIgnoreCase("open cases")) {
            ocCount = casesCount = Integer.parseInt(openCasesCount.getText().split("Cases")[0].trim());

        } else if (cases.equalsIgnoreCase("employee relations")) {
            casesCount = Integer.parseInt(employeeRelationsCount.getText().split("Cases")[0].trim());
            System.out.println(casesCount);
//			double erPercent = Double.parseDouble(employeeRelationsCount.getText().split(" ")[1].substring(1));
//			double casePercent = (new BigDecimal((double) casesCount * 100 / ocCount).setScale(2, RoundingMode.HALF_UP))
//					.doubleValue();
//			if (erPercent == casePercent) {
//				log.info( " ER Case Percent on page: " + erPercent
//						+ "%, matched with calculated ER percent: " + casePercent + "%", false);
//			} else {
//				log.info(" ER Case Percent on page: " + erPercent
//						+ "%, did not match with calculated ER percent: " + casePercent + "%", false);
//			}

        } else if (cases.equalsIgnoreCase("investigation")) {
            casesCount = Integer.parseInt(investigationCount.getText().split("Cases")[0].trim());

        } else if (cases.equalsIgnoreCase("managER cases")) {
            casesCount = Integer.parseInt(managERCount.getText().split("Cases")[0].trim());

        } else if (cases.equalsIgnoreCase("post hire")) {
            casesCount = Integer.parseInt(postHireCount.getText().split(" ")[0]);

        } else if (cases.equalsIgnoreCase("exit interview")) {
            casesCount = Integer.parseInt(exitInterviewCount.getText().split(" ")[0]);
        }

        System.out.println("All " + cases + " count is " + casesCount);
        log.info("All " + cases + " count is " + casesCount);

        if (casesCount > 20) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", pageEndCount);
            String[] endCount = pageEndCount.getText().split(" ");
            int casePageEndCount = Integer.parseInt((endCount[endCount.length - 1]).trim());

            if (casesCount == casePageEndCount) {
                log.info("Case Count at the top: " + casesCount
                        + ", matched with case count at the end of the page: " + casePageEndCount);
            } else {
                log.info("Case Count at the top: " + casesCount
                        + ", did not match with case count at the end of the page: " + casePageEndCount);
            }
        }

        Thread.sleep(3000);
    }

    // user click on "open cases" tab to delete case

    public void userClickOnCaseTypeTab(String caseType) throws Throwable {

        if (caseType.equalsIgnoreCase("open cases")) {
            openCases.click();
        } else if (caseType.equalsIgnoreCase("employee relations")) {
            employeeRelations.click();
        } else if (caseType.equalsIgnoreCase("investigation")) {
            investigation.click();
        } else if (caseType.equalsIgnoreCase("post hire")) {
            postHire.click();
        } else if (caseType.equalsIgnoreCase("exit interview")) {
            exitInterview.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(caseNumberHeader));
        log.info("When I Clicked on " + caseType);
    }

    public void userGetsCaseTypeCount(String cases) throws Throwable {
        if (cases.equalsIgnoreCase("open cases")) {
            int openCasesCnt = Integer.parseInt(openCasesCount.getText().split(" ")[0]);
            log.info("All " + cases + " count is " + openCasesCnt);
        } else if (cases.equalsIgnoreCase("employee relations")) {
            System.out.println("Inside employee relations count method ");
            Thread.sleep(2000);
            String erCasesCount = employeeRelationsCount.getText().split(" ")[0];
            System.out.println("Er case count " + erCasesCount);
            log.info("All " + cases + " count is " + erCasesCount);
            //System.out.println("Er case count " + erCasesCount);
            Thread.sleep(1000);
        } else if (cases.equalsIgnoreCase("investigation")) {
            int invCasesCount = Integer.parseInt(investigationCount.getText().split(" ")[0]);
            log.info("All " + cases + " count is " + invCasesCount);
        } else if (cases.equalsIgnoreCase("post hire")) {
            int phCasesCount = Integer.parseInt(postHireCount.getText().split(" ")[0]);
            log.info("All " + cases + " count is " + phCasesCount);
        } else if (cases.equalsIgnoreCase("exit interview")) {
            int eiCasesCount = Integer.parseInt(exitInterviewCount.getText().split(" ")[0]);
            log.info("All " + cases + " count is " + eiCasesCount);
        }

    }

    public void userClickOnGear() throws IOException, InterruptedException {
        BrowserUtilities.waitAndClickButton(gearHomePage);
        log.info("User clicked on gear");
    }

    public void reasonForDeletingCase() throws Exception {
        reasonTextBox.sendKeys("Inconclusive case XXXXXXYYYYZZZ");
        log.info("Entered the reason for deleting the task ");
        Thread.sleep(3000);

    }

    public void confirmDelete() {
        deleteReasonConfirm.click();

    }

    public void deletePopUpCase() throws InterruptedException, IOException {
        BrowserUtilities.waitAndClickButton(popupDelete);
        Thread.sleep(3000);
    }

    public void deleteCase() throws Exception {
        caseNumber = deleteCase.getAttribute("casenumber");
        deleteCase.click();
        Thread.sleep(3000);
    }

    public void deleteInReasonWindow() throws Exception {
        BrowserUtilities.waitAndClickButton(deleteReasonConfirm);
    }

    public void searchCaseNumber() throws InterruptedException, IOException {
        BrowserUtilities.sendInputKeys(searchCaseNumber, caseNumber);
        TimeUnit.SECONDS.sleep(3);
        BrowserUtilities.waitAndClickButton(searchButton);
    }

    public void verifyCaseDeleted() throws IOException {
        if (caseNotFound.isDisplayed()) {
            log.info(caseNotFound.getText());
        } else {
            log.info("Case is not deleted");
        }
    }

    public void verifyCaseReassign(String newOwner) throws IOException {
        if (newCaseowner.getText().contains(newOwner)) {
            System.out.println("Expected new owner is " + newOwner + " and actual new owner is " + newCaseowner.getText().split("  ")[0]);
            log.info("Expected new owner is " + newOwner + " and actual new owner is " + newCaseowner.getText().split("  ")[0]);
        } else {
            log.info("Expected new owner is " + newOwner + " and actual new owner is " + newCaseowner.getText().split("  ")[0]);
        }
    }

    public void clickOnReassignCaseOwner() throws InterruptedException, IOException {
        caseNumber = reAssignCaseOwner.getAttribute("casenumber");
        System.out.println(caseNumber);
        BrowserUtilities.waitAndClickButton(reAssignCaseOwner);
        TimeUnit.SECONDS.sleep(3);
        log.info("Reassign the case owner ");
    }

    public void enterCaseOwnerName(String newOwner) throws InterruptedException, IOException {
        BrowserUtilities.sendInputKeys(reAssignCaseOwnerTextBox, newOwner);
        Thread.sleep(1000);
        BrowserUtilities.sendInputKeys(reAssignCaseOwnerTextBox, Keys.DOWN);
        Thread.sleep(1000);
        BrowserUtilities.sendInputKeys(reAssignCaseOwnerTextBox, Keys.ENTER);
        TimeUnit.SECONDS.sleep(3);
        log.info("Entered new case owner name - " + newOwner);

    }

    public void saveCaseOwner() throws InterruptedException, IOException {
        BrowserUtilities.waitAndClickButton(reAssignCaseOwnerSave);
        TimeUnit.SECONDS.sleep(3);
        log.info("Save the new case owner ");
    }

    public void okToReassignCaseOwner() throws InterruptedException, IOException {
        BrowserUtilities.waitAndClickButton(reAssignCaseOwnerConfirmOk);
        TimeUnit.SECONDS.sleep(3);
        log.info("Ok to save the new case owner ");

    }

//All Open Cases Age and Health Case Count//

    public void userClickOnAllOpenCaseAgeTab(String casesAgeTab, String caseAgeDays) throws Throwable {

        if (casesAgeTab.equalsIgnoreCase("All Open Case")) {
            allOpenAgeTab.click();
            if (caseAgeDays.equalsIgnoreCase("11 - 30 days")) {
                dayscheckbox1130.click();
                log.info("open cases 11 to 30 days" + dayscheckbox1130.getText());
            }

            if (caseAgeDays.equalsIgnoreCase("61 - 90 days")) {
                dayscheckbox6190.click();
                log.info("open cases 61 to 90 days" + dayscheckbox6190.getText());
            }

            if (caseAgeDays.equalsIgnoreCase("greater then 90 days")) {
                greaterthen90days.click();
                log.info("open cases greater than days" + dayscheckbox6190.getText());
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(caseNumberHeader));
        log.info(" when user clicked on " + casesAgeTab);
    }

    public void userGetsAllOpenCaseCountonAge(String casesAge) throws Throwable {
        int casesCount = 0;

        if (casesAge.equalsIgnoreCase("11-30 days")) {
            ocCount = casesCount = Integer.parseInt(dayscheckbox1130casecount.getText().split("Cases")[0].trim());
            System.out.println(casesCount);
        } else if (casesAge.equalsIgnoreCase("61-90 days")) {
            casesCount = Integer.parseInt(dayscheckbox6190casecount.getText().split("Cases")[0].trim());
            System.out.println(casesCount);
        } else if (casesAge.equalsIgnoreCase("greater then 90 days")) {
            casesCount = Integer.parseInt(greaterthen90dayscasecount.getText().split("Cases")[0].trim());
            System.out.println(casesCount);
        }

        System.out.println("All " + casesAge + " count is " + casesCount);
        log.info("All " + casesAge + " count is " + casesCount);

        if (casesCount > 20) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", pageEndCount);
            String[] endCount = pageEndCount.getText().split(" ");
            int casePageEndCount = Integer.parseInt((endCount[endCount.length - 1]).trim());

            if (casesCount == casePageEndCount) {
                log.info("Case Count at the top: " + casesCount
                        + ", matched with case count at the end of the page: " + casePageEndCount);
            } else {
                log.info("Case Count at the top: " + casesCount
                        + ", did not match with case count at the end of the page: " + casePageEndCount);
            }
        }
        allOpenAgeTabClose.click();
        filterClose.click();
        Thread.sleep(3000);
    }

    public void userClickOnAllOpenCaseHeatlthTab(String casesHealthTab, String caseHealthPercentage) throws Throwable {

        if (casesHealthTab.equalsIgnoreCase("All Open Case")) {
            allOpenHealthTab.click();
            if (caseHealthPercentage.equalsIgnoreCase("50% or less")) {
                percent50orlesscheckbox.click();
                log.info("open cases 50% or less health" + dayscheckbox1130.getText());
            }
            if (caseHealthPercentage.equalsIgnoreCase("51% to 75%")) {
                percent51to75checkbox.click();
                log.info("open cases 51% to 75% health" + dayscheckbox6190.getText());
            }

            if (caseHealthPercentage.equalsIgnoreCase("91% to 100%")) {
                percent91to100checkbox.click();
                log.info("open cases 91% to 100% health" + dayscheckbox6190.getText());
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(caseNumberHeader));
        log.info(" when user clicked on " + casesHealthTab);
    }

    public void userGetsAllOpenCaseCountonHealth(String casesHealth) throws Throwable {
        int casesCount = 0;

        if (casesHealth.equalsIgnoreCase("50% or less")) {
            ocCount = casesCount = Integer.parseInt(percent50orlesshealthcasecount.getText().split("Cases")[0].trim());
            System.out.println(casesCount);
        } else if (casesHealth.equalsIgnoreCase("51% to 75%")) {
            casesCount = Integer.parseInt(percent51to75healthcasecount.getText().split("Cases")[0].trim());
            System.out.println(casesCount);
        } else if (casesHealth.equalsIgnoreCase("91% to 100%")) {
            casesCount = Integer.parseInt(percent91to100healthcasecount.getText().split("Cases")[0].trim());
        }


        if (casesCount > 20) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", pageEndCount);
            String[] endCount = pageEndCount.getText().split(" ");
            int casePageEndCount = Integer.parseInt((endCount[endCount.length - 1]).trim());

            if (casesCount == casePageEndCount) {
                log.info("Case Count at the top: " + casesCount
                        + ", matched with case count at the end of the page: " + casePageEndCount);
            } else {
                log.info("Case Count at the top: " + casesCount
                        + ", did not match with case count at the end of the page: " + casePageEndCount);
            }
        }
        allOpenHealthTabClose.click();
        filterClose.click();
        Thread.sleep(3000);
    }

}

